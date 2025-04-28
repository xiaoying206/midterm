package oop.statistics;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    public MyListVector() {
        this.data = new ArrayList<>();
    }

    public MyListVector add(MyListVector another) {
        MyListVector result = new MyListVector();
        int size = Math.min(this.size(), another.size());
        for (int i = 0; i < size; i++) {
            result.insert(this.coordinate(i) + another.coordinate(i));
        }
        return result;
    }

    public MyListVector add(double value) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(d + value);
        }
        return result;
    }

    public double coordinate(int index) {
        return data.get(index);
    }

    public double[] coordinates() {
        double[] arr = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = data.get(i);
        }
        return arr;
    }

    public MyListVector dot() {
        MyListVector result = new MyListVector();
        for (int i = 0; i < this.size(); i++) {
            double val = this.coordinate(i);
            result.insert(val * val);  // tự nhân phần tử
        }
        return result;
    }

    public MyListVector extract(int[] indices) {
        MyListVector result = new MyListVector();
        for (int i : indices) {
            result.insert(this.coordinate(i));
        }
        return result;
    }

    public MyListVector insert(double value) {
        data.add(value);
        return this;
    }

    public MyListVector insert(double value, int index) {
        data.add(index, value);
        return this;
    }

    public MyListVector minus() {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(-d);
        }
        return result;
    }

    public MyListVector minus(MyListVector another) {
        MyListVector result = new MyListVector();
        int size = Math.min(this.size(), another.size());
        for (int i = 0; i < size; i++) {
            result.insert(this.coordinate(i) - another.coordinate(i));
        }
        return result;
    }

    public MyListVector minus(double value) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(d - value);
        }
        return result;
    }

    public double norm() {
        double sum = 0;
        for (double d : data) {
            sum += d * d;
        }
        return Math.sqrt(sum);
    }

    public MyListVector pow(double power) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(Math.pow(d, power));
        }
        return result;
    }

    public MyArrayVector remove(int index) {
        data.remove(index);
        MyArrayVector result = new MyArrayVector();
        for (double d : data) {
            result.insert(d);
        }
        return result;
    }

    public MyListVector scale(double value) {
        MyListVector result = new MyListVector();
        for (double d : data) {
            result.insert(d * value);
        }
        return result;
    }

    public void set(double value, int index) {
        data.set(index, value);
    }

    public int size() {
        return data.size();
    }
}