package oop.principles.abstraction;

// 3. Trừu tượng (Abstraction): Cho phép người dùng thao tác với đối tượng qua interface chung mà không cần biết chi tiết bên trong.

public class Client {
    public static void main(String[] args) {
        // 3. Trừu tượng (Abstraction):
        // Tạo đối tượng Circle và gán vào biến có kiểu là Shape (kiểu trừu tượng)
        Shape shape = new Circle(3.0);

        // → Người dùng chỉ gọi getArea thông qua interface chung là Shape
        // mà không cần biết bên trong Circle tính diện tích như thế nào.
        // => Đây là ý nghĩa của Abstraction: ẩn chi tiết, chỉ lộ interface cần dùng
        System.out.println("Area: " + shape.getArea());
    }
}
