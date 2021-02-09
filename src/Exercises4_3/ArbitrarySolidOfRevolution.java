package Exercises4_3;

import Exercises4_2.Shape;

public class ArbitrarySolidOfRevolution implements Shape {
    private ArbitraryFunction function;
    private double a;
    private double b;

    public ArbitrarySolidOfRevolution(double a, double b, ArbitraryFunction function) {
        this.function = function;
        this.a = a;
        this.b = b;
    }

    private double rightRiemannSum() {
        double sum = 0.0;
        double n = 10000.0;
        double step = (b-a)/n;

        double x = a;
        while(x < b) {
            sum += function.getValue(x) * function.getValue(x) * step;
            x += step;
        }

        return sum;
    }

    @Override
    public double getVolume() {
        return Math.PI * rightRiemannSum();
    }
}
