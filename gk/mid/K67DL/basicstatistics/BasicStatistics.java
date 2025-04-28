package hus.oop.basicstatistics;

import java.util.Arrays;

public class BasicStatistics implements Statistics {
    private DataSet dataSet;

    /**/
    public BasicStatistics() {
        this.dataSet = null;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        // TODO: Trả về số phần tử trong tập dữ liệu.
        if (dataSet == null) {
            return 0;
        } else {
            return dataSet.size();
        }
    }

    @Override
    public double max() {
        // TODO: Trả về giá trị lớn nhất trong tập dữ liệu.
        if (dataSet == null) {
            return Double.NaN;
        } else { // [1, 5, 3, 2, 4] -> 5
            double max = dataSet.get(0);
            // Duyệt qua từng phần tử trong tập dữ liệu.
            // So sánh phần tử hiện tại với giá trị lớn nhất hiện tại.
            // Nếu phần tử hiện tại lớn hơn giá trị lớn nhất hiện tại thì cập nhật giá trị lớn nhất.
            for (int i = 1; i < dataSet.size(); i++) {
                if (dataSet.get(i) > max) {
                    max = dataSet.get(i);
                }
            }
            // Trả về giá trị lớn nhất.
            return max;
        }
    }

    @Override
    public double min() {
        // Tương tự ngược lại như hàm max().
        if (dataSet == null) {
            return Double.NaN;
        } else {
            double min = dataSet.get(0);
            for (int i = 1; i < dataSet.size(); i++) {
                if (dataSet.get(i) < min) {
                    min = dataSet.get(i);
                }
            }
            return min;
        }
    }

    @Override
    public double mean() {
        // TODO: Trả về giá trị trung bình của tập dữ liệu.
        if (dataSet != null && dataSet.size() > 0) {
            double sum = 0;
            for (int i = 0; i < dataSet.size(); i++) {
                sum += dataSet.get(i);
            }
            return sum / dataSet.size();
        } else {
            return Double.NaN;
        }
    }


    @Override
    public double variance() {
        // TODO: Trả về phương sai của tập dữ liệu.
        // Phương sai = tổng bình phương độ lệch so với giá trị trung bình / số phần tử
        if (dataSet != null && dataSet.size() > 0) {
            double mean = mean();
            double sum = 0;
            for (int i = 0; i < dataSet.size(); i++) {
                sum += Math.pow(dataSet.get(i) - mean, 2);
            }
            return sum / dataSet.size();
        } else {
            return Double.NaN;
        }
    }

    @Override
    public AbstractDataSet rank() {
        // TODO: Trả về tập dữ liệu đã được sắp xếp tăng dần.
        // Nếu tập dữ liệu rỗng thì trả về null.
        if (dataSet != null && dataSet.size() > 0) {
            double[] data = dataSet.toArray();
            ArrayDataSet rankedData = new ArrayDataSet();
            for (double value : data) {
                rankedData.append(value);
            }
            return rankedData;
        } else {
            return null;
        }
    }

    @Override
    public double median() {
        // TODO: Trả về giá trị trung vị của tập dữ liệu.
        // Công thức tính trung vị: 
        // nếu số phần tử của tập dữ liệu là lẻ thì trung vị là phần tử ở giữa.
        // nếu số phần tử của tập dữ liệu là chẵn thì trung vị là trung bình cộng của 2 phần tử ở giữa.
        // Trường hợp tập dữ liệu rỗng thì trả về NaN.
        if (dataSet != null && dataSet.size() > 0) {
            double[] data = dataSet.toArray();
            Arrays.sort(data);

            if (data.length % 2 == 0) {
                int midIndex1 = data.length / 2 - 1;
                int midIndex2 = data.length / 2;
                return (data[midIndex1] + data[midIndex2]) / 2.0; // 2.0 là để từ int -> double
            } else {
                int midIndex = data.length / 2;
                return data[midIndex];
            }
        } else {
            return Double.NaN; // Lần đầu thấy
        }
    }
}
