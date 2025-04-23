package lab6.Menu;

public class MenuItem {
    private String name;
    private MenuCust menuCust;

    public MenuItem(String name, MenuCust menuCust) {
        this.name = name;
        this.menuCust = menuCust;
    }

    public String getName() {
        return name;
    }

    public void runMethod() {
        menuCust.execute();
    }
}