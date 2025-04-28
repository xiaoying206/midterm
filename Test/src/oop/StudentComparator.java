package oop;

import java.util.Comparator; // Sử dụng Comparator của Java để nhất quán

// Interface StudentComparator
// Mặc dù diagram chỉ có 1 phương thức compare(Student, Student),
// việc kế thừa java.util.Comparator sẽ giúp sử dụng interface này với Collections.sort
// Nếu bạn chỉ muốn đúng 100% như diagram, bỏ "extends Comparator<Student>"
public interface StudentComparator extends Comparator<Student> {
     int compare(Student s1, Student s2); // Chỉ cần cái này nếu không extends Comparator
}
