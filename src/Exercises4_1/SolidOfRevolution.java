package Exercises4_1;

public abstract class SolidOfRevolution extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }
}
