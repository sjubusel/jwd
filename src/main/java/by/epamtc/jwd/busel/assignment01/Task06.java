package by.epamtc.jwd.busel.assignment01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task06 {
    private static final String SCALAR = "(-?[0-9]+)([.][0-9Ee]+)?";
    private static Scanner scanner = new Scanner(System.in);

    private static double receiveDoubleFromConsole() {
        String input = scanner.nextLine().trim();
        if (isDouble(input)) {
            return Double.parseDouble(input);
        } else {
            informAboutInvalidScannerInput();
            return receiveDoubleFromConsole();
        }
    }

    private static boolean isDouble(String input) {
        return Pattern.matches(SCALAR, input);
    }

    private static void informAboutInvalidScannerInput() {
        System.out.println("You have entered an invalid token,"
                + "because it can not be translated into a valid"
                + " double value!");
    }

    private static long computeN(double a1, double d, double min, double max) {
        if (d > 0) {
            return computeNInAscendingOrder(a1, d, max);
        } else {
            return computeNInDescendingOrder(a1, d, min);
        }
    }

    private static long computeNInAscendingOrder(double a1, double d, double max) {
        double sum = 0;
        double aN;
        long n = 1;
        long nStep = 10000;
        while (sum <= max) {
            aN = a1 + (n - 1) * d;
            sum = (a1 + aN) * n / 2;
            n += nStep;
        }
        return computeNInAscendingOrder(a1, d, max, n - nStep * 2);
    }

    private static long computeNInAscendingOrder(double a1, double d, double max,
                                             long nMin) {
        double sum = 0;
        double aN;
        long n = nMin;
        while (sum <= max) {
            aN = a1 + (n - 1) * d;
            sum = (a1 + aN) * n++ / 2;
        }
        return --n;
    }

    private static long computeNInDescendingOrder(double a1, double d,
                                              double min) {
        double sum = 0;
        double aN;
        long n = 1;
        long nStep = 10000;
        while (sum >= min) {
            aN = a1 + (n - 1) * d;
            sum = (a1 + aN) * n / 2;
            n += nStep;
        }
        return computeNInDescendingOrder(a1, d, min, n - nStep * 2);
    }

    private static long computeNInDescendingOrder(double a1, double d, double min,
                                              long nMin) {
        double sum = 0;
        double aN;
        long n = nMin;
        while (sum >= min) {
            aN = a1 + (n - 1) * d;
            sum = (a1 + aN) * n++ / 2;
        }
        return --n;
    }

    public static void main(String[] args) {
        System.out.println("Please, insert an initial term of" +
                " an arithmetic progression.");
        double initialTerm = receiveDoubleFromConsole();
        System.out.println("Please, insert a common difference.");
        double commonDifference = receiveDoubleFromConsole();

        long nThTermIfIntegerMax = computeN(initialTerm, commonDifference,
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("The sum of an arithmetic progression exceed"
                        + " Integer type boundaries, when \"N\" = %d%n",
                nThTermIfIntegerMax);

        long nThTermIfLongMax = computeN(initialTerm, commonDifference,
                Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("The sum of an arithmetic progression exceed"
                        + " Long type boundaries, when \"N\" = %d%n",
                nThTermIfLongMax);

        scanner.close();
    }
}
