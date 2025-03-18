package com.example.excelparser.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

@Service
public class ExcelService {

    public String parseExcelFile(MultipartFile file) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try (InputStream is = file.getInputStream(); Workbook workbook = getWorkbook(file, is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Read header row (first row)
            if (!rowIterator.hasNext()) {
                return "{\"error\":\"Excel file is empty\"}";
            }

            Row headerRow = rowIterator.next();
            Map<Integer, String> columnMapping = getColumnMapping(headerRow);

            // Validate required columns
            List<String> requiredColumns = Arrays.asList("Name", "Age", "Email");
            if (!columnMapping.values().containsAll(requiredColumns)) {
                return "{\"error\":\"Missing required columns: Name, Age, Email\"}";
            }

            // Read data rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Map<String, Object> rowData = new LinkedHashMap<>();

                for (Cell cell : row) {
                    String columnName = columnMapping.get(cell.getColumnIndex());
                    if (columnName != null) {
                        rowData.put(columnName, getCellValue(cell, columnMapping));
                    }
                }

                rows.add(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Failed to parse Excel file\"}";
        }

        // Convert to JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(rows);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Failed to convert to JSON\"}";
        }
    }

    // Method to detect and return the correct Workbook instance
    private Workbook getWorkbook(MultipartFile file, InputStream is) throws Exception {
        String filename = file.getOriginalFilename();
        if (filename != null && filename.endsWith(".xls")) {
            return new HSSFWorkbook(is); // .xls format (HSSF)
        } else {
            return new XSSFWorkbook(is); // .xlsx format (XSSF)
        }
    }

    // Extract column names from the header row
    private Map<Integer, String> getColumnMapping(Row headerRow) {
        Map<Integer, String> columnMapping = new HashMap<>();
        for (Cell cell : headerRow) {
            columnMapping.put(cell.getColumnIndex(), cell.getStringCellValue().trim());
        }
        return columnMapping;
    }

    // Get cell value as Object
    private Object getCellValue(Cell cell, Map<Integer, String> columnMapping) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue(); // Handle date format if needed
                }
                double numericValue = cell.getNumericCellValue();
                if (cell.getColumnIndex() == getPhoneColumnIndex(columnMapping)) {
                    return String.valueOf((long) numericValue); // Convert large numbers to string
                }
                return numericValue % 1 == 0 ? (int) numericValue : numericValue;
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    //Automatically detect the phone column index
    // Method to get the phone column index
    private int getPhoneColumnIndex(Map<Integer, String> columnMapping) {
        // Assuming "Phone" is the column header in the first row
        for (Map.Entry<Integer, String> entry : columnMapping.entrySet()) {
            if ("Phone".equalsIgnoreCase(entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1; // Return -1 if no match found (fallback to default handling)
    }
}