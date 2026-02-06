package Session10.B5;

import java.text.NumberFormat;

public abstract class Employee {
    protected String name;
    protected double baseSalary;
    protected static NumberFormat nf = NumberFormat.getNumberInstance();
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void printInfo() {
        System.out.printf("%-15s | %-15s | %-15s%n", name, nf.format(baseSalary), nf.format(calculateSalary()));
    }
}

