package Exercises8_2;

import java.util.Queue;
import java.util.function.Supplier;

public class Producer<T> implements Runnable {
    Queue<T> buffer;
    int limit;
    Supplier<T> generator;


    public Producer(Queue<T> data, int limit, Supplier<T> generator) {
        this.buffer = data;
        this.limit = limit;
        this.generator = generator;
    }

    private void produce() throws InterruptedException {
        synchronized(buffer) {
            if (buffer.size() == limit) {
                buffer.wait();
            }

            buffer.add(generator.get());
            System.out.println("SET " + buffer.size());
            buffer.notifyAll();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
