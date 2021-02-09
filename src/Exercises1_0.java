// Максимальное, минимальное и среднее значение

public class Exercises1_0 {
    public static void main(String[] args) {
        int length = 100;

        double[] values = new double[length];
        for(int i = 0; i < length; i++) {
            values[i] =  Math.random() * 100;
        }

        double max = values[0], min = values[0], sum = 0.0;
        for(double value : values) {
            if (value > max) max = value;
            if (value < min) min = value;
            sum += value;
        }

        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
        System.out.println("Mean = " + (sum/ length));
    }
}
