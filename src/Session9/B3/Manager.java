package Session9.B3;

import java.text.NumberFormat;

public class Manager extends Employee {
    private String department;

    public Manager(String name, double baseSalary, String department) {
        super(name, baseSalary);
        this.department = department;
    }

    public void display() {
        System.out.println("Ten: " + name);
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Luong co ban: " + nf.format(baseSalary));
        System.out.println("Phong ban: " +department);
    }
}

