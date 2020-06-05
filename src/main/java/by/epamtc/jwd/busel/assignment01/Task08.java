package by.epamtc.jwd.busel.assignment01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task08 {
    private static final String SCALAR = "(-?[0-9]+)([.][0-9Ee]+)?";
    private static final double CONST = Math.PI;
    private static Scanner scanner = new Scanner(System.in);
    
    private static double getDoubleFromConsole() {
        String input = scanner.nextLine().trim();
        if (isDouble(input)) {
            return Double.parseDouble(input);
        } else {
            informAboutInvalidScannerInput();
            return getDoubleFromConsole();
        }
    }
    
    private static boolean isDouble(String input) {
        return Pattern.matches(SCALAR, input);
    }
    
    private static void informAboutInvalidScannerInput() {
        System.out.println("You have entered an invalid token,"
                + "because it can not be translated into a valid"
                + " double value!");
    }
    
    private static Map<Double, Double> getFunctionValues(double openingPoint,
            double closingPoint, double step) {
        Map<Double, Double> pairsXY = new LinkedHashMap<>();
        int accuracyAfterPoint = getAccuracyAfterPoint(openingPoint, step);
        for (double x = openingPoint; x <= closingPoint; ) {
            double y = computeFunction(x);
            pairsXY.putIfAbsent(x, y);
            x = getAccurateValue(x + step, accuracyAfterPoint);
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
    
    private static double trimToGetAccurateValue(double realNumber,
            int accuracy) {
        double tempNumber = realNumber * Math.pow(10, accuracy);
        tempNumber = Math.round(tempNumber);
        realNumber = tempNumber * Math.pow(10, (-1) * accuracy);
        return realNumber;
    }
    
    private static int getDigitsNumberAfterPoint(double realNumber) {
        String number = Double.toString(realNumber);
        String[] parts = number.split("[.]");
        return parts[1].length();
    }
    
    private static double computeFunction(double x) {
        return (x != 15) ? computeFunctionIfNotEquals(x)
                         : computeFunctionIfEquals(x);
    }
    
    private static double computeFunctionIfNotEquals(double x) {
        return ((x - CONST) + 6);
    }
    
    private static double computeFunctionIfEquals(double x) {
        return ((x + CONST) * 2);
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
    }
}
