package Exercises4_0;

public class SolidOfRevolution extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }
}
