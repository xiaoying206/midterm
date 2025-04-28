package oop; // Giả sử các file khác nằm trong package 'oop'

// Class TestMyList (lớp client để kiểm thử)
public class TestMyList {

    // m main(String[]): void - Phương thức chính để chạy chương trình kiểm thử
    public static void main(String[] args) {
        TestMyList tester = new TestMyList(); // Tạo đối tượng TestMyList để gọi các phương thức kiểm thử

        System.out.println("--- Bắt đầu kiểm thử MyArrayList ---");
        tester.testMyArrayList(); // Chạy kiểm thử cho MyArrayList

        System.out.println("\n--- Bắt đầu kiểm thử MyLinkedList ---");
        tester.testMyLinkedList(); // Chạy kiểm thử cho MyLinkedList

        // Lưu ý: Theo yêu cầu chỉ kiểm thử 3 hàm trong sơ đồ con của TestMyList
        // nên không gọi phương thức testStudentStatistics() ở đây.
        // Tuy nhiên, các lớp Student và StudentStatistics vẫn cần thiết cho bài toán tổng thể.

        System.out.println("\n--- Kết thúc các kiểm thử được yêu cầu ---");
    }

    // m TestMyList() - Constructor của lớp kiểm thử
    public TestMyList() {
        // Khởi tạo cho lớp TestMyList nếu cần, ở đây không cần làm gì đặc biệt
    }

    // m testIterator(MyList): void - Phương thức chung để kiểm thử Iterator của bất kỳ MyList nào
    // Được gọi bởi testMyArrayList() và testMyLinkedList()
    public void testIterator(MyList list) {
        System.out.println("  Lặp qua các phần tử trong danh sách:");
        MyIterator it = list.iterator(); // Lấy Iterator từ danh sách
        int index = 0;
        while (it.hasNext()) { // Kiểm tra xem còn phần tử tiếp theo không
            Object element = it.next(); // Lấy phần tử tiếp theo và di chuyển con trỏ
            System.out.println("    Phần tử [" + index + "]: " + element); // In phần tử
            index++;
        }
        System.out.println("  Kết thúc lặp.");
    }

    // m testMyArrayList(): void - Kiểm thử các chức năng của MyArrayList
    public void testMyArrayList() {
        MyList arrayList = new MyArrayList(); // Tạo một MyArrayList mới

        System.out.println("  Kích thước ArrayList ban đầu: " + arrayList.size()); // Ban đầu phải là 0

        // Kiểm thử append (thêm vào cuối)
        System.out.println("  --- Kiểm thử append ---");
        arrayList.append("Phần tử Array 1");
        arrayList.append("Phần tử Array 2");
        arrayList.append("Phần tử Array 3");
        System.out.println("  Sau khi thêm 3 phần tử. Kích thước: " + arrayList.size()); // Phải là 3
        testIterator(arrayList); // In nội dung danh sách

        // Kiểm thử insert (chèn)
        System.out.println("  --- Kiểm thử insert ---");
        arrayList.insert("Chèn đầu Array", 0); // Chèn vào đầu danh sách
        arrayList.insert("Chèn giữa Array", 2); // Chèn vào vị trí giữa
        arrayList.insert("Chèn cuối Array", arrayList.size()); // Chèn vào cuối danh sách (giống append)
        System.out.println("  Sau khi chèn thêm. Kích thước: " + arrayList.size()); // Phải là 6
        testIterator(arrayList); // In nội dung danh sách

        // Kiểm thử get (lấy phần tử theo index)
        System.out.println("  --- Kiểm thử get ---");
        System.out.println("  Phần tử tại index 0: " + arrayList.get(0));
        System.out.println("  Phần tử tại index 3: " + arrayList.get(3));
        System.out.println("  Phần tử tại index cuối: " + arrayList.get(arrayList.size() - 1));
        try {
            System.out.println("  Thử lấy phần tử tại index ngoài phạm vi (100):");
            arrayList.get(100); // Index không hợp lệ
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Bắt được ngoại lệ dự kiến: " + e.getMessage());
        }

        // Kiểm thử set (thay thế phần tử tại index)
        System.out.println("  --- Kiểm thử set ---");
        arrayList.set("Đặt lại Đầu Array", 0); // Đặt lại phần tử đầu tiên
        arrayList.set("Đặt lại Cuối Array", arrayList.size() - 1); // Đặt lại phần tử cuối cùng
        System.out.println("  Sau khi đặt lại phần tử. Kích thước: " + arrayList.size()); // Vẫn là 6
        testIterator(arrayList); // In nội dung danh sách sau khi set

        // Kiểm thử remove (xóa phần tử tại index)
        System.out.println("  --- Kiểm thử remove ---");
        Object removedMiddle = arrayList.remove(3); // Xóa phần tử tại index 3
        System.out.println("  Phần tử đã xóa tại index 3: " + removedMiddle);
        Object removedFirst = arrayList.remove(0); // Xóa phần tử tại index 0
        System.out.println("  Phần tử đã xóa tại index 0: " + removedFirst);
        Object removedLast = arrayList.remove(arrayList.size() - 1); // Xóa phần tử cuối
        System.out.println("  Phần tử đã xóa tại index cuối: " + removedLast);
        System.out.println("  Sau khi xóa. Kích thước: " + arrayList.size()); // Phải là 3
        testIterator(arrayList); // In nội dung danh sách sau khi xóa

        try {
            System.out.println("  Thử xóa phần tử tại index ngoài phạm vi (100):");
            arrayList.remove(100); // Index không hợp lệ
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Bắt được ngoại lệ dự kiến: " + e.getMessage());
        }

        System.out.println("  ArrayList cuối cùng: " + arrayList.toString());
    }

    // m testMyLinkedList(): void - Kiểm thử các chức năng của MyLinkedList
    public void testMyLinkedList() {
        MyList linkedList = new MyLinkedList(); // Tạo một MyLinkedList mới

        System.out.println("  Kích thước LinkedList ban đầu: " + linkedList.size()); // Ban đầu phải là 0

        // Kiểm thử append (thêm vào cuối)
        System.out.println("  --- Kiểm thử append ---");
        linkedList.append("Node Link A");
        linkedList.append("Node Link B");
        linkedList.append("Node Link C");
        System.out.println("  Sau khi thêm 3 phần tử. Kích thước: " + linkedList.size()); // Phải là 3
        testIterator(linkedList); // In nội dung danh sách

        // Kiểm thử insert (chèn)
        System.out.println("  --- Kiểm thử insert ---");
        linkedList.insert("Chèn đầu Link", 0); // Chèn vào đầu danh sách
        linkedList.insert("Chèn giữa Link", 2); // Chèn vào vị trí giữa
        linkedList.insert("Chèn cuối Link", linkedList.size()); // Chèn vào cuối danh sách
        System.out.println("  Sau khi chèn thêm. Kích thước: " + linkedList.size()); // Phải là 6
        testIterator(linkedList); // In nội dung danh sách

        // Kiểm thử get (lấy phần tử theo index)
        System.out.println("  --- Kiểm thử get ---");
        System.out.println("  Phần tử tại index 0: " + linkedList.get(0));
        System.out.println("  Phần tử tại index 3: " + linkedList.get(3));
        System.out.println("  Phần tử tại index cuối: " + linkedList.get(linkedList.size() - 1));
        try {
            System.out.println("  Thử lấy phần tử tại index ngoài phạm vi (100):");
            linkedList.get(100); // Index không hợp lệ
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Bắt được ngoại lệ dự kiến: " + e.getMessage());
        }

        // Kiểm thử set (thay thế phần tử tại index)
        System.out.println("  --- Kiểm thử set ---");
        linkedList.set("Đặt lại Đầu Link", 0); // Đặt lại phần tử đầu tiên
        linkedList.set("Đặt lại Cuối Link", linkedList.size() - 1); // Đặt lại phần tử cuối cùng
        System.out.println("  Sau khi đặt lại phần tử. Kích thước: " + linkedList.size()); // Vẫn là 6
        testIterator(linkedList); // In nội dung danh sách sau khi set

        // Kiểm thử remove (xóa phần tử tại index)
        System.out.println("  --- Kiểm thử remove ---");
        Object removedMiddle = linkedList.remove(3); // Xóa phần tử tại index 3
        System.out.println("  Phần tử đã xóa tại index 3: " + removedMiddle);
        Object removedFirst = linkedList.remove(0); // Xóa phần tử tại index 0
        System.out.println("  Phần tử đã xóa tại index 0: " + removedFirst);
        Object removedLast = linkedList.remove(linkedList.size() - 1); // Xóa phần tử cuối
        System.out.println("  Phần tử đã xóa tại index cuối: " + removedLast);
        System.out.println("  Sau khi xóa. Kích thước: " + linkedList.size()); // Phải là 3
        testIterator(linkedList); // In nội dung danh sách sau khi xóa

        try {
            System.out.println("  Thử xóa phần tử tại index ngoài phạm vi (100):");
            linkedList.remove(100); // Index không hợp lệ
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  Bắt được ngoại lệ dự kiến: " + e.getMessage());
        }

        System.out.println("  LinkedList cuối cùng: " + linkedList.toString());
    }

    // Phương thức testStudentStatistics() đã bị loại bỏ theo yêu cầu của bạn
    // vì nó không có trong sơ đồ con của TestMyList bạn gửi.
}