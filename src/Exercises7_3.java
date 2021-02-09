// Написать итератор по массиву

import Exercises7_3.ArrayIterator;

import java.util.ArrayList;

public class Exercises7_3 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        ArrayIterator<Integer> iterator = new ArrayIterator<>(array);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
