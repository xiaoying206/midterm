package oop.principles.polymorphism;
/*
Sử dụng tính đa hình (polymorphism)
để định nghĩa hành vi của các đối tượng thuộc lớp con (BigDog, Cat, Dog) dựa trên hành vi của lớp cha (Animal)
 */
public class Client {
    public static void main(String[] args) {
        Animal a1 = new Dog("Buddy");
        a1.greets();
        Animal a2 = new Cat("Tom");
        a2.greets();
        Dog d1 = new BigDog("Max");
        d1.greets();
        Dog d2 = new Dog("Rocky");
        d1.greets(d2);
        BigDog bd = new BigDog("Champ");
        d1.greets(bd);
    }
}
