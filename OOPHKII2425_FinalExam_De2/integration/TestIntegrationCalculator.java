package hus.oop.integration;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        /* TODO
         - Thực hiện các yêu cầu trong từng hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
    }

    public void testArrayPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyArrayPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 1.0 và 5.0.
         */
    }

    public void testListPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyListPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 2.0 và 6.0.
         */
    }
}
