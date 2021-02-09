package Exercises2_0;

public class Vector {
    private double x;
    private double y;
    private double z;

    public double getX() { return x; };
    public double getY() { return y; };
    public double getZ() { return z; };

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void print() {
        System.out.println(String.format("x: %.2g\ty: %.2g\tz: %.2g", x, y, z));
    }

    public double getLength() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public static double scalarProduct(Vector v1, Vector v2) {
        return (v1.x*v2.x + v1.y*v2.y + v1.z*v2.z);
    }

    public static Vector vectorProduct(Vector v1, Vector v2) {
        return new Vector(v1.y*v2.z - v1.z*v2.y, v1.z*v2.x - v1.x*v2.z, v1.x*v2.y - v1.y*v2.x);
    }

    public static double cos(Vector v1, Vector v2) {
        double scalarProductValue = scalarProduct(v1, v2);
        double lengthProductValue = v1.getLength() * v2.getLength();

        return scalarProductValue / lengthProductValue;
    }

    public static Vector sum(Vector v1, Vector v2) {
        return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    };

    public static Vector difference(Vector v1, Vector v2) {
        return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    };

    public static Vector[] randomVectors(int count) {
        Vector[] randomVectorArray = new Vector[count];

        for(int i = 0; i < count; i++) {
            randomVectorArray[i] = new Vector(Math.random() * 10, Math.random() * 10, Math.random() * 10);
        }

        return randomVectorArray;
    };
}
