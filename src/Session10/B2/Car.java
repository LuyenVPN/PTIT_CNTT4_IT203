package Session10.B2;

public class Car extends Vehicle {

    public Car(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang dong co");
    }
}
