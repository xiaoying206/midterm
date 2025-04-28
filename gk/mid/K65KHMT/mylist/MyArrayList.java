package com.mylist;

/**
 * Implementation of a simplified ArrayList
 */
public class MyArrayList extends MyAbstractList {
    static final int INITIAL_SIZE = 16;
    Object[] elements;
    int size;

    public MyArrayList() {
        elements = new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public void add(Object o) {
        if (size >= elements.length) { // sửa: bỏ -1 để tránh thiếu 1 chỗ
            enlarge();
        }
        elements[size++] = o;
    }

    @Override
    public void add(Object o, int index) {
        checkBoundaries(index, size); // sửa: dùng phương thức checkBoundaries kế thừa

        if (size >= elements.length) {
            enlarge();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = o;
        size++;
    }

    @Override
    public Object get(int index) {
        checkBoundaries(index, size - 1);
        return elements[index];
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1); // sửa: dùng phương thức kế thừa

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    // Tăng gấp đôi kích thước mảng khi đầy
    void enlarge() {
        Object[] tmp = new Object[elements.length * 2];
        System.arraycopy(elements, 0, tmp, 0, elements.length);
        elements = tmp;
    }
}