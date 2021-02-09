package Exercises4_0;

public class Pyramid extends Shape {
    private double height;
    private double baseArea;

    public double getHeight() {
        return height;
    }

    public double getBaseArea() {
        return baseArea;
    }

    public Pyramid(double height, double baseArea) {
        super((height * baseArea) / 3.0);
        this.height = height;
        this.baseArea = baseArea;
    }
}