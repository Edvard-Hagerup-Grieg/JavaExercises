// Поиск простых чисел

public class Exercises1_2 {
    public static void main(String[] args) {

        System.out.println("Prime numbers:");

        for (int i = 2; i < 101; i++) {
            int divisor = 2;
            while (i % divisor != 0)
                divisor++;

            if (divisor == i)
                System.out.print(i + " ");
        }
    }
}
