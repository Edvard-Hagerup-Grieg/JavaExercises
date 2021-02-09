// Синхронизация потоков: реализовать два потока, которые выводят на консоль своё имя по очереди

public class Exercises8_1 {
    synchronized static void printName(Thread thread) {
        System.out.println(thread.getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread("Thread 1");
        Thread thread2 = new Thread("Thread 2");

        thread1.start();
        thread2.start();

        while(true) {
            printName(thread1);
            printName(thread2);
        }
    }
}