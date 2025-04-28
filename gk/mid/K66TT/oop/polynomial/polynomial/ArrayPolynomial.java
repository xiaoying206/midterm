package oop.polynomial.polynomial;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficients;
    private int size;

    public ArrayPolynomial(double[] coefficients) {
        this.coefficients = coefficients;
        degree = coefficients.length - 1;
        reduce();
    }

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        coefficients = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     *
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        if (index < 0 || index > degree) {
            return 0;
        }
        return coefficients[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     *
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        return coefficients;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        if (size > coefficients.length){
            enlarge();
        }
        coefficients[size] = coefficient;
        size++;

        return new ArrayPolynomial(coefficients);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (size >= coefficients.length){
            enlarge();
        }
        for (int i = size - 1; i >= index; i--){
            coefficients[i + 1] = coefficients[i];
        }
        coefficients[index] = coefficient;
        size++;

        return new ArrayPolynomial(coefficients);
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        coefficients[index] = coefficient;

        return new ArrayPolynomial(coefficients);
    }

    /**
     * Lấy bậc của đa thức.
     *
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        return degree;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++){
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        if (degree <= 0) {
            throw new NegativeArraySizeException("There are no derivatives");
        } else {
            double[] derivativeCoeffs = new double[degree];

            for (int i = 1; i <= degree; i++) {
                derivativeCoeffs[i - 1] = i * coefficients[i];
            }

            return new ArrayPolynomial(derivativeCoeffs);
        }
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        int maxDegree = Math.max(degree, another.degree);
        double[] resultCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = coefficients[i] + another.coefficient(i);
        }

        return new ArrayPolynomial(resultCoeffs);
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        int maxDegree = Math.max(degree, another.degree);
        double[] resultCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            resultCoeffs[i] = coefficients[i] - another.coefficient(i);
        }

        return new ArrayPolynomial(resultCoeffs);
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        double[] resultCoeffs = new double[degree + another.degree + 1];
        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= another.degree; j++) {
                resultCoeffs[i + j] += coefficient(i) * another.coefficient(j);
            }
        }
        return new ArrayPolynomial(resultCoeffs);
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        double[] enlargedArray = new double[coefficients.length * 2];
        System.arraycopy(coefficients, 0, enlargedArray, 0, coefficients.length);
        coefficients = enlargedArray;
    }

    private void reduce() {
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                // xem các hệ số bậc cao nhất của đa thức
                // có bằng 0 hay không,
                degree = i;
                break;
            }
            // nếu bằng 0 thì điều chỉnh lại degree cho thích hợp để
            // không sử dụng đến những phần tử này.
            degree--;
        }
    }
}
