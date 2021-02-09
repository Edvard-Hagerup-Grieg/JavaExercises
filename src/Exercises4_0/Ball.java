package Exercises4_0;

public class Ball extends SolidOfRevolution {
    public Ball( double radius) {
        super((4.0 * Math.PI * radius * radius * radius) / 3.0, radius);
    }
}
