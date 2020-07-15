package by.epamtc.jwd.busel.assignment01;

import java.util.Scanner;

public class Task06Alternative {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static long receiveNumberFromConsole() {
        if (scanner.hasNextLong()) {
            return scanner.nextLong();
        } else {
            informAboutInvalidScannerInput(scanner.next());
            return receiveNumberFromConsole();
        }
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token \"%s\","
                + "because it can not be translated into a valid"
                + " long value!\n", input);
    }

    private static long receiveValidCommonDifferenceFromConsole() {
        long commonDifference;
        while (true) {
            commonDifference = receiveNumberFromConsole();
            if (commonDifference != 0) {
                return commonDifference;
            } else {
                System.out.println("Common Difference must differ from zero."
                        + " Please, insert one again.");
            }
        }
    }

    private static long computeN(long initTerm, long diff, String classType) {
        boolean isAscending = diff > 0;
        switch (classType) {
            case "Integer":
                return computeNIfInt((int) initTerm, (int) diff, isAscending);
            case "Long":
                return computeNIfLong(initTerm, diff, isAscending);
            default:
                return -1;
        }
    }

    private static boolean isSumBidirectional(long initTerm, long difference) {
        return (Math.abs(initTerm) > Math.abs(difference))
                && ((initTerm * difference) < 0);
    }

    private static long computeNIfInt(int initTerm, int diff, boolean isAscending) {
        int aN;
        int n = 1;
        int previousSum;
        int nextSum = initTerm;
        if (isSumBidirectional(initTerm, diff)) {
            n = (int) Math.ceil((double) initTerm / diff) * (-1) + 1;
            aN = (initTerm + (n - 1) * diff);
            nextSum = (initTerm + aN) * n / 2;
        }
        do {
            n++;
            previousSum = nextSum;
            aN = initTerm + (n - 1) * diff;
            nextSum = previousSum + aN;
        } while (isAscending ? previousSum <= nextSum
                             : previousSum >= nextSum);
        return n;
    }

    private static long computeNIfLong(long initTerm, long difference,
            boolean isAscending) {
        long aN;
        long n = 1;
        long previousSum;
        long nextSum = initTerm;
        if (isSumBidirectional(initTerm, difference)) {
            n = (long) Math.ceil((double) initTerm / difference) * (-1) + 1;
            aN = (initTerm + (n - 1) * difference);
            nextSum = (initTerm + aN) * n / 2;
        }
        do {
            n++;
            previousSum = nextSum;
            aN = initTerm + (n - 1) * difference;
            nextSum = previousSum + aN;
        } while (isAscending ? previousSum <= nextSum
                             : previousSum >= nextSum);
        return n;
    }

    public static void main(String[] args) {
        System.out.println("Please, insert an initial term of" +
                " an arithmetic progression.");
        long initialTerm = receiveNumberFromConsole();
        System.out.println("Please, insert a common difference, which"
                + " differs from zero.");
        long commonDifference = receiveValidCommonDifferenceFromConsole();

        long nThTermToExceedIntegerType = computeN(initialTerm, commonDifference,
                "Integer");
        System.out.printf("The sum of an arithmetic progression exceed"
                        + " Integer type boundaries, when \"N\" = %d%n",
                nThTermToExceedIntegerType);

        long nThTermToExceedLongType = computeN(initialTerm, commonDifference,
                "Long");
        System.out.printf("The sum of an arithmetic progression exceed"
                        + " Long type boundaries, when \"N\" = %d%n",
                nThTermToExceedLongType);

        scanner.close();
    }
}
