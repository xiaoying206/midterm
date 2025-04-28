package com.poly;

/**
 * Interface representing a polynomial
 */
interface Poly {
    // Trả về hệ số của x^base
    int coefficient(int base);

    // Trả về một mảng là các hệ số của đa thức
    int[] coefficient();

    // Trả về bậc của đa thức
    int degree();

    // Trả về một đa thức mới là đạo hàm của đa thức ban đầu
    Poly derivative();

    // Tính giá trị của đa thức tại x
    double evaluate(double x);
}
