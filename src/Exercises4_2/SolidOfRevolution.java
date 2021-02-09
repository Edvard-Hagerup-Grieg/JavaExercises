package Exercises4_2;

public abstract class SolidOfRevolution implements Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }
}