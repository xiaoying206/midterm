package oop.mylist;

public class MyLinkedListIterator implements MyIterator {
    private MyLinkedListNode currentNode;

    public MyLinkedListIterator(MyLinkedListNode head) {
        this.currentNode = head;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public Object next() {
        if (!hasNext()) return null;
        Object value = currentNode.getPayload();
        currentNode = currentNode.getNext();
        return value;
    }
}