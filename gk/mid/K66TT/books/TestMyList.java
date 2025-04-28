package oop.books;

public class TestMyList {
    public static void main(String[] args) {
        System.out.println("Test Array list: ");
        testMyArrayList();

        System.out.println("Test Linked list: ");
        testMyLinkedList();
    }

    public static void print(MyList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void testMyArrayList() {
        MyList array = new MyArrayList();
        int year = 2000;
        int page = 50;
        for (int i = 0; i < 10; i++, year++, page++) {
            array.append(new Book("Book" + (i + 1), year, page));
        }
        BookManager bookManager = new BookManager(array);
        System.out.println("Test add: ");
        print(array);

        MyList sortByTitleAscending = bookManager.sortByTitle(true);
        System.out.println("Test Ascending by title:");
        print(sortByTitleAscending);

        MyList sortByTitleDescending = bookManager.sortByTitle(false);
        System.out.println("Test Descending by title: ");
        print(sortByTitleDescending);

        MyList sortByPageAscending = bookManager.sortByPageNumber(true);
        System.out.println("Test Ascending by page number:");
        print(sortByPageAscending);

        MyList sortByPageDescending = bookManager.sortByPageNumber(false);
        System.out.println("Test Descending by page number: ");
        print(sortByPageDescending);

        System.out.println("Test Iterator:");
        testIterator(array);
    }

    public static void testMyLinkedList() {
        MyList linkedList = new MyLinkedList();
        int year = 2000;
        int page = 50;
        for (int i = 0; i < 10; i++, year++, page++) {
            linkedList.append(new Book("Book" + (i + 1), year, page));
        }
        BookManager bookManager = new BookManager(linkedList);
        System.out.println("Test add: ");
        print(linkedList);

        MyList sortByTitleAscending = bookManager.sortByTitle(true);
        System.out.println("Test Ascending by title:");
        print(sortByTitleAscending);

        MyList sortByTitleDescending = bookManager.sortByTitle(false);
        System.out.println("Test Descending by title: ");
        print(sortByTitleDescending);

        MyList sortByPageAscending = bookManager.sortByPageNumber(true);
        System.out.println("Test Ascending by page number:");
        print(sortByPageAscending);

        MyList sortByPageDescending = bookManager.sortByPageNumber(false);
        System.out.println("Test Descending by page number: ");
        print(sortByPageDescending);

        System.out.println("Test Iterator:");
        testIterator(linkedList);
    }

    public static void testIterator(MyList list) {
        System.out.println("Iterating through the list and printing element information:");

        MyIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object book = iterator.next();
            System.out.println(book.toString());
        }
    }
}
