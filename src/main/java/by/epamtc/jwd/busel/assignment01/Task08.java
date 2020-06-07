package by.epamtc.jwd.busel.assignment01;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Task08 {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n")
            .useLocale(Locale.US);

    private static double getDoubleFromConsole() {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            informAboutInvalidScannerInput(scanner.next());
            return getDoubleFromConsole();
        }
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token \"%s\","
                + " because it can not be translated into a valid"
                + " double value!%n", input);
    }

    //TODO create javaDoc
    private static Map<Double, Double> getFunctionValues(double openingPoint,
            double closingPoint, double step) {
        Map<Double, Double> pairsXY = new LinkedHashMap<>();
        int accuracy = getAccuracyAfterPoint(openingPoint, step);
        for (double x = openingPoint; x <= closingPoint; ) {
            double y = computeFunction(x);
            pairsXY.putIfAbsent(x, y);
            x = getAccurateValue(x + step, accuracy);
        }
        return pairsXY;
    }

    private static int getAccuracyAfterPoint(double openingPoint, double step) {
        int digitsNumber = getDigitsNumberAfterPoint(openingPoint);
        int digitsNumber2 = getDigitsNumberAfterPoint(step);
        return Math.max(digitsNumber, digitsNumber2);
    }

    private static double getAccurateValue(double realNumber, int accuracy) {
        int digitsNumberAfterPoint = getDigitsNumberAfterPoint(realNumber);
        if (digitsNumberAfterPoint > accuracy) {
            realNumber = trimToGetAccurateValue(realNumber, accuracy);
        }
        return realNumber;
    }

    private static int getDigitsNumberAfterPoint(double realNumber) {
        String number = Double.toString(realNumber);
        String[] parts = number.split("[.]");
        return parts[1].length();
    }

    private static double trimToGetAccurateValue(double realNumber,
            int accuracy) {
        double tempNumber = realNumber * Math.pow(10.0, accuracy);
        tempNumber = Math.round(tempNumber);
        realNumber = tempNumber * Math.pow(10, (-1) * accuracy);
        return realNumber;
    }

    private static double computeFunction(double x) {
        double CONST = Math.PI;
        return (x != 15) ? ((x - CONST) + 6)
                         : ((x + CONST) * 2);
    }

    private static void print(Map<Double, Double> pairs) {
        for (Map.Entry<Double, Double> pair : pairs.entrySet()) {
            System.out.printf("If x = %f, y = %f.\n", pair.getKey(),
                    pair.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Please, insert an opening point \"a\" of"
                + " a line segment.");
        double openingPoint = getDoubleFromConsole();
        System.out.println("Please, insert a closing point \"b\" of"
                + " a line segment.");
        double closingPoint = getDoubleFromConsole();
        System.out.println("Please, insert a function step \"h\".");
        double step = getDoubleFromConsole();

        Map<Double, Double> pairs = getFunctionValues(openingPoint,
                closingPoint, step);
        print(pairs);
        scanner.close();
    }
}
