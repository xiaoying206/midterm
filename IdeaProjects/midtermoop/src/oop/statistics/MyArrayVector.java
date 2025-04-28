package oop.statistics;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int size;

    public MyArrayVector() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayVector add(MyArrayVector another) {
        MyArrayVector result = new MyArrayVector();
        int len = Math.min(this.size(), another.size());
        for (int i = 0; i < len; i++) {
            result.insert(this.coordinate(i) + another.coordinate(i));
        }
        return result;
    }

    public MyArrayVector add(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + value);
        }
        return result;
    }

    public double coordinate(int index) {
        return data[index];
    }

    public double[] coordinates() {
        double[] result = new double[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    public MyListVector dot() {
        MyListVector result = new MyListVector();
        for (int i = 0; i < this.size(); i++) {
            double val = this.coordinate(i);
            result.insert(val * val);  // tự nhân
        }
        return result;
    }

    public void enlarge() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public MyArrayVector extract(int[] indices) {
        MyArrayVector result = new MyArrayVector();
        for (int i : indices) {
            result.insert(this.coordinate(i));
        }
        return result;
    }

    public MyArrayVector insert(double value) {
        if (size == data.length) enlarge();
        data[size++] = value;
        return this;
    }

    public MyArrayVector insert(double value, int index) {
        if (size == data.length) enlarge();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return this;
    }

    public MyArrayVector minus() {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(-data[i]);
        }
        return result;
    }

    public MyArrayVector minus(MyArrayVector another) {
        MyArrayVector result = new MyArrayVector();
        int len = Math.min(this.size(), another.size());
        for (int i = 0; i < len; i++) {
            result.insert(this.coordinate(i) - another.coordinate(i));
        }
        return result;
    }

    public MyArrayVector minus(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] - value);
        }
        return result;
    }

    public double norm() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    public MyArrayVector pow(double power) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(Math.pow(data[i], power));
        }
        return result;
    }

    public MyArrayVector remove(int index) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            if (i != index) result.insert(data[i]);
        }
        return result;
    }

    public MyArrayVector scale(double value) {
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] * value);
        }
        return result;
    }

    public void set(double value, int index) {
        data[index] = value;
    }

    public int size() {
        return size;
    }
}