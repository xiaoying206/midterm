package oop.mylist;

public class StudentComparable extends Student implements Comparable<Student> {

    public StudentComparable(String name, String lastname, double average) {
        super(name, lastname, average);
    }

    @Override
    public int compareTo(Student other) {
        // Sắp xếp tăng dần theo điểm trung bình
        return Double.compare(this.getAverage(), other.getAverage());
    }
}