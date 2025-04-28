package oop;

import java.util.Objects;

// Class Student
public class Student {
    private String name; // f name: String
    private String lastname; // f lastname: String
    private double average; // f average: double

    // m Student(String, String, double)
    public Student(String name, String lastname, double average) {
        this.name = name;
        this.lastname = lastname;
        this.average = average;
    }

    // m getAverage(): double
    public double getAverage() {
        return average;
    }

    // m getLastName(): String
    public String getLastName() {
        return lastname;
    }

    // m getName(): String
    public String getName() {
        return name;
    }

    // m setAverage(double): void
    public void setAverage(double average) {
        this.average = average;
    }

    // m setLastname(String): void
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // m setName(String): void
    public void setName(String name) {
        this.name = name;
    }

    // m equals(Object): boolean - Cần override cho đúng
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.average, average) == 0 &&
                Objects.equals(name, student.name) &&
                Objects.equals(lastname, student.lastname);
    }

    // m hashCode(): int - Cần override cho đúng (phải nhất quán với equals)
    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, average);
    }

    // m toString(): String - Cần override để in thông tin dễ đọc
    @Override
    public String toString() {
        return name + " " + lastname + " (" + average + ")";
    }

    // m Student(Student, String, double) - Constructor copy? Diagram shows this signature.
    // This signature doesn't quite make sense as a constructor name is the class name.
    // It might be a typo in the diagram, maybe intended as another method?
    // Assuming it is meant to be a constructor, but the parameters don't fit typical use cases.
    // Let's skip implementing a constructor with this signature unless clarified, as it's unusual.
    // The diagram seems to show a constructor with parameters (String, String, double) which we already have.
    // The line "m Student(Student, String, double)" might represent something else or be an error.
    // Sticking to the first constructor shown (String, String, double).
    // If it was meant to be a copy constructor, it would be Student(Student other).
    // If it was meant to create a new student based on an existing one plus some data, it would likely be a static factory method or another named method.
    // Given the ambiguity and unusual signature, I will omit this method.
    // **If you need this specific constructor implemented, please clarify its intended behavior.**
}
