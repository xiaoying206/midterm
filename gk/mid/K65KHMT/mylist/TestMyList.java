package com.mylist;

public class TestMyList {
    public static void main(String[] args) {
        MyList list = new MyLinkedList();

        // add values 1 to 10 to the list
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // print the list before modification
        System.out.print("Original list: ");
        printList(list);

        // add value 11 at index 2
        list.add(11, 2);
        System.out.print("After adding 11 at index 2: ");
        printList(list);

        // remove value at index 5
        list.remove(5);
        System.out.print("After removing value at index 5: ");
        printList(list);
    }

    // helper method to print the contents of a list
    public static void printList(MyList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i) + "] ");
        }
        System.out.println();
    }
}


