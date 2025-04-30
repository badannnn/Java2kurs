import model.Customer;
import repository.CustomerRepositoryImpl;
import service.CustomerService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerRepositoryImpl repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService();
        Scanner scanner = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Олександр Бойко", "Київ", "1234567812345678", 1000.0, 5, 5000.0));
        customers.add(new Customer(2, "Анна Іванова", "Львів", "8765432187654321", -500.0, 3, 3000.0));
        customers.add(new Customer(3, "Петро Петренко", "Одеса", "1111222233334444", 200.0, 2, 1000.0));

        File file = new File("customers.dat");

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Список покупців, чиє ім’я починається з указаних літер");
            System.out.println("2. Список покупців, у яких номер кредитної картки знаходиться в заданому інтервалі");
            System.out.println("3. Список покупців, які мають заборгованість (від’ємний баланс на карті)");
            System.out.println("4. Список покупців, упорядкований за спаданням загальної суми витрат");
            System.out.println("5. Перевірити, чи є вказаний покупець у списку. І, якщо є - вивести його середню вартість покупки");
            System.out.println("6. Зберегти клієнтів");
            System.out.println("7. Завантажити клієнтів");
            System.out.println("8. Вихід");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Введіть початкові літери імені: ");
                        String prefix = scanner.next();
                        service.filterByNamePrefix(customers, prefix).forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Введіть початок діапазону номеру картки: ");
                        String start = scanner.next();
                        System.out.print("Введіть кінець діапазону номеру картки: ");
                        String end = scanner.next();
                        service.filterByCreditCardRange(customers, start, end).forEach(System.out::println);
                    }
                    case 3 -> service.filterByNegativeBalance(customers).forEach(System.out::println);
                    case 4 -> service.sortByTotalSpentAndName(customers).forEach(System.out::println);
                    case 5 -> {
                        System.out.print("Введіть ім’я покупця (наприклад, 'Олександр Бойко'): ");
                        scanner.nextLine(); // Очищення
                        String name = scanner.nextLine();
                        service.findExactCustomerByName(customers, name).ifPresentOrElse(
                                c -> System.out.println("Середня вартість покупки: " + c.getAveragePurchase()),
                                () -> System.out.println("Покупця не знайдено.")
                        );
                    }
                    case 6 -> repository.save(customers, file);
                    case 7 -> {
                        List<Customer> loadedCustomers = repository.load(file);
                        loadedCustomers.forEach(System.out::println);
                    }
                    case 8 -> {
                        System.out.println("Вихід із програми...");
                        System.exit(0);
                    }
                    default -> System.out.println("Будь ласка, виберіть пункт із меню (1-8).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка вводу! Будь ласка, введіть число від 1 до 8.");
                scanner.nextLine(); // Очищення вводу
            }
        }
    }
}