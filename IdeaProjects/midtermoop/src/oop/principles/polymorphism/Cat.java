package oop.principles.polymorphism;

// Lớp con override phương thức makeSound
public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}