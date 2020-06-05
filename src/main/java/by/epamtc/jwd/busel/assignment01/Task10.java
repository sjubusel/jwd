package by.epamtc.jwd.busel.assignment01;

import java.util.Scanner;

public class Task10 {
    private static final Scanner scanner = new Scanner(System.in);

    private static long initialiseValidFirstNumber() {
        long firstNumber;
        while (true) {
            firstNumber = getWholeNumberFromConsole();
            if (firstNumber != 0) {
                break;
            } else {
                reportNecessityOfNonZeroNumbers();
            }
        }
        return firstNumber;
    }

    private static long getWholeNumberFromConsole() {
        long number;
        while (true) {
            if (scanner.hasNextLong()) {
                number = scanner.nextLong();
                break;
            } else {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        return number;
    }

    private static void reportNecessityOfNonZeroNumbers() {
        System.out.println("There should be two non-zero whole numbers"
                + " at least.\nPlease, insert one more non-zero integer.");
    }

    private static void printInfoAboutSequenceOfNumbers(String sequence,
            boolean isAscending, boolean hasEqualNeighbours,
            boolean isAlternating) {
        System.out.printf("You have entered the following sequence of"
                + " integral numbers:%n[%s]%n", sequence);
        System.out.printf("The sequence is %sin an ascending order.%n",
                (isAscending) ? "" : "not ");
        System.out.printf("The sequence %s one pair of equal" +
                " contiguous numbers at least.%n", (hasEqualNeighbours)
                                                   ? "has" : "doesn't have");
        System.out.printf("The sequence is %salternating.%n",
                (isAlternating) ? "" : "not ");
    }

    public static void main(String[] args) {
        StringBuilder sequenceOfNumbers = new StringBuilder();
        String delimiter = ", ";

        long firstNumber = initialiseValidFirstNumber();
        sequenceOfNumbers.append(firstNumber);

        int counter = 1;
        long secondNumber;
        boolean isAscending = true;
        boolean hasEqualNeighbours = false;
        boolean isAlternating = true;
        while (true) {
            secondNumber = getWholeNumberFromConsole();
            if (secondNumber == 0) {
                if (counter >= 2) {
                    break;
                } else {
                    reportNecessityOfNonZeroNumbers();
                    continue;
                }
            }
            if (firstNumber >= secondNumber) {
                isAscending = false;
            }
            if (firstNumber == secondNumber) {
                hasEqualNeighbours = true;
            }
            if ((firstNumber * secondNumber) > 0) {
                isAlternating = false;
            }
            firstNumber = secondNumber;
            counter++;
            sequenceOfNumbers.append(delimiter).append(secondNumber);
        }

        printInfoAboutSequenceOfNumbers(sequenceOfNumbers.toString(),
                isAscending, hasEqualNeighbours, isAlternating);
    }
}