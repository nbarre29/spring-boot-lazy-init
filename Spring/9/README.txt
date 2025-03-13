https://www.youtube.com/watch?v=czb2k8gWh4o&list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB&index=3

using @Value to inject values from application.properties



GET: http://localhost:8080/greeting



-> remove the my.greeting=Hello  from application.properties  and update below

@Value("${my.greeting: Default Greeting}")


-> @Value("Hello Naveen")


-> @Value("${my.list.values}")

application.properties
my.list.values=one,two,three