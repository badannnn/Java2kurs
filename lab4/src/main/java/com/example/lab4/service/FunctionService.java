package com.example.lab4.service;

import java.util.ArrayList;
import java.util.List;

public class FunctionService {

    public static List<Double[]> calculateValues(double xStart, double xEnd, double dx, double a) {
        List<Double[]> result = new ArrayList<>();
        for (double x = xStart; x <= xEnd; x += dx) {
            double y;
            if (x < 1.7) {
                y = Math.PI * x * x - 7 / (x * x);
            } else if (Math.abs(x - 1.7) < 1e-8) {
                y = a * Math.pow(x, 3) + 7 * Math.sqrt(x);
            } else {
                y = Math.log10(x + 7 * Math.sqrt(x));
            }
            result.add(new Double[]{x, y});
        }
        return result;
    }
}
