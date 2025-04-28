package oop;

import java.util.Comparator;
import java.util.Collections; // Để sử dụng Collections.sort
import java.util.ArrayList; // Để chuyển đổi tạm thời để sort

// Class StudentStatistics
public class StudentStatistics {
    private MyList students; // f students: MyList

    // m StudentStatistics(MyList)
    public StudentStatistics(MyList students) {
        // Nên tạo một bản sao của danh sách để tránh sửa đổi danh sách gốc
        // hoặc chỉ lưu trữ tham chiếu nếu được phép. Lưu tham chiếu đơn giản hơn.
        this.students = students;
    }

    // m sortByAverage(boolean): MyList
    // Sắp xếp danh sách sinh viên theo điểm trung bình.
    // Trả về một MyList MỚI chứa các sinh viên đã sắp xếp.
    public MyList sortByAverage(boolean ascending) {
        // Chuyển đổi MyList sang ArrayList để sử dụng Collections.sort
        ArrayList<Student> studentList = new ArrayList<>();
        MyIterator it = students.iterator();
        while(it.hasNext()) {
            Object element = it.next();
            if (element instanceof Student) {
                studentList.add((Student) element);
            }
            // Xử lý các phần tử không phải Student nếu cần, hoặc giả định MyList chỉ chứa Student
        }

        // Sử dụng Comparator để sắp xếp theo điểm trung bình
        Comparator<Student> averageComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // So sánh double cần cẩn thận, dùng Double.compare
                int result = Double.compare(s1.getAverage(), s2.getAverage());
                return ascending ? result : -result; // Đảo ngược kết quả nếu descending
            }
        };

        Collections.sort(studentList, averageComparator);

        // Chuyển đổi lại sang MyList mới (ví dụ: MyArrayList)
        // Chọn MyArrayList vì dễ dàng thêm các phần tử từ ArrayList đã sort.
        MyList sortedList = new MyArrayList();
        for (Student student : studentList) {
            sortedList.append(student);
        }

        return sortedList;
    }

    // m sortByFullName(boolean): MyList
    // Sắp xếp danh sách sinh viên theo tên đầy đủ (họ trước, tên sau).
    // Trả về một MyList MỚI chứa các sinh viên đã sắp xếp.
    public MyList sortByFullName(boolean ascending) {
        // Chuyển đổi MyList sang ArrayList để sử dụng Collections.sort
        ArrayList<Student> studentList = new ArrayList<>();
        MyIterator it = students.iterator();
        while(it.hasNext()) {
            Object element = it.next();
            if (element instanceof Student) {
                studentList.add((Student) element);
            }
        }

        // Sử dụng Comparator để sắp xếp theo tên đầy đủ (Họ + Tên)
        Comparator<Student> fullNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // So sánh theo họ trước, nếu họ giống nhau thì so sánh theo tên
                int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
                if (lastNameComparison != 0) {
                    return ascending ? lastNameComparison : -lastNameComparison;
                } else {
                    int nameComparison = s1.getName().compareTo(s2.getName());
                    return ascending ? nameComparison : -nameComparison;
                }
            }
        };

        Collections.sort(studentList, fullNameComparator);

        // Chuyển đổi lại sang MyList mới (ví dụ: MyArrayList)
        MyList sortedList = new MyArrayList();
        for (Student student : studentList) {
            sortedList.append(student);
        }

        return sortedList;
    }

    // Diagram shows StudentComparable and StudentComparator interfaces, but they are not directly
    // used as parameters in the sorting methods as designed in the diagram.
    // The logic for comparison is implemented using anonymous Comparator classes directly
    // within the sorting methods, which is a common pattern in modern Java.
    // The interfaces StudentComparable and StudentComparator might be intended for
    // a different sorting approach (e.g., passing comparator instances to the sort method)
    // or if Student implemented StudentComparable. Sticking to the diagram's method signatures,
    // implementing comparison logic internally via Comparator seems appropriate.
}
