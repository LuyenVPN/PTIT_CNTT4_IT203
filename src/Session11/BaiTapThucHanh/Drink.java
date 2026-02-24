package Session11.BaiTapThucHanh;

import java.text.NumberFormat;

abstract public class Drink {
    protected String id;
    protected String name;
    protected double price;
    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public abstract double calculatePrice();
    public void displayInfo() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("ID: " + id+", Name: " + name + ", Price: " + nf.format(price) + " VND");
    }
}
