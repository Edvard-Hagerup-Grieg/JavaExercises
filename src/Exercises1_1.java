// Реализуйте алгоритм сортировки пузырьком для сортировки массива

public class Exercises1_1 {

    private static void printArray(double[] array) {
        for (double value : array) {
            System.out.print(String.format("%.2f",value) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int length = 10;

        double[] values = new double[length];
        for(int i = 0; i < length; i++) {
            values[i] =  Math.random() * 100;
        }

        System.out.println("Source array:");
        printArray(values);

        double tmp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    tmp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = tmp;
                }
            }
        }

        System.out.println("Sorted array:");
        printArray(values);
    }
}
