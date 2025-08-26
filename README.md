<!-- Badges: Adjust Java version or badge links as needed -->
<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-11-blue?logo=java">
  <img alt="License" src="https://img.shields.io/badge/license-Educational-lightgrey">
  <img alt="Repo Size" src="https://img.shields.io/github/repo-size/masiri0240-jpg/project">
  <img alt="Last Commit" src="https://img.shields.io/github/last-commit/masiri0240-jpg/project">
</p>

# 📂 CPCS203 Project Repository

Welcome! 🎉  
This repository contains **two independent Java projects** developed as coursework at **King Abdulaziz University, Faculty of Computing & Information Technology (FCIT)**.

Each project has its own folder with a **detailed README** covering installation, usage, examples, and testing.

---

## 🚀 Projects Overview

### 1️⃣ [Employee Management System](./EmployeeManagementSystem/README.md) 👨‍💼👩‍💻

A Java-based system that demonstrates **advanced OOP concepts**:

- Abstract `Employee` class with subclasses (`Manager`, `Developer`, `Designer`)
- Polymorphism for **bonus calculation** 💰
- Managers can **approve/reject leave requests** 📝
- Employee roster managed with `ArrayList` 📋
- Leave tracking and reporting 🗓️

👉 [Read More → Employee Management System](./EmployeeManagementSystem/README.md)

---

### 2️⃣ [Airline Ticket Reservation System](./AirlineTicketReservationSystem/README.md) ✈️🎟️

A simulation of a flight booking platform:

- Register flights (`AddFlight`) ✈️ and passengers (`AddPassenger`) 🧳
- Book tickets with **seat allocation & class type** 💺
- Generate invoices for passengers (`GenerateInvoice`) 🧾
- Summarize all bookings per flight (`GenerateFlightInvoice`)
- Visualize seat maps in tabular format 📊
- Uses **File I/O** for input commands and output records

👉 [Read More → Airline Ticket Reservation System](./AirlineTicketReservationSystem/README.md)

---

## 📂 Repository Structure

```text
├── EmployeeManagementSystem/
│   ├── src/                  # Java source files
│   ├── Input.txt             # Sample input commands
│   ├── Output.txt            # Sample output
│   └── README.md             # Project-specific documentation
│
├── AirlineTicketReservationSystem/
│   ├── src/                  # Java source files
│   ├── flight_passenger.txt  # Flight & passenger data
│   ├── inputCommands.txt     # Booking commands
│   ├── output.txt            # Generated results
│   └── README.md             # Project-specific documentation
│
└── README.md                 # This file (outer overview)
```

---

## 🛠️ How to Run

1. **Clone this repository:**
   ```bash
   git clone https://github.com/masiri0240-jpg/project.git
   cd project
   ```
2. **Choose a project folder:**
   - `EmployeeManagementSystem/`
   - `AirlineTicketReservationSystem/`
3. **Follow the instructions inside each project’s `README.md` to compile & run.**

---

## 🎉 Fun Facts

- The Employee Management System decides who gets a bonus and who takes a vacation 😎.
- The Airline Ticket System decides where you sit on the plane (hopefully not the middle seat 🪑).
- Together, they make sure you earn money 💵 and then spend it on travel ✈️!

---

## 👨‍💻 Contributors

- Built by students at **King Abdulaziz University**
- Faculty of Computing & Information Technology (FCIT)

---

## 📜 License

This repository is intended for **educational purposes only**.
