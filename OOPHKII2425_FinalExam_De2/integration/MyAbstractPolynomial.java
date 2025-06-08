package hus.oop.integration;

import hus.oop.statistics.MyIterator;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder("[");
        MyIterator it = iterator(0);
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
    }
}
