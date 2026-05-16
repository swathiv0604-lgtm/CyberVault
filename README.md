
# CyberVault 🔐

CyberVault is a secure Java-based desktop application developed for managing and protecting user credentials efficiently. The application provides a user-friendly graphical interface with authentication, credential management, and database integration features.

---

## 🚀 Features

- User Registration & Login System
- Secure Credential Management
- Add / Store Credentials
- Dashboard Interface
- MySQL Database Connectivity
- Java Swing GUI
- DAO-Based Architecture
- Organized MVC Structure

---

## 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| Java | Core Application Development |
| Java Swing | GUI Development |
| MySQL | Database |
| JDBC | Database Connectivity |
| VS Code | Development Environment |

---

## 📂 Project Structure

```bash
CyberVault/
│
├── src/
│   ├── dao/
│   │   ├── CredentialDAO.java
│   │   └── UserDAO.java
│   │
│   ├── db/
│   │   └── DBConnection.java
│   │
│   ├── gui/
│   │   ├── LoginForm.java
│   │   ├── RegisterForm.java
│   │   ├── Dashboard.java
│   │   └── AddCredentialForm.java
│   │
│   └── model/
│       ├── User.java
│       └── Credential.java
│
├── lib/
│   └── mysql-connector-j-9.7.0.jar
│
├── database.sql
├── README.md
└── .gitignore
