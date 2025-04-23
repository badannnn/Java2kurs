package lab6;

import lab6.File.FileProcess;
import lab6.Logic.Logic;
import lab6.Menu.MenuItem;
import lab6.Customer.Customer;
import lab6.Menu.Menu;

import java.util.*;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();
        FileProcess fileProcess = new FileProcess();
        List<Customer> list = new ArrayList<>();
        list = fileProcess.ReadFile(list);
        List<Customer> finalList = list;

        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem("Вийти з програми", () -> System.exit(0)),
                new MenuItem("Додати дані", () -> {
                    // Логіка додавання даних
                    String surname, name, middleName, address;
                    long creditCardNumber;
                    double creditCardBalance;

                    surname = logic.inputWithValidation(scanner, "Введіть прізвище: ");
                    name = logic.inputWithValidation(scanner, "Введіть ім'я: ");
                    middleName = logic.inputWithValidation(scanner, "Введіть по батькові: ");
                    address = logic.inputWithValidation(scanner, "Введіть адресу: ");

                    creditCardNumber = logic.inputCardNumber(scanner, "Введіть номер кредитної карти: ");
                    creditCardBalance = logic.inputCardBalance(scanner, "Введіть кількість грошей на рахунку: ");

                    logic.addEll(finalList, surname, name, middleName, address, creditCardNumber, creditCardBalance);
                    fileProcess.WriteFile(finalList);
                }),
                new MenuItem("Видалити клієнта", () -> {
                    logic.showAllProducts(finalList);
                    System.out.println("Введіть id для видалення");
                    int productToDelete = scanner.nextInt();
                    scanner.nextLine();
                    logic.remEll(finalList, productToDelete);
                    fileProcess.WriteFile(finalList);
                }),
                new MenuItem("Список всіх клієнтів", () -> logic.showAllProducts(finalList)),
                new MenuItem("Список покупців, у яких номер картки знаходиться в заданому інтервалі", () -> {
                    System.out.println("Введіть першу картку:");
                    long x1 = scanner.nextLong();
                    System.out.println("Введіть другу картку:");
                    long x2 = scanner.nextLong();
                    System.out.println(logic.compareCreditCardNumbers(x1, x2, finalList));
                }),
                new MenuItem("Список покупців із вказаним іменем", () -> {
                    System.out.println("Введіть ім'я");
                    String xName = scanner.nextLine();
                    System.out.println(logic.defineName(xName, finalList));
                }),
                new MenuItem("Список покупців, які мають заборгованість", () -> {
                    System.out.println(logic.customersWithDept(finalList));
                })
        );

        Menu menu = new Menu(menuItems);
        menu.run();
    }
}