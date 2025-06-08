package hus.oop.statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        top = null;
    }

    @Override
    public int size() {
        /* TODO */
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double data) {
        /* TODO */
        if (top == null) {
            top = new MyNode(data);
        } else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new MyNode(data, null, current);
        }
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0) return;
        if (index == 0) {
            MyNode newNode = new MyNode(data, top, null);
            if (top != null) top.previous = newNode;
            top = newNode;
            return;
        }
        MyNode prev = getNodeByIndex(index - 1);
        if (prev == null) return;
        MyNode next = prev.next;
        MyNode newNode = new MyNode(data, next, prev);
        prev.next = newNode;
        if (next != null) next.previous = newNode;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        MyNode node = getNodeByIndex(index);
        if (node == null) return;
        if (node.previous != null) node.previous.next = node.next;
        if (node.next != null) node.next.previous = node.previous;
        if (index == 0) top = node.next;
    }

    @Override
    public MyLinkedList sortIncreasing() {
        /* TODO */
        int n = size();
        double[] temp = new double[n];
        MyNode current = top;
        for (int i = 0; i < n; i++) {
            temp[i] = current.data;
            current = current.next;
        }

        java.util.Arrays.sort(temp);

        MyLinkedList sorted = new MyLinkedList();
        for (double d : temp) {
            sorted.add(d);
        }
        return sorted;
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
        MyLinkedList sorted = this.sortIncreasing();
        int left = 0, right = sorted.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            double midVal = sorted.getNodeByIndex(mid).data;
            if (midVal == data) return mid;
            if (midVal < data) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        /* TODO */
        MyNode current = top;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return getNodeByIndex(currentPosition) != null;
        }

        @Override
        public Number next() {
            /* TODO */
            return getNodeByIndex(currentPosition++).data;
        }

        @Override
        public void remove() {
            /* TODO */
            MyLinkedList.this.remove(--currentPosition);
        }
    }
}
