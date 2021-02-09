// Производитель-потребитель

import Exercises8_2.*;

import java.util.LinkedList;
import java.util.Queue;

public class Exercises8_2 {
    public static void main(String[] args) {
        Queue<Double> data = new LinkedList<>();
        Thread producer = new Thread(new Producer<>(data, 4, Math::random), "Producer");
        Thread consumer = new Thread(new Consumer<>(data), "Cunsumer");

        producer.start();
        consumer.start();
    }
}
