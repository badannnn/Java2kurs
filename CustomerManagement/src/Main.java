package main;

import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import java.util.stream.Collectors;
import java.text.Collator;
import java.util.Locale;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepository();
        CustomerService service = new CustomerService();
        Scanner scanner = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Олександр Бойко", "Київ", "1234567812345678", 1000.0, 5, 5000.0));
        customers.add(new Customer(2, "Анна Іванова", "Львів", "8765432187654321", -500.0, 3, 3000.0));
        customers.add(new Customer(3, "Іна Іванова", "Львів", "8765432187654324", 7000.0, 3, 9000.0));
        customers.add(new Customer(4, "Марина Іванова", "Львів", "8765432187654323", 300.0, 7, 6000.0));
        customers.add(new Customer(5, "Петро Петренко", "Одеса", "1111222233334444", 200.0, 2, 1000.0));
        customers.add(new Customer(6, "Іван Петренко", "Одеса", "1111222233334443", 200.0, 5, 10000.0));


        File file = new File("customers.dat");

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Фільтрація за ім’ям");
            System.out.println("2. Фільтрація за карткою");
            System.out.println("3. Фільтрація заборгованостей");
            System.out.println("4. Сортування покупців");
            System.out.println("5. Пошук покупця");
            System.out.println("6. Унікальні міста реєстрації");
            System.out.println("7. Групування по містах");
            System.out.println("8. Загальна сума витрат по містах");
            System.out.println("9. Вихід");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очистка после ввода числа

                switch (choice) {
                    case 1 -> {
                        System.out.print("Введіть початкові літери імені: ");
                        String prefix = scanner.nextLine();
                        service.filterByNamePrefix(customers, prefix).forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Введіть початок діапазону номеру картки: ");
                        String start = scanner.nextLine();
                        System.out.print("Введіть кінець діапазону номеру картки: ");
                        String end = scanner.nextLine();
                        service.filterByCreditCardRange(customers, start, end).forEach(System.out::println);
                    }
                    case 3 -> service.filterByNegativeBalance(customers).forEach(System.out::println);
                    case 4 -> service.sortByTotalSpentAndName(customers).forEach(System.out::println);
                    case 5 -> {
                        System.out.print("Введіть ім’я покупця: ");
                        String name = scanner.nextLine();
                        service.findExactCustomerByName(customers, name).ifPresentOrElse(
                                c -> System.out.println("Середня вартість покупки: " + c.getAveragePurchase()),
                                () -> System.out.println("Покупця не знайдено.")
                        );
                    }
                    case 6 -> {
                        System.out.print("Введіть мінімальну кількість покупок n: ");
                        int n = scanner.nextInt();
                        scanner.nextLine(); // Очистка ввода

                        Set<String> cities = customers.stream()
                                .collect(Collectors.groupingBy(Customer::getCity, Collectors.summingInt(Customer::getPurchaseCount)))
                                .entrySet().stream()
                                .filter(entry -> entry.getValue() > n)
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toSet());

                        System.out.println("Міста з сумарною кількістю покупок > " + n + ": " + cities);
                    }
                    case 7 -> {
                        Map<String, List<Customer>> grouped = customers.stream()
                                .collect(Collectors.groupingBy(Customer::getCity));

                        System.out.println("\nГрупування покупців по містах (в алфавітному порядку за іменами):");
                        grouped.forEach((city, customerList) -> {
                            System.out.println("🔹 " + city);
                            customerList.stream()
                                    .sorted(Comparator.comparing(Customer::getFullName, Collator.getInstance(new Locale("uk", "UA")))) // Сортировка по украинскому алфавиту
                                    .forEach(customer -> System.out.println("   - " + customer.getFullName()));
                        });
                    }
                    case 8 -> System.out.println(service.totalSpentByCity(customers));
                    case 9 -> {
                        System.out.println("Вихід з програми...");
                        System.exit(0);
                    }
                    default -> System.out.println("Невірний вибір, спробуйте ще раз!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка вводу! Будь ласка, введіть число від 1 до 9.");
                scanner.nextLine(); // Очистка після помилки
            }
        }
    }
}