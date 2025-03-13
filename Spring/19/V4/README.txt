This Spring Boot client demonstrates how to call a public API, https://openweathermap.org/api 
This Weather API requires API Key Authentication.

Enhancements Added:

✔ API Key Authentication


mvn clean install
mvn spring-boot:run


In Postman:
Go to the Headers tab.
Add a new key-value pair:

    Key: x-api-key
    Value: 9e4c9d83b2c0c789e088b7481fc55cd3

GET: http://localhost:8080/api/weather/London
GET: http://localhost:8080/api/weather/New York
GET: http://localhost:8080/api/weather/Houston


https://openweathermap.org/api  

userName: nbarre
email: naveen.dec29@gmail.com
pwd: Vrishabh@1

Registered on above URL and received two emails with subject as below:

OpenWeatherMap Account confirmation
OpenWeatherMap API Instruction

API key:
- Within the next couple of hours, your API key 9e4c9d83b2c0c789e088b7481fc55cd3 will be activated and ready to use
- You can later create more API keys on your account page, https://home.openweathermap.org/api_keys



GET: https://api.openweathermap.org/data/2.5/weather?q=London


GET: https://api.openweathermap.org/data/2.5/weather?q=New York


There are many other requests I can make to this public API, https://openweathermap.org/api and I will explore it later

