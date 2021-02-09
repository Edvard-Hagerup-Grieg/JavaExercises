// Подсчёт элементов

import java.util.HashMap;
import java.util.Map;

public class Exercises7_7 {
    static private <T> Map<T, Integer> contains(T[] array) {
        Map<T, Integer> items = new HashMap<>();

        for(T item : array) {
            if(items.containsKey(item)) {
                int number = items.get(item);
                items.put(item, ++number);
            } else {
                items.put(item, 1);
            }
        }

        return items;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1, 2, 3, 5, 5, 1, 8, 2, 2 ,9, 1, 0, 3, 3, 6};

        Map<Integer, Integer> items = contains(array);

        System.out.println(items);
    }
}
