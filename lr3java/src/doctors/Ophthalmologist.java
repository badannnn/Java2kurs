package doctors;

public class Ophthalmologist extends Doctor {
    public Ophthalmologist(String name) {
        super(name);
    }

    @Override
    public String cure() {
        return "Призначає лікування для очей.";
    }

    @Override
    public String[] consult() {
        return new String[]{"Катаракта", "Глаукома", "Синдром сухого ока"};
    }

    @Override
    public String getDescription() {
        return "Займається діагностикою та лікуванням захворювань очей.";
    }
}