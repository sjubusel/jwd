package com.github.sjubusel.assignment01;

import java.util.ArrayList;
import java.util.List;

public class Task09 {
    private static double computeFunction() {
        List<Double> elementsToMultiply = getElementsToMultiply();
        return multiplyElements(elementsToMultiply);
    }
    
    private static List<Double> getElementsToMultiply() {
        List<Double> elements = new ArrayList<>(9);
        double a1 = 1;
        double sum;
        for (int aN = 2; aN <= 10; aN++) {
            sum = aN / 2.0 * (a1 + aN);
            elements.add(sum);
        }
        return elements;
    }
    
    private static double multiplyElements(List<Double> elementsToMultiply) {
        double product = 1.0;
        for (double element : elementsToMultiply) {
            product = product * element;
        }
        return product;
    }
    
    public static void main(String[] args) {
        System.out.println("Currently computing the following mathematical" +
                " expression:\n(1+2) * (1+2+3) * ... * (1+2+...+10).");
        double result = computeFunction();
        System.out.printf("The result of computation is %f", result);
    }
}
