package hus.oop.integration;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        /* TODO */
        if (index < coefficients.size()) return coefficients.get(index);
        return 0.0;
    }

    @Override
    public double[] coefficients() {
        /* TODO */
        double[] arr = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            arr[i] = coefficients.get(i);
        }
        return arr;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        /* TODO */
        while (coefficients.size() <= index) {
            coefficients.add(0.0);
        }
        coefficients.set(index, coefficients.get(index) + coefficient);
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        /* TODO */
        while (coefficients.size() <= index) {
            coefficients.add(0.0);
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        /* TODO */
        int deg = coefficients.size() - 1;
        while (deg >= 0 && coefficients.get(deg) == 0) {
            deg--;
        }
        return deg;
    }

    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        for (int i = degree(); i >= 0; i--) {
            result = result * x + coefficient(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        /* TODO */
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 1; i <= degree(); i++) {
            result.append(i * coefficient(i));
        }
        return result;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        /* TODO */
        MyListPolynomial result = new MyListPolynomial();
        int maxDeg = Math.max(this.degree(), right.degree());
        for (int i = 0; i <= maxDeg; i++) {
            result.append(this.coefficient(i) + right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        /* TODO */
        MyListPolynomial result = new MyListPolynomial();
        int maxDeg = Math.max(this.degree(), right.degree());
        for (int i = 0; i <= maxDeg; i++) {
            result.append(this.coefficient(i) - right.coefficient(i));
        }
        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        /* TODO */
        MyListPolynomial result = new MyListPolynomial();
        int newDeg = this.degree() + right.degree();
        for (int i = 0; i <= newDeg; i++) {
            result.append(0.0);
        }
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= right.degree(); j++) {
                double value = result.coefficient(i + j) + this.coefficient(i) * right.coefficient(j);
                result.set(value, i + j);
            }
        }
        return result;
    }
}
