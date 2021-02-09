package Exercises8_2;

import java.util.Queue;

public class Consumer<T> implements Runnable {
    Queue<T> buffer;

    public Consumer(Queue<T> data) {
        this.buffer = data;
    }

    private void consume() throws InterruptedException {
        synchronized (buffer) {
            if (buffer.isEmpty()) {
                buffer.wait();
            }
            buffer.notifyAll();
            System.out.println("GET " + buffer.size());
            buffer.poll();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
