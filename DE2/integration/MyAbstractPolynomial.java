package hus.oop.integration;
public abstract class MyAbstractPolynomial implements MyPolynomial {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double[] coeffs = coefficients();
        for (int i = degree(); i >= 0; i--) {
            double c = coeffs[i];
            if (c == 0) continue;
            if (sb.length() > 0 && c > 0) sb.append(" + ");
            else if (c < 0) sb.append(" - ");
            else if (sb.length() > 0) sb.append(" ");
            sb.append(String.format("%.2f", Math.abs(c)));
            if (i == 1) sb.append("x");
            else if (i > 1) sb.append("x^").append(i);
        }
        return sb.toString();
    }
}