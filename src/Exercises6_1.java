// Stringbuilder с поддержкой операции undo.
// Шаблон проектирования "Команда" (Объект команды заключает в себе само действие и его параметры.)
// реализован через interface Action.

import Exercises6_1.UndoableStringBuilder;

public class Exercises6_1 {
    public static void main(String[] args) {
        UndoableStringBuilder string = new UndoableStringBuilder("1 2 3 ");

        System.out.println("The given string:");
        System.out.println(string);
        System.out.println();

        System.out.println("The string after APPEND(7 8 9 ):");
        System.out.println(string.append("7 8 9 "));
        System.out.println();

        System.out.println("The string after INSERT(4 5 6 ) at 6th position:");
        System.out.println(string.insert(6,"4 5 6 "));
        System.out.println();

        System.out.println("The string after REPLACE(4.5 5 5.5) from 8th to 9th positions:");
        System.out.println(string.replace(8, 9,"4.5 5 5.5"));
        System.out.println();

        System.out.println("The string after DELETE string from 12th to 14th positions:");
        System.out.println(string.delete(12, 14));
        System.out.println();

        System.out.println("The string after REVERSE:");
        System.out.println(string.reverse());
        System.out.println();

        System.out.println("UNDO:");
        System.out.println(string.undo());
        System.out.println(string.undo());
        System.out.println(string.undo());
        System.out.println(string.undo());
        System.out.println(string.undo());
    }
}
