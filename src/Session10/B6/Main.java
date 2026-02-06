package Session10.B6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500));
        products.add(new Product("Mouse", 20));
        products.add(new Product("Keyboard", 100));
        products.add(new Product("Monitor", 300));

        Collections.sort(products, new Comparator<Product>() {

            private final double taxRate = 1.0;

            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(
                        p1.getPrice() * taxRate,
                        p2.getPrice() * taxRate
                );
            }
        });

        System.out.println("Danh sach sap xep theo gia tang dan:");
        for (Product p : products) {
            System.out.println(p);
        }


        products.sort(
                (p1, p2) -> p1.getName().compareTo(p2.getName())
        );

        System.out.println("\nDanh sach sap xep theo ten A-Z:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
