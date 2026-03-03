package MiniProject_SS16;
import java.text.NumberFormat;
import java.util.*;

interface IRepository<T> {
    boolean add(T item);
    boolean removeById(String id);
    T findById(String id);
    List<T> findAll();
}
abstract class Product{
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    NumberFormat nf = NumberFormat.getNumberInstance();
    public abstract double calculateFinalPrice();
    public void displayInfo() {
        System.out.println("Mã: " + id + " | Tên: " + name + " | Giá gốc: " + nf.format(price));
    }
}
class ElectronicProduct extends  Product{
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        if (warrantyMonths >12){
            return price + 1000000;
        } else {
            return price;
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bảo hành: " + warrantyMonths + " tháng");
    }
}

class FoodProduct extends Product{
    private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateFinalPrice() {
        return price - (price * discountPercent / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giảm giá: " + discountPercent + "%");
    }
}

class ProductRepository implements IRepository<Product> {
   List<Product> productList = new ArrayList<>();
   Map<String,Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || item.getId() == null) {
            return false;
        }

        if (productMap.containsKey(item.getId())) {
            return false;
        }

        productList.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null) {
            return false;
        }
        Product p = productMap.remove(id);
        if (p != null){
            productList.remove(p);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }
    public void sortByPrice() {
        Collections.sort(productList, new Comparator<Product>(){
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.calculateFinalPrice(), p2.calculateFinalPrice());
            }
        });
    }

}
public class Main {
    public static void main(String[] args) {
        ProductRepository list = new ProductRepository();
        list.add(new ElectronicProduct("E01", "Laptop", 20000000, 24));
        list.add(new ElectronicProduct("E02", "Tai nghe", 2000000, 6));
        list.add(new FoodProduct("F01", "Bánh kẹo", 100000, 10));
        list.add(new FoodProduct("F02", "Sữa", 50000, 5));

        //      1. Hiển thị danh sách
        System.out.println("=== DANH SÁCH SẢN PHẨM ===");
        for (Product p : list.findAll()) {
            if (p != null) {
                p.displayInfo();
                System.out.println("Thành tiền: " + p.calculateFinalPrice());
                System.out.println("----------------------");
            }
        }


//      2. Tìm theo ID
        System.out.println("\n=== TÌM SẢN PHẨM ID = E01 ===");
        Product found = list.findById("E01");
        if (found != null) {
            found.displayInfo();
        } else {
            System.out.println("Không tìm thấy!");
        }


//      3. Sắp xếp theo giá tăng
        list.sortByPrice();
        System.out.println("\n=== SAU KHI SẮP XẾP ===");
        NumberFormat nf = NumberFormat.getNumberInstance();
        for (Product p : list.findAll()) {
            System.out.println(p.getId() + " - " + nf.format(p.getPrice()));
        }
    }
}
