package hus.oop.studentmanager;

public class Student implements MyStudentComparable {
    private String id;
    private String lastname;
    private String firstname;
    private int yearOfBirth;
    private double mathsGrade;
    private double physicsGrade;
    private double chemistryGrade;

    private Student() {}

    // Sử dụng Builder Pattern để tạo đối tượng Student
    // Đảm bảo rằng mỗi đối tượng Student được tạo ra phải có id
    public static class StudentBuilder {
        private String id;
        private String lastname;
        private String firstname;
        private int yearOfBirth;
        private double mathsGrade;
        private double physicsGrade;
        private double chemistryGrade;

        public StudentBuilder(String id) {
            this.id = id;
        }

        public StudentBuilder withLastname(String lastname) {
            /* TODO */
            this.lastname = lastname;
            return this;
        }

        public StudentBuilder withFirstname(String firstname) {
            /* TODO */
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder withYearOfBirth(int yearOfBirth) {
            /* TODO */
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public StudentBuilder withMathsGrade(double mathsGrade) {
            /* TODO */
            this.mathsGrade = mathsGrade;
            return this;
        }

        public StudentBuilder withPhysicsGrade(double physicsGrade) {
            /* TODO */
            this.physicsGrade = physicsGrade;
            return this;
        }

        public StudentBuilder withChemistryGrade(double chemistryGrade) {
            /* TODO */
            this.chemistryGrade = chemistryGrade;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.id = this.id;
            student.lastname = this.lastname;
            student.firstname = this.firstname;
            student.yearOfBirth = this.yearOfBirth;
            student.mathsGrade = this.mathsGrade;
            student.physicsGrade = this.physicsGrade;
            student.chemistryGrade = this.chemistryGrade;
            return student;
        }
    }

    public String getId() {
        /* TODO */
        return id;
    }

    public String getLastname() {
        /* TODO */
        return lastname;
    }

    public String getFirstname() {
        /* TODO */
        return firstname;
    }

    public int getYearOfBirth() {
        /* TODO */
        return yearOfBirth;
    }

    public double getMathsGrade() {
        /* TODO */
        return mathsGrade;
    }

    public double getPhysicsGrade() {
        /* TODO */
        return physicsGrade;
    }

    public double getChemistryGrade() {
        /* TODO */
        return chemistryGrade;
    }

    // Tính điểm trung bình của sinh viên
    // Điểm trung bình = (mathsGrade + physicsGrade + chemistryGrade) / 3
    public double getAverageGrade() {
        /* TODO */
        return (mathsGrade + physicsGrade + chemistryGrade) / 3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", mathsGrade=" + mathsGrade +
                ", physicsGrade=" + physicsGrade +
                ", chemistryGrade=" + chemistryGrade +
                '}';
    }

    /**
     * Phương thức đưa ra tiêu chí so sánh 2 đối tượng kiểu Student sao cho
     * thứ tự tăng dần theo tên và sau đó đến họ.
     * @param another
     * @return
     */
    // vidu 2 sinh vien: A, B
    // A: lastname = "Nguyen", firstname = "Van A", Nguyen Van A
    // B: lastname = "Nguyen", firstname = "Van B", Nguyen Van B
    // A.compareTo(B) < 0
    // B.compareTo(A) > 0
    // A.compareTo(A) = 0
    @Override
    public int compareTo(Student another) {
        /* TODO */
        if (this.lastname.compareTo(another.lastname) == 0) {
            return this.firstname.compareTo(another.firstname);  // > < = 0
        }
        return this.lastname.compareTo(another.lastname);
    }
}
