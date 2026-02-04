package Session9.B5;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new OfficeEmployee("An", 8000000, 2000000));
        employees.add(new ProductionEmployee("Binh", 500, 20000));
        employees.add(new OfficeEmployee("Cuong", 9000000, 1500000));

        double totalSalary = 0;

        for (Employee e : employees) {
            totalSalary += e.calculateSalary();
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Tong luong: " + nf.format(totalSalary));
    }
}
