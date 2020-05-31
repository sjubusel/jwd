package com.github.sjubusel.assignment01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task01 {
    private static final String SCALAR = "(-?[0-9]+)([.][0-9Ee]+)?";
    private static Scanner scanner = new Scanner(System.in);
    private static String[] variableName = {"a", "b", "c"};

    private static double getDoubleFromConsoleNamedAs(String variableName) {
        System.out.printf("Please, insert a value of a \"%s\" variable.%n",
                variableName);
        return getValueUnlessItIsDouble(variableName);
    }

    private static double getValueUnlessItIsDouble(String variableName) {
        String input = scanner.nextLine();
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

    private static double computeExpression(double a, double b, double c) {
        reportInputValuesToConsole(a, b, c);
        double firstExpressionPart = computeFirstExpressionPart(a, b, c);
        double secondExpressionPart = computeSecondExpressionPart(a, c);
        double thirdExpressionPart = computeThirdExpressionPart(b);
        return firstExpressionPart - secondExpressionPart + thirdExpressionPart;
    }

    private static double computeFirstExpressionPart(double a, double b,
                                                     double c) {
        double dividend = b + Math.sqrt(Math.pow(b, 2.0) + 4 * a * c);
        double divisor = 2 * a;
        return dividend / divisor;
    }

    private static double computeSecondExpressionPart(double a, double c) {
        return Math.pow(a, 3.0) * c;
    }

    private static double computeThirdExpressionPart(double b) {
        return Math.pow(b, -2.0);
    }

    private static void reportInputValuesToConsole(double a, double b,
                                                   double c) {
        System.out.println("You have entered the following variables:");
        System.out.printf("- variable \"%s\" is %f%n", variableName[0], a);
        System.out.printf("- variable \"%s\" is %f%n", variableName[1], b);
        System.out.printf("- variable \"%s\" is %f%n", variableName[2], c);
    }

    public static void main(String[] args) {
        double a = getDoubleFromConsoleNamedAs(variableName[0]);
        double b = getDoubleFromConsoleNamedAs(variableName[1]);
        double c = getDoubleFromConsoleNamedAs(variableName[2]);

        double expression = computeExpression(a, b, c);
        System.out.printf("The result of computing is%n%g", expression);
        scanner.close();
    }
}
