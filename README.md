# 📚 School Library Management System

JavaFX desktop application developed for the **Object-Oriented Programming (OOP)** course at **VAMK University of Applied Sciences**.

This project demonstrates core OOP concepts by building a simple library system where users can borrow and return books or magazines through a graphical interface.

---

## 🚀 Features

### 📖 Library Items

* Books
* Magazines
* Availability tracking
* Borrowed status shown in UI

### 👤 User Types

* Guest (limit: 1 item)
* Student (limit: 3 items)
* Staff (limit: 5 items)

### 🖥 User Interface

* View all items
* Select users
* Borrow items
* Return items
* View item details
* View user borrowing status

---

## 🛠 Technologies Used

* Java 17
* JavaFX
* Maven
* Git & GitHub

---

## 📚 OOP Concepts Demonstrated

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction
* Interfaces
* SOLID Principles

---

## 📂 Project Structure

```text id="f4a9ko"
src/main/java/fi/oop
│── App.java
│── MainController.java
│
├── model/item
│   ├── Borrowable.java
│   ├── LibraryItem.java
│   ├── Book.java
│   └── Magazine.java
│
├── model/user
│   ├── LibraryUser.java
│   ├── Guest.java
│   ├── Student.java
│   └── Staff.java
│
└── service
    └── LibraryService.java
```

---

## ▶️ Run the Project

```bash id="bry82f"
mvn clean javafx:run
```

---

## 🎯 Purpose of This Project

The goal of this project is to practice designing classes, using inheritance, interfaces, and connecting backend logic to a JavaFX GUI.

---

## 👨‍💻 Author

Minh Lam Son Nguyen
Student at VAMK University of Applied Sciences
