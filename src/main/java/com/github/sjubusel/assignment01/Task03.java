package com.github.sjubusel.assignment01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task03 {
    private static final String SCALAR = "(-?[0-9]+)([.][0-9Ee]+)?";
    private static Scanner scanner = new Scanner(System.in);
    private static String[] variableName = {"a", "b", "c"};

    private static double getDoubleFromConsoleNamedAs(String variableName) {
        System.out.printf("Please, insert a value of a \"%s\" variable.%n",
                variableName);
        return getValueUnlessItIsDouble(variableName);
    }

    private static double getValueUnlessItIsDouble(String variableName) {
        String input = scanner.nextLine().trim();
        if (isDouble(input)) {
            return Double.parseDouble(input);
        } else {
            informAboutInvalidScannerInput();
            return getDoubleFromConsoleNamedAs(variableName);
        }
    }

    private static boolean isDouble(String input) {
        return Pattern.matches(SCALAR, input);
    }

    private static void informAboutInvalidScannerInput() {
        System.out.println("You have entered an invalid token,");
        System.out.println("because it can not be translated");
        System.out.println("into a valid double value!\n");
    }

    private static boolean doValuesMeetCondition(double a, double b,
                                                 double c) {
        return ((a > b) && (b > c));
    }

    private static void printCurrentValues(double a, double b, double c) {
        System.out.println("The current values are:");
        System.out.printf("- %s is %g%n", variableName[0], a);
        System.out.printf("- %s is %g%n", variableName[1], b);
        System.out.printf("- %s is %g%n", variableName[2], c);
    }

    public static void main(String[] args) {
        double a = getDoubleFromConsoleNamedAs(variableName[0]);
        double b = getDoubleFromConsoleNamedAs(variableName[1]);
        double c = getDoubleFromConsoleNamedAs(variableName[2]);
        if (doValuesMeetCondition(a, b, c)) {
            a *= 2;
            b *= 2;
            c *= 2;
        } else {
            a = Math.abs(a);
            b = Math.abs(b);
            c = Math.abs(c);
        }
        printCurrentValues(a, b, c);
    }
}
