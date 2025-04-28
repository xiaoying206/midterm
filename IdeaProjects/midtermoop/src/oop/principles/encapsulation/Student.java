package oop.principles.encapsulation;

// Encapsulation (Đóng gói): Che giấu dữ liệu, chỉ cho phép truy cập qua các phương thức setter/getter.
public class Student {
    // Dữ liệu được khai báo là private để không thể truy cập trực tiếp từ bên ngoài
    private String name;
    private int age;

    // Cho phép truy cập gián tiếp thông qua getter và setter (đây là biểu hiện của tính đóng gói)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Có thể kiểm tra điều kiện trước khi gán -> kiểm soát dữ liệu
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // Tính đóng gói cho phép kiểm soát dữ liệu đầu vào
        if (age >= 0) {
            this.age = age;
        }
    }
}