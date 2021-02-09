// Связный список

import Exercises2_2.*;

public class Exercises2_2 {
    public static void main(String[] args) {
        List<Double> list = new List<Double>();

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        System.out.println(list);
        System.out.println();

        try {
            System.out.println("Adding node(6) to position 1:");
            list.add(6.0, 1);
            System.out.println(list);
        } catch (OutOfListSizeException e) {
            System.out.println(e);
        }
        System.out.println();

        try {
            System.out.println("Adding node(7) to position 20:");
            list.add(7.0, 20);
            System.out.println(list);
        } catch (OutOfListSizeException e) {
            System.out.println(e);
        }
        System.out.println();

        try {
            System.out.println("Adding node(7) to position -1:");
            list.add(8.0, -1);
            System.out.println(list);
        } catch (OutOfListSizeException e) {
            System.out.println(e);
        }
        System.out.println();

        try {
            System.out.println("Getting node from position 3:");
            Node<Double> node = list.get(3);
            System.out.println("Value of node 3: " + node.getValue());
        } catch (OutOfListSizeException e) {
            System.out.println(e);
        }
        System.out.println();

        try {
            System.out.println("Getting node from position 20:");
            Node<Double> node = list.get(20);
        } catch (OutOfListSizeException e) {
            System.out.println(e);
        }
        System.out.println();

        try {
            System.out.println("Removing node from position 5:");
            list.remove(5);
            System.out.println(list);
        } catch (OutOfListSizeException e) {
            System.out.println(e);
        }
        System.out.println();

        try {
            System.out.println("Removing node from position 20:");
            list.remove(20);
        } catch (OutOfListSizeException e) {
            System.out.println(e);
        }
        System.out.println();
    }
}
