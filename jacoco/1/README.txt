A simple maven projects in IntelliJ. Used Mockito and Junit 

Dependency injection (DI) is a process whereby objects define their dependencies (that is, the other objects with which they work) only through constructor arguments. 

Easier Testing: Because MessageProcessor depends on an interface, you can easily substitute a mock or stub implementation of MessageService in tests. This enables isolated testing of MessageProcessor’s behavior without relying on a specific MessageService implementation.

-> Add JaCoCo Plugin to pom.xml to check the code coverage.
mvn clean verify

The report will be generated in the target/site/jacoco directory.
