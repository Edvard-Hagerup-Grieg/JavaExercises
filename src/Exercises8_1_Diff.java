// Синхронизация потоков: реализовать два потока, которые выводят на консоль своё имя по очереди
// Иначе:

class StepThread extends Thread {
    Object lock;

    StepThread(Object o) {
        lock = o;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(getName());
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Exercises8_1_Diff {
    public static void main(String[] args) {
        String object = "";
        new StepThread(object);
        new StepThread(object);
    }
}
