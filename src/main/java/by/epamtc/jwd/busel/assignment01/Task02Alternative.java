package by.epamtc.jwd.busel.assignment01;

import by.epamtc.jwd.busel.assignment01.entity.NonLeapYearDate;

import java.util.Scanner;

public class Task02Alternative {
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
        switch (month) {
            default:
            case 1:
                month++;
                if ((day - 31) <= 0) {
                    break;
                }
                day -= 31;
            case 2:
                month++;
                if ((day - 28) <= 0) {
                    break;
                }
                day -= 28;
            case 3:
                month++;
                if ((day - 31) <= 0) {
                    break;
                }
                day -= 31;
            case 4:
                month++;
                if ((day - 30) <= 0) {
                    break;
                }
                day -= 30;
            case 5:
                month++;
                if ((day - 31) <= 0) {
                    break;
                }
                day -= 31;
            case 6:
                month++;
                if ((day - 30) <= 0) {
                    break;
                }
                day -= 30;
            case 7:
                month++;
                if ((day - 31) <= 0) {
                    break;
                }
                day -= 31;
            case 8:
                month++;
                if ((day - 31) <= 0) {
                    break;
                }
                day -= 31;
            case 9:
                month++;
                if ((day - 30) <= 0) {
                    break;
                }
                day -= 30;
            case 10:
                month++;
                if ((day - 31) <= 0) {
                    break;
                }
                day -= 31;
            case 11:
                month++;
                if ((day - 30) <= 0) {
                    break;
                }
                day -= 30;
            case 12:
                month++;
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
