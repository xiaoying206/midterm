package com.poly;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    private final List<Integer> coefficients;

    public ListPoly(int[] coefficients) {
        this.coefficients = new ArrayList<>(coefficients.length);
        for (int coeff : coefficients) {
            this.coefficients.add(coeff);
        }
        reduce();
    }

    @Override
    public int coefficient(int base) {
        if (base < 0 || base > degree) {
            return 0;
        }
        return coefficients.get(base);
    }

    @Override
    public int[] coefficient() {
        int[] result = new int[degree + 1];
        for (int i = 0; i <= degree; i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    @Override
    public Poly derivative() {
        if (degree <= 0) {
            throw new NegativeArraySizeException("There are no derivatives");
        }
        int[] derivativeCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoeffs[i - 1] = i * coefficients.get(i);
        }
        return new ListPoly(derivativeCoeffs);
    }

    public ListPoly minus(ListPoly listPoly) {
        int maxDegree = Math.max(degree, listPoly.degree);
        int[] resultCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = this.coefficient(i) - listPoly.coefficient(i);
        }
        return new ListPoly(resultCoeffs);
    }

    public ListPoly plus(ListPoly listPoly) {
        int maxDegree = Math.max(degree, listPoly.degree);
        int[] resultCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = this.coefficient(i) + listPoly.coefficient(i);
        }
        return new ListPoly(resultCoeffs);
    }

    private void reduce() {
        int lastNonZero = -1;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                lastNonZero = i;
                break;
            }
        }

        if (lastNonZero == -1) {
            coefficients.clear();
            coefficients.add(0);
            degree = 0;
        } else {
            while (coefficients.size() > lastNonZero + 1) {
                coefficients.remove(coefficients.size() - 1);
            }
            degree = lastNonZero;
        }
    }

    public ListPoly times(ListPoly listPoly) {
        int[] resultCoeffs = new int[this.degree + listPoly.degree + 1];
        for (int i = 0; i <= this.degree; i++) {
            for (int j = 0; j <= listPoly.degree; j++) {
                resultCoeffs[i + j] += this.coefficient(i) * listPoly.coefficient(j);
            }
        }
        return new ListPoly(resultCoeffs);
    }

    public String type() {
        return "List Poly";
    }
}