package oop;

import java.util.NoSuchElementException;

// Class MyLinkedListIterator, implements MyIterator
public class MyLinkedListIterator implements MyIterator {
    private MyLinkedListNode currentNode; // f currentNode: MyLinkedListNode

    // m MyLinkedListIterator(MyLinkedListNode)
    public MyLinkedListIterator(MyLinkedListNode head) {
        this.currentNode = head; // Bắt đầu từ node đầu tiên
    }

    // m hasNext(): boolean
    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    // m next(): Object
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object element = currentNode.getPayload();
        currentNode = currentNode.getNext(); // Di chuyển đến node tiếp theo
        return element;
    }
}
