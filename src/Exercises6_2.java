// Stringbuilder с возможностью отслеживания состояния.
// Шаблон проектирования "Наблюдатель" (Реализует у класса механизм, который позволяет объекту
// этого класса получать оповещения об изменении состояния других объектов и тем самым наблюдать за ними.)
// реализован через interface Observer и interface Observable

import Exercises6_2.*;

public class Exercises6_2 {
    public static void main(String[] args) {
        Observer observer1 = () -> System.out.println("The observer 1 has been notified.");
        Observer observer2 = () -> System.out.println("The observer 2 has been notified.");
        Observer observer3 = () -> System.out.println("The observer 3 has been notified.");

        ObservableStringBuilder string = new ObservableStringBuilder("1 2 3");
        string.addObserver(observer1);
        string.addObserver(observer2);

        System.out.println("The given string:");
        System.out.println(string);
        System.out.println();

        System.out.println(String.format("Changing the string (%d observers):", string.getObservers()));
        string.append(" 4 5 6");
        System.out.println(string);
        System.out.println();

        string.addObserver(observer3);

        System.out.println(String.format("Changing the string (%d observers):", string.getObservers()));
        string.delete(5, 7);
        System.out.println(string);
        System.out.println();

        string.removeObserver(observer2);

        System.out.println(String.format("Changing the string (%d observers):", string.getObservers()));
        string.replace(5, 7, " 3.5");
        System.out.println(string);
        System.out.println();


        string.removeObserver(observer1);
        string.removeObserver(observer3);

        System.out.println(String.format("Changing the string (%d observers):", string.getObservers()));
        string.reverse();
        System.out.println(string);
    }
}
