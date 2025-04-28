package oop;

import java.util.NoSuchElementException;

// Class MyLinkedList, kế thừa MyAbstractList
public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head; // f head: MyLinkedListNode
    private int size; // f size: int

    // m MyLinkedList()
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // m append(Object): void
    @Override
    public void append(Object element) {
        MyLinkedListNode newNode = new MyLinkedListNode(element);
        if (head == null) {
            head = newNode;
        } else {
            MyLinkedListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // m get(int): Object
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyLinkedListNode node = getNodeByIndex(index);
        return node.getPayload();
    }

    // m insert(Object, int): void
    @Override
    public void insert(Object element, int index) {
        if (index < 0 || index > size) { // index == size là insert vào cuối (append)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyLinkedListNode newNode = new MyLinkedListNode(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MyLinkedListNode prevNode = getNodeByIndex(index - 1);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
        size++;
    }

    // m remove(int): Object
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removedElement;
        if (index == 0) {
            removedElement = head.getPayload();
            head = head.getNext();
        } else {
            MyLinkedListNode prevNode = getNodeByIndex(index - 1);
            MyLinkedListNode currentNode = prevNode.getNext();
            removedElement = currentNode.getPayload();
            prevNode.setNext(currentNode.getNext());
        }
        size--;
        return removedElement;
    }

    // m set(Object, int): void
    @Override
    public void set(Object element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyLinkedListNode node = getNodeByIndex(index);
        // Assume payload is mutable or can be replaced. Since it's Object, replacing is fine.
        node = new MyLinkedListNode(element); // Create new node? No, just update payload or next.
        if (index == 0) {
            // Need to handle setting the head separately if payload is final, but it's not here.
            // We just need to update the node's payload at index.
            node = head;
            for(int i = 0; i < index; i++) {
                node = node.getNext();
            }
            // Here, node is the node at 'index'. We can't change the payload directly
            // if MyLinkedListNode doesn't have setPayload. Looking at MyLinkedListNode,
            // it does *not* have setPayload. This is a potential issue based on diagram vs typical need.
            // Let's assume for "set" you replace the *node* at the index by adjusting pointers.
            // This makes "set" behave more like remove + insert.
            // Re-reading diagram: MyLinkedListNode only has getPayload. setNext adjusts the link, not the payload.
            // This means to "set" at an index, you'd typically modify the payload of the existing node.
            // However, if payload is intended to be immutable or not modifiable directly via a setter,
            // then the "set" operation in MyList doesn't make sense for MyLinkedListNode as designed.
            // LET'S ASSUME the payload field *can* be set directly, despite no public setter in MyLinkedListNode.
            // This is a common discrepancy in simple diagrams.
            // Or, alternative: "set" means replace the node. Let's go with replacing the node as it aligns better with available node methods.
            // This is inefficient but follows the available tools.

            // **Revised set logic (less efficient but uses available node methods):**
            Object oldElement = remove(index); // Remove the old node
            insert(element, index); // Insert the new element at the same index
            // size is handled by remove/insert, so no need to adjust here.
            // The return value of remove is discarded as set is void.

            // **Alternative Revised set logic (more efficient by changing payload, ASSUMING payload can be accessed/modified directly or getNodeByIndex gives mutable access):**
            // If we assume `getNodeByIndex` allows modifying the payload:
            // MyLinkedListNode targetNode = getNodeByIndex(index);
            // targetNode.payload = element; // <-- ASSUMING direct field access is allowed or there's a hidden setter.
            // This contradicts the diagram's MyLinkedListNode public methods.

            // Let's stick to the remove+insert approach for set, as it strictly uses the provided node methods.
            Object temp = remove(index); // Use remove and insert to simulate set
            insert(element, index);


        }
    }

    // m size(): int
    @Override
    public int size() {
        return size;
    }

    // m iterator(): MyIterator
    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }

    // m getNodeByIndex(int): MyLinkedListNode? (Returns MyLinkedListNode) - Helper method
    // Marked as protected as it's an internal helper useful for subclasses (though none here)
    // or within the package. Diagram doesn't specify visibility, private is also reasonable.
    // Let's make it private as it's purely an internal implementation detail for this class.
    private MyLinkedListNode getNodeByIndex(int index) {
        // Assumes index is valid (checked by callers like get, insert, remove, set)
        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    // Override toString from MyAbstractList to provide a standard list representation
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        MyIterator it = iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (it.hasNext()) {
            Object element = it.next();
            sb.append(element == this ? "(this Collection)" : element); // Avoid infinite recursion
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
