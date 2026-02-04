package Session9.B5;

public class ProductionEmployee extends Employee {
    private int products;
    private double salaryPerProduct;

    public ProductionEmployee(String name, int products, double salaryPerProduct) {
        super(name);
        this.products = products;
        this.salaryPerProduct = salaryPerProduct;
    }

    @Override
    public double calculateSalary() {
        return products * salaryPerProduct;
    }
}

