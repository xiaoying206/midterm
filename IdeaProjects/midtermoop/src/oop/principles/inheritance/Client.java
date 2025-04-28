package oop.principles.inheritance;

// 1. Kế thừa (Inheritance): Là cơ chế cho phép một lớp (subclass/con class) kế thừa thuộc tính (fields)
// và phương thức (methods) từ một lớp khác (superclass/cha class).

public class Client {
    public static void main(String[] args) {
        Dog d = new Dog();

        // d có thể sử dụng phương thức eat từ lớp Animal -> thể hiện tính kế thừa
        d.eat();
        d.bark();
    }
}
