import java.util.LinkedList;
import java.util.Queue;

// implements Runnable чтобы запускать в отдельном потоке
class Producer_ implements Runnable {
    // Общая очередь
    private final Queue<Double> sharedQueue;
    // Максимальный размер
    private final int SIZE;

    // Конструктор
    public Producer_(Queue<Double> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        // Цикл бесконечен
        while (true) {
            try {
                // В цикле вызывается метод produce
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private double produce() throws InterruptedException {
        synchronized (sharedQueue) { // обязательно synchronized
            if (sharedQueue.size() == SIZE) {
                // Если очередь полна, то ждём
                sharedQueue.wait();
            }

            // Добавили элемент в очередь.
            double newValue = Math.random();
            sharedQueue.add(newValue);
            System.out.println("SET " + sharedQueue.size());

            // Уведомили другой поток на случай, если он ждет
            sharedQueue.notifyAll();

            return newValue;
        }
    }
}

// implements Runnable чтобы запускать в отдельном потоке
class Consumer_ implements Runnable {
    // Общая очередь
    private final Queue<Double> sharedQueue;

    public Consumer_(Queue<Double> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Метод, извлекающий элементы из общей очереди
    private Double consume() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.isEmpty()) { // Если пуста, надо ждать
                sharedQueue.wait();
            }

            sharedQueue.notifyAll();
            System.out.println("GET " + sharedQueue.size());
            return sharedQueue.poll();
        }
    }
}


public class Exercises8_2_Diff {
    public static void main(String[] strings) {
        LinkedList<Double> sharedQueue = new LinkedList<>();
        int size = 4;
        Thread prodThread = new Thread(new Producer_(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer_(sharedQueue), "Consumer");
        prodThread.start();
        consThread.start();
    }

}
