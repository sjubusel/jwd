package com.github.sjubusel.assignment01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task04 {
    private static final String SCALAR = "(-?[0-9]+)([.][0-9Ee]+)?";
    private static Scanner scanner = new Scanner(System.in);

    private static double getValueUnlessItIsDouble() {
        System.out.println("Please, input any real number");
        String input = scanner.nextLine().trim();
        if (isDouble(input)) {
            return Double.parseDouble(input);
        } else {
            informAboutInvalidScannerInput();
            return getValueUnlessItIsDouble();
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

    private static double computeFunction(double x) {
        if (x <= 13) {
            return computeFunctionIfTrue(x);
        } else {
            return computeFunctionIfFalse(x);
        }
    }

    private static double computeFunctionIfTrue(double x) {
        return (-1.0 * Math.pow(x, 3.0) + 9.0);
    }

    private static double computeFunctionIfFalse(double x) {
        return -1.0 * (3.0 / (x + 1.0));
    }

    private static void printValues(double x, double y) {
        System.out.printf("The value of function \"y\" equals to %g%n", y);
        System.out.printf("if the value of Variable \"x\" is %g%n", x);
    }

    public static void main(String[] args) {
        double x = getValueUnlessItIsDouble();
        double y = computeFunction(x);
        printValues(x, y);
    }
}
