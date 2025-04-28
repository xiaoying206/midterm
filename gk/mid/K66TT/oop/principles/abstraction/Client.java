package oop.principles.abstraction;
/*
Abstraction là một trong những nguyên lý quan trọng nhất của lập trình hướng đối tượng.
Nguyên lý này yêu cầu chúng ta tách biệt khái niệm logic và khái niệm vật lý trong một hệ thống phần mềm,
đồng thời giúp giảm sự phức tạp và tăng tính tái sử dụng của mã nguồn.
 */
public class Client {
    public static void main(String[] args) {
        Customer customer = new Customer();

        // Sử dụng setter để thiết lập thông tin khách hàng
        customer.setName("Ancient Soul");
        customer.setAddress("Cau Giay, Ha Noi, Viet Nam");
        customer.setPhoneNumber("555-1234");
        customer.setBalance(1000.0);

        // Sử dụng getter để truy cập thông tin khách hàng
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Customer address: " + customer.getAddress());
        System.out.println("Customer phone number: " + customer.getPhoneNumber());
        System.out.println("Customer balance: " + customer.getBalance());
    }
}
