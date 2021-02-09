// ArrayList и LinkedList

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.random;

public class Exercises7_2 {
    private static void  fill(List<Double> list, int size) {
        for(int i = 0; i < size; i++)
            list.add(random() * 100.0);
    }

    private static Double getRandomItem(List<Double> list) {
        int idx = (int) (random() * (list.size() + 1));
        return list.get(idx);
    }


    public static void main(String[] args) {
        LinkedList<Double> linkedList = new LinkedList<>();
        ArrayList<Double> arrayList = new ArrayList<>();

        int size = 1000000;
        int iter = 10000;
        long time;

        fill(linkedList, size);
        fill(arrayList, size);

        System.out.println("LinkedList:");
        time = System.currentTimeMillis();
        for(int i = 0; i < iter; i++)
            getRandomItem(linkedList);
        System.out.println("Time: " + (double) (System.currentTimeMillis() - time));

        System.out.println("ArrayList:");
        time = System.currentTimeMillis();
        for(int i = 0; i < iter; i++)
            getRandomItem(arrayList);
        System.out.println("Time: " + (double) (System.currentTimeMillis() - time));
    }
}
