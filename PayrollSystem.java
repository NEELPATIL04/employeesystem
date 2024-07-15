package mainfiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void updateEmployee(int id, Scanner scanner) {
        Employee employeeToUpdate = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToUpdate = employee;
                break;
            }
        }
        if (employeeToUpdate != null) {
            System.out.println("Updating details for " + employeeToUpdate.getName());
            System.out.print("Enter new name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                employeeToUpdate.setName(newName);
            }
            System.out.print("Enter new joining date (dd/mm/yyyy, leave blank to keep current): ");
            String newJoiningDate = scanner.nextLine();
            if (!newJoiningDate.isEmpty()) {
                employeeToUpdate.setJoiningDate(newJoiningDate);
            }
            if (employeeToUpdate instanceof FullTimeEmployee) {
                System.out.print("Enter new monthly salary (leave blank to keep current): ");
                String newSalary = scanner.nextLine();
                if (!newSalary.isEmpty()) {
                    ((FullTimeEmployee) employeeToUpdate).setMonthlySalary(Double.parseDouble(newSalary));
                }
            } else if (employeeToUpdate instanceof PartTimeEmployee) {
                System.out.print("Enter new hourly rate (leave blank to keep current): ");
                String newHourlyRate = scanner.nextLine();
                if (!newHourlyRate.isEmpty()) {
                    ((PartTimeEmployee) employeeToUpdate).setHourlyRate(Double.parseDouble(newHourlyRate));
                }
                System.out.print("Enter new hours worked (leave blank to keep current): ");
                String newHoursWorked = scanner.nextLine();
                if (!newHoursWorked.isEmpty()) {
                    ((PartTimeEmployee) employeeToUpdate).setHoursWorked(Integer.parseInt(newHoursWorked));
                }
            }
            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void searchEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public double calculateTotalPayroll() {
        double totalPayroll = 0;
        for (Employee employee : employeeList) {
            totalPayroll += employee.calculateSalary();
        }
        return totalPayroll;
    }

    public void sortEmployeesByName() {
        employeeList.sort(Comparator.comparing(Employee::getName));
        System.out.println("Employees sorted by name.");
    }

    public void sortEmployeesById() {
        employeeList.sort(Comparator.comparingInt(Employee::getId));
        System.out.println("Employees sorted by ID.");
    }

    public void sortEmployeesByJoiningDate() {
        employeeList.sort(Comparator.comparing(Employee::getJoiningDate));
        System.out.println("Employees sorted by joining date.");
    }

    public void sortEmployeesBySalary() {
        employeeList.sort(Comparator.comparingDouble(Employee::calculateSalary));
        System.out.println("Employees sorted by salary.");
    }
}
