import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double real1 = scanner.nextDouble();
        double imag1 = scanner.nextDouble();
        MyComplex num1 = new MyComplex(real1, imag1);

        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double real2 = scanner.nextDouble();
        double imag2 = scanner.nextDouble();
        MyComplex num2 = new MyComplex(real2, imag2);

        System.out.println("\nNumber 1 is: " + num1);
        System.out.println(num1 + (num1.isReal() ? " is a pure real number" : " is NOT a pure real number"));
        System.out.println(num1 + (num1.isImaginary() ? " is a pure imaginary number" : " is NOT a pure imaginary number"));

        System.out.println("\nNumber 2 is: " + num2);
        System.out.println(num2 + (num2.isReal() ? " is a pure real number" : " is NOT a pure real number"));
        System.out.println(num2 + (num2.isImaginary() ? " is a pure imaginary number" : " is NOT a pure imaginary number"));

        System.out.println("\n" + num1 + (num1.equals(num2) ? " is equal to " : " is NOT equal to ") + num2);
        System.out.println(num1 + " + " + num2 + " = " + num1.addNew(num2));
        System.out.println(num1 + " - " + num2 + " = " + num1.subtractNew(num2));
        System.out.println(num1 + " * " + num2 + " = " + num1.multiply(num2));
        System.out.println(num1 + " / " + num2 + " = " + num1.divide(num2));

        scanner.close();
    }
}