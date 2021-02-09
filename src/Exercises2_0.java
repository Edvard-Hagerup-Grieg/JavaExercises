// Проектирование и создание класса, описывающего вектор

import Exercises2_0.Vector;

public class Exercises2_0 {
    public static void main(String[] args) {
        Vector v1 = new Vector(1.0, 2.0, 3.0);
        Vector v2 = new Vector(3.0, 4.0, 5.0);

        System.out.println("Vector 1:");
        v1.print();
        System.out.println("Length: " + v1.getLength());
        System.out.println();

        System.out.println("Vector 2:");
        v2.print();
        System.out.println("Length: " + v2.getLength());
        System.out.println();

        System.out.println("Vector 1 + Vector 2:");
        Vector.sum(v1, v2).print();
        System.out.println();

        System.out.println("Vector 1 - Vector 2:");
        Vector.difference(v1, v2).print();
        System.out.println();

        System.out.println("(Vector 1, Vector 2):");
        System.out.println(Vector.scalarProduct(v1, v2));
        System.out.println();

        System.out.println("[Vector 1, Vector 2]:");
        Vector.vectorProduct(v1, v2).print();
        System.out.println();

        System.out.println("cos(Vector 1, Vector 2):");
        System.out.println(Vector.cos(v1, v2));
        System.out.println();

        System.out.println("5 random vectors:");
        Vector[] randomVectorsArray = Vector.randomVectors(5);
        for(int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ":\t");
            randomVectorsArray[i].print();
        }
    }
}
