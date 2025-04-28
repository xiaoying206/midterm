package hus.oop.studentmanager;

public interface MyStudentComparator {
    // So sánh 2 sinh viên theo điểm trung bình
    // Trả về giá trị < 0 nếu sinh viên left có điểm trung bình nhỏ hơn sinh viên right
    // Trả về giá trị > 0 nếu sinh viên left có điểm trung bình lớn hơn sinh viên right
    // Trả về 0 nếu 2 sinh viên có điểm trung bình bằng nhau
    int compare(Student left, Student right);
}
