mvn clean install
mvn spring-boot:run

-> check in postman with GET request, should see a list of all courses in JSON format.
http://localhost:8080/courses


-> convert the spring application from folder 3 above to a a spring-boot application.

Note the below changes.
1) pom.xml

2) Added CourseController.java

3) Create the main Spring Boot application class: Update Application.java to use @SpringBootApplication and SpringApplication.run.

4) AppConfig.java is not required here, as we already have @Service annotation.  We can delete it.

_____________________________________________________________________

Additional changes that we can try 

->
 @GetMapping("/getAllCourses")
    public List<Course> getAllCourses() {
        return courseService.list();
    }
	
http://localhost:8080/courses/getAllCourses

-> Add spring-boot-devtools dependency

<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <version>3.4.0</version>
            <scope>runtime</scope>
        </dependency>
		
		
Ensure that your IDE (IntelliJ IDEA) is configured to compile the project automatically. You can enable this by going to File > Settings > Build, Execution, Deployment > Compiler and checking the Build project automatically option.
