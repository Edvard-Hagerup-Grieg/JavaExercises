// Многопоточность: Состояния

import java.util.ArrayList;

public class Exercises8_0 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> threadsArray = new ArrayList<>();

        Thread thread = new Thread("Thread 1") {
            @Override
            public void run() {
                synchronized (threadsArray) {
                    threadsArray.add(getName());
                    threadsArray.notify();
                    try {
                        threadsArray.wait();
                        // threadsArray.wait(100); // для TIME_WAITING:
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        synchronized (threadsArray) {
            System.out.println(thread.getName() + " : " + thread.getState());

            thread.start();
            System.out.println(thread.getName() + " : " + thread.getState());

            threadsArray.wait();
            System.out.println(thread.getName() + " : " + thread.getState());

            threadsArray.notifyAll();
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName() + " : " + thread.getState());

        System.out.println(threadsArray);
    }
}
