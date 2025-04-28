package com.fraction;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Fraction extends Number implements Comparable<Fraction> {

    private int numerator;
    private int denominator;

    /**
     * Creates a new instance of Fraction
     */

    public Fraction(Fraction another) {
        this.numerator = another.numerator;
        this.denominator = another.denominator;
        simplify();
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean equals(Fraction other) {
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }

    public double doubleValue() {
        return (double) numerator / (double) denominator;
    }

    public float floatValue() {
        return (float) numerator / (float) denominator;
    }

    public int intValue() {
        return numerator / denominator;
    }

    public long longValue() {
        return (long) numerator / (long) denominator;
    }

    public int compareTo(Fraction other) {
        int product1 = this.numerator * other.denominator;
        int product2 = this.denominator * other.numerator;
        return Integer.compare(product1, product2);
    }

    // Euclidean algorithms
    private static int gcd(int m, int n) {
        // euclidean algorithm pseudocode
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }

        return m;
    }

    private void simplify() {
        if (numerator == 0) {
            denominator = 1;
        } else {
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }
    }

    public Fraction add(Fraction other) {
        int newNumerator = numerator * other.denominator + denominator * other.numerator;
        int newDenominator = denominator * other.denominator;
        simplify();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction add(int other) {
        int newNumerator = numerator + other * denominator;
        return new Fraction(newNumerator, denominator);
    }

    /*
     *   Our main method tests our class and demonstrates behavior
     * */
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(1, 4);

        System.out.println(f1.add(1));
        System.out.println(f1.intValue());
        System.out.println(f1.doubleValue());

        List<Fraction> myFractions = new ArrayList<>();
        myFractions.add(f1);
        myFractions.add(f2);
        myFractions.add(f3);
        Collections.sort(myFractions);

        for (Fraction f : myFractions) {
            System.out.println(f);
        }
    }
}
