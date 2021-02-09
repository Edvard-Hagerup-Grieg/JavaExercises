package Exercises4_1;

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
        this.height = height;
        this.baseArea = baseArea;
    }

    @Override
    public double getVolume() {
        return (height * baseArea) / 3.0;
    }
}