package oop.mylist;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void append(Object obj) {
        insert(obj, size);
    }

    private void enlarge() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) return null;
        return data[index];
    }

    @Override
    public void insert(Object obj, int index) {
        if (index < 0 || index > size) return;
        if (size >= data.length) enlarge();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = obj;
        size++;
    }

    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator(data);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) return;

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    @Override
    public void set(Object obj, int index) {
        if (index < 0 || index >= size) return;
        data[index] = obj;
    }

    @Override
    public int size() {
        return size;
    }
}