package doctors;

public abstract class Doctor {
    protected String name;

    public Doctor(String name) {
        this.name = name;
    }

    public abstract String cure();
    public abstract String[] consult();
    public abstract String getDescription();

    public String getName() {
        return name;
    }
}