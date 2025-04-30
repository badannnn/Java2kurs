package lab4;

public class Main {
    public static void main(String[] args) {
        Tabulation tabulation = new Tabulation();

        // Параметры табуляции
        double start = 0.8;
        double end = 2.0;
        double step = 0.005;

        // Генерация данных
        double[] arguments = tabulation.generateArguments(start, end, step);
        double[] values = tabulation.calculateValues(arguments);

        // Поиск номеров минимального и максимального значения
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[minIndex]) {
                minIndex = i;
            }
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
        }

        // Расчёт суммы и среднего арифметического
        double sum = 0;s
        for (double value : values) {
            sum += value;
        }
        double average = sum / values.length;

        // Вывод результатов на украинском
        System.out.println("Кількість точок табуляції: " + arguments.length);
        System.out.printf("Мінімальне значення: %.5f (x = %.5f, номер: %d)%n", values[minIndex], arguments[minIndex], minIndex);
        System.out.printf("Максимальне значення: %.5f (x = %.5f, номер: %d)%n", values[maxIndex], arguments[maxIndex], maxIndex);
        System.out.printf("Сума елементів масиву значень функції: %.5f%n", sum);
        System.out.printf("Середнє арифметичне значення: %.5f%n", average);
    }
}