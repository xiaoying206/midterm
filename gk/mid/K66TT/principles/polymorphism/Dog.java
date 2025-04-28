package oop.principles.polymorphism;

public class Dog extends Animal{
    public Dog(String name){
        super(name);
    }

    @Override
    void greets() {
        System.out.println("Woof");
    }

    public void greets(Dog another){
        System.out.println("Woooof");
    }
}
