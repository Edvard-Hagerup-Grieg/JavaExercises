// Удаление из массива

public class Exercises1_3 {

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static int[] deleteFromArray(int[] array, int valueToDelete) {
        int repetitionsNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToDelete) {
                repetitionsNum++;
            } else {
                array[i - repetitionsNum] = array[i];
            }
        }

        int[] newArray = new int[array.length - repetitionsNum];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int length = 10;
        int [] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 10);
        }

        System.out.println("Source array:");
        printArray(array);

        array = deleteFromArray(array, 5);

        System.out.println("Array after deleting value \"5\":");
        printArray(array);

        array = deleteFromArray(array, 1);

        System.out.println("Array after deleting value \"1\":");
        printArray(array);
    }
}
