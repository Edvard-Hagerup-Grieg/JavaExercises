// Поменять ключи и значения в Map

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Exercises7_8 {
    static private <T1, T2> Map<T2, Collection<T1>> reverse(Map<T1, T2> map) {
        Map<T2, Collection<T1>> reverseMap = new HashMap<>();

        for (Map.Entry<T1, T2> entry : map.entrySet()) {
            T2 key = entry.getValue();
            Collection<T1> values;

            if (reverseMap.containsKey(key))
                values = reverseMap.get(key);
            else
                values = new HashSet<>();

            values.add(entry.getKey());
            reverseMap.put(key, values);
        }

        return reverseMap;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(2, "prime");
        map.put(3, "prime");
        map.put(4, "non prime");
        map.put(5, "prime");
        map.put(6, "non prime");
        map.put(7, "prime");
        map.put(8, "non prime");
        map.put(9, "non prime");
        map.put(10, "non prime");

        System.out.println(map);
        System.out.println(reverse(map));

        Object lock = new Object();

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " is running.");
                try {
                    synchronized (lock) {
                        lock.notifyAll();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        synchronized (lock) {
            System.out.println("State: " + thread.getState());
            thread.start();
            System.out.println("State: " + thread.getState());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("State: " + thread.getState());
            lock.notifyAll();
            System.out.println("State: " + thread.getState());
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State: " + thread.getState());
    }
}
