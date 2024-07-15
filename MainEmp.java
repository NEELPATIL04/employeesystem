package mainfiles;

import java.util.Scanner;

public class MainEmp {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n------ Payroll System Menu ------");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Update Employee");
            System.out.println("6. Search Employee");
            System.out.println("7. Calculate Total Payroll");
            System.out.println("8. Sort Employees");
            System.out.println("9. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String ftName = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int ftId = scanner.nextInt();
                    System.out.print("Enter monthly salary: ");
                    double monthlySalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter joining date (dd/mm/yyyy): ");
                    String ftJoiningDate = scanner.nextLine();
                    FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(ftName, ftId, monthlySalary, ftJoiningDate);
                    payrollSystem.addEmployee(fullTimeEmployee);
                    System.out.println("Full-Time Employee added successfully.");
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String ptName = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int ptId = scanner.nextInt();
                    System.out.print("Enter hours worked: ");
                    int hoursWorked = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double hourlyRate = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter joining date (dd/mm/yyyy): ");
                    String ptJoiningDate = scanner.nextLine();
                    PartTimeEmployee partTimeEmployee = new PartTimeEmployee(ptName, ptId, hoursWorked, hourlyRate, ptJoiningDate);
                    payrollSystem.addEmployee(partTimeEmployee);
                    System.out.println("Part-Time Employee added successfully.");
                    break;
                case 3:
                    System.out.print("Enter the ID of the employee to remove: ");
                    int removeId = scanner.nextInt();
                    payrollSystem.removeEmployee(removeId);
                    break;
                case 4:
                    payrollSystem.displayEmployees();
                    break;
                case 5:
                    System.out.print("Enter the ID of the employee to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    payrollSystem.updateEmployee(updateId, scanner);
                    break;
                case 6:
                    System.out.print("Enter the ID of the employee to search: ");
                    int searchId = scanner.nextInt();
                    payrollSystem.searchEmployee(searchId);
                    break;
                case 7:
                    System.out.println("Total payroll: " + payrollSystem.calculateTotalPayroll());
                    break;
                case 8:
                    System.out.println("Sort by:");
                    System.out.println("1. Name");
                    System.out.println("2. ID");
                    System.out.println("3. Joining Date");
                    System.out.println("4. Salary");
                    System.out.print("Enter your choice: ");
                    int sortChoice = scanner.nextInt();
                    switch (sortChoice) {
                        case 1:
                            payrollSystem.sortEmployeesByName();
                            break;
                        case 2:
                            payrollSystem.sortEmployeesById();
                            break;
                        case 3:
                            payrollSystem.sortEmployeesByJoiningDate();
                            break;
                        case 4:
                            payrollSystem.sortEmployeesBySalary();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
