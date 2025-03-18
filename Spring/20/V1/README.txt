Parse an Excel document and convert it into JSON.

mvn clean install
mvn spring-boot:run

POST: http://localhost:8080/api/excel/upload

Body: select form-data , Key: file Value: path to Excel.xlsx


Steps:

    Use Apache POI to read Excel files.
    Convert the data into JSON using Jackson.
    Expose a REST API to upload an Excel file and return JSON.
