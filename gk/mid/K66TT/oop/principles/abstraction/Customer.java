package oop.principles.abstraction;

public class Customer {
    private String name; // Tên khách hàng
    private String address; // Địa chỉ khách hàng
    private String phoneNumber; // Số điện thoại khách hàng
    private double balance; // Số dư tài khoản khách hàng

    // Các phương thức getter và setter để truy cập các thuộc tính private của đối tượng Customer
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
