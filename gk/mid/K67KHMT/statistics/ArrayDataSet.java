package oop.statistics;

import java.sql.Array;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayDataSet(double[] data) {
        this.data = data;
        size = data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double element(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("The index is invalid");
        }
        return data[index];
    }

    @Override
    public double[] elements(int from, int to) {
        if (from < 0 || to >= size || from > to){
            throw new IndexOutOfBoundsException("Invalid range");
        }

        double[] result = new double[to - from + 1];
        for (int i = from; i <= to; i++) {
            result[i - from] = data[i];
        }
        return result;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        if (size >= data.length) {
            enlarge();
        }
        data[size] = value;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value
     * @param index
     */
    @Override
    public void insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (size >= data.length) {
            enlarge();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value.
     * @param value
     */
    @Override
    public void remove(double value) {
        int i = 0;
        while (i < size){
            if (data[i] == value){
                remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void enlarge() {
        double[] enlargedArray = new double[data.length * 2];
        System.arraycopy(data, 0, enlargedArray, 0, data.length);
        data = enlargedArray;
    }
}

