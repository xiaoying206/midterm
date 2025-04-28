package hus.oop.basicstatistics;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        /* Yêu cầu:

        I. Hoàn thiện các file source code đã cho. Viết các chức năng test cho chương trình.
        Viết hàm test cho ArrayDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         Viết hàm test cho LinkedListDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         II. Chạy các hàm test để test chương trình.
         Copy kết quả chạy chương trình và lưu vào file text có tên <TenSinhVien_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
         Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <TenSinhVien_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */
        testStatisticsUsingArrayDataSet();
        testStatisticsUsingLinkedListDataSet();
    }

    /**
     * Hàm test cho tập dữ liệu kiểu ArrayDataSet.
     */
    // Sử dung ArrayDataSet gần giống(<=>) ArrayList
    public static void testStatisticsUsingArrayDataSet() {
        // Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30].
        int randomSize = (int) (Math.random() * 11) + 20;
        // Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử là các số double được sinh ngẫu nhiên,
        ArrayDataSet arrayDataSet = generateRandomArrayDataSet(randomSize);
        // In ra các dữ liệu thống kê về tập dữ liệu.
        System.out.println("ArrayDataSet statistics:");
        printStatistics(arrayDataSet);

        // Xóa một phần tử
        if (arrayDataSet.size() > 0) {
            // Xóa một phần tử ở đầu tập dữ liệu
            arrayDataSet.remove(0);
            // Xóa một phần tử ở cuối tập dữ liệu
            arrayDataSet.remove(arrayDataSet.size() - 1);
            // In ra các dữ liệu thống kê về tập dữ liệu.
            System.out.println("\nArrayDataSet statistics after removing elements:");
            printStatistics(arrayDataSet);
        }
    }

    /**
     * Function to test LinkedListDataSet statistics.
     */
    // Sử dụng LinkedListDataSet gần giống(<=>) LinkedList
    public static void testStatisticsUsingLinkedListDataSet() {
        // Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30].
        int randomSize = (int) (Math.random() * 11) + 20;
        // Tạo ra tập dữ liệu kiểu LinkedListDataSet gồm các phần tử là các số double được sinh ngẫu nhiên,
        LinkedListDataSet linkedListDataSet = generateRandomLinkedListDataSet(randomSize);
        // In ra các dữ liệu thống kê về tập dữ liệu.
        System.out.println("LinkedListDataSet statistics:");
        printStatistics(linkedListDataSet);

        // Xóa một phần tử
        if (linkedListDataSet.size() > 1) {
            // Xóa một phần tử ở đầu tập dữ liệu
            linkedListDataSet.remove(0);
            // Xóa một phần tử ở cuối tập dữ liệu
            linkedListDataSet.remove(linkedListDataSet.size() - 1);
            // In ra các dữ liệu thống kê về tập dữ liệu.
            System.out.println("\nLinkedListDataSet statistics after removing elements:");
            printStatistics(linkedListDataSet);
        }
    }

    // Implement your random dataset generation for ArrayDataSet
    // Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử là các số double được sinh ngẫu nhiên,
    private static ArrayDataSet generateRandomArrayDataSet(int size) {
        // Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử là các số double được sinh ngẫu nhiên,
        ArrayDataSet dataSet = new ArrayDataSet();
        // Sinh ngẫu nhiên các phần tử trong tập dữ liệu
        for (int i = 0; i < size; i++) {
            double randomValue = Math.random() * 100;
            dataSet.append(randomValue);
        }
        return dataSet;
    }

    // Implement your random dataset generation for LinkedListDataSet
    // Tạo ra tập dữ liệu kiểu LinkedListDataSet gồm các phần tử là các số double được sinh ngẫu nhiên,
    private static LinkedListDataSet generateRandomLinkedListDataSet(int size) {
        // Tạo ra tập dữ liệu kiểu LinkedListDataSet gồm các phần tử là các số double được sinh ngẫu nhiên,
        LinkedListDataSet dataSet = new LinkedListDataSet();
        // Sinh ngẫu nhiên các phần tử trong tập dữ liệu
        for (int i = 0; i < size; i++) {
            double randomValue = Math.random() * 100;
            dataSet.append(randomValue);
        }
        return dataSet;
    }

    // Implement your statistics printing function
    // In ra các dữ liệu thống kê về tập dữ liệu.
    private static void printStatistics(DataSet dataSet) {
        // In ra các dữ liệu thống kê về tập dữ liệu.
        System.out.println("Dataset: " + Arrays.toString(dataSet.toArray()));
        // Số phần tử trong tập dữ liệu.
        System.out.println("Size: " + dataSet.size());

        // Tạo ra đối tượng BasicStatistics
        BasicStatistics basicStats = new BasicStatistics();
        // Gán tập dữ liệu cho đối tượng BasicStatistics
        basicStats.setDataSet(dataSet);

        // In ra các dữ liệu thống kê về tập dữ liệu.
        System.out.println("Max: " + basicStats.max());
        System.out.println("Min: " + basicStats.min());
        System.out.println("Mean: " + basicStats.mean());
        System.out.println("Variance: " + basicStats.variance());
        System.out.println("Median: " + basicStats.median());
    }
}
