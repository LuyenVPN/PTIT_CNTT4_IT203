package Session9.B6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(3));
        shapes.add(new Circle());
        shapes.add(new Rectangle(4, 5));
        shapes.add(new Rectangle(6));

        double totalArea = 0;

        for (Shape s : shapes) {
            totalArea += s.area();
        }
        System.out.println("Tong dien tich: " + totalArea);
    }
}
