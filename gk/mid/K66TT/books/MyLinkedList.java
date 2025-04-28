package oop.books;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        size = 0;
        head = null;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyLinkedListNode temp = head;
        for (int i = 0; i < index; i += 1) {
            temp = temp.getNext();
        }
        return temp.getPayload();
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = new MyLinkedListNode(payload, head.getNext());
        } else {
            MyLinkedListNode temp = new MyLinkedListNode(payload);
            MyLinkedListNode temp2 = head;
            for (int i = 1; i < index; i += 1) {
                temp2 = temp2.getNext();
            }
            temp.setNext(temp2.getNext().getNext());
            temp2.setNext(temp);
        }
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            MyLinkedListNode temp = head;
            for (int i = 1; i < index; i += 1) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (head == null) {
            head = newNode;  // Danh sách rỗng, cập nhật giá trị của head
        } else {
            MyLinkedListNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        size += 1; // Tăng giá trị của biến đếm 'size'
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        if (index == 0) {
            MyLinkedListNode newNode = new MyLinkedListNode(payload, head);
            head = newNode;
        } else {
            MyLinkedListNode temp = head;
            for (int i = 1; i < index; i += 1) {
                MyLinkedListNode newNode = new MyLinkedListNode(payload, temp.getNext());
                temp.setNext(newNode);
            }
        }
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode temp = head;
        for (int i = 0; i < index; i += 1) {
            temp = temp.getNext();
        }
        return temp;
    }
}
