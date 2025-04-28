package oop.principles.inheritance;

public class Client {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(1.0f, 2.0f);
        System.out.println("Point2D: " + point2D.toString());
        point2D.setXY(3.0f, 4.0f);
        System.out.println("Point2D after setXY: " + point2D.toString());

        Point3D point3D = new Point3D(5.0f, 6.0f, 7.0f);
        System.out.println("Point3D: " + point3D.toString());
        point3D.setXYZ(8.0f, 9.0f, 10.0f);
        System.out.println("Point3D after setXYZ: " + point3D.toString());
    }
}
