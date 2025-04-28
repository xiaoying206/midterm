package hus.oop.basicstatistics;

public class ArrayDataSet extends AbstractDataSet {
    // Kích thước mảng mặc định.
    private static final int DEFAULT_CAPACITY = 16;
    // Mảng dữ liệu.
    private double[] data;
    // Kích thước của mảng dữ liệu.
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy kích thước của tập dữ liệu.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public double get(int index) {
        if (checkBoundaries(index, size - 1)) {
            return data[index];
        } else {
            // Loi: IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(double value, int index) {
        if (checkBoundaries(index, size - 1)) {
            data[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        // aray.size() = 5 muốn them phần tử thứ 6 -> mở rộng mảng
        if (size == data.length) {
            allocateMore();
        }
        // gán giá trị vào phần tử mới vào vị trí tiếp theo của mảng.
        data[size++] = value;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value
     * @param index
     */
    @Override
    public void insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        // aray.size() = 5 muốn them phần tử thứ 6 -> mở rộng mảng
        if (size == data.length) {
            allocateMore();
        }

        // Di chuyển các phần tử từ index -> size - 1 sang phải 1 vị trí.
        // System.arraycopy(data, index, data, index + 1, size - index);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        // Gán giá trị mới vào vị trí index.
        data[index] = value;

        // Tăng kích thước mảng lên 1.
        size++;
    }


    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        // Nếu index = 5 mà size = 5 -> không xóa được
        // [1, 2, 3, 4, 5] -> xóa phần tử thứ 3 -> [1, 2, 4, 5]
        if (checkBoundaries(index, size - 1)) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            size--;
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        // array.size() = 5
        // newArray.size() = 10
        int newCapacity = data.length * 2;
        // Kích thước mảng mới.
        // [1, 2, 3, 4, 5] -> [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
        double[] newData = new double[newCapacity];
        // Copy từ 0 -> size - 1 và còn lại kệ nó
        // C1
        // System.arraycopy(data, 0, newData, 0, size);

        // C2
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }


    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public double[] toArray() {
        double[] result = new double[size];
        // Chuyển dữ liệu từ mảng data (List) sang mảng result(double[])
        // C1
        // System.arraycopy(data, 0, result, 0, size);

        // C2
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }

        return result;
    }
}
