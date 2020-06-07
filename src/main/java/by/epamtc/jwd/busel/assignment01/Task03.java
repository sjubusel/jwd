package by.epamtc.jwd.busel.assignment01;

import java.util.Locale;
import java.util.Scanner;

public class Task03 {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n")
            .useLocale(Locale.US);

    private static double getDoubleFromConsole() {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            informAboutInvalidScannerInput(scanner.next());
            return getDoubleFromConsole();
        }
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token \"%s\","
                + " because it can not be translated into a valid"
                + " double value!\n", input);
    }

    private static boolean doValuesMeetCondition(double a, double b,
            double c) {
        return ((a > b) && (b > c));
    }

    private static void printValues(double a, double b, double c) {
        System.out.println("The current values are:");
        System.out.printf("- %s is %g%n", "a", a);
        System.out.printf("- %s is %g%n", "b", b);
        System.out.printf("- %s is %g%n", "c", c);
    }

    public static void main(String[] args) {
        System.out.println("Please, insert a value of a \"a\" variable.");
        double a = getDoubleFromConsole();
        System.out.println("Please, insert a value of a \"b\" variable.");
        double b = getDoubleFromConsole();
        System.out.println("Please, insert a value of a \"c\" variable.");
        double c = getDoubleFromConsole();

        if (doValuesMeetCondition(a, b, c)) {
            a *= 2;
            b *= 2;
            c *= 2;
        } else {
            a = Math.abs(a);
            b = Math.abs(b);
            c = Math.abs(c);
        }
        printValues(a, b, c);
    }
}
