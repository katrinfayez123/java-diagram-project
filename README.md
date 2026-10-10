# Employee Management System

**Name:** Catherine Fayez
**Student ID:** 2300313

## Description
A Java implementation of a UML class diagram for an employee management system.

- `Employee` (abstract): id, name, gender, hireDate, department, `calculateSalary()`
- `CommissionEmployee`: base salary + commission on sales
- `MonthlyEmployee`: monthly salary + bonus percentage, vacation days, health insurance
- `HourlyEmployee`: hourly pay with overtime after 40 hours
- `Department`: has a manager and a list of employees; add/remove/find employees, total payroll
- `Gender` (enum): `MALE`, `FEMALE`

## Project Structure
```
EmployeeManagementSystem/
├── src/
│   ├── Main.java
│   ├── model/   (Employee, CommissionEmployee, MonthlyEmployee, HourlyEmployee, Department, Gender)
│   └── test/    (MainTest.java)
└── README.md
```

## How to Run

### Command line (JDK 11+)
```bash
mkdir out
javac -d out src/model/*.java src/test/*.java src/Main.java
java -cp out Main
```

### IDE
Open the folder as a Java project, mark `src` as the source root, and run `Main` (or `test.MainTest`).