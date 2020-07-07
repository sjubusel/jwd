package by.epamtc.jwd.busel.assignment01;

import java.util.Locale;
import java.util.Scanner;

public class Task04 {
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
        System.out.printf("You have entered an invalid token"
                + " \"%s\", because it can not be translated into"
                + " a valid int value!\n", input);
    }

    private static double computeFunction(double x) {
        if (x <= 13) {
            return ((-1.0) * Math.pow(x, 3.0) + 9.0);
        } else {
            return ((-1.0) * (3.0 / (x + 1.0)));
        }
    }

    public static void main(String[] args) {
        System.out.println("Please, input any real number");
        double x = receiveDoubleFromConsole();
        double y = computeFunction(x);

        System.out.printf("The value of function \"y\" equals to %g%n", y);
        System.out.printf("if the value of Variable \"x\" is %g%n", x);

        scanner.close();
    }
}
