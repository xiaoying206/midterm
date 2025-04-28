package com.poly;

public class ArrayPoly extends AbstractPoly {
    private final int[] coefficients;

    public ArrayPoly(int[] coefficients) {
        this.coefficients = coefficients;
        degree = coefficients.length - 1;
        reduce();
    }

    @Override
    public int coefficient(int base) {
        if (base < 0 || base > degree) {
            return 0;
        }
        return coefficients[base];
    }

    @Override
    public int[] coefficient() {
        return coefficients;
    }

    @Override
    public Poly derivative() {
        if (degree <= 0) {
            throw new NegativeArraySizeException("There are no derivatives");
        }
        int[] derivativeCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoeffs[i - 1] = i * coefficients[i];
        }
        return new ArrayPoly(derivativeCoeffs);
    }

    public ArrayPoly minus(ArrayPoly arrayPoly) {
        int maxDegree = Math.max(this.degree, arrayPoly.degree);
        int[] resultCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = this.coefficient(i) - arrayPoly.coefficient(i);
        }
        return new ArrayPoly(resultCoeffs);
    }

    public ArrayPoly plus(ArrayPoly arrayPoly) {
        int maxDegree = Math.max(this.degree, arrayPoly.degree);
        int[] resultCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = this.coefficient(i) + arrayPoly.coefficient(i);
        }
        return new ArrayPoly(resultCoeffs);
    }

    private void reduce() {
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                degree = i;
                return;
            }
        }
        degree = 0; // Nếu toàn bộ hệ số là 0
    }

    public ArrayPoly times(ArrayPoly arrayPoly) {
        int[] resultCoeffs = new int[this.degree + arrayPoly.degree + 1];
        for (int i = 0; i <= this.degree; i++) {
            for (int j = 0; j <= arrayPoly.degree; j++) {
                resultCoeffs[i + j] += this.coefficient(i) * arrayPoly.coefficient(j);
            }
        }
        return new ArrayPoly(resultCoeffs);
    }

    public String type() {
        return "Array Poly";
    }
}