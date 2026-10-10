package model;

import java.time.LocalDate;
import java.time.Period;

/**
 * Employee paid a fixed monthly salary plus a percentage bonus.
 */
public class MonthlyEmployee extends Employee {
    private double monthlySalary;
    private int vacationDays;
    private double bonusPercentage;   // e.g. 10 = 10%
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                           double monthlySalary, int vacationDays,
                           double bonusPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        this.monthlySalary = monthlySalary;
        this.vacationDays = vacationDays;
        this.bonusPercentage = bonusPercentage;
        this.hasHealthInsurance = hasHealthInsurance;
    }

    // Getters
    public double getMonthlySalary() { return monthlySalary; }
    public int getVacationDays() { return vacationDays; }
    public double getBonusPercentage() { return bonusPercentage; }
    public boolean isHasHealthInsurance() { return hasHealthInsurance; }

    // Setters
    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }
    public void setVacationDays(int vacationDays) { this.vacationDays = vacationDays; }
    public void setBonusPercentage(double bonusPercentage) { this.bonusPercentage = bonusPercentage; }
    public void setHasHealthInsurance(boolean hasHealthInsurance) { this.hasHealthInsurance = hasHealthInsurance; }

    @Override
    public double calculateSalary() {
        return monthlySalary + (monthlySalary * bonusPercentage / 100.0);
    }

    /**
     * Extra vacation days earned: 1 additional day for every 2 full years of service.
     */
    public int calculateAdditionalVacation() {
        int years = Period.between(getHireDate(), LocalDate.now()).getYears();
        return years / 2;
    }

    @Override
    public String toString() {
        return "MonthlyEmployee{" + super.toString()
                + ", monthlySalary=" + monthlySalary
                + ", vacationDays=" + vacationDays
                + ", bonusPercentage=" + bonusPercentage
                + ", hasHealthInsurance=" + hasHealthInsurance
                + ", salary=" + calculateSalary() + "}";
    }
}
