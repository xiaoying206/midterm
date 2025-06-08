package hus.oop.statistics;

public class MyNode {
    double data;
    MyNode next;
    MyNode previous;

    public MyNode(double data) {
        this.data = data;
    }

    public MyNode(double data, MyNode next, MyNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}
