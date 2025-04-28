package hus.oop.studentmanager;

public interface MyStudentComparable {
    // So sánh 2 sinh viên theo điểm trung bình
    // Trả về giá trị < 0 nếu sinh viên hiện tại có điểm trung bình nhỏ hơn sinh viên another
    // Trả về giá trị > 0 nếu sinh viên hiện tại có điểm trung bình lớn hơn sinh viên another
    // Trả về 0 nếu 2 sinh viên có điểm trung bình bằng nhau
    int compareTo(Student another);
}
