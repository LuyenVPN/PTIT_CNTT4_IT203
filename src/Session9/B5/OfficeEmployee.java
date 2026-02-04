package Session9.B5;

public class OfficeEmployee extends Employee {
    private double baseSalary;
    private double allowance;

    public OfficeEmployee(String name, double baseSalary, double allowance) {
        super(name);
        this.baseSalary = baseSalary;
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + allowance;
    }
}

