package Exercises4_0;

import java.util.ArrayList;

public class Box extends Shape {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private double freeVolume;

    public double getFreeVolume() {
        return freeVolume;
    }

    public Box(double volume) {
        super(volume);
        freeVolume = volume;
    }

    public boolean add(Shape shape) {
        if(shape.getVolume() <= freeVolume) {
            shapes.add(shape);
            freeVolume -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }
}