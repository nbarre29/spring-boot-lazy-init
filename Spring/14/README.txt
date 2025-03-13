mvn clean install
mvn spring-boot:run


@PathVariable
GET: http://localhost:8080/api/users/42
Output: User ID: 42


@RequestParam
GET: http://localhost:8080/api/search?name=John&age=30
Output: Searching for user: John, Age: 30



Key Considerations

    Use @PathVariable:
        When the value is part of the URL structure.
        Example: /users/{id}, where id is a unique identifier.

    Use @RequestParam:
        When the value is optional or acts as a filter.
        Example: /search?name=John, where name is a query parameter.
		
	Default Values:
    @RequestParam allows setting default values using the defaultValue attribute.
	
	
Conclusion

    Use @PathVariable for path-based parameters where the value is part of the URL structure.
    Use @RequestParam for query parameters where values are passed as key-value pairs in the URL.
	
	

Key Differences Between @PathVariable and @RequestParam

Purpose:
@PathVariable is used to extract values from the URL path, whereas @RequestParam extracts query parameters from the URL query string.

Binding:
@PathVariable maps to placeholders in the URL path, while @RequestParam maps to query string parameters.

Optional Parameters:
For @PathVariable, parameters are not optional by default, but they can be made optional. For @RequestParam, parameters are optional by default and can have default values.

Syntax:
For @PathVariable, values appear as placeholders in the path, such as /users/{id}. For @RequestParam, values appear in the query string as key-value pairs, such as ?id=value.

Use Case:
Use @PathVariable when the value is part of the URL structure, such as identifying resources. Use @RequestParam when the value is passed as a key-value pair in the query string, often for filtering or additional parameters.