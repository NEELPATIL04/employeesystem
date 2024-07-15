# Payroll System

This project is a simple payroll system implemented in Java. It allows for the management of full-time and part-time employees, 
including adding, removing, updating, searching, displaying, and sorting employees, as well as calculating the total payroll.

## Project Structure

src/
├── Employee.java
├── FullTimeEmployee.java
├── PartTimeEmployee.java
├── PayrollSystem.java
└── MainEmp.java


## Features

1. **Add Full-Time Employee**
2. **Add Part-Time Employee**
3. **Remove Employee**
4. **Display Employees**
5. **Update Employee**
6. **Search Employee**
7. **Calculate Total Payroll**
8. **Sort Employees** by:
   - Name
   - ID
   - Joining Date
   - Salary

## Classes

### 1. Employee.java
An abstract class representing an employee with common attributes and methods.
- Attributes:
  - `name` (String)
  - `id` (int)
  - `joiningDate` (String)
- Methods:
  - `getName()`
  - `getId()`
  - `getJoiningDate()`
  - `setName(String name)`
  - `setJoiningDate(String joiningDate)`
  - `calculateSalary()` (abstract method)
  - `toString()`

### 2. FullTimeEmployee.java
A class representing a full-time employee.
- Inherits from `Employee`
- Additional Attributes:
  - `monthlySalary` (double)
- Additional Methods:
  - `getMonthlySalary()`
  - `setMonthlySalary(double monthlySalary)`
  - `calculateSalary()`

### 3. PartTimeEmployee.java
A class representing a part-time employee.
- Inherits from `Employee`
- Additional Attributes:
  - `hoursWorked` (int)
  - `hourlyRate` (double)
- Additional Methods:
  - `getHoursWorked()`
  - `setHoursWorked(int hoursWorked)`
  - `getHourlyRate()`
  - `setHourlyRate(double hourlyRate)`
  - `calculateSalary()`

### 4. PayrollSystem.java
A class to manage the payroll system.
- Attributes:
  - `employeeList` (ArrayList<Employee>)
- Methods:
  - `addEmployee(Employee employee)`
  - `removeEmployee(int id)`
  - `displayEmployees()`
  - `updateEmployee(int id, Scanner scanner)`
  - `searchEmployee(int id)`
  - `calculateTotalPayroll()`
  - `sortEmployeesByName()`
  - `sortEmployeesById()`
  - `sortEmployeesByJoiningDate()`
  - `sortEmployeesBySalary()`

### 5. MainEmp.java
The main class to run the payroll system.
- Contains the `main` method
- Provides a menu for user interaction
