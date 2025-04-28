package oop;

// Class MyLinkedListNode
public class MyLinkedListNode {
    private Object payload; // f payload: Object
    private MyLinkedListNode next; // f next: MyLinkedListNode

    // m MyLinkedListNode(Object)
    public MyLinkedListNode(Object payload) {
        this.payload = payload;
        this.next = null; // Mặc định node tiếp theo là null
    }

    // m getNext(): MyLinkedListNode
    public MyLinkedListNode getNext() {
        return next;
    }

    // m getPayload(): Object
    public Object getPayload() {
        return payload;
    }

    // m setNext(MyLinkedListNode): void
    public void setNext(MyLinkedListNode next) {
        this.next = next;
    }

    // Có thể thêm toString() cho node để debug nếu cần, nhưng không có trong diagram.
}
