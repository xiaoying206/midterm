package oop.statistics;

public interface DataSet {
    /**
     * Lấy kích thước mẫu.
     * @return kích thước mẫu.
     */
    int size();

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return giá trị phần tử ở vị trí index.
     */
    double element(int index);

    /**
     * Lấy các giá trị của tập dữ liệu từ vị trí from đến vị trí to.
     * @param from
     * @param to
     * @return mảng các phần tử từ vị trí from đến vị trí to.
     */
    double[] elements(int from, int to);

    /**
     * Thêm dữ liệu vào cuối tập dữ liệu.
     * @param data
     */
    void append(double data);

    /**
     * Thêm dữ liệu data vào vị trí index của tập dữ liệu.
     * @param data
     * @param index
     */
    void insert(double data, int index);

    /**
     * Xóa phần tử dũ liệu tại vị trí index.
     * @param index
     */
    void remove(int index);

    /**
     * Xóa tất cả các phần tử dữ liệu bằng data trong tập dữ liệu.
     * @param data
     */
    void remove(double data);
}
