package hus.oop.statistics;

public class Statistics {
    private MyList data;

    public Statistics(MyList data) {
        this.data = data;
    }

    public double max() {
        double max = Double.NEGATIVE_INFINITY;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            if (val > max) max = val;
        }
        return max;
    }

    public double mean() {
        double sum = 0;
        int count = 0;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            sum += it.next().doubleValue();
            count++;
        }
        return count == 0 ? 0 : sum / count;
    }

    public double min() {
        double min = Double.POSITIVE_INFINITY;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            if (val < min) min = val;
        }
        return min;
    }

    public int rank(double value) {
        MyList sorted = data.sortIncreasing();
        int rank = 0;
        MyIterator it = sorted.iterator(0);
        while (it.hasNext()) {
            if (it.next().doubleValue() < value) rank++;
        }
        return rank;
    }

    public int search(double value) {
        return data.binarySearch(value);
    }

    public double variance() {
        double mean = mean();
        double sumSq = 0;
        int count = 0;
        MyIterator it = data.iterator(0);
        while (it.hasNext()) {
            double x = it.next().doubleValue();
            sumSq += (x - mean) * (x - mean);
            count++;
        }
        return count == 0 ? 0 : sumSq / count;
    }


}
