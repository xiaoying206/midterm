package oop.mylist;

public class Student {
    private String name;
    private String lastname;
    private double average;

    public Student(String name, String lastname, double average) {
        this.name = name;
        this.lastname = lastname;
        this.average = average;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.name.equals(other.name) && this.lastname.equals(other.lastname);
    }

    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public double getAverage() { return average; }

    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setAverage(double average) { this.average = average; }

    @Override
    public String toString() {
        return name + " " + lastname + ": " + average;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + lastname.hashCode();
    }
}