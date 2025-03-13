This Spring Boot client demonstrates how to call a public API using WebClient (Reactive Approach)

mvn clean install
mvn spring-boot:run


-> GET: http://localhost:8080/api/posts


Steps to Set Up the Client Application

    Create a Spring Boot project with dependencies in pom.xml
        Spring Web (spring-boot-starter-web)
        Jackson for JSON parsing (included in Spring Web)
        Lombok (optional for reducing boilerplate code)
		spring-boot-starter-webflux
		
Post.java: This class maps to the JSON response from the public API.
		
PostService.java: uses WebClient to fetch posts from the public API.

PostController.java: This exposes an endpoint to retrieve posts from the public API.