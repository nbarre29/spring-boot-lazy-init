Parse an Excel document and convert it into JSON.

mvn clean install
mvn spring-boot:run

POST: http://localhost:8080/api/excel/upload

Body: select form-data , Key: file Value: path to Excel.xlsx


In the earlier version (V2) we have seen that "Phone": 1.23456789E9 , the output json has the "Phone" in this format. The issue arises because Java treats large numbers as double values, and JSON serialization converts them into scientific notation (1.23456789E9). To fix this and ensure the phone number is stored as a string instead of scientific notation, modify the getCellValue method.

✅ Solution: Convert Large Numbers to Strings

Modify the getCellValue method to detect if a number is large and convert it to a string.

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
	
	
How It Works

    Detects if the cell contains a numeric value.
    Checks if it's in the "Phone" column.
    Converts the numeric value to a long and then to a string to avoid scientific notation.
	
	
	
Example Output Before Fix

{
  "Name": "Alice",
  "Age": 30,
  "Email": "alice@email.com",
  "Phone": 1.23456789E9
}

Example Output After Fix

{
  "Name": "Alice",
  "Age": 30,
  "Email": "alice@email.com",
  "Phone": "1234567890"
}
