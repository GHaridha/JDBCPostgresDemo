# JDBC Postgres Demo

This is a simple Java-based Student Management system using JDBC and PostgreSQL. It allows performing basic CRUD operations (Create, Read, Update, Delete) on student records.

## Features:
- Add a student
- Update a student's information
- Delete a student
- Fetch all students
- Fetch a student by ID

## Requirements:
- Java 8 or higher
- PostgreSQL Database

## Setup:
1. Clone this repository to your local machine.
2. Create a PostgreSQL database named `postgres`.
3. Configure the database connection by editing the `dbconfig.properties` file with your credentials.
4. Run the `StudentController` class to interact with the system.

## Technologies Used:
- Java (JDBC)
- PostgreSQL

## How to Run:
1. Compile the Java files: `javac src/com/example/jdbc/*.java`
2. Run the `StudentController` class: `java com.example.jdbc.controller.StudentController`

## License:
This project is open source and available under the [MIT License](LICENSE).
