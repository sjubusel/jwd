package by.epamtc.jwd.busel.assignment01;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Task08 {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n")
            .useLocale(Locale.US);

    private static double receiveDoubleFromConsole() {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            informAboutInvalidScannerInput(scanner.next());
            return receiveDoubleFromConsole();
        }
    }

    private static void informAboutInvalidScannerInput(String input) {
        System.out.printf("You have entered an invalid token \"%s\","
                + " because it can not be translated into a valid"
                + " double value!%n", input);
    }

    //TODO create javaDoc in order to clarify
    private static Map<Double, Double> computeFunctionValues(double openingPoint,
            double closingPoint, double step) {
        Map<Double, Double> pairsXY = new LinkedHashMap<>();
        int accuracy = computeAccuracyAfterPoint(openingPoint, step);
        double x = openingPoint;
        while (x <= closingPoint) {
            double y = computeFunction(x);
            pairsXY.putIfAbsent(x, y);
            x = computeAccurateValue(x + step, accuracy);
        }
        return pairsXY;
    }

    private static int computeAccuracyAfterPoint(double openingPoint, double step) {
        int digitsNumber = calculateDigitsNumberAfterPoint(openingPoint);
        int digitsNumber2 = calculateDigitsNumberAfterPoint(step);
        return Math.max(digitsNumber, digitsNumber2);
    }

    private static double computeAccurateValue(double realNumber, int accuracy) {
        int digitsNumberAfterPoint = calculateDigitsNumberAfterPoint(realNumber);
        if (digitsNumberAfterPoint > accuracy) {
            realNumber = trimToGetAccurateValue(realNumber, accuracy);
        }
        return realNumber;
    }

    private static int calculateDigitsNumberAfterPoint(double realNumber) {
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
        double openingPoint = receiveDoubleFromConsole();
        System.out.println("Please, insert a closing point \"b\" of"
                + " a line segment.");
        double closingPoint = receiveDoubleFromConsole();
        System.out.println("Please, insert a function step \"h\".");
        double step = receiveDoubleFromConsole();

        Map<Double, Double> pairs = computeFunctionValues(openingPoint,
                closingPoint, step);
        print(pairs);
        scanner.close();
    }
}
