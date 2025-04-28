package oop.polynomial.polynomial;

public abstract class AbstractPolynomial implements Polynomial {
    protected int degree;

    public int degree() {
        return degree;
    }
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (degree == 0){
            sb.append(0);
            sb.append("]");
        } else {
            for (int i = 0; i <= degree; i++) {
                sb.append(coefficient(i));
                sb.append("x^");
                sb.append(i);
                sb.append(i < degree ? " + " : "]");
            }
        }

        return sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        double[] derivative = new double[degree];
        for (int i = 1; i <= degree; i++) {
            derivative[i - 1] = i * coefficient(i);
        }

        return derivative;
    }
}
