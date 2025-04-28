package hus.oop.studentmanager;

import java.util.*;

public class StudentManager {
    // List interface extends Collection interface
    // ArrayList implements List interface -> ArrayList is a List [1,2, 3, 4, 5]
    // LinkedList implements List interface -> LinkedList is a node [1] -> [2] -> [3] -> [4] -> [5] -> null
    private List<Student> studentList;

    StudentManager() {
        this.studentList = new LinkedList<>();
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    // array[index] -> [0, limit]
    private boolean checkBoundaries(int index, int limit) {
        /* TODO */
        if (index < 0 && index > limit) {
            return false;
        }
        return true;
    }

    public List<Student> getStudentList() {
        /* TODO */
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index, chỉ thêm vào nếu index có giá trị
     * nằm trong đoạn từ [0 - length], trong đó length là số sinh viên trong danh sách hiện tại.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        // studentList.size() -> length == limit
        if (checkBoundaries(index, studentList.size())) {
            studentList.add(index, student);
        }
    }

    /**
     * Xóa sinh viên ở vị trí index, chỉ xóa được nếu index nằm trong đoạn [0 - (length - 1)],
     * trong đó length là số sinh viên trong danh sách hiện tại.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        // array[index] -> [0, limit - 1]
        if (checkBoundaries(index, studentList.size() - 1)) {
            studentList.remove(index);
        }
    }

    /**
     * Lấy ra sinh viên ở vị trí index.
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        // [1, 2, 3, 4, 5] -> array[index] -> [0, limit - 1]
        if (checkBoundaries(index, studentList.size() - 1)) {
            return studentList.get(index);
        }else
            throw new IndexOutOfBoundsException();
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên và sau đó đến họ.
     * @return
     */
    public List<Student> sortStudentByName() {
        /* TODO */
        List<Student> studentCopy = new LinkedList<>(studentList);
        for (int i = 0; i < studentCopy.size() - 1; i++) {
            for (int j = i + 1; j < studentCopy.size(); j++) {
                if (studentCopy.get(i).compareTo(studentCopy.get(j)) > 0) {
                    Student temp = studentCopy.get(i);
                    studentCopy.set(i, studentCopy.get(j));
                    studentCopy.set(j, temp);
                }
            }
        }

        return studentCopy;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeIncreasing() {
        /* TODO */
        List<Student> studentCopy = new LinkedList<>(studentList);
        for (int i = 0; i < studentCopy.size() - 1; i++) {
            for (int j = i + 1; j < studentCopy.size(); j++) {
                if (studentCopy.get(i).getAverageGrade() > studentCopy.get(j).getAverageGrade()) {
                    Student temp = studentCopy.get(i);
                    studentCopy.set(i, studentCopy.get(j));
                    studentCopy.set(j, temp);
                }
            }
        }
        return studentCopy;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự giảm dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeDecreasing() {
        /* TODO */
        List<Student> studentCopy = new LinkedList<>(studentList);
        for (int i = 0; i < studentCopy.size() - 1; i++) {
            for (int j = i + 1; j < studentCopy.size(); j++) {
                if (studentCopy.get(i).getAverageGrade() < studentCopy.get(j).getAverageGrade()) {
                    Student temp = studentCopy.get(i);
                    studentCopy.set(i, studentCopy.get(j));
                    studentCopy.set(j, temp);
                } else if (studentCopy.get(i).getAverageGrade() == studentCopy.get(j).getAverageGrade()) {
                    if (studentCopy.get(i).getMathsGrade() < studentCopy.get(j).getMathsGrade()) {
                        Student temp = studentCopy.get(i);
                        studentCopy.set(i, studentCopy.get(j));
                        studentCopy.set(j, temp);
                    }
                }
            }
        }

        return studentCopy;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả tốt nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestGrade(int howMany) {
        /* TODO */
        List<Student> studentCopy = sortByGradeDecreasing();
        // return studentCopy.subList(0, howMany);

        // howMany = 5
        // [1, 2, 3] -> [1, 3, 5]
        if (howMany > studentCopy.size()) {
            return studentCopy;
        }

        // howMany = 5
        // [1, 2, 3, 4, 5, 6] -> [1, 2, 3, 4, 5]
        List<Student> result = new LinkedList<>();
        for (int i = 0; i < howMany; i++) {
            result.add(studentCopy.get(i));
        }

        return result;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả thấp nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestGrade(int howMany) {
        /* TODO */
        List<Student> studentCopy = sortByGradeIncreasing();

        if (howMany > studentCopy.size()) {
            return studentCopy;
        }

        List<Student> result = new LinkedList<>();
        for (int i = 0; i < howMany; i++) {
            result.add(studentCopy.get(i));
        }

        return result;
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
