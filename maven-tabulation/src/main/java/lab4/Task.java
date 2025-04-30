package lab4;

public class Task {
    public String[] processString(String input) {
        char[] chars = input.toCharArray();
        StringBuilder lettersLine = new StringBuilder();
        StringBuilder numbersLine = new StringBuilder();

        for (char ch : chars) {
            if (Character.isLetter(ch)) {
                lettersLine.append(ch).append("  ");

                // Для кириллицы и латиницы корректно рассчитываем позиции букв
                if (ch >= 'А' && ch <= 'Я') { // Верхний регистр кириллицы
                    int position = ch - 'А' + 1;
                    numbersLine.append(position).append("  ");
                } else if (ch >= 'а' && ch <= 'я') { // Нижний регистр кириллицы
                    int position = ch - 'а' + 1;
                    numbersLine.append(position).append("  ");
                } else if (ch >= 'A' && ch <= 'Z') { // Верхний регистр латиницы
                    int position = ch - 'A' + 1;
                    numbersLine.append(position).append("  ");
                } else if (ch >= 'a' && ch <= 'z') { // Нижний регистр латиницы
                    int position = ch - 'a' + 1;
                    numbersLine.append(position).append("  ");
                }
            } else {
                lettersLine.append(ch).append("  ");
                numbersLine.append("   ");
            }
        }

        return new String[]{lettersLine.toString().trim(), numbersLine.toString().trim()};
    }
}