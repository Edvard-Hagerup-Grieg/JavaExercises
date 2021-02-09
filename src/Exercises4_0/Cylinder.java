package Exercises4_0;

public class Cylinder extends SolidOfRevolution {
    private double height;

    public double getHeight() {
        return height;
    }

    public Cylinder(double radius, double height) {
        super(Math.PI * height * radius * radius, radius);
        this.height = height;
    }
}
