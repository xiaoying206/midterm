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
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < size) return coefficents[index];
        return 0.0;
    }

    @Override
    public double[] coefficients() {
        /* TODO */
        return Arrays.copyOf(coefficents, size);
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size >= coefficents.length) {
            allocateMore();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        /* TODO */
        if (index >= coefficents.length) {
            int newSize = index + 1;
            coefficents = Arrays.copyOf(coefficents, newSize * 2);
        }
        coefficents[index] += coefficient;
        size = Math.max(size, index + 1);
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        if (index >= coefficents.length) {
            coefficents = Arrays.copyOf(coefficents, (index + 1) * 2);
        }
        coefficents[index] = coefficient;
        size = Math.max(size, index + 1);
        return this;
    }

    @Override
    public int degree() {
        /* TODO */
        int deg = size - 1;
        while (deg >= 0 && coefficents[deg] == 0) {
            deg--;
        }
        return deg;
    }

    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = degree(); i >= 0; i--) {
            result = result * x + coefficents[i];
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        /* TODO */
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 1; i <= degree(); i++) {
            result.append(i * coefficents[i]);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        /* TODO */
        MyArrayPolynomial result = new MyArrayPolynomial();
        int maxDeg = Math.max(this.degree(), right.degree());
        for (int i = 0; i <= maxDeg; i++) {
            result.append(this.coefficient(i) + right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        /* TODO */
        MyArrayPolynomial result = new MyArrayPolynomial();
        int maxDeg = Math.max(this.degree(), right.degree());
        for (int i = 0; i <= maxDeg; i++) {
            result.append(this.coefficient(i) - right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        /* TODO */
        int newDegree = this.degree() + right.degree();
        MyArrayPolynomial result = new MyArrayPolynomial();
        result.coefficents = new double[newDegree + 1];
        result.size = newDegree + 1;

        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= right.degree(); j++) {
                result.coefficents[i + j] += this.coefficient(i) * right.coefficient(j);
            }
        }
        return result;
    }

    /**
     * Tăng kích thước mảng lên gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        coefficents = Arrays.copyOf(coefficents, coefficents.length * 2);
    }
}
