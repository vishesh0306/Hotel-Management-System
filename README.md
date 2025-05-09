# 🏨 Hotel Management System (Console-Based Java App) 💻

Welcome to the **Hotel Management System**, a Java-based console application that simulates real-world hotel operations using object-oriented programming. Built with **Core Java**, this system offers role-based access for **Admins 👑**, **Managers 🧑‍💼**, and **Customers 🧍** to manage rooms, bookings, and payments efficiently.

---

## ✨ Features

### 👑 Admin Panel
- 🔍 View all customers and managers
- ➕ Add new managers
- ❌ Remove managers or customers
- 📆 View all bookings
- 📊 Generate CSV reports
- 🚪 Exit

### 🧑‍💼 Manager Console
- 🛏️ View available rooms
- ➕ Add a room
- ❌ Remove a room
- 💸 Change room price
- 🚪 Exit

### 🧍 Customer Portal
- 🏨 View available rooms
- 💵 Check room prices
- 🛒 Add rooms to cart
- 📦 View or clear cart
- 💳 Make payment
- ✅ Checkout
- 📖 View booked rooms
- 🚪 Exit

---

## 🔧 Technologies Used
- **Java (Core)**
- **OOP Principles**
- **File I/O**
- **CSV File Generation**
- **Console-Based UI**

---

## 🗂️ Project Structure

## 📁 Project Structure

Follows a clean and modular architecture 🧱:

- 🧍‍♂️ `Entity/` – Domain models like **Admin**, **Room**, **Customer**, etc.
- 🛠️ `Service/` – Business logic and core operations (Booking, Reports, Calculator...)
- 🗄️ `Database2/` – Simulated in-memory database to store data during runtime
- 🚀 `Driver/` – Application entry point and **CSV report** generator
