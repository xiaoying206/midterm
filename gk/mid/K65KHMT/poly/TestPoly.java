package com.poly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestPoly {
    static List<Poly> polyList;

    public static void main(String[] args) {
        // Tạo ra 10 đa thức
        // trong đó có 5 đa thức loại ArrayPoly và 5 đa thức loại ListPoly
        // Lưu các đa thức này vào List polyList
        polyList = new ArrayList<>();
        polyList.add(createArrayPoly(createRandomArray(3)));
        polyList.add(createArrayPoly(createRandomArray(4)));
        polyList.add(createArrayPoly(createRandomArray(5)));
        polyList.add(createArrayPoly(createRandomArray(1)));
        polyList.add(createArrayPoly(createRandomArray(1)));
        polyList.add(createListPoly(createRandomArray(3)));
        polyList.add(createListPoly(createRandomArray(4)));
        polyList.add(createListPoly(createRandomArray(2)));
        polyList.add(createListPoly(createRandomArray(1)));
        polyList.add(createListPoly(createRandomArray(1)));

        double x = 5.0;

        for (Poly p : polyList) {
            try {
                System.out.println(p.toString());
                System.out.println(p.derivative().toString());
                System.out.println("x = " + x + ", P(x) = " + p.evaluate(x));
                if (p instanceof ArrayPoly ap) {
                    System.out.println("Type: " + ap.type());
                } else if (p instanceof ListPoly lp) {
                    System.out.println("Type: " + lp.type());
                }
                System.out.println();
            } catch (NegativeArraySizeException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static ArrayPoly createArrayPoly(int[] coefficients) {
        if (coefficients == null || coefficients.length == 0) {
            throw new IllegalArgumentException("Coefficients cannot be null or empty.");
        }
        return new ArrayPoly(coefficients);
    }

    public static ListPoly createListPoly(int[] coefficients) {
        if (coefficients == null || coefficients.length == 0) {
            throw new IllegalArgumentException("Coefficients cannot be null or empty.");
        }
        return new ListPoly(coefficients);
    }

    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
