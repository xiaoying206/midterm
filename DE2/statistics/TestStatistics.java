package hus.oop.statistics;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        System.out.println("===== Testing with MyArrayList =====");
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(9);
        arrayList.add(3);

        Statistics statArray = new Statistics(arrayList);
        TestStatistics testArray = new TestStatistics(statArray);
        testArray.testMyArrayList();

        System.out.println("\n===== Testing with MyLinkedList =====");
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(1);
        linkedList.add(9);
        linkedList.add(3);

        Statistics statLinked = new Statistics(linkedList);
        TestStatistics testLinked = new TestStatistics(statLinked);
        testLinked.testMyLinkedList();
    }

    public void testMyArrayList() {
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Search(4): " + statistics.search(4));
        System.out.println("Rank(4): " + statistics.rank(4));
    }

    public void testMyLinkedList() {
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Search(4): " + statistics.search(4));
        System.out.println("Rank(4): " + statistics.rank(4));
    }
}
