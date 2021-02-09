package Exercises4_2;

public class Ball extends SolidOfRevolution {
    public Ball( double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        double radius = this.getRadius();
        return (4.0 * Math.PI * radius * radius * radius) / 3.0;
    }
}
