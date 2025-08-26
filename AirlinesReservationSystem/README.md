# Airline Ticket Reservation System

## Introduction

The Airline Ticket Reservation System is a Java-based application designed to simplify booking flights, managing passenger details, and handling reservations.  
It demonstrates object-oriented programming (OOP) and File I/O operations by simulating a real-world airline system where passengers can be registered, flights added, seats booked, and invoices generated.  
This project was developed as part of the **CPCS203 Programming-II (Semester 2)** coursework at King Abdulaziz University, Faculty of Computing & Information Technology (FCIT).

---

## Table of Contents

- [Objectives](#objectives)
- [Features](#features)
- [Class Structure](#class-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

---

## Objectives

- Learn classes and objects implementation in Java.
- Practice File I/O (reading/writing) with structured input/output files.
- Use arrays of objects and manage relationships between them.
- Implement ticket booking workflows including seat allocation and invoicing.

---

## Features

- **Flight Registration (`AddFlight`)**: Add new flights with flight number, departure/arrival cities, gate, and seat map.
- **Passenger Registration (`AddPassenger`)**: Register passengers by passport number and name.
- **Booking Tickets (`BookTicket`)**: Assign passengers to specific flights, seats, and classes.
- **Invoice Generation (`GenerateInvoice`)**: Generate ticket invoices based on class and VAT rules.
- **Flight Invoice (`GenerateFlightInvoice`)**: Summarize all bookings and total ticket prices for a flight.
- **Seat Plan Visualization**: Displays seat allocation in a tabular format.
- **Validation Handling**: Detects duplicate seats, missing passengers, missing flights, etc.

---

## Class Structure

- **Passenger**: Stores passport number and name.
- **Flight**: Holds flight details and a seat map (2D array).
- **Ticket**: Represents a booking with passenger, flight, seat, class, and reservation number.
- **BookingSystem**: Main controller, managing passengers, flights, and ticketing operations.

---

## Installation

1. Clone or download this repository.
2. Ensure you have **Java 8+** installed.
3. Place input files in the project root (`flight_passenger.txt`, `inputCommands.txt`).
4. Compile:
    ```sh
    javac *.java
    ```
5. Run:
    ```sh
    java BookingSystem
    ```

---

## Usage

- Commands are read from `inputCommands.txt` and processed sequentially.
- Results are written to `output.txt`.
- Supports commands:
    - `AddFlight <flightNumber> <depCity> <arrCity> <gate> <rows> <cols>`
    - `AddPassenger <passport> <name>`
    - `BookTicket <passport> <flight> <row> <col> <class>`
    - `GenerateInvoice <reservationNumber>`
    - `GenerateFlightInvoice <flightNumber>`

---

## Testing

**Input files provided:**
- `flight_passenger.txt` → preloaded flight & passenger data.
- `inputCommands.txt` → list of booking operations.

**Output file generated:**
- `output.txt` → contains booking confirmations, invoices, and flight seat plans.

---

## Examples

### Example Input (`inputCommands.txt`)

```
BookTicket X12345 551 10 C BusinessClass
BookTicket X12345 601 10 A BusinessClass
BookTicket X18345 601 80 C BusinessClass
BookTicket X18345 601 10 C BusinessClass
BookTicket X12345 61 10 S BusinessClass
BookTicket Z34563 551 10 D FirstClass
BookTicket X12345 601 10 S BusinessClass
GenerateInvoice 101
GenerateInvoice 100
GenerateInvoice 103
GenerateFlightInvoice 551
GenerateFlightInvoice 601
GenerateFlightInvoice 503
GenerateFlightInvoice 61
```

### Example Output (`output.txt`)

```
Flight 501 added successfully
Flight 601 added successfully
Flight 509 added successfully
Flight 551 added successfully
Flight 671 added successfully
Passenger Ahmed_Ali added successfully
Passenger Jane_Smith added successfully
Passenger Emily_Johnson added successfully
...

*********************BookTicket**************************
Seat booked successfully.
Ticket Information:
Reservation Confirmation Number=100, Flight Number=551, Passenger Name=Ahmed_Ali, Seat Number=10C, classType=BusinessClass

*********************BookTicket**************************
Passenger with Passport number X18345 is not Registered

*********************Generate Ticket Invoice**************************
Ticket Information:
Reservation Confirmation Number=101, Flight Number=601, Passenger Name=Ahmed_Ali, Seat Number=10A, classType=BusinessClass
Total ticket price = 6900.0

*********************Generate Flight Invoice**************************
Seat Plane for flight 551 is:
Row  a  b  c  d  e  f
10   o  o  X12345  Z34563  o  o

Total Invoice price =14720.0
```

---

## Troubleshooting

- **Passenger not found** → Make sure passenger is added via `AddPassenger`.
- **Flight not found** → Ensure flight is added via `AddFlight`.
- **Seat already reserved** → Choose another seat.
- **Reservation not available** → Double-check confirmation numbers.

---

## Contributors

Developed as part of **CPCS203 Programming-II** at King Abdulaziz University (FCIT).

---

## License

This project is intended for educational purposes only.
