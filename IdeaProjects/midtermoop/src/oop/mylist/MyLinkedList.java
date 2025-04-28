package oop.mylist;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void append(Object obj) {
        insert(obj, size);
    }

    @Override
    public Object get(int index) {
        return getNodeByIndex(index).getPayload();
    }

    protected MyLinkedListNode getNodeByIndex(int index) {
        if (index < 0 || index >= size) return null;
        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void insert(Object obj, int index) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            head = new MyLinkedListNode(obj, head);
        } else {
            MyLinkedListNode prev = getNodeByIndex(index - 1);
            prev.setNext(new MyLinkedListNode(obj, prev.getNext()));
        }
        size++;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.getNext();
        } else {
            MyLinkedListNode prev = getNodeByIndex(index - 1);
            prev.setNext(prev.getNext().getNext());
        }
        size--;
    }

    @Override
    public void set(Object obj, int index) {
        MyLinkedListNode node = getNodeByIndex(index);
        if (node != null) {
            node = new MyLinkedListNode(obj, node.getNext());
        }
    }

    @Override
    public int size() {
        return size;
    }
}