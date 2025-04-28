package oop.statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicStatistic implements Statistic {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistic() {
        this.dataSet = new ArrayDataSet();
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        return dataSet.size();
    }

    @Override
    public double max() {
        double max = dataSet.element(0);

        for (int i = 1; i < dataSet.size(); i++){
            double element = dataSet.element(i);

            if (element > max){
                max = element;
            }
        }

        return max;
    }

    @Override
    public double min() {
        double min = dataSet.element(0);

        for (int i = 1; i < dataSet.size(); i++){
            double element = dataSet.element(i);

            if (element < min){
                min = element;
            }
        }

        return min;
    }

    @Override
    public double mean() {
        double sum = 0;

        for (int i = 0; i < dataSet.size(); i++){
            sum += dataSet.element(i);
        }

        return sum / dataSet.size();
    }

    @Override
    public double variance() {
        double mean = mean();
        double sum = 0;

        for (int i = 0; i < dataSet.size(); i++){
            double diff = dataSet.element(i) - mean;
            sum += diff * diff;
        }

        return sum / dataSet.size();
    }

    @Override
    public double[] rank() {
        if (dataSet.size() == 0) {
            return new double[0];
        }

        double[] data = dataSet.elements(0, dataSet.size());
        Arrays.sort(data);
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            if (data[i] == data[i - 1]) {
                duplicates.add(i);
            }
        }

        double[] rank = new double[data.length];

        for (int i = 0; i < data.length; i++) {
            int index = Arrays.binarySearch(dataSet.elements(0, dataSet.size()), data[i]);
            if (duplicates.contains(i)) {
                int count = 0;
                double sum = index + 1;
                for (int j = i; j < data.length && data[j] == data[i]; j++) {
                    count++;
                    sum += Arrays.binarySearch(dataSet.elements(0, dataSet.size()), data[j]);
                }
                rank[index] = sum / count;
                i += count - 1;
            } else {
                rank[index] = (double) (i + 1) / data.length;
            }
        }
        return rank;
    }

    @Override
    public double median() {
        double[] sortedData = dataSet.elements(0, dataSet.size());
        Arrays.sort(sortedData);
        int mid = dataSet.size() / 2;

        if (dataSet.size() % 2 == 0) {
            return (sortedData[mid - 1] + sortedData[mid]) / 2;
        } else {
            return sortedData[mid];
        }
    }
}
