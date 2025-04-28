package hus.oop.basicstatistics;

public class LinkedListDataSet extends AbstractDataSet {
    private Node head;
    private int size;

    public LinkedListDataSet() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        // TODO: Đếm số phần tử trong danh sách liên kết
        return size;
    }

    @Override
    public double get(int index) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            return node.data;
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    @Override
    public void set(double data, int index) {
        Node node = getNodeByIndex(index);
        if (node != null) {
            node.data = data;
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    @Override
    public void append(double value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    private Node getNodeByIndex(int index) {
        // TODO: Lấy ra node ở vị trí index
        if (index < 0 || index >= size) {
            return null;
        }

        // Duyệt từ đầu danh sách liên kết
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        // Trả về node ở vị trí index
        return current;
    }

    @Override
    public double[] toArray() {
        double[] array = new double[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    private static class Node {
        double data;
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }
}
