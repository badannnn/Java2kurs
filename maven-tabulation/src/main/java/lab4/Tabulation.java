package lab4;

public class Tabulation {
    public double calculateFunction(double x) {
        if (x < 1.7) {
            return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        } else if (x == 1.7) {
            return 1.5 * Math.pow(x, 3) + 7 * Math.sqrt(x);
        } else {
            return Math.log10(x + 7 * Math.sqrt(x));
        }
    }

    public double[] generateArguments(double start, double end, double step) {
        int size = (int) Math.ceil((end - start) / step) + 1;
        double[] arguments = new double[size];
        for (int i = 0; i < size; i++) {
            arguments[i] = start + i * step;
        }
        return arguments;
    }

    public double[] calculateValues(double[] arguments) {
        double[] values = new double[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            values[i] = calculateFunction(arguments[i]);
        }
        return values;
    }

    public double findMin(double[] values) {
        double min = Double.MAX_VALUE;
        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public double findMax(double[] values) {
        double max = Double.MIN_VALUE;
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}