package com.fraction;

import java.util.*;

public class TestFraction {
    private List<Fraction> fractions;

    public static void main(String[] args) {
        //Tạo ngẫu nhiên 30 cặp số nguyên có giá trị nằm trong khoảng [1, 1000] để tạo ra 30
        //phân số Fraction
        List<Fraction> fractions = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 30; i++){
            int numerator = random.nextInt(1000) + 1;
            int denominator = random.nextInt(1000) + 1;
            fractions.add(new Fraction(numerator, denominator));
        }

        // In ra các phân số trong list fractions
        System.out.println("Print the values of a list of fraction: ");
        print(fractions);

        // In ra các phân số theo thứ tự có giá trị tăng dần
        // (theo sắp thứ tự của Comparable);
        System.out.println("Print a list of fraction in increasing value: ");
        print(sortByValue(fractions));

        // In ra các phân số có mẫu số tăng dần
        System.out.println("Print a list of fraction in increasing value of denominator: ");
        print(sortByDenominator(fractions));

        // Tìm phân số có giá trị lớn thứ hai trong list fractions
        System.out.println("Print the second largest value in a list: " + getSecondLargestValue(fractions));


    }

    public static List<Fraction> sortByValue(List<Fraction> fractions) {
        List<Fraction> sorted = new ArrayList<>(fractions);
        Collections.sort(sorted);
        return sorted;
    }

    public static List<Fraction> sortByDenominator(List<Fraction> fractions) {
        List<Fraction> newList = new ArrayList<>(fractions);
        newList.sort(Comparator.comparingInt(Fraction::getDenominator));
        return newList;
    }

    public static void print(List<Fraction> fractions) {
        for (Fraction fraction : fractions){
            System.out.println(fraction.toString());
        }
    }

    public static Fraction getSecondLargestValue(List<Fraction> fractions) {
        if (fractions.size() < 2) {
            throw new IllegalArgumentException("List must contain at least 2 fractions.");
        }

        List<Fraction> sorted = new ArrayList<>(fractions);
        sorted.sort(Collections.reverseOrder()); // sắp xếp giảm dần

        return sorted.get(1); // phần tử lớn thứ hai
    }
}
