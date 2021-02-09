package Exercises4_1;

public class Cylinder extends SolidOfRevolution {
    private double height;

    public double getHeight() {
        return height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        double radius = this.getRadius();
        return Math.PI * height * radius * radius;
    }
}
