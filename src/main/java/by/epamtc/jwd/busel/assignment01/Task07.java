package by.epamtc.jwd.busel.assignment01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task07 {
    private static final String VALID_DOUBLE = "([1-9][0-9]{2})([.][0-9]{3})";
    private static Scanner scanner = new Scanner(System.in);

    private static double receiveValidDoubleFromConsole() {
        String input = scanner.nextLine().trim();
        if (isValid(input)) {
            return Double.parseDouble(input);
        } else {
            informAboutInvalidScannerInput();
            return receiveValidDoubleFromConsole();
        }
    }

    private static boolean isValid(String input) {
        return Pattern.matches(VALID_DOUBLE, input);
    }

    private static void informAboutInvalidScannerInput() {
        System.out.println("You have entered an invalid token.\n"
                + "An acceptable format is \"nnn.ddd\".");
    }

    private static int receiveFractionalPart(double realNumber, int integralPart) {
        double delta = realNumber - integralPart;
        return (int) (delta * 1000);
    }

    private static double compute(int integralPart, int fractionalPart) {
        return (fractionalPart + (integralPart / 1000.0));
    }

    public static void main(String[] args) {
        System.out.printf("Please, insert a real number%nin the following"
                + " format:%n\"%s\".%n", "nnn.ddd");
        double realNumber = receiveValidDoubleFromConsole();
        int integralPart = (int) realNumber;
        int fractionalPart = receiveFractionalPart(realNumber, integralPart);

        double newRealNumber = compute(integralPart, fractionalPart);
        System.out.printf("A new real number:%n%.3f%n", newRealNumber);

        scanner.close();
    }
}
