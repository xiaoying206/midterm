package hus.oop.integration;

public class SimpsonRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        /* TODO */
        int n = 4;
        if (n % 2 != 0) n++;
        double prev = integrate(polynomial, lower, upper, n);
        for (int i = 1; i <= maxIterations; i++) {
            n *= 2;
            if (n % 2 != 0) n++;
            double curr = integrate(polynomial, lower, upper, n);
            if (Math.abs(curr - prev) / 15 < precision) {
                return curr;
            }
            prev = curr;
        }
        return prev;
    }

    /**
     * Tính xấp xỉ giá trị tích phân với numOfSubIntervals (số chẵn) khoảng phân hoạch đều.
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        if (numOfSubIntervals % 2 != 0) numOfSubIntervals++;
        double h = (upper - lower) / numOfSubIntervals;
        double sum = polynomial.evaluate(lower) + polynomial.evaluate(upper);

        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            sum += (i % 2 == 0 ? 2 : 4) * polynomial.evaluate(x);
        }
        return (h / 3) * sum;
    }
}
