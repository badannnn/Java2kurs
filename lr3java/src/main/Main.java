package main;

import doctors.*;
import patients.Patient;

public class Main {
    public static void main(String[] args) {
        // Масив лікарів
        Doctor[] doctors = {
                new Therapist("Терапевт Іван"),
                new Surgeon("Хірург Петро"),
                new Ophthalmologist("Офтальмолог Анна")
        };

        // Пацієнт
        Patient patient = new Patient("Олександр");

        // Відправлення на консультації
        for (Doctor doctor : doctors) {
            patient.visit(doctor);
        }

        // Виклик методів consult і cure
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getName() + " лікує: " + doctor.cure());
            System.out.println("Може діагностувати: " + String.join(", ", doctor.consult()));
        }
    }
}