package oop.polynomial.polynomial;
import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        this.coefficients = new ArrayList<>();
        this.degree = 0;
        this.coefficients.add(0.0);
    }

    public ListPolynomial(double[] coefficients) {
        this.coefficients = new ArrayList<>(coefficients.length);

        for (double coeff : coefficients) {
            this.coefficients.add(coeff);
        }

        reduce();
    }


    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        if (index < 0 || index > degree){
            return 0;
        }

        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        double[] result = new double[degree + 1];

        for (int i = 0; i <= degree; i++) {
            result[i] = coefficients.get(i);
        }

        return result;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        degree = coefficients.size() - 1;
        reduce();
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        if (index < 0 || index > degree) {
            throw new IllegalArgumentException("Invalid index!");
        }
        coefficients.add(index, coefficient);
        degree = coefficients.size() + 1;
        reduce();
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        if (index < 0 || index > degree) {
            throw new IllegalArgumentException("Invalid index!");
        }

        coefficients.set(index, coefficient);
        reduce();
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        return degree;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.size(); i++){
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        coefficients.remove(coefficients.size() - 1);
        for (int i = 0; i < coefficients.size(); i++) {
            coefficients.set(i, i * coefficients.get(i));
        }
        return this;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        int maxDegree = Math.max(degree, another.degree);
        double[] resultCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = coefficient(i) + another.coefficient(i);
        }

        return new ListPolynomial(resultCoeffs);
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        int maxDegree = Math.max(degree, another.degree);
        double[] resultCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = coefficient(i) - another.coefficient(i);
        }

        return new ListPolynomial(resultCoeffs);
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        double[] resultCoeffs = new double[degree + another.degree + 1];
        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= another.degree; j++) {
                resultCoeffs[i + j] += coefficient(i) * another.coefficient(j);
            }
        }
        return new ListPolynomial(resultCoeffs);
    }

    private void reduce() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                // xem các hệ số bậc cao nhất của đa thức
                // có bằng 0 hay không,
                degree = i;
                break;
            }
            // nếu bằng 0 thì điều chỉnh lại degree cho thích hợp để
            // không sử dụng đến những phần tử này.
            coefficients.remove(coefficients.get(i));
            degree--;
        }

        if (coefficients.isEmpty()) {
            degree = 0;
            coefficients.add(0.0);
        }
    }
}
