package by.epamtc.jwd.busel.assignment01;

import java.util.Scanner;

public class Task10 {
    private static Scanner scanner = new Scanner(System.in);

    private static long initialiseValidNonZeroNumberFromConsole() {
        long number;
        while (true) {
            number = receiveWholeNumberFromConsole();
            if (number != 0) {
                break;
            } else {
                reportNecessityOfNonZeroNumbers();
            }
        }
        return number;
    }

    private static long receiveWholeNumberFromConsole() {
        if (scanner.hasNextLong()) {
            return scanner.nextLong();
        } else {
            System.out.printf("Invalid input \"%s\"%n", scanner.next());
            return receiveWholeNumberFromConsole();
        }
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

        long firstNumber = initialiseValidNonZeroNumberFromConsole();
        sequenceOfNumbers.append(firstNumber);
        long secondNumber = initialiseValidNonZeroNumberFromConsole();

        boolean isAscending = true;
        boolean hasEqualNeighbours = false;
        boolean isAlternating = true;

        while (secondNumber != 0) {
            sequenceOfNumbers.append(delimiter).append(secondNumber);
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
            secondNumber = receiveWholeNumberFromConsole();
        }

        printInfoAboutSequenceOfNumbers(sequenceOfNumbers.toString(),
                isAscending, hasEqualNeighbours, isAlternating);
        scanner.close();
    }
}