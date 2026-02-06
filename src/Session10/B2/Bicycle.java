package Session10.B2;

public class Bicycle extends Vehicle {

    public Bicycle(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang suc nguoi");
    }
}
