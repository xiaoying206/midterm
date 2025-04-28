package com.fractionn;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Fraction extends Number implements Comparable<Fraction> {

    private int numerator;
    private int denominator;

    public Fraction(Fraction another) {
        this.numerator = another.numerator;
        this.denominator = another.denominator;
        simplify();
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
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
        simplify();
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
        simplify();
    }

    @Override
    public String toString() {
        if (denominator == 1) return String.valueOf(numerator);
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numerator) * 31 + Integer.hashCode(denominator);
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public int compareTo(Fraction other) {
        long lhs = (long) this.numerator * other.denominator;
        long rhs = (long) other.numerator * this.denominator;
        return Long.compare(lhs, rhs);
    }

    private static int gcd(int m, int n) {
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
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction add(int other) {
        int newNumerator = this.numerator + other * this.denominator;
        return new Fraction(newNumerator, this.denominator);
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(1, 4);

        System.out.println("f1 + 1 = " + f1.add(1));
        System.out.println("f1 as int = " + f1.intValue());
        System.out.println("f1 as double = " + f1.doubleValue());

        List<Fraction> myFractions = new ArrayList<>();
        myFractions.add(f1);
        myFractions.add(f2);
        myFractions.add(f3);

        Collections.sort(myFractions);

        System.out.println("Sorted Fractions:");
        for (Fraction f : myFractions) {
            System.out.println(f);
        }
    }
}