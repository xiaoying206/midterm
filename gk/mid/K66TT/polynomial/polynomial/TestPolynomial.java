package oop.polynomial.polynomial;

public class TestPolynomial {
    public static void main(String[] args) {
        testArrayPolynomial();
        testListPolynomial();
        testRootSolver();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */

        // Khởi tạo đa thức
        ArrayPolynomial arrayPolynomial = new ArrayPolynomial(new double[]{2.0, 1.0, 0.0});
        System.out.println("Đa thức hiện có: f(x1) = " + arrayPolynomial);

        // Thêm phần tử vào đa thức
        arrayPolynomial.append(3.0);
        System.out.println("Đa thức sau khi thêm phần tử : " + arrayPolynomial);

        // Thay đổi hệ số
        arrayPolynomial.set(5.0, 1);
        System.out.println("Đa thức sau khi sửa hệ số 5 tại vị trí thứ: " + arrayPolynomial);

        // Đa thức tính toán thứ 2
        ArrayPolynomial another = new ArrayPolynomial(new double[]{1.0, 2.0, 3.0});
        System.out.println("Đa thức để tính toán: f(x2) + " + another);

        // Cộng 2 đa thức
        System.out.println("Tổng 2 đa thức f(x1) và f(x2) là f(x1) + f(x2) = " + arrayPolynomial.plus(another));

        // Trừ 2 đa thức
        System.out.println("Hiệu 2 đa thức f(x1) và f(x2) là f(x1) - f(x2) = " + arrayPolynomial.minus(another));

        // Nhân 2 đa thức
        System.out.println("Tích 2 đa thức f(x1) và f(x2) là f(x1) * f(x2) = " + arrayPolynomial.multiply(another));

        // Giá trị của đa thức khi biết trước x1 = 2.5
        System.out.println("Giá trị của đa thức f(x1) tại x1 = 2.5 là f(2.5) = " + arrayPolynomial.evaluate(2.5));

        System.out.println();
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */

        // Khởi tạo đa thức
        // Test initialization
        double[] coeffs = {1, 2, 3};
        ListPolynomial p1 = new ListPolynomial(coeffs);
        System.out.println("Đa thức hiện có: f(x1) = " + p1);

        // Thêm phần tử vào đa thức
        p1.append(4);
        System.out.println("Đa thức sau khi thêm phần tử : " + p1);

        // Test insert
        p1.insert(5, 2);
        System.out.println("Đa thức sau khi thêm hệ số 5 tại vị trí thứ 3: " + p1);

        // Test set
        p1.set(6, 3);
        System.out.println("Đa thức sau khi sửa hệ số 6 tại vị trí thứ 4: " + p1);

        // Test evaluate
        System.out.println("Giá trị của đa thức f(x1) tại x1 = 2.5 là f(2.5) = " + p1.evaluate(2.5));

        // Test plus
        double[] coeffs2 = {1, 1, 1};
        ListPolynomial p2 = new ListPolynomial(coeffs2);
        System.out.println("Đa thức để tính toán: f(x2) + " + p2);

        // Cộng 2 đa thức
        System.out.println("Tổng 2 đa thức f(x1) và f(x2) là f(x1) + f(x2) = " + p1.plus(p2));

        // Trừ 2 đa thức
        System.out.println("Hiệu 2 đa thức f(x1) và f(x2) là f(x1) - f(x2) = " + p1.minus(p2));

        // Nhân 2 đa thức
        System.out.println("Tích 2 đa thức f(x1) và f(x2) là f(x1) * f(x2) = " + p1.multiply(p2));

        System.out.println();
    }

    public static void testRootSolver() {
        /*
         TODO

         - Tạo đa thức có nghiệm trong khoảng [a, b] nào đó.
         - Viết chương trình tìm nghiệm của đa thức theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           PolynomialRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, đa thức, và nghiệm của đa thức.
         */
        double a = -10;
        double b = 10;
        // Khởi tạo đa thức
        ArrayPolynomial p = new ArrayPolynomial(new double[]{2.0, 1.0, 0.0});
        System.out.println("Đa thức hiện có: f(x) = " + p);

        // Tìm nghiệm của đa thức sử dụng phương pháp Bisection.
        BisectionSolver bisectionSolver = new BisectionSolver(0.0001, 100);
        double rootBisection = bisectionSolver.solve(p, a, b);

        // Tìm nghiệm của đa thức sử dụng phương pháp Newton-Raphson.
        NewtonRaphsonSolver newtonRaphsonSolver = new NewtonRaphsonSolver(0.0001, 100);
        double rootNewtonRaphson = newtonRaphsonSolver.solve(p, a, b);

        // Tìm nghiệm của đa thức sử dụng phương pháp Secant.
        SecantSolver secantSolver = new SecantSolver(0.0001, 100);
        double rootSecant = secantSolver.solve(p, a, b);

        // In ra kết quả.
        System.out.println("Bisection method: root = " + rootBisection);
        System.out.println("Newton-Raphson method: root = " + rootNewtonRaphson);
        System.out.println("Secant method: root = " + rootSecant);

    }
}
