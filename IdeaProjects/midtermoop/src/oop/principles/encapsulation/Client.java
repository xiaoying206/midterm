package oop.principles.encapsulation;

// 4. Đóng gói (Encapsulation)
// Giấu thông tin bên trong lớp, chỉ cung cấp giao diện cần thiết cho bên ngoài truy cập.
// Bảo vệ dữ liệu, tăng tính bảo trì và linh hoạt của hệ thống.

public class Client {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Lan");
        s.setAge(20);

        // Không thể truy cập trực tiếp s.name hay s.age từ bên ngoài
        System.out.println("Student name: " + s.getName());
        System.out.println("Student age: " + s.getAge());
    }
}