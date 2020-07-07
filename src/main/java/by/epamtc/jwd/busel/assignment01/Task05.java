package by.epamtc.jwd.busel.assignment01;

import java.util.Scanner;

public class Task05 {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static int receiveThreeFiguresNumberFromConsole() {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (isThreeDigit(number)) {
                return number;
            } else {
                System.out.printf("Invalid input \"%d\"", number);
            }
        } else {
            informAboutInvalidScannerInput(scanner.next());
        }
        return receiveThreeFiguresNumberFromConsole();
    }

    private static boolean isThreeDigit(int number) {
        return (number >= 100) && (number <= 999);
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token \"%s\","
                + " because it can not be translated into a valid int"
                + " value!\n", input);
    }

    private static int computeAdditionOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static int computeMultiplicationOfDigits(int number) {
        int product = 1;
        while (number != 0) {
            product *= number % 10;
            number /= 10;
        }
        return product;
    }

    private static int computeHundredsAndTensRearrangement(int number) {
        int unitsDigit = number % 10;
        number /= 10;
        int tensDigit = number % 10;
        number /= 10;
        int hundredsDigit = number % 10;
        return tensDigit * 100 + hundredsDigit * 10 + unitsDigit;
    }

    private static int computeFourFiguresFrom(int number) {
        int thousandsDigit = number % 10;
        return thousandsDigit * 1000 + number;
    }

    public static void main(String[] args) {
        System.out.println("Please, insert a three figures number.");
        int number = receiveThreeFiguresNumberFromConsole();

        int sumOfDigits = computeAdditionOfDigits(number);
        int productOfDigits = computeMultiplicationOfDigits(number);
        int rearrangedNumber = computeHundredsAndTensRearrangement(number);
        int fourFiguresNumber = computeFourFiguresFrom(number);

        System.out.printf("Sum of digits: %d%n", sumOfDigits);
        System.out.printf("Product of digits: %d%n", productOfDigits);
        System.out.printf("Rearranged input number: %d%n", rearrangedNumber);
        System.out.printf("Four figures number: %d%n", fourFiguresNumber);
        scanner.close();
    }
}
