package hus.oop.sortstrategy;

import java.util.Arrays;
import java.util.Random;

public class TestSortStrategy {
    /* Yêu cầu:
         - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
         - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
         - Copy dữ liệu mảng trên sang 2 mảng khác để có 3 mảng có dữ liệu giống nhau.
         - Tạo đối tượng có kiểu dữ liệu SortStrategy. Dùng đối tượng này test 3 thuật toán đã cho với 3 mảng dữ liệu trên.
           Các kết quả test được in ra terminal theo định dạng: ví dụ
           Using Bubble Sort Algorithm:
           Before sorting: [5.0 4.0 3.0 2.0 1.0]
           After sorting: [1.0 2.0 3.0 4.0 5.0]

           Using Insertion Sort Algorithm:
           Before sorting: [5.0 4.0 3.0 2.0 1.0]
           After sorting: [1.0 2.0 3.0 4.0 5.0]

         - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_SortStrategy.txt.
         - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
           <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
           nộp lên classroom
          */
    public static void main(String[] args) {
        Random random = new Random();

        int randomSize = random.nextInt(11) + 20;
        // 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30

        // Khởi tạo mảng randomArray với kích thước randomSize
        double[] randomArray = new double[randomSize];

        // Sinh ngẫu nhiên các phần tử trong mảng randomArray
        for (int i = 0; i < randomSize; i++){
            randomArray[i] = random.nextDouble();
        }

        // Copy dữ liệu từ mảng randomArray sang 2 mảng khác
        double[] arrayCopy1 = Arrays.copyOf(randomArray, randomSize);
        double[] arrayCopy2 = Arrays.copyOf(randomArray, randomSize);

        // Tạo đối tượng có kiểu dữ liệu SortStrategy
        SortStrategy sortStrategy = SortStrategy.getInstance();

        // Sử dụng thuật toán Bubble Sort
        // Nhận xét: Bubble Sort chạy chậm nhất trong 3 thuật toán
        BubbleSort bubbleSort = new BubbleSort();
        sortStrategy.setSortee(bubbleSort);
        System.out.println("Using Bubble Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(randomArray));
        sortStrategy.sort(randomArray, true);
        System.out.println("After sorting: " + Arrays.toString(randomArray));

        // Sử dụng thuật toán Selection Sort
        // Nhận xét: Selection Sort chạy nhanh hơn Bubble Sort nhưng chậm hơn Insertion Sort
        SelectionSort selectionSort = new SelectionSort();
        sortStrategy.setSortee(selectionSort);
        System.out.println("Using Selection Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(arrayCopy1));
        sortStrategy.sort(arrayCopy1, true);
        System.out.println("After sorting: " + Arrays.toString(arrayCopy1));

        // Sử dụng thuật toán Insertion Sort
        // Nhận xét: Insertion Sort chạy nhanh nhất trong 3 thuật toán
        sortStrategy.setSortee(new InsertionSort());
        System.out.println("Using Insertion Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(arrayCopy2));
        sortStrategy.sort(arrayCopy2, true);
        System.out.println("After sorting: " + Arrays.toString(arrayCopy2));
    }

}
