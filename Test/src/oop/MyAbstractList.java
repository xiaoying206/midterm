package oop;

public abstract class MyAbstractList implements MyList {
    @Override
    public String toString() {
        // Có thể để cài đặt mặc định hoặc yêu cầu lớp con override.
        // Cài đặt đơn giản trả về tên lớp
        return getClass().getSimpleName();
        // Hoặc cài đặt như ban đầu nếu bạn muốn thông tin size ở lớp abstract
        // return getClass().getSimpleName() + " (size=" + size() + ")";
        // Lưu ý: Gọi size() ở đây có thể gây lỗi nếu lớp con chưa cài đặt size()
        // và bạn gọi toString() trên một đối tượng của lớp con nhưng size() chưa implement.
        // Cách an toàn hơn là để lớp con tự override và gọi size().
    }
}