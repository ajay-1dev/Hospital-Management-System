# 🏥 Hospital Management System

A backend REST API for managing core hospital operations such as **patients, doctors, departments, appointments, and insurance**.

This project is built using **Java 25 and Spring Boot** and follows a layered architecture using Spring Data JPA and Hibernate for database persistence.

> **Project Status:** Personal / Learning Project
> The project is continuously being improved to practice real-world backend development concepts.

---

## 🚀 Features

* Patient management
* Doctor management
* Department management
* Appointment management
* Insurance management
* Patient–Insurance relationship
* Patient–Appointment relationship
* Doctor–Appointment relationship
* Doctor–Department relationship
* Request DTOs
* Bean Validation
* Global exception handling
* JPA entity relationships
* JPA auditing
* Custom JPQL queries
* Derived query methods
* Projection queries
* Group By and aggregation queries
* MySQL database integration
* Environment-based configuration
* Layered backend architecture

---

## 🛠️ Tech Stack

| Technology              | Purpose                         |
| ----------------------- | ------------------------------- |
| Java 25                 | Programming language            |
| Spring Boot 4.0.3       | Backend framework               |
| Spring Web              | REST API development            |
| Spring Data JPA         | Data access                     |
| Hibernate               | ORM                             |
| MySQL                   | Database                        |
| Lombok                  | Reduce boilerplate code         |
| Jakarta Bean Validation | Request validation              |
| Gradle                  | Build tool                      |
| dotenv-java             | Environment variable management |

---

# 🏗️ Architecture

The application follows a layered architecture:

```text
                    Client
                      │
                      ▼
                 Controller
                      │
                      ▼
                     DTO
                      │
                      ▼
                  Service
                      │
                      ▼
                 Repository
                      │
                      ▼
               Spring Data JPA
                      │
                      ▼
                  Hibernate
                      │
                      ▼
                    MySQL
```

### Controller Layer

Responsible for:

* Receiving HTTP requests
* Validating request data
* Calling service methods
* Returning HTTP responses

### DTO Layer

Request DTOs are used to separate API request models from JPA entities.

### Service Layer

Contains application and business logic.

### Repository Layer

Uses Spring Data JPA to communicate with the database.

### Entity Layer

Contains JPA entities representing the application's database model.

---

# 📦 Main Modules

## 👤 Patient

The Patient module manages patient information.

### Base Endpoint

```text
/Api/v1/patients
```

### Operations

```text
GET    /Api/v1/patients
GET    /Api/v1/patients/{id}
POST   /Api/v1/patients
PUT    /Api/v1/patients/edit/{id}
DELETE /Api/v1/patients/{id}
```

---

## 👨‍⚕️ Doctor

The Doctor module manages doctors working in the hospital.

### Base Endpoint

```text
/v1/doctor
```

### Operations

```text
POST   /v1/doctor
GET    /v1/doctor
GET    /v1/doctor/{id}
PUT    /v1/doctor/{id}
```

---

## 🏢 Department

The Department module manages hospital departments and doctor assignments.

### Base Endpoint

```text
/v1/department
```

### Operations

```text
POST   /v1/department/{doctorId}
GET    /v1/department
PUT    /v1/department/assignheaddoctor/{departmentId}/{headDoctorId}
PUT    /v1/department/assigndoctor/{departmentId}/{doctorId}
DELETE /v1/department/{id}
```

---

## 📅 Appointment

The Appointment module manages appointments between patients and doctors.

### Base Endpoint

```text
/v1/appointment
```

### Operations

```text
POST   /v1/appointment
GET    /v1/appointment
PUT    /v1/appointment/{id}
DELETE /v1/appointment/{id}
```

---

## 🛡️ Insurance

The Insurance module manages patient insurance information.

### Base Endpoint

```text
/v1/insurance
```

### Operations

```text
POST   /v1/insurance
GET    /v1/insurance
```

---

# 🔗 Entity Relationships

The project demonstrates several JPA/Hibernate relationships.

```text
                     ┌──────────────┐
                     │    Patient   │
                     └──────┬───────┘
                            │
                       One-to-One
                            │
                            ▼
                     ┌──────────────┐
                     │   Insurance  │
                     └──────────────┘


                     ┌──────────────┐
                     │    Patient   │
                     └──────┬───────┘
                            │
                       One-to-Many
                            │
                            ▼
                     ┌──────────────┐
                     │ Appointment  │
                     └──────┬───────┘
                            ▲
                            │
                       Many-to-One
                            │
                     ┌──────┴───────┐
                     │    Doctor    │
                     └──────┬───────┘
                            │
                       Many-to-Many
                            │
                            ▼
                     ┌──────────────┐
                     │ Department  │
                     └──────────────┘
```

The project uses JPA annotations such as:

```java
@OneToOne
@OneToMany
@ManyToOne
@ManyToMany
@JoinColumn
@JoinTable
```

---

# 🗄️ Database

The application uses **MySQL**.

Create the database:

```sql
CREATE DATABASE hospitalmanagementsystem;
```

Database configuration is handled through environment variables.

Example:

```env
DB_PASSWORD=your_mysql_password
```

---

# 🔐 Environment Configuration

The project uses environment variables for sensitive configuration.

Create a `.env` file in the project root:

```env
DB_PASSWORD=your_mysql_password
```

A `.env.example` file is provided as a reference.

```env
DB_PASSWORD=your_mysql_password
```

### ⚠️ Important

Do **not** commit your real `.env` file to GitHub.

Your `.gitignore` should contain:

```text
.env
```

Only `.env.example` should be committed to the repository.

---

# ▶️ Running the Application

## 1. Clone the repository

```bash
git clone https://github.com/ajay-1dev/Hospital-Management-System.git
```

Move into the project:

```bash
cd Hospital-Management-System
```

## 2. Configure MySQL

Make sure MySQL is running.

Create the database:

```sql
CREATE DATABASE hospitalmanagementsystem;
```

## 3. Configure environment variables

Create:

```text
.env
```

in the project root.

Add:

```env
DB_PASSWORD=your_mysql_password
```

## 4. Run the application

### Windows

```bash
gradlew.bat bootRun
```

### Linux / macOS

```bash
./gradlew bootRun
```

Or run the main application class from IntelliJ IDEA:

```text
HospitalManagementSystemApplication
```

The application runs on:

```text
http://localhost:8080
```

---

# 🧪 Validation

The project uses Jakarta Bean Validation for validating incoming API requests.

Examples include:

```java
@NotNull
@NotBlank
@Email
```

Validation helps prevent invalid data from entering the application.

---

# 🚨 Exception Handling

The project includes centralized exception handling.

Instead of handling every exception separately inside controllers, common application errors are handled centrally.

This helps provide consistent error responses to API clients.

---

# 🔍 Database Queries

The project demonstrates different Spring Data JPA query approaches.

### Derived Queries

Example concept:

```java
findBy...
```

### JPQL

Custom JPQL queries are used for more specific database operations.

### Projections

Projection queries are used when only selected fields are required instead of retrieving an entire entity.

### Aggregation

The project also demonstrates:

```text
GROUP BY
COUNT
Aggregation queries
```

These concepts are useful for building database-driven backend applications.

---

# 🕒 JPA Auditing

The project uses Spring Data JPA auditing to automatically track entity timestamps.

Examples include:

```java
@CreatedDate
@LastModifiedDate
```

Auditing is enabled using:

```java
@EnableJpaAuditing
```

This helps maintain information about when entities were created and last modified.

---

# 📁 Project Structure

```text
Hospital-Management-System
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.Hospital_Management_System
│   │   │       │
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       │   └── request
│   │   │       ├── GlobalException
│   │   │       ├── Repository
│   │   │       ├── schema
│   │   │       │   └── Enums
│   │   │       └── Service
│   │   │
│   │   └── resources
│   │       └── application.yml
│   │
│   └── test
│       └── java
│
├── .env.example
├── .gitignore
├── build.gradle
├── settings.gradle
└── README.md
```

---

# 📝 API Naming Note

The project currently uses different endpoint naming conventions between modules.

For example:

```text
/Api/v1/patients
```

is used by the Patient module, while other modules currently use:

```text
/v1/doctor
/v1/department
/v1/appointment
/v1/insurance
```

This is **intentional in the current learning version of the project**.

The difference provides an opportunity for developers working with the project to identify and improve API naming and versioning consistency.

A future improvement would be to standardize all endpoints under a common convention such as:

```text
/api/v1/patients
/api/v1/doctors
/api/v1/departments
/api/v1/appointments
/api/v1/insurances
```

---

# 🎯 Learning Objectives

This project was created to practice and demonstrate:

* Java backend development
* Spring Boot
* REST API development
* Layered architecture
* Spring Data JPA
* Hibernate
* Entity relationships
* DTO-based API design
* Bean Validation
* Exception handling
* JPQL
* Derived queries
* Projections
* Aggregation queries
* MySQL integration
* JPA auditing
* Environment configuration
* Git and GitHub workflow

---

# 🔮 Future Improvements

The project can be extended with:

* Comprehensive unit tests
* Integration tests
* Swagger / OpenAPI documentation
* Standardized API naming
* Pagination and sorting
* Authentication and authorization
* Role-based access control
* Complete soft-delete implementation
* Improved API response DTOs
* Docker support
* Database migration management
* CI/CD using GitHub Actions
* Hospital staff/user management
* Appointment status management
* Prescription management
* Medical records management

---

# 👨‍💻 Author

## Ajay Kumar

**Backend Developer | Java | Spring Boot**

### Profiles

* GitHub: https://github.com/ajay-1dev
* LinkedIn: https://www.linkedin.com/in/ajaypayyabula/
* LeetCode: https://leetcode.com/u/ajaypayyabula/
* HackerRank: https://www.hackerrank.com/profile/ajaypayyabula

---

## ⭐ Project

If you find this project useful for learning Spring Boot, JPA, and backend development, feel free to explore the code and suggest improvements.
