package model;

import java.time.LocalDate;

/**
 * Employee paid a base salary plus a commission on sales.
 */
public class CommissionEmployee extends Employee {
    private double baseSalary;
    private double commissionRate;   // e.g. 0.10 = 10%
    private double salesAmount;

    public CommissionEmployee(int id, String name, Gender gender, LocalDate hireDate,
                              double baseSalary, double commissionRate, double salesAmount) {
        super(id, name, gender, hireDate);
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
        this.salesAmount = salesAmount;
    }

    // Getters
    public double getBaseSalary() { return baseSalary; }
    public double getCommissionRate() { return commissionRate; }
    public double getSalesAmount() { return salesAmount; }

    // Setters
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    public void setCommissionRate(double commissionRate) { this.commissionRate = commissionRate; }
    public void setSalesAmount(double salesAmount) { this.salesAmount = salesAmount; }

    public double calculateCommission() {
        return salesAmount * commissionRate;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + calculateCommission();
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" + super.toString()
                + ", baseSalary=" + baseSalary
                + ", commissionRate=" + commissionRate
                + ", salesAmount=" + salesAmount
                + ", salary=" + calculateSalary() + "}";
    }
}
