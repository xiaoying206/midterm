package oop.statistics;

import java.util.*;

public class BasicStatistics {
    private MyVector[] vectors;

    public BasicStatistics() {
    }

    public void doSimpleStatic() {
        for (MyVector vector : vectors) {
            System.out.println("Vector: " + vector.toString());
            System.out.println("Norm: " + vector.norm());
        }
    }

    public MyVector[] filter(int minSize, int maxSize) {
        List<MyVector> filtered = new ArrayList<>();
        for (MyVector v : vectors) {
            int size = v.size();
            if (size >= minSize && size <= maxSize) {
                filtered.add(v);
            }
        }
        return filtered.toArray(new MyVector[0]);
    }

    public static void main(String[] args) {
        BasicStatistics stats = new BasicStatistics();
        stats.testArrayVector();
        stats.testListVector();
        stats.testBasicStatistics();
    }

    public double normMin() {
        double min = Double.MAX_VALUE;
        for (MyVector v : vectors) {
            min = Math.min(min, v.norm());
        }
        return min;
    }

    public double normMax() {
        double max = Double.MIN_VALUE;
        for (MyVector v : vectors) {
            max = Math.max(max, v.norm());
        }
        return max;
    }

    public double rank() {
        double totalNorm = 0.0;
        for (MyVector v : vectors) {
            totalNorm += v.norm();
        }
        return totalNorm / vectors.length;
    }

    public MyVector[] sortNorm(boolean increasing) {
        MyVector[] sorted = Arrays.copyOf(vectors, vectors.length);
        Arrays.sort(sorted, new Comparator<MyVector>() {
            @Override
            public int compare(MyVector o1, MyVector o2) {
                return increasing ? Double.compare(o1.norm(), o2.norm())
                        : Double.compare(o2.norm(), o1.norm());
            }
        });
        return sorted;
    }

    public void testArrayVector() {
        System.out.println("==== Test MyArrayVector ====");
        MyArrayVector a = new MyArrayVector();
        a.insert(1.0).insert(2.0).insert(3.0);
        a.insert(9.0, 1); // insert at index

        System.out.println("a = " + a);
        System.out.println("a.size() = " + a.size());
        System.out.println("a.norm() = " + a.norm());

        a.remove(2); // remove element at index
        System.out.println("a after remove(2): " + a);

        MyArrayVector b = new MyArrayVector();
        b.insert(4.0).insert(5.0).insert(6.0).insert(7.0);

        System.out.println("b = " + b);
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.minus(b));
        System.out.println("a - 2.0 = " + a.minus(2.0));

        System.out.println("a.scale(2.0) = " + a.scale(2.0));
        System.out.println("a.pow(2.0) = " + a.pow(2.0));

        System.out.println("a.dot() = " + a.dot());
        int[] indices = {0, 1, 2}; // hoặc bất kỳ chỉ số nào bạn muốn lấy
        MyVector extracted = a.extract(indices);
        System.out.println("a.extract({0,1,2}) = " + extracted);
    }

        public void testListVector() {
        System.out.println("==== Test MyListVector ====");
        MyListVector a = new MyListVector();
        a.insert(1.0).insert(2.0).insert(3.0);
        a.insert(10.0, 0); // insert at index

        System.out.println("a = " + a);
        System.out.println("a.size() = " + a.size());
        System.out.println("a.norm() = " + a.norm());

        a.remove(1); // remove element at index
        System.out.println("a after remove(1): " + a);

        MyListVector b = new MyListVector();
        b.insert(4.0).insert(5.0).insert(6.0).insert(7.0);

        System.out.println("b = " + b);
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.minus(b));
        System.out.println("a - 1.5 = " + a.minus(1.5));

        System.out.println("a.scale(1.5) = " + a.scale(1.5));
        System.out.println("a.pow(3.0) = " + a.pow(3.0));

        System.out.println("a.dot() = " + a.dot());

        int[] indices = {0, 2}; // extract specific indices
        MyVector extracted = a.extract(indices);
        System.out.println("a.extract({0,2}) = " + extracted);
    }

    public void testBasicStatistics() {
        System.out.println("==== Test BasicStatistics ====");

        // Tạo một số vector để gán vào biến vectors
        MyArrayVector v1 = new MyArrayVector();
        v1.insert(1.0).insert(2.0).insert(2.0);

        MyListVector v2 = new MyListVector();
        v2.insert(3.0).insert(4.0);

        MyArrayVector v3 = new MyArrayVector();
        v3.insert(0.0).insert(1.0);

        this.vectors = new MyVector[] {v1, v2, v3};

        // In thông tin vector và norm
        doSimpleStatic();

        // Test lọc theo kích thước vector
        System.out.println("\nFilter vectors with size between 2 and 3:");
        MyVector[] filtered = filter(2, 3);
        for (MyVector v : filtered) {
            System.out.println(v + " (size = " + v.size() + ")");
        }

        // Test normMin, normMax, rank
        System.out.println("\nMin norm: " + normMin());
        System.out.println("Max norm: " + normMax());
        System.out.println("Average norm (rank): " + rank());

        // Test sắp xếp theo norm
        System.out.println("\nVectors sorted by norm (increasing):");
        MyVector[] sortedAsc = sortNorm(true);
        for (MyVector v : sortedAsc) {
            System.out.println(v + " (norm = " + v.norm() + ")");
        }

        System.out.println("\nVectors sorted by norm (decreasing):");
        MyVector[] sortedDesc = sortNorm(false);
        for (MyVector v : sortedDesc) {
            System.out.println(v + " (norm = " + v.norm() + ")");
        }
    }
}