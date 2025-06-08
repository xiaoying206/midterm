package hus.oop.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MySquareMatrix {
    private int[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    public MySquareMatrix(int size) {
        initRandom(size);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [10, 90]
     * @param size
     */
    private void initRandom(int size) {
        /* TODO */
        data = new int[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = rand.nextInt(81) + 10; // [10, 90]
            }
        }
    }

    /**
     * Lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        /* TODO */
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i][i];
        }
        return result;
    }

    /**
     * Lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        /* TODO */
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i][data.length - 1 - i];
        }
        return result;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        /* TODO */
        List<Integer> result = new ArrayList<>();
        for (int[] row : data) {
            for (int num : row) {
                if (num < 2) continue;
                boolean isPrime = true;
                if (num != 2 && num % 2 == 0) {
                    isPrime = false;
                } else {
                    for (int i = 3; i <= Math.sqrt(num); i += 2) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                if (isPrime) {
                    result.add(num);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Sắp xếp các phần tử của ma trận theo thứ tự giảm dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự giảm dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public MySquareMatrix getSortedMatrix() {
        /* TODO */
        int size = data.length;
        int[] flat = new int[size * size];
        int index = 0;
        for (int[] row : data) {
            for (int val : row) {
                flat[index++] = val;
            }
        }
        Arrays.sort(flat);
        index = flat.length - 1;

        int[][] sortedData = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sortedData[i][j] = flat[index--];
            }
        }

        MySquareMatrix result = new MySquareMatrix(size);
        result.data = sortedData;
        return result;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public MySquareMatrix add(MySquareMatrix that) {
        /* TODO */
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        result.data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] + that.data[i][j];
            }
        }
        return result;
    }

    /**
     * Trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public MySquareMatrix minus(MySquareMatrix that) {
        /* TODO */
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        result.data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] - that.data[i][j];
            }
        }
        return result;
    }

    /**
     * Nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public MySquareMatrix multiply(MySquareMatrix that) {
        /* TODO */
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        result.data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += this.data[i][k] * that.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    /**
     * Nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public MySquareMatrix scaled(int value) {
        /* TODO */
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        result.data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[i][j] = this.data[i][j] * value;
            }
        }
        return result;
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public MySquareMatrix transpose() {
        /* TODO */
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        result.data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     *   1 2 3
     *   4 5 6
     *   7 8 9
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (int[] row : data) {
            for (int val : row) {
                sb.append(String.format("%4d", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
