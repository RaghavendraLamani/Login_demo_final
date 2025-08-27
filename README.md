Perfect 👍
Here’s a **README.md** tailored for your **GitHub repository** (so anyone cloning it understands setup & usage).

---

# 📧 OTP-Based Login & Signup System (Java + MySQL)

A simple **Java console application** where users can **sign up and log in using OTP verification via email**.
It uses **MySQL** for data storage and **Jakarta Mail API** for sending OTPs.

---

## 🚀 Features

* 🔐 **Sign Up with OTP verification**
* 🔑 **Login with OTP verification**
* 📬 **Email delivery using Gmail SMTP**
* 🗄️ **MySQL integration for user data**
* 💻 **Console-based UI**

---

## 🛠️ Tech Stack

* Java (17+)
* Maven
* MySQL
* Jakarta Mail (2.0.1)

---

## 📂 Project Structure

```
src/main/java
 ├── dao/
 │   └── UserDAO.java
 ├── model/
 │   └── User.java
 ├── service/
 │   ├── GenerateOTP.java
 │   ├── SendOTPService.java
 │   └── UserService.java
 ├── Views/
 │   └── Welcome.java
 └── Main.java
```

---

## ⚡ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/otp-login-system.git
cd otp-login-system
```

### 2️⃣ Setup MySQL Database

```sql
CREATE DATABASE otp_app;
USE otp_app;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

### 3️⃣ Configure Email (SMTP)

* Enable **2-Step Verification** in your Google account
* Generate a **16-digit App Password**
* Update `SendOTPService.java` with:

```java
final String fromEmail = "your-email@gmail.com";
final String password = "your-app-password";
```

### 4️⃣ Run the Application

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="Main"
```

---

## 🎯 Usage

When running:

```
Welcome to the Application
Press 1 to login
Press 2 to signup
Press 0 to exit
```

* If you **Sign Up**, you will receive an OTP email.
* Enter OTP → User saved to MySQL.
* If you **Login**, OTP verification is required.

---

## 📌 Dependencies

Defined in `pom.xml`:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>jakarta.mail</artifactId>
    <version>2.0.1</version>
</dependency>
```

---

## ✅ Example Run

```
Enter your email: test@example.com
📬 OTP sent to test@example.com
Enter OTP: 1234
✅ Login successful!
```

---

## 📝 License

This project is licensed under the **MIT License**.

---

Would you like me to also include **badges** (Java, Maven, MySQL, License) at the top of the README so it looks professional on GitHub?
