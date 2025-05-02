package repository;

import model.Customer;
import java.io.*;
import java.util.*;

public class CustomerRepository {
    public void save(List<Customer> customers, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> load(File file) {
        if (!file.exists()) {
            System.out.println("Файл не знайдено: " + file.getAbsolutePath());
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}