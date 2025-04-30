package lab4;

public class Printer {
    public void printArray(double[] arguments, double[] values) {
        for (int i = 0; i < arguments.length; i++) {
            System.out.printf("x = %.5f, y = %.5f%n", arguments[i], values[i]);
        }
    }
}