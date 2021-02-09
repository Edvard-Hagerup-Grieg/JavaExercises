// Реализовать иерархию классов, описывающую трёхмерные фигуры

//import Exercises4_0.*;
//import Exercises4_1.*; // Реализуйте ту же иерархию классов, но сделав некоторые классы абстрактными.
import Exercises4_2.*; // Реализуйте ту же иерархию классов, но использовав интерфейсы. + Comparable
import Exercises4_3.*; //Добавьте в иерархию классов фигуру вращения для произвольной функции.

public class Exercises4 {
    public static void main(String[] args) {
        Box box = new Box(31);

        Shape cylinder = new Cylinder(1, 4);
        Shape pyramid = new Pyramid(1, 4);
        Shape ball = new Ball(2);


        ArbitraryFunction cos = ((x) -> (Math.cos(x)));
        Shape shapeCos = new ArbitrarySolidOfRevolution(0, 10, cos);

        System.out.println(String.format("The box's free volume: %.3g.", box.getFreeVolume()));

        if(box.add(cylinder)) {
            System.out.println(String.format("The cylinder with volume %.3g has been added. The box's free volume: %.3g.",
                    cylinder.getVolume(), box.getFreeVolume()));
        } else {
            System.out.println(String.format("The cylinder with volume %.3g has not been added. The box's free volume: %.3g.",
                cylinder.getVolume(), box.getFreeVolume()));
        }

        if(box.add(pyramid)) {
            System.out.println(String.format("The pyramid with volume %.3g has been added. The box's free volume: %.3g.",
                    pyramid.getVolume(), box.getFreeVolume()));
        } else {
            System.out.println(String.format("The pyramid with volume %.3g has not been added. The box's free volume: %.3g.",
                    pyramid.getVolume(), box.getFreeVolume()));
        }

        if(box.add(ball)) {
            System.out.println(String.format("The ball with volume %.3g has been added. The box's free volume: %.3g.",
                    ball.getVolume(), box.getFreeVolume()));
        } else {
            System.out.println(String.format("The ball with volume %.3g has not been added. The box's free volume: %.3g.",
                    ball.getVolume(), box.getFreeVolume()));
        }

        if(box.add(shapeCos)) {
            System.out.println(String.format("The cosinus [0, 10] with volume %.3g has been added. The box's free volume: %.3g.",
                    shapeCos.getVolume(), box.getFreeVolume()));
        } else {
            System.out.println(String.format("The cosinus [0, 10] with volume %.3g has not been added. The box's free volume: %.3g.",
                    shapeCos.getVolume(), box.getFreeVolume()));
        }
    }
}
