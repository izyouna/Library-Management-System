# Design Specification: Library Management System README.md Documentation

**Date:** 2026-08-14  
**Topic:** README.md Documentation  
**Project:** Library Management System (`Library-Management-System`)  

---

## 1. Goal
Provide a comprehensive, professional, bilingual (Thai & English) `README.md` file at the root of the repository to document the Spring Boot Library Management System.

---

## 2. Target File
- Location: `/Users/chakritpukmee/Coding/Project/Mini_Project/Software_Design/Library-Management-System/README.md`

---

## 3. Specifications & Structure

The `README.md` will contain the following detailed sections:

### 3.1 Header & Overview
- Project Title: Library Management System (ระบบจัดการห้องสมุด)
- Brief description of the Web Application (Spring Boot + Thymeleaf + PostgreSQL).

### 3.2 Features (ฟีเจอร์การทำงาน)
- **Book Listing:** Displays all books in a table formatted with details (Title, Author, Category, ISBN, Price, Published Date, Status).
- **Add Book:** Form to input new book details.
- **Edit Book:** Form to update existing book attributes.
- **Delete Book:** Confirmation and removal of books.

### 3.3 Tech Stack (เทคโนโลยีที่พัฒนา)
- Language: Java 17
- Framework: Spring Boot 4.1.0 (Spring Data JPA, Spring Web MVC)
- Database: PostgreSQL (Port 5433, Database Name: `labmock`)
- Template Engine: Thymeleaf
- Build System: Maven (with `mvnw` wrapper)

### 3.4 Project Architecture & Folder Structure
Visual ASCII directory layout detailing layered architecture:
- `demo/src/main/java/com/example/demo/model/Book.java` (JPA Entity)
- `demo/src/main/java/com/example/demo/repository/BookRepository.java` (Data Access Layer)
- `demo/src/main/java/com/example/demo/service/BookService.java` (Business Logic Layer)
- `demo/src/main/java/com/example/demo/controller/BookController.java` (MVC Controller)
- `demo/src/main/resources/templates/books/` (`list.html`, `add.html`, `edit.html`, `delete.html`)
- `demo/src/main/resources/application.properties` (Database and Hibernate configs)

### 3.5 Database Setup (การตั้งค่าฐานข้อมูล)
- Required PostgreSQL connection specs (`jdbc:postgresql://localhost:5433/labmock`, username: `postgres`, password: `123456789`).
- SQL command snippet to create the database: `CREATE DATABASE labmock;`.

### 3.6 How to Run (ขั้นตอนการรันโปรเจกต์)
1. Clone repository.
2. Navigate to `demo/`.
3. Execute `./mvnw spring-boot:run` (Mac/Linux) or `mvnw.cmd spring-boot:run` (Windows).
4. Access web UI at `http://localhost:8080/books`.

### 3.7 Endpoint Routing Table
| Method | Endpoint | Description | View Template |
|---|---|---|---|
| GET | `/books` | View list of all books | `books/list` |
| GET | `/books/add` | Show add book form | `books/add` |
| POST | `/books/save` | Save new book | Redirect `/books` |
| GET | `/books/edit/{id}` | Show edit form for book | `books/edit` |
| POST | `/books/update/{id}` | Update existing book details | Redirect `/books` |
| GET | `/books/delete/{id}` | Show delete confirmation | `books/delete` |
| POST | `/books/delete/{id}` | Delete book from database | Redirect `/books` |

---

## 4. Self-Review Check
- [x] **Placeholder scan:** No TBD/TODO sections.
- [x] **Internal consistency:** Matches current codebase configuration (`application.properties` and controllers).
- [x] **Scope check:** Focused purely on root `README.md` creation.
- [x] **Ambiguity check:** All routes and commands are explicitly stated.
