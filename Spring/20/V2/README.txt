Parse an Excel document and convert it into JSON.

mvn clean install
mvn spring-boot:run

POST: http://localhost:8080/api/excel/upload

Body: select form-data , Key: file Value: path to Excel.xlsx


include the following improvements:

    Validation for Missing Columns: Ensure required columns (Name, Age, Email) exist in the uploaded Excel file.
    Support for Different Excel Formats (.xls and .xlsx): Use Apache POI to handle both .xls (HSSF) and .xlsx (XSSF).
    Support Dynamic Column Structures: Allow parsing Excel files with different column names while dynamically mapping them to JSON.
	
	
1. Update ExcelService.java to Add Validations for Missing Columns

We will modify the service to:

    Validate required columns (Name, Age, Email).
    Handle both .xls (HSSF) and .xlsx (XSSF).
    Support dynamic column structures.
	

Enhancements Summary

✅ Validation for missing columns: Checks if required columns (Name, Age, Email) exist. If missing, returns an error.
✅ Support for different Excel formats (.xls and .xlsx): Dynamically detects the format and reads the correct file type.
✅ Extend to handle dynamic column structures: Supports any number of columns, reading them dynamically.
