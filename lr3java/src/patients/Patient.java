package patients;

import doctors.Doctor;

public class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public void visit(Doctor doctor) {
        System.out.println(name + " прийшов на консультацію до " + doctor.getName());
        System.out.println("Опис: " + doctor.getDescription());
    }
}