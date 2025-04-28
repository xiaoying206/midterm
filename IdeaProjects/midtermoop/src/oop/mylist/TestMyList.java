package oop.mylist;

public class TestMyList {

    public TestMyList() {
    }

    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
/*
        System.out.println("=== Test Iterator ===");
        MyList list = new MyArrayList();
        list.append(new Student("John", "Doe", 8.0));
        list.append(new Student("Jane", "Doe", 9.1));
        testIterator(list);
 */
    }

    public static void testMyArrayList() {
        System.out.println("=== Test MyArrayList ===");
        MyList list = new MyArrayList();
        list.append(new Student("Alice", "Smith", 8.5));
        list.append(new Student("Bob", "Brown", 7.0));
        list.append(new Student("Charlie", "White", 9.2));

        testIterator(list);
        System.out.println("List: " + list);
    }

    public static void testMyLinkedList() {
        System.out.println("=== Test MyLinkedList ===");
        MyList list = new MyLinkedList();
        list.append(new Student("Daisy", "Green", 8.8));
        list.append(new Student("Eve", "Black", 7.5));
        list.append(new Student("Frank", "Gray", 9.0));

        testIterator(list);
        System.out.println("List: " + list);
    }

    public static void testIterator(MyList list) {
        MyIterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}