package lab03;

import java.util.Scanner;

// Exercise 2.1
public class Exponent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int base = scanner.nextInt();
        System.out.print("Enter the exponent: ");
        int exp = scanner.nextInt();
        scanner.close();

        System.out.printf("%d raises to power of %d is: %d",
                base, exp, exponent(base, exp));
    }

    public static int exponent(int base, int exp) {
        int product = 1;
        for (int count = 0; count  < exp; count++) {
            product *= base;
        }
        return product;
    };
}
