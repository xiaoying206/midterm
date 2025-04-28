package oop.principles.encapsulation;

public class Employee {
    private int id; // instance variable for employee id
    private String firstName; // instance variable for employee name
    private String lastName; // instance variable for employee name
    private int salary; // instance variable for employee salary

    // Constructor to initialize instance variables
    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Getter and Setter methods for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for first name
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter methods for last name
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get full name
    public String getName(){
        return firstName + " " + lastName;
    }

    // Getter and Setter methods for salary
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    //Get annual salary
    public int getAnnualSalary(){
        return salary*12;
    }

    // Method to raise salary by given percentage
    public void raiseSalary(int percent) {
        salary *= (1 + percent/100);
    }

    // toString method to print Employee details
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + getName() + ", salary=" + salary + "]";
    }
}

