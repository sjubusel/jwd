package by.epamtc.jwd.busel.assignment01;

import java.util.Locale;
import java.util.Scanner;

public class Task01 {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n")
            .useLocale(Locale.US);

    private static double receiveDoubleFromConsole() {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            informAboutInvalidScannerInput(scanner.next());
            return receiveDoubleFromConsole();
        }
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token \"%s\","
                + " because it can not be translated into a valid"
                + " double value!\n", input);
    }

    private static double computeExpression(double a, double b, double c) {
        double dividend = b + Math.sqrt(Math.pow(b, 2.0) + 4 * a * c);
        double divisor = 2 * a;
        double firstExpressionPart = dividend / divisor;
        double secondExpressionPart = Math.pow(a, 3.0) * c;
        double thirdExpressionPart = Math.pow(b, -2.0);
        return firstExpressionPart - secondExpressionPart + thirdExpressionPart;
    }

    private static void reportInputValuesToConsole(double a, double b,
            double c) {
        System.out.println("You have entered the following variables:");
        System.out.printf("- variable \"%s\" is %f%n", "a", a);
        System.out.printf("- variable \"%s\" is %f%n", "b", b);
        System.out.printf("- variable \"%s\" is %f%n", "c", c);
    }

    public static void main(String[] args) {
        System.out.println("Please, insert a value of a \"a\" variable.");
        double a = receiveDoubleFromConsole();
        System.out.println("Please, insert a value of a \"b\" variable.");
        double b = receiveDoubleFromConsole();
        System.out.println("Please, insert a value of a \"c\" variable.");
        double c = receiveDoubleFromConsole();

        reportInputValuesToConsole(a, b, c);

        double expression = computeExpression(a, b, c);
        System.out.printf("The result of computing is%n%g", expression);

        scanner.close();
    }
}
