package lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TabulationTest {

    @Test
    void testCalculateFunctionForXLessThan1Point7() {
        Tabulation tabulation = new Tabulation();

        // Проверка для x < 1.7
        double x = 1.5;
        double expected = Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2); // Расчёт вручную
        double actual = tabulation.calculateFunction(x);

        assertEquals(expected, actual, 0.001); // Точность проверки
    }

    @Test
    void testCalculateFunctionForXEquals1Point7() {
        Tabulation tabulation = new Tabulation();

        // Проверка для x = 1.7
        double x = 1.7;
        double expected = 1.5 * Math.pow(x, 3) + 7 * Math.sqrt(x); // Расчёт вручную
        double actual = tabulation.calculateFunction(x);

        assertEquals(expected, actual, 0.001); // Точность проверки
    }

    @Test
    void testCalculateFunctionForXGreaterThan1Point7() {
        Tabulation tabulation = new Tabulation();

        // Проверка для x > 1.7
        double x = 2;
        double expected = Math.log10(x + 7 * Math.sqrt(x)); // Расчёт вручную
        double actual = tabulation.calculateFunction(x);

        assertEquals(expected, actual, 0.001); // Точность проверки
    }
}