package test;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class: creates objects with sample data and exercises the model.
 */
public class MainTest {
    public static void main(String[] args) {
        // Create employees
        MonthlyEmployee manager = new MonthlyEmployee(1, "Ahmed Hassan", Gender.MALE,
                LocalDate.of(2018, 3, 15), 15000, 21, 10, true);

        CommissionEmployee sales1 = new CommissionEmployee(2, "Sara Ali", Gender.FEMALE,
                LocalDate.of(2021, 6, 1), 5000, 0.10, 60000);

        HourlyEmployee worker1 = new HourlyEmployee(3, "Omar Khaled", Gender.MALE,
                LocalDate.of(2023, 1, 10), 100, 50, 150);

        HourlyEmployee worker2 = new HourlyEmployee(4, "Mona Samir", Gender.FEMALE,
                LocalDate.of(2022, 9, 5), 90, 35, 135);

        // Create department
        List<Employee> initial = new ArrayList<>();
        initial.add(sales1);
        initial.add(worker1);
        Department dept = new Department(10, "Operations", manager, initial);

        System.out.println("=== Department ===");
        System.out.println(dept);

        System.out.println("\n=== Add employee ===");
        dept.addEmployee(worker2);
        dept.addEmployee(manager);
        dept.printAllEmployees();

        System.out.println("\n=== Individual salaries ===");
        for (Employee e : dept.getEmployees()) {
            System.out.printf("%-12s -> %.2f%n", e.getName(), e.calculateSalary());
        }
        System.out.printf("Commission of %s: %.2f%n", sales1.getName(), sales1.calculateCommission());
        System.out.println("Additional vacation for " + manager.getName() + ": "
                + manager.calculateAdditionalVacation() + " day(s)");

        System.out.println("\n=== Find employee ===");
        System.out.println("Find id=3: " + dept.findEmployee(3));
        System.out.println("Find id=99: " + dept.findEmployee(99));

        System.out.printf("%nTotal payroll: %.2f%n", dept.calculateTotalPayroll());

        System.out.println("\n=== Remove employee ===");
        dept.removeEmployee(2);
        dept.printAllEmployees();
        System.out.printf("Total payroll after removal: %.2f%n", dept.calculateTotalPayroll());
    }
}
