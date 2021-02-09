// Заполнение массива

import java.util.function.Function;

public class Exercises6_4 {
    public static <T> void fill(T[] array, Function<Integer, T> function) {
        for(int i = 0; i < array.length; i++) {
            array[i] = function.apply(i);
        }
    }

    public static void main(String[] args) {
        Integer[] squares = new Integer[11];
        fill(squares, integer -> integer * integer);
        for(int val : squares) {
            System.out.print(val + " ");;
        }
    }
}
