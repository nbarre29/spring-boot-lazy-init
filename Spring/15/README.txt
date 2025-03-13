mvn clean install
mvn spring-boot:run


com.example.userapp
├── controller
│   └── UserController.java
├── service
│   └── UserService.java
├── repository
│   └── UserRepository.java
├── model
│   └── User.java
└── UserApplication.java



1) Get User by ID
GET: http://localhost:8080/users/1
Response:
{
    "id": 1,
    "name": "Alice",
    "age": 25
}


2) Get All Users
GET: http://localhost:8080/users
Response:
[
    {
        "id": 1,
        "name": "Alice",
        "age": 25
    },
    {
        "id": 2,
        "name": "Bob",
        "age": 30
    },
    {
        "id": 3,
        "name": "Charlie",
        "age": 25
    }
]


3) Filter Users by Name
GET: http://localhost:8080/users?name=Alice
Response:
[
    {
        "id": 1,
        "name": "Alice",
        "age": 25
    }
]


4) Filter Users by Age
GET: http://localhost:8080/users?age=25
Response:
[
    {
        "id": 1,
        "name": "Alice",
        "age": 25
    },
    {
        "id": 3,
        "name": "Charlie",
        "age": 25
    }
]