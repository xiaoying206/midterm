package oop.statistics;

import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
        /*
        TODO

        I. Viết các chức năng test cho chương trình.
        Viết hàm test cho ArrayDataSet:
            1. Tạo một tập dữ liệu ít nhất 10 phần tử. Trong đó có test các chức năng:
                + Thêm phần tử vào cuối tập dữ liệu.
                + Thêm phần tử vào đầu tập dữ liệu.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
            4. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         Viết hàm test cho ListDataSet:
            1. Tạo một tập dữ liệu ít nhất 10 phần tử. Trong đó có test các chức năng:
                + Thêm phần tử vào cuối tập dữ liệu.
                + Thêm phần tử vào đầu tập dữ liệu.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu.
            4. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         II. Chạy các hàm test để test chương trình.
         Copy kết quả chạy chương trình và lưu vào file text có tên <Ten_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
         Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <Ten_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */

        // Test ArrayDataSet
        System.out.println("Testing ArrayDataSet");

        Random random = new Random();
        ArrayDataSet dataSet = new ArrayDataSet();
        for (int i = 1; i <= 10; i++){
            dataSet.append(random.nextDouble(1000));
        }

        System.out.println(dataSet);
    }
}
