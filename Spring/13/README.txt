mvn clean install
mvn spring-boot:run



GET: http://localhost:8080/greeting

Output:
{
    "id": 1,
    "content": "Hello, World!"
}

GET: http://localhost:8080/greeting?name=Naveen

Output:
{
    "id": 2,
    "content": "Hello, Naveen!"
}

________________________________________________________________

-> @PathVariable
you can rewrite the provided GreetingController to use @PathVariable instead of @RequestParam. This involves changing the way the name parameter is passed to the endpoint, moving it from a query parameter to a path variable.

Changes Made

    Endpoint Definition:
        Changed the mapping from /greeting to /greeting/{name}.

    Parameter Annotation:
        Replaced @RequestParam with @PathVariable.

    Default Value Handling:
        Removed the default value ("World") because @PathVariable requires the name parameter to always be part of the URL.

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting/{name}")
	public Greeting greeting(@PathVariable("name") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}


http://localhost:8080/greeting/Naveen
{
    "id": 1,
    "content": "Hello, Naveen!"
}



REFERENCES:
https://spring.io/guides/gs/rest-service