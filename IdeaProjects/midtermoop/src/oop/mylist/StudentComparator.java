package oop.mylist;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // Sắp xếp tăng dần theo họ tên đầy đủ
        String fullname1 = s1.getLastname() + " " + s1.getName();
        String fullname2 = s2.getLastname() + " " + s2.getName();
        return fullname1.compareTo(fullname2);
    }
}