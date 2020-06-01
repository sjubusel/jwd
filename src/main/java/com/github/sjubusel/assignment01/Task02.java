package com.github.sjubusel.assignment01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task02 {
    private static final String DAY_PATTERN = "[0-9]+";
    private static Scanner scanner = new Scanner(System.in);
    private static int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31};

    private static int getValidOrdinalDayNumberFromConsole() {
        String input = scanner.nextLine();
        if (isInteger(input)) {
            int dayNumber = Integer.parseInt(input);
            return (isValid(dayNumber))
                    ? dayNumber
                    : getValidOrdinalDayNumberFromConsole();
        } else {
            informAboutInvalidScannerInput();
            return getValidOrdinalDayNumberFromConsole();
        }
    }

    private static boolean isInteger(String input) {
        return Pattern.matches(DAY_PATTERN, input);
    }

    private static boolean isValid(int dayNumber) {
        return (dayNumber > 0) && (dayNumber <= 365);
    }

    private static void informAboutInvalidScannerInput() {
        System.out.println("You have entered an invalid token,");
        System.out.println("because it can not be translated");
        System.out.println("into a valid int value!\n");
    }

    private static int[] calculateDateAndMonthBy(int ordinalDayNumber) {
        int day = 0;
        int month = 0;
        for (int i = 0; i < daysPerMonth.length; i++) {
            if (ordinalDayNumber > daysPerMonth[i]) {
                ordinalDayNumber = ordinalDayNumber - daysPerMonth[i];
            } else {
                month = ++i;
                day = ordinalDayNumber;
                break;
            }
        }
        return new int[]{day, month};
    }

    public static void main(String[] args) {
        System.out.println("Please, input an ordinal number");
        System.out.println("of any day of a common (non-leap) year");
        int ordinalDayNumber = getValidOrdinalDayNumberFromConsole();

        int[] dateAndMonth = calculateDateAndMonthBy(ordinalDayNumber);
        System.out.printf("Day \"%s\" and Month \"%s\" conform to",
                dateAndMonth[0], dateAndMonth[1]);
        System.out.printf(" an ordinal day number \"%s\"%n",
                ordinalDayNumber);
    }
}
