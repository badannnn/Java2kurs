package doctors;

public class Surgeon extends Doctor {
    public Surgeon(String name) {
        super(name);
    }

    @Override
    public String cure() {
        return "Проводить хірургічні операції.";
    }

    @Override
    public String[] consult() {
        return new String[]{"Апендицит", "Переломи", "Травми"};
    }

    @Override
    public String getDescription() {
        return "Спеціалізується на хірургічному лікуванні.";
    }
}