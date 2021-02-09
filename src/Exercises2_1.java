// Генерация случайного элемента с весом

import Exercises2_1.WeightNumberGenerator;

public class Exercises2_1 {
    public static void main(String[] args) {
        int testCount = 10;

        WeightNumberGenerator generator = new WeightNumberGenerator(testCount);

        System.out.println(generator);
        System.out.println("Distribution function:");
        for(int i = 0; i < generator.getBoundaries().length; i++) {
            System.out.print(String.format("%.2g\t", generator.getBoundaries()[i]));
        }
        System.out.println();

        System.out.println("Probabilities:");
        System.out.print(String.format("%.2g\t", generator.getBoundaries()[0]));
        for(int i = 0; i < generator.getBoundaries().length - 1; i++) {
            System.out.print(String.format("%.2g\t", generator.getBoundaries()[i + 1] - generator.getBoundaries()[i]));
        }
        System.out.println();

        System.out.println("Random sequence:");
        for(int value : generator.next(20)) {
            System.out.print(value + " ");
        }
        System.out.println();


        System.out.println("Frequencies:");
        double[] frequencies = new double[testCount];
        int[] values = generator.getValues();
        int bigTestCount = 100000;
        for(int randomValue : generator.next(bigTestCount)) {
            for(int j = 0; j < values.length; j++) {
                if(randomValue == values[j]) {
                    frequencies[j] += 1.0;
                    break;
                }
            }
        }
        for(double frequency : frequencies) {
            System.out.print(String.format("%.2g\t", frequency / bigTestCount));
        }
        System.out.println();
    }
}
