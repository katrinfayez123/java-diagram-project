package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A department has a manager and a list of employees (composition).
 */
public class Department {
    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.employees = (employees != null) ? new ArrayList<>(employees) : new ArrayList<>();
        for (Employee e : this.employees) {
            e.setDepartment(this);
        }
        if (manager != null) {
            manager.setDepartment(this);
        }
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public Employee getManager() { return manager; }
    public List<Employee> getEmployees() { return employees; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setManager(Employee manager) {
        this.manager = manager;
        if (manager != null) {
            manager.setDepartment(this);
        }
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = (employees != null) ? new ArrayList<>(employees) : new ArrayList<>();
        for (Employee e : this.employees) {
            e.setDepartment(this);
        }
    }

    public void addEmployee(Employee employee) {
        if (employee != null && findEmployee(employee.getId()) == null) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(int employeeId) {
        Employee e = findEmployee(employeeId);
        if (e != null) {
            employees.remove(e);
            e.setDepartment(null);
        }
    }

    public Employee findEmployee(int employeeId) {
        for (Employee e : employees) {
            if (e.getId() == employeeId) {
                return e;
            }
        }
        return null;
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public void printAllEmployees() {
        System.out.println("Employees in " + name + ":");
        if (employees.isEmpty()) {
            System.out.println("  (no employees)");
            return;
        }
        for (Employee e : employees) {
            System.out.println("  " + e);
        }
    }

    @Override
    public String toString() {
        return "Department{id=" + id
                + ", name='" + name + '\''
                + ", manager=" + (manager != null ? manager.getName() : "N/A")
                + ", employeesCount=" + employees.size() + "}";
    }
}
