package com.poly;

abstract class AbstractPoly implements Poly {
    protected int degree;
    private Object poly;

    public int degree() {
        return degree;
    }

    // Trả về mảng là các hệ số của đa thức đạo hàm
    int[] differentiate() {
        int[] derivative = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivative[i - 1] = i * coefficient(i);
        }

        return derivative;
    }

    // Kiểm tra xem hai đa thức có bằng nhau hay không
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) { // check tập rỗng không và kiểm tra xem 2 hàm có cùng một loại
            return false;
        }

        AbstractPoly poly = (AbstractPoly) o;

        if (degree != poly.degree()) {
            return false;
        }

        // so sánh hệ số giữa hai đa thức
        for (int i = 0; i <= degree; i++) {
            if (coefficient(i) != poly.coefficient(i)) {
                return false;
            }
        }
        return true;
    }

    // Tính giá trị đa thức tại x = a;
    public double evaluate(double x) {
        double value = 0;
        for (int i = 0; i <= degree; i++) {
            value += coefficient(i) * Math.pow(x, i);
        }

        return value;
    }

    // Mô tả đa thức
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Poly[");

        if (degree == 0){
            sb.append(0);
            sb.append("]");
        } else {
            for (int i = 0; i <= degree; i++) {
                sb.append(coefficient(i));
                sb.append("x^");
                sb.append(i);
                sb.append(i < degree ? " + " : "]"); // Nếu là bậc của x nhỏ hơn bậc đa thức thì cộng còn không thì kết thúc ở ]
            }
        }

        return sb.toString();
    }
}
