package oop.principles.encapsulation;
/*
Nguyên lý Encapsulation là đảm bảo tính đóng gói của dữ liệu và hành vi của đối tượng.
Điều này được thể hiện bằng việc đặt các thuộc tính của Employee là private
và cung cấp các getter và setter để truy cập vào các thuộc tính này.
 */
public class Client {
    public static void main(String[] args) {
        // Create an employee object
        Employee employee = new Employee(1, "John", "Doe", 50000);

        // Print employee details
        System.out.println(employee);

        // Raise employee salary by 10%
        employee.raiseSalary(10);

        // Print employee details after salary raise
        System.out.println(employee);
    }
}
