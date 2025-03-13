Simple spring-boot application with dependecy, springdoc-openapi-starter-webmvc-ui  added.
I used githut copilot suggestions to autogenerate the swagger related code.


Access swaagger via http://localhost:8080/swagger-ui/index.html


POST: http://localhost:8080/api/

Headers:
Content-Type : application/json

{
    "id":"foo",
    "name":"Mr. Foo",
    "phone": "123-123-1234"
}


{
    "id":"bar",
    "name":"Mr. Bar",
    "phone": "456-123-1234"
}



GET: http://localhost:8080/api/

______________________________________________________

REFERENCES:
https://www.youtube.com/watch?v=gduKpLW_vdY ( How to add Swagger to Spring Boot - Brain Bytes )
Use above video for reference only but it used a different dependency, springfox-swagger2 which is no longer actively maintained and does not support newer versions of Spring Boot

______________________________________________________

springdoc-openapi-starter-webmvc-ui is widely used and has become the de facto standard for integrating OpenAPI (formerly Swagger) documentation into Spring Boot applications, especially for projects using Spring MVC.

Here’s why it is popular and widely adopted:
Reasons for Wide Usage
1. Modern Replacement for Springfox

    Springfox was previously the most common library for integrating Swagger/OpenAPI in Spring applications.
    However, Springfox is no longer actively maintained and does not support newer versions of Spring Boot (e.g., Spring Boot 3+ with Jakarta EE).
    springdoc-openapi was developed as a modern alternative, fully compatible with Spring Boot 2.x and 3.x.

2. Ease of Use

    It integrates seamlessly with Spring Boot applications.
    Auto-generates API documentation by scanning Spring MVC controllers and their request mappings.
    Provides an embedded Swagger UI at a default URL (/swagger-ui.html or /swagger-ui).

3. Supports OpenAPI 3.0

    Fully compliant with the OpenAPI 3.0 specification, allowing you to define, share, and consume REST APIs using industry standards.

4. Rich Features

    Customizable:
        Allows developers to customize API documentation through annotations (@Operation, @Parameter, etc.) or YAML/JSON configuration files.
    Out-of-the-Box Support:
        Works with Spring Web MVC, WebFlux, and Spring Data REST.
    Integration with Security:
        Supports OpenAPI authentication mechanisms like OAuth 2.0 and JWT.
    Multi-Module and Multi-Version Support:
        Suitable for complex applications with multiple APIs and versions.
		
______________________________________________________
