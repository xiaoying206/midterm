package oop.polynomial.polynomial;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp chia đôi (Bisection)
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        double f0 = polynomial.evaluate(x0);
        double f1 = polynomial.evaluate(x1);

        if (f0 * f1 > 0) {
            throw new IllegalArgumentException("No roots exist within the specified interval.");
        }

        double x = 0;
        int iterations = 0;

        while (iterations < maxIterations) {
            x = (x0 + x1) / 2;
            double fx = polynomial.evaluate(x);

            if (Math.abs(fx) < tolerance) {
                break;
            }

            if (fx * f0 < 0) {
                x1 = x;
                f1 = fx;
            } else {
                x0 = x;
                f0 = fx;
            }

            iterations++;
        }

        if (iterations == maxIterations) {
            throw new RuntimeException("Maximum iterations reached.");
        }

        return x;
    }
}
