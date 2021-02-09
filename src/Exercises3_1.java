// Найти корень уравнения

public class Exercises3_1 {
    private static double function(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.5*x - 23.0;
    };

    public static double bisectionMethod(double lowBound, double highBound, double accuracy) {
        double middlePoint = (lowBound + highBound) / 2.0;
        double middleValue = function(middlePoint);

        if(Math.abs(function(lowBound) - function(highBound)) < accuracy) {
            return middlePoint;
        } else if (middleValue < 0) {
            return bisectionMethod(middlePoint, highBound, accuracy);
        } else {
            return bisectionMethod(lowBound, middlePoint, accuracy);
        }
    }

    public static void main(String[] args) {
        double root = bisectionMethod(0, 10, 0.001);
        System.out.println("Root = " + root);
    }
}
