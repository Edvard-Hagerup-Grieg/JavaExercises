// Двоичный поиск

import java.util.Arrays;

public class Exercises3_0 {
    public static boolean search(double[] array, double valueSearch) {
        for(double value : array) {
            if(value == valueSearch) {
                return true;
            }
        }
        return false;
    }

    private static boolean SerchIteration(double[] sortedArray, double valueSearch, int lowBound, int highBound) {
        int middle = (lowBound + highBound) / 2;

        if((highBound < lowBound) || (middle >= sortedArray.length)) {
            return false;
        }

        if(valueSearch == sortedArray[middle]) {
            return true;
        } else if (valueSearch < sortedArray[middle]) {
            return SerchIteration(sortedArray, valueSearch, lowBound, middle - 1);
        } else {
            return SerchIteration(sortedArray, valueSearch, middle + 1, highBound);
        }
    }

    public static boolean binarySearch(double[] sortedArray, double valueSearch) {
        return SerchIteration(sortedArray, valueSearch, 0, sortedArray.length);
    }

    public static void main(String[] args) {

        double[] smallTestArray = new double[] {1,2,3,4,5,6,7};

        System.out.print("Given array:\t");
        for(double value : smallTestArray) {
            System.out.print(String.format("%.0g", value) + " ");
        }
        System.out.println();

        System.out.print("Does the array contain the number 3?\t");
        if(binarySearch(smallTestArray, 3)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        System.out.print("Does the array contain the number 8?\t");
        if(binarySearch(smallTestArray, 8)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        double[] bigTestArray = new double[100000000];
        for (int i = 0; i < bigTestArray.length; i++) {
            bigTestArray[i] = Math.random();
        }
        Arrays.sort(bigTestArray);

        long time;
        boolean result;
        System.out.println("Big data test: ");

        time = System.currentTimeMillis();
        result = search(bigTestArray, bigTestArray[bigTestArray.length - 1]);
        System.out.println("Search time:\t" + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        result = binarySearch(bigTestArray, bigTestArray[bigTestArray.length - 1]);
        System.out.println("Binary search time:\t" + (System.currentTimeMillis() - time));
    }
}
