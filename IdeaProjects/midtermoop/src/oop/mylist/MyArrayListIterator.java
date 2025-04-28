package oop.mylist;

public class MyArrayListIterator implements MyIterator {
    private Object[] data;
    private int currentPosition;

    public MyArrayListIterator(Object[] data) {
        this.data = data;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < data.length;
    }

    @Override
    public Object next() {
        return hasNext() ? data[currentPosition++] : null;
    }
}
