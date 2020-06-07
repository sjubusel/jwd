package by.epamtc.jwd.busel.assignment01;

import by.epamtc.jwd.busel.assignment01.entity.NonLeapYearDate;

import java.util.Scanner;

public class Task02 {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static int getValidOrdinalDayNumberFromConsole() {
        if (scanner.hasNextInt()) {
            int dayNumber = scanner.nextInt();
            if (isValid(dayNumber)) {
                return dayNumber;
            } else {
                System.out.printf("There is no day \"%d\"%n", dayNumber);
            }
        } else {
            informAboutInvalidScannerInput(scanner.next());
        }
        return getValidOrdinalDayNumberFromConsole();
    }

    private static boolean isValid(int dayNumber) {
        return (dayNumber > 0) && (dayNumber <= 365);
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token"
                + " \"%s\", because it can not be translated into"
                + " a valid int value!\n", input);
    }

    private static NonLeapYearDate getDateBy(int ordinalDayNumber) {
        int day = ordinalDayNumber;
        int month = 0;
        int delta = 0;
        boolean canQuit = false;
        while (!canQuit) {
            day = day - delta;
            month++;
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    delta = 31;
                    canQuit = ((day - delta) <= 0);
                    break;
                case 2:
                    delta = 28;
                    canQuit = ((day - delta) <= 0);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    delta = 30;
                    canQuit = ((day - delta) <= 0);
                    break;
            }
        }
        return new NonLeapYearDate(day, month);
    }

    public static void main(String[] args) {
        System.out.println("Please, input an ordinal number of any day of"
                + " a common (non-leap) year");
        int ordinalDayNumber = getValidOrdinalDayNumberFromConsole();

        NonLeapYearDate date = getDateBy(ordinalDayNumber);
        System.out.printf("Day \"%s\" and Month \"%s\" conform to",
                date.getDayNumber(), date.getMonthNumber());
        System.out.printf(" an ordinal day number \"%s\".%n",
                ordinalDayNumber);
        scanner.close();
    }
}
