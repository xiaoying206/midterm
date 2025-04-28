package oop.principles.abstraction;

// Lớp Circle triển khai cụ thể phương thức getArea()
// Đây là chi tiết cài đặt cụ thể mà người dùng không cần biết khi thao tác với Shape
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Cài đặt cụ thể phương thức trừu tượng getArea() được định nghĩa trong lớp Shape
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
