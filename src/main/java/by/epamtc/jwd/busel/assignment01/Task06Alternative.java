package by.epamtc.jwd.busel.assignment01;

import java.util.Scanner;

public class Task06Alternative {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static long getNumberFromConsole() {
        if (scanner.hasNextLong()) {
            return scanner.nextLong();
        } else {
            informAboutInvalidScannerInput(scanner.next());
            return getNumberFromConsole();
        }
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token \"%s\","
                + "because it can not be translated into a valid"
                + " long value!\n", input);
    }

    private static long getValidCommonDifferenceFromConsole() {
        long commonDifference;
        while (true) {
            commonDifference = getNumberFromConsole();
            if (commonDifference != 0) {
                return commonDifference;
            } else {
                System.out.println("Common Difference must differ from zero."
                        + " Please, insert one again.");
            }
        }
    }

    private static long getN(long initTerm, long diff, String classType) {
        boolean isAscending = diff > 0;
        switch (classType) {
            case "Integer":
                return getNIfInt((int) initTerm, (int) diff, isAscending);
            case "Long":
                return getNIfLong(initTerm, diff, isAscending);
            default:
                return -1;
        }
    }

    private static boolean isSumBidirectional(long initTerm, long difference) {
        return (Math.abs(initTerm) > Math.abs(difference))
                && ((initTerm * difference) < 0);
    }

    private static long getNIfInt(int initTerm, int diff, boolean isAscending) {
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

    private static long getNIfLong(long initTerm, long difference,
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
        long initialTerm = getNumberFromConsole();
        System.out.println("Please, insert a common difference, which"
                + " differs from zero.");
        long commonDifference = getValidCommonDifferenceFromConsole();

        long nThTermToExceedIntegerType = getN(initialTerm, commonDifference,
                "Integer");
        System.out.printf("The sum of an arithmetic progression exceed"
                        + " Integer type boundaries, when \"N\" = %d%n",
                nThTermToExceedIntegerType);

        long nThTermToExceedLongType = getN(initialTerm, commonDifference,
                "Long");
        System.out.printf("The sum of an arithmetic progression exceed"
                        + " Long type boundaries, when \"N\" = %d%n",
                nThTermToExceedLongType);
    }
}
