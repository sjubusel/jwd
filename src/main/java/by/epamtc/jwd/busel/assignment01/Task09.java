package by.epamtc.jwd.busel.assignment01;

public class Task09 {
    private static long computeFunction() {
        long sum = 1;
        long product = 1;
        for (int i = 2; i <= 10; i++) {
            sum += i;
            product *= sum;
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println("Currently computing the following mathematical" +
                " expression:\n(1+2) * (1+2+3) * ... * (1+2+...+10).");
        long result = computeFunction();
        System.out.printf("The result of computation is %d.", result);
    }
}
