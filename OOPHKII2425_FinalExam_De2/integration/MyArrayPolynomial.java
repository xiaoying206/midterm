package hus.oop.integration;

import java.util.Arrays;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        /* TODO */
        this.coefficents = coefficents;
        this.size = 0;
    }

    @Override
    public double coefficient(int index) {
        /* TODO */
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        /* TODO */
        return Arrays.copyOf(coefficents, size);
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size >= coefficient.size) {
            allocateMore();
        }
        coefficient[size++] = coefficient;
        return true;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        /* TODO */
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        /* TODO */
    }

    @Override
    public int degree() {
        /* TODO */
    }

    @Override
    public double evaluate(double x) {
        /* TODO */
    }

    @Override
    public MyArrayPolynomial derivative() {
        /* TODO */
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        /* TODO */
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        /* TODO */
        if (right.size() != size) throw new IllegalArgumentException("Different vector sizes");
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i < size; i++) {
            result.insert(coefficents[i] - right.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        /* TODO */
    }

    /**
     * Tăng kích thước mảng lên gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        coefficents = Arrays.copyOf(coefficents, coefficents.length * 2);
    }
}
