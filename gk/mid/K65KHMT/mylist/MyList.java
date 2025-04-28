package com.mylist;

interface MyList {
    void add(Object object, int index);

    void remove(int index);

    int size();

    Object get(int index);

    void add(Object object);
}
