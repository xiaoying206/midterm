package hus.oop.sortstrategy;

public class InsertionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Insertion sort.
     *
     * @param data
     */
    @Override
    public void sort(double[] data, boolean order) {
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Insertion sort.
     *
     * @param data
     */
    private void sortAscending(double[] data) {
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            double key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Insertion sort.
     *
     * @param data
     */
    private void sortDescending(double[] data) {
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            double key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] < key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }
}
