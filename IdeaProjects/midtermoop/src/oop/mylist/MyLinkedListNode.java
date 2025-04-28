package oop.mylist;

public class MyLinkedListNode {
    private Object payload;
    private MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        this.payload = payload;
        this.next = null;
    }

    public MyLinkedListNode(Object payload, MyLinkedListNode next) {
        this.payload = payload;
        this.next = next;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public Object getPayload() {
        return payload;
    }

    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }
}
