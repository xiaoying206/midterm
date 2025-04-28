package oop;

import java.util.NoSuchElementException;

// Class MyArrayListIterator, implements MyIterator
public class MyArrayListIterator implements MyIterator {
    private Object[] data; // f data: Object[] - Tham chiếu đến mảng của ArrayList
    private int size; // Số lượng phần tử thực tế trong ArrayList
    private int currentPosition; // f currentPosition: int - Vị trí hiện tại

    // m MyArrayListIterator(Object[], int)
    // Cần truyền cả size để biết giới hạn lặp
    public MyArrayListIterator(Object[] data, int size) {
        this.data = data;
        this.size = size;
        this.currentPosition = 0; // Bắt đầu từ đầu
    }

    // m hasNext(): boolean
    @Override
    public boolean hasNext() {
        return currentPosition < size;
    }

    // m next(): Object
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object element = data[currentPosition];
        currentPosition++;
        return element;
    }
}
