package oop.principles.polymorphism;

// 2. Đa hình (Polymorphism): Một hành động có thể được thực hiện theo nhiều cách khác nhau tuỳ theo kiểu đối tượng.

public class Client {
    public static void main(String[] args) {
        Animal a1 = new Dog();  // đa hình: kiểu tham chiếu là Animal nhưng đối tượng thực tế là Dog
        Animal a2 = new Cat();  // tương tự với Cat

        a1.makeSound(); // Gọi Dog.barks -> thể hiện tính đa hình tại runtime
        a2.makeSound(); // Gọi Cat.meows
    }
}