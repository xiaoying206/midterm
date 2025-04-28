package oop.mylist;

public interface MyList extends MyIterable {
    void append(Object obj);
    Object get(int index);
    void insert(Object obj, int index);
    void remove(int index);
    void set(Object obj, int index);
    int size();
}