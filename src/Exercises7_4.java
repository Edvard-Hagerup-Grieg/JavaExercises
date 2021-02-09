// Итератор по двумерному массиву

import Exercises7_4.Iterable2DArray;

public class Exercises7_4 {
    public static void main(String[] args) {
        Integer[][] array = new Integer[5][6];

        int item = 0;
        for(int x = 0; x < 5; x++)
            for(int y = 0; y < 6; y++) {
                array[x][y] = item;
                item++;
            }

        Iterable2DArray<Integer> iterableArray = new Iterable2DArray<Integer>(array);
        iterableArray.forEach(x -> System.out.println(x));
    }
}
