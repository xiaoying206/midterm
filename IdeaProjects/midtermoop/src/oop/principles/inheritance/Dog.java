package oop.principles.inheritance;

// Dog kế thừa Animal, có thể dùng phương thức eat() mà không cần định nghĩa lại
public class Dog extends Animal {
    public void bark() {
        System.out.println("Dog barks.");
    }
}