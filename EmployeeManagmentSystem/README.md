# Employee Management System

## Introduction
The Employee Management System (EMS) is a Java-based application designed to demonstrate advanced object-oriented programming (OOP) principles, including inheritance, polymorphism, dynamic binding, interfaces, and abstract classes.  
It manages employee records, handles leave requests, and demonstrates real-world organizational workflows with role-based responsibilities.  
This project was developed as part of the Faculty of Computing & Information Technology, King Abdulaziz University coursework.

## Table of Contents
- [Objectives](#objectives)
- [Features](#features)
- [Class Structure](#class-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Configuration](#configuration)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

## Objectives
- Practice inheritance and dynamic binding.
- Implement polymorphism and explicit casting.
- Use ArrayList for employee management.
- Apply abstract classes and interfaces.
- Work with the `instanceof` operator for type checking.

## Features
- **Abstract Employee class** with core attributes (name, ID, salary).
- **Subclasses:**
  - **Manager** (with approval authority)
  - **Developer**
  - **Designer**
- Polymorphic methods for bonus calculation and leave handling.
- Interface `Approver` for manager-level permissions.
- `EmployeeManagementSystem` class to handle:
  - Adding/removing employees
  - Approving leave
  - Marking employees as working
  - Printing employee rosters and leave records
- Leave management system (`Leave` class).

## Class Structure
The main components based on the UML:
- **Employee (abstract):** Base attributes & methods.
- **Manager:** Extends Employee, implements Approver.
- **Developer:** Extends Employee.
- **Designer:** Extends Employee.
- **Approver (interface):** Defines approval behavior.
- **Leave:** Stores leave details.
- **EmployeeManagementSystem:** Central controller.
```
              +---------------------+
              |     Employee        |  (abstract)
              +---------------------+
              | - id : int          |
              | - name : String     |
              | - salary : double   |
              +---------------------+
              | + calculateBonus()  |
              | + getters/setters   |
              +---------------------+
                       ^
          +------------+-------------+
          |            |             |
+----------------+  +----------------+  +----------------+
|    Manager     |  |   Developer    |  |   Designer     |
+----------------+  +----------------+  +----------------+
| + approveLeave()|  | + calculateBonus()| | + calculateBonus()|
| + markWorking() |  | (12% salary)    | | (10% salary)     |
| (15% salary)    |  |                 | |                  |
+-----------------+  +-----------------+ +-----------------+
          |
          | implements
          v
     +-----------------+
     |    Approver     | (interface)
     +-----------------+
     | + approveLeave()|
     | + markWorking() |
     +-----------------+

+------------------------------+
|            Leave             |
+------------------------------+
| - employee : Employee        |
| - startDate : LocalDate      |
| - duration : int             |
+------------------------------+

+--------------------------------------+
|   EmployeeManagementSystem           |
+--------------------------------------+
| - employees : ArrayList<Employee>    |
| - leaves : List<Leave>               |
+--------------------------------------+
| + addEmployee(Employee)              |
| + removeEmployee(int id)             |
| + printAllEmployees()                |
| + approveLeave(...)                  |
| + markEmployeeAsWorking(...)         |
| + findEmployeeById(int id)           |
| + printEmployeeLeaveRecords(int id)  |
+--------------------------------------+
```

## Installation
1. Clone or download the project repository.
2. Ensure you have Java 8+ installed.
3. Place the provided `Input.txt` file in the project root (for testing).
4. Compile using:
   ```sh
   javac *.java
   ```
5. Run the program with:
   ```sh
   java EmployeeManagementSystem
   ```

## Usage
- Use the main method to load commands from `Input.txt`.
- The system processes employee operations (add/remove, leave approval, etc.) sequentially.
- Results are saved to `Output.txt`.

## Testing
- **Input File (`Input.txt`):** Contains commands for simulation.
- **Execution:** Runs all operations in order.
- **Output File (`Output.txt`):** Stores system responses.

### Bonus Rules (predefined for validation):
- **Designer** → 10% of salary
- **Developer** → 12% of salary
- **Manager** → 15% of salary

## Configuration
- Modify `Input.txt` to define test cases.
- Customize employee bonus logic by adjusting methods in respective subclasses.

## Examples

### Example Input (`Input.txt`)
```
Add_Manager, Mohammed, 1, 60000
Add_Developer, Hala, 2, 30000
Add_Developer, Fatima, 3, 35000
Add_Developer, Omar, 4, 25000
Add_Developer, Ahmed, 5, 42000
Add_Developer, Yousef, 6, 45000
Add_Designer, Khalid, 7, 45000
Add_Designer, Sara, 8, 25000
Add_Designer, Ali, 9, 36000
Add_Designer, Layla, 10, 39000

Give_Leave, 1, 3, 2024-04-01, 10
Give_Leave, 1, 7, 2024-04-02, 5
Give_Leave, 1, 15, 2024-04-03, 7
Give_Leave, 2, 15, 2024-04-03, 7
Give_Leave, 1, 8, 2024-04-03, 7

Change_State, 1, 7, Working
Give_Leave, 1, 3, 2024-08-12, 5
Change_State, 1, 3, Working
Give_Leave, 1, 3, 2024-08-12, 5

del_Employee, 2
del_Employee, 5
del_Employee, 15

printAllEmployees
print_Leave_Records, 3
```

### Example Output (`Output.txt`)
```
Manager Mohammed added.
Developer Hala added.
Developer Fatima added.
Developer Omar added.
Developer Ahmed added.
Developer Yousef added.
Designer Khalid added.
Designer Sara added.
Designer Ali added.
Designer Layla added.
Leave approved for Fatima.
Leave approved for Khalid.
Leave approval failed. Either manager ID is incorrect or employee ID does not exist.
Leave approval failed. Either manager ID is incorrect or employee ID does not exist.
Leave approved for Sara.
Employee Khalid is now marked as working.
Cannot approve leave for Fatima as they are already on leave.
Employee Fatima is now marked as working.
Leave approved for Fatima.
Employee removed successfully.
Employee removed successfully.
Employee with ID 15 not found.

Name       ID   Salary     Bonus
Mohammed    1   60000.00   9000.00
Fatima      3   35000.00   4200.00
Omar        4   25000.00   3000.00
Yousef      6   45000.00   5400.00
Khalid      7   45000.00   4500.00
Sara        8   25000.00   2500.00
Ali         9   36000.00   3600.00
Layla      10   39000.00   3900.00

Leave Records for Fatima:
Start Date   Days of Leave
2024-04-01   10
2024-08-12   5
```

## Troubleshooting
- **Compilation errors:** Ensure all classes are in the same package or directory.
- **Incorrect bonus calculation:** Verify subclass `calculateBonus` overrides.
- **Leave approval issues:** Ensure manager is correctly implementing `Approver`.
- **Null employee lookup:** Check that `findEmployeeById` returns non-null before proceeding.

## Contributors
Developed as part of coursework at King Abdulaziz University.  
Faculty of Computing & Information Technology (FCIT).

## License
This project is intended for educational purposes only.
