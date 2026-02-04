package Session9.B6;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
        this.radius = 1.0;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
