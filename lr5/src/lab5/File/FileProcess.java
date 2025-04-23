package lab6.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab6.Customer.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileProcess {
    private final String filePath = "C:\\Users\\bogda\\OneDrive\\Рабочий стол\\УЧЕБА НОВАЯ\\Технологія розробки ПЗ на сучасних платформах\\LR5\\customer.json";

    public void CheckFileExists() {
        File file = new File(filePath);
        if (!file.exists()) {
            CreateFile();
        }
    }

    public void CreateFile() {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void WriteFile(List<Customer> list) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Customer> ReadFile(List<Customer> list) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            if (file.length() != 0) {
                return objectMapper.readValue(file, new TypeReference<List<Customer>>() {});
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}