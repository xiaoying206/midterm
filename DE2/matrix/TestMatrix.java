package hus.oop.matrix;

import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        Random rand = new Random();
        int size = rand.nextInt(6) + 5; // [5,10]
        MySquareMatrix matrix1 = new MySquareMatrix(size);
        MySquareMatrix matrix2 = new MySquareMatrix(size);

        System.out.println("=== Matrix 1 ===");
        System.out.println(matrix1);

        System.out.println("=== Transpose of Matrix 1 ===");
        System.out.println(matrix1.transpose());

        System.out.println("=== Matrix 2 ===");
        System.out.println(matrix2);

        System.out.println("=== Transpose of Matrix 2 ===");
        System.out.println(matrix2.transpose());

        System.out.println("=== Principal Diagonal of Matrix 1 ===");
        printArray(matrix1.principalDiagonal());

        System.out.println("=== Secondary Diagonal of Matrix 1 ===");
        printArray(matrix1.secondaryDiagonal());

        System.out.println("=== Principal Diagonal of Matrix 2 ===");
        printArray(matrix2.principalDiagonal());

        System.out.println("=== Secondary Diagonal of Matrix 2 ===");
        printArray(matrix2.secondaryDiagonal());

        System.out.println("=== Matrix 1 + Matrix 2 ===");
        System.out.println(matrix1.add(matrix2));

        System.out.println("=== Matrix 1 - Matrix 2 ===");
        System.out.println(matrix1.minus(matrix2));

        System.out.println("=== Matrix 1 * Matrix 2 ===");
        System.out.println(matrix1.multiply(matrix2));

        System.out.println("=== Prime Numbers in Matrix 1 ===");
        printArray(matrix1.primes());

        System.out.println("=== Prime Numbers in Matrix 2 ===");
        printArray(matrix2.primes());
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
