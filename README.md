# Student Management System

Console-based Student Management System built using Java, JDBC, and MySQL.

## Features
- CRUD operations for student records
- Secure database access using PreparedStatement
- Modular project structure (model, dao, util, app)
- REST-style backend flow (conceptual)
- Git-based version control

## Technologies Used
- Java
- MySQL
- JDBC
- Git & GitHub

## Project Structure
StudentManagementSystem
├── src
│   ├── app        # Main controller and user interaction
│   ├── dao        # Database access layer
│   ├── model      # Student data model
│   └── util       # Database connection utility
├── .gitignore
└── README.md

## How to Run
1. Create the required MySQL database and tables
2. Update database credentials in DBConnection.java
3. Run Main.java
