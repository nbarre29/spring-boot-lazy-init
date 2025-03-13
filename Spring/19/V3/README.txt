This Spring Boot client demonstrates how to call a public API using RestTemplate 

Enhancements Added to V1:

✔ Error Handling (try-catch in PostService)
✔ Logging Requests (Slf4j in RestTemplateConfig & PostService)
✔ Pagination (_page & _limit params in PostService)
✔ Additional Endpoints (GET /{id}, POST /, DELETE /{id})


mvn clean install
mvn spring-boot:run



Request 1) GET: http://localhost:8080/api/posts?page=2&size=5

2025-03-04 20:29:48 [http-nio-8080-exec-3] ERROR o.a.c.c.C.[.[.[.[dispatcherServlet] - Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.IllegalArgumentException: Name for argument of type [int] not specified, and parameter name information not available via reflection. Ensure that the compiler uses the '-parameters' flag.] with root cause
java.lang.IllegalArgumentException: Name for argument of type [int] not specified, and parameter name information not available via reflection. Ensure that the compiler uses the '-parameters' flag.


Above error indicates that the parameter names are not available at runtime. This can be fixed by ensuring that the Java compiler includes parameter names in the compiled bytecode.  Solution: Add the -parameters compiler argument to the maven-compiler-plugin configuration in your pom.xml file.

This configuration ensures that parameter names are retained in the compiled bytecode, making them available at runtime.


<plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.14.0</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                    <compilerArgs>
                        <arg>-parameters</arg>
                    </compilerArgs>
                </configuration>
            </plugin>
			
			
Request 2) GET: http://localhost:8080/api/posts/1



Request 3) POST: http://localhost:8080/api/posts
{
    "userId": 1,
    "title": "New Post",
    "body": "This is a test post."
}


Request 4) DELETE: http://localhost:8080/api/posts/1
			
			
			

		
		
		

