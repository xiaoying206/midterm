package oop;

import java.util.Arrays;
import java.util.NoSuchElementException;

// Class MyArrayList, kế thừa MyAbstractList
public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 10; // f DEFAULT_CAPACITY: int (constant)
    private Object[] data; // f data: Object[]
    private int size; // f size: int

    // m MyArrayList()
    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // m append(Object): void
    @Override
    public void append(Object element) {
        if (size == data.length) {
            enlarge(); // Mở rộng mảng nếu đầy
        }
        data[size] = element;
        size++;
    }

    // m get(int): Object
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    // m insert(Object, int): void
    @Override
    public void insert(Object element, int index) {
        if (index < 0 || index > size) { // index == size là insert vào cuối (append)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == data.length) {
            enlarge(); // Mở rộng mảng nếu đầy
        }
        // Dịch các phần tử sang phải
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    // m remove(int): Object
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removedElement = data[index];
        // Dịch các phần tử sang trái
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // Gán null cho phần tử cuối để giải phóng bộ nhớ
        size--;
        return removedElement;
    }

    // m set(Object, int): void
    @Override
    public void set(Object element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        data[index] = element;
    }

    // m size(): int
    @Override
    public int size() {
        return size;
    }

    // m iterator(): MyIterator
    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator(data, size); // Cần truyền data và size thực tế
    }

    // m enlarge(): void - Helper method
    // Marked as private as it's purely an internal implementation detail.
    private void enlarge() {
        int newCapacity = data.length * 2; // Tăng gấp đôi dung lượng
        data = Arrays.copyOf(data, newCapacity); // Sao chép mảng cũ sang mảng mới
    }

    // Override toString from MyAbstractList to provide a standard list representation
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            Object element = data[i];
            sb.append(element == this ? "(this Collection)" : element); // Avoid infinite recursion
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
