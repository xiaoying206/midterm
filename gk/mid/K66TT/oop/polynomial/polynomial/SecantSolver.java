package oop.polynomial.polynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp Secant
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức trong khoảng [lower, upper]
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        double f0 = polynomial.evaluate(x0);
        double f1 = polynomial.evaluate(x1);

        for (int i = 0; i < maxIterations; i++) {
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double f2 = polynomial.evaluate(x2);
            if (Math.abs(f2) < tolerance) {
                return x2;
            }
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;
        }

        throw new RuntimeException("Failed to converge after " + maxIterations + " iterations");
    }
}
