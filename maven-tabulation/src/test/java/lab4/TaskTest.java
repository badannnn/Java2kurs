package lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testProcessString() {
        Task task = new Task();
        String input = "Привет";
        String[] result = task.processString(input);

        // Ожидаемые строки
        String expectedLetters = "П  р  и  в  е  т";
        String expectedNumbers = "17 18  9  3  6  20"; // Исправленные порядковые номера

        // Проверка на соответствие
        assertEquals(expectedLetters, result[0]);
        assertEquals(expectedNumbers, result[1]);
    }

    @Test
    void testProcessStringWithPunctuation() {
        Task task = new Task();
        String input = "Привет, мир!";
        String[] result = task.processString(input);

        // Ожидаемые строки
        String expectedLetters = "П  р  и  в  е  т  ,     м  и  р  !";
        String expectedNumbers = "17 18  9  3  6  20       13  9  18   ";

        // Проверка на соответствие
        assertEquals(expectedLetters, result[0]);
        assertEquals(expectedNumbers, result[1]);
    }
}