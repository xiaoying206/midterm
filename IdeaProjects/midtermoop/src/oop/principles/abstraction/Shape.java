package oop.principles.abstraction;

public abstract class Shape {
    // Phương thức trừu tượng - chỉ định nghĩa tên, không định nghĩa chi tiết.
    // Cho phép các lớp con định nghĩa cách tính diện tích riêng phù hợp.
    public abstract double getArea();
}