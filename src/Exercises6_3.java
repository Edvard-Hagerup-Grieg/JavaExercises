// Фильтр

import Exercises6_3.*;

import java.util.Arrays;
import java.util.function.Function;

public class Exercises6_3 {
    public static Object[] filter(Object[] array, Filter filter) {
        Object[] arrayCopy = array.clone();
        int step = 0;
        for(int i = 0; i < arrayCopy.length; i++) {
            if(!filter.apply(arrayCopy[i])) {
                arrayCopy[i - step] = arrayCopy[i];
            } else {
                step++;
            }
        }

        return Arrays.copyOf(arrayCopy, arrayCopy.length - step);
    }

    public static <T> T[] filterGenerics(T[] array, Function<? super T, Boolean> filter) {
        T[] arrayCopy = array.clone();
        int step = 0;
        for(int i = 0; i < arrayCopy.length; i++) {
            if(!filter.apply(arrayCopy[i])) {
                arrayCopy[i - step] = arrayCopy[i];
            } else {
                step++;
            }
        }

        return Arrays.copyOf(arrayCopy, arrayCopy.length - step);
    }

    public static void print(Object[] array) {
        for(Object o : array) {
            System.out.print(o.toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] stringArray = new String[] {"1", "a", null, "2", "b", "3", "_", null, "4", "5"};
        String[] filteredStrings = (String[]) filter(stringArray, o -> o == null);
        String[] filteredStringsGenerics = filterGenerics(stringArray, o -> o == null);

        System.out.println("String array:");
        print(filteredStrings);
        print(filteredStringsGenerics);

        Integer[] integerArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 3, 4, 1, 5, 7};
        Integer[] filteredIntegers = (Integer[]) filter(integerArray, o -> o.equals(3));
        Integer[] filteredIntegersGenerics = filterGenerics(integerArray, o -> o.equals(3));

        System.out.println("Integer array:");
        print(filteredIntegers);
        print(filteredIntegersGenerics);
    }
}