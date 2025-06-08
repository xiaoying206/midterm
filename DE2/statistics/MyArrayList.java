package hus.oop.statistics;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public void add(double data) {
        /* TODO */
        if (size >= this.data.length) {
            allocateMore();
        }
        this.data[size++] = data;
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0 || index > size) return;
        if (size >= this.data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) return;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        /* TODO */
        MyArrayList sorted = new MyArrayList();
        sorted.data = Arrays.copyOf(this.data, this.size);
        sorted.size = this.size;
        Arrays.sort(sorted.data, 0, sorted.size);
        return sorted;

    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
        MyArrayList sorted = this.sortIncreasing();
        int left = 0, right = sorted.size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sorted.data[mid] == data) return mid;
            if (sorted.data[mid] < data) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        data = Arrays.copyOf(data, data.length * 2);
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            /* TODO */
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        @Override
        public Number next() {
            /* TODO */
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            /* TODO */
            MyArrayList.this.remove(--currentPosition);
        }
    }
}
