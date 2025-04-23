package lab6.Menu;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void show() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " - " + menuItems.get(i).getName());
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            show();
            System.out.println("Оберіть функцію:");
            int choice = scanner.nextInt();
            menuItems.get(choice).runMethod();
        }
    }
}