package com.example.excelparser.service;

import com.example.excelparser.model.ExcelRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    public String parseExcelFile(MultipartFile file) {
        List<ExcelRow> rows = new ArrayList<>();

        try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the header row
            if (rowIterator.hasNext()) rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String name = row.getCell(0).getStringCellValue();
                int age = (int) row.getCell(1).getNumericCellValue();
                String email = row.getCell(2).getStringCellValue();

                rows.add(new ExcelRow(name, age, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\":\"Failed to parse Excel\"}";
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
}