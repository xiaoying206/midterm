package oop;

public interface MyList extends MyIterable {
    void append(Object element); // Thêm phần tử vào cuối
    Object get(int index);       // Lấy phần tử tại index
    void insert(Object element, int index); // Chèn phần tử tại index
    Object remove(int index);    // Xóa phần tử tại index và trả về nó
    void set(Object element, int index); // Thay thế phần tử tại index
    int size();                  // Trả về số lượng phần tử
}
