package hus.oop.integration;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        TestIntegrationCalculator test = new TestIntegrationCalculator(null);
        System.out.println("===== Test with MyArrayPolynomial =====");
        test.testArrayPolynomial();

        System.out.println("\n===== Test with MyListPolynomial =====");
        test.testListPolynomial();
    }

    public void testArrayPolynomial() {
        MyArrayPolynomial poly = new MyArrayPolynomial();
        poly.append(1).append(3).append(-2).append(1); // 1 + 3x -2x^2 + x^3
        this.polynomial = poly;
        System.out.println("Polynomial: " + polynomial);

        double lower = 0;
        double upper = 2;

        System.out.println("\n-- Midpoint Rule --");
        IntegrationCalculator calc1 = new IntegrationCalculator(new MidpointRule(1e-6, 20), polynomial);
        System.out.printf("Result: %.6f\n", calc1.integrate(lower, upper));

        System.out.println("-- Trapezoid Rule --");
        IntegrationCalculator calc2 = new IntegrationCalculator(new TrapezoidRule(1e-6, 20), polynomial);
        System.out.printf("Result: %.6f\n", calc2.integrate(lower, upper));

        System.out.println("-- Simpson Rule --");
        IntegrationCalculator calc3 = new IntegrationCalculator(new SimpsonRule(1e-6, 20), polynomial);
        System.out.printf("Result: %.6f\n", calc3.integrate(lower, upper));
    }

    public void testListPolynomial() {
        MyListPolynomial poly = new MyListPolynomial();
        poly.append(1).append(3).append(-2).append(1); // 1 + 3x -2x^2 + x^3
        this.polynomial = poly;
        System.out.println("Polynomial: " + polynomial);

        double lower = 0;
        double upper = 2;

        System.out.println("\n-- Midpoint Rule --");
        IntegrationCalculator calc1 = new IntegrationCalculator(new MidpointRule(1e-6, 20), polynomial);
        System.out.printf("Result: %.6f\n", calc1.integrate(lower, upper));

        System.out.println("-- Trapezoid Rule --");
        IntegrationCalculator calc2 = new IntegrationCalculator(new TrapezoidRule(1e-6, 20), polynomial);
        System.out.printf("Result: %.6f\n", calc2.integrate(lower, upper));

        System.out.println("-- Simpson Rule --");
        IntegrationCalculator calc3 = new IntegrationCalculator(new SimpsonRule(1e-6, 20), polynomial);
        System.out.printf("Result: %.6f\n", calc3.integrate(lower, upper));
    }
}
