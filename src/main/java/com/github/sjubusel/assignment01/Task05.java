package com.github.sjubusel.assignment01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task05 {
    private static final String INTEGER_PATTERN = "[0-9]+";
    private static Scanner scanner = new Scanner(System.in);

    private static int getThreeFiguresNumberFromConsole() {
        System.out.println("Please, insert a three figures number.");
        String input = scanner.nextLine();
        if (isInteger(input)) {
            int number = Integer.parseInt(input);
            return (isValid(number))
                    ? number
                    : getThreeFiguresNumberFromConsole();
        } else {
            informAboutInvalidScannerInput();
            return getThreeFiguresNumberFromConsole();
        }
    }

    private static boolean isInteger(String input) {
        return Pattern.matches(INTEGER_PATTERN, input);
    }

    private static boolean isValid(int number) {
        return (number >= 100) && (number <= 999);
    }

    private static void informAboutInvalidScannerInput() {
        System.out.println("You have entered an invalid token,");
        System.out.println("because it can not be translated");
        System.out.println("into a valid int value!\n");
    }

    private static int[] getDigitsInAscendingPriority(int threeFigures) {
        int unitsDigit = threeFigures % 10;
        int tensDigit = ((threeFigures % 100) - unitsDigit) / 10;
        int hundredsDigit = threeFigures / 100;
        return new int[]{unitsDigit, tensDigit, hundredsDigit};
    }

    private static int computeAdditionOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    private static int computeMultiplicationOfDigits(int[] digits) {
        int product = 1;
        for (int digit : digits) {
            product *= digit;
        }
        return product;
    }

    private static int computeHundredsAndTensRearrangement(int[] digits) {
        return digits[1] * 100 + digits[2] * 10 + digits[0];
    }

    private static int computeFourFiguresFrom(int[] digits) {
        return digits[0] * 1000 + digits[2] * 100 + digits[1] * 10
                + digits[0];
    }

    public static void main(String[] args) {
        int threeFiguresNumber = getThreeFiguresNumberFromConsole();
        int[] digits = getDigitsInAscendingPriority(threeFiguresNumber);

        int sumOfDigits = computeAdditionOfDigits(digits);
        int productOfDigits = computeMultiplicationOfDigits(digits);
        int rearrangedNumber = computeHundredsAndTensRearrangement(digits);
        int fourFiguresNumber = computeFourFiguresFrom(digits);

        System.out.printf("Sum of digits: %d%n", sumOfDigits);
        System.out.printf("Product of digits: %d%n", productOfDigits);
        System.out.printf("Rearranged input number: %d%n", rearrangedNumber);
        System.out.printf("Four figures number: %d%n", fourFiguresNumber);
    }
}
