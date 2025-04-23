package doctors;

public class Therapist extends Doctor {
    public Therapist(String name) {
        super(name);
    }

    @Override
    public String cure() {
        return "Призначає ліки та фізіотерапію.";
    }

    @Override
    public String[] consult() {
        return new String[]{"Грип", "ГРВІ", "Бронхіт"};
    }

    @Override
    public String getDescription() {
        return "Займається лікуванням загальних хвороб.";
    }
}