package oop.principles.polymorphism;

// Lớp con khác cũng override phương thức makeSound
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}