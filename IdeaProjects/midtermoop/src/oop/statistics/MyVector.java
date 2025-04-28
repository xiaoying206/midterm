package oop.statistics;

public interface MyVector {
    double coordinate(int i);
    double[] coordinates();
    boolean equals(MyVector other);
    double norm();
    void set(double value, int index);
    int size();
}