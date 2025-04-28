package oop.polynomial.polynomial;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức sử dụng phương pháp Newton-Raphson.
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x = (lower + upper) / 2; // Khởi tạo giá trị đầu tiên cho x.
        double fx = polynomial.evaluate(x); // Tính giá trị của đa thức tại x.

        int i = 0;
        while (Math.abs(fx) > tolerance && i < maxIterations) {
            double dfx = polynomial.derivative().evaluate(x); // Tính đạo hàm của đa thức tại x.
            x = x - fx / dfx; // Cập nhật giá trị của x.
            fx = polynomial.evaluate(x); // Tính giá trị của đa thức tại x.
            i++;
        }

        return x;
    }
}
