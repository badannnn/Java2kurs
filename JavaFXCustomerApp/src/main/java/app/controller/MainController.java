package app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField namePrefixField;

    @FXML
    private TextField cardMinField;

    @FXML
    private TextField cardMaxField;

    @FXML
    private TextField customerSearchField;

    @FXML
    private TextArea outputArea;

    @FXML
    private void filterByNamePrefix() {
        String prefix = namePrefixField.getText();
        outputArea.setText("Фільтрація за префіксом імені: " + prefix);
        // Додайте тут логіку фільтрації
    }

    @FXML
    private void filterByCardRange() {
        String min = cardMinField.getText();
        String max = cardMaxField.getText();
        outputArea.setText("Фільтрація за діапазоном карт: " + min + " - " + max);
        // Додайте тут логіку фільтрації
    }

    @FXML
    private void showDebtors() {
        outputArea.setText("Виведення боржників...");
        // Додайте тут логіку пошуку боржників
    }

    @FXML
    private void sortBySpent() {
        outputArea.setText("Сортування за витратами...");
        // Додайте тут логіку сортування
    }

    @FXML
    private void searchCustomerAndAvg() {
        String name = customerSearchField.getText();
        outputArea.setText("Пошук покупця: " + name);
        // Додайте логіку пошуку та обчислення середнього
    }

    @FXML
    private void citiesWithMoreThanN() {
        outputArea.setText("Міста з кількістю покупців > 2...");
        // Додайте логіку підрахунку
    }

    @FXML
    private void mapCityToCustomers() {
        outputArea.setText("Мапа: місто → покупці");
        // Додайте логіку побудови мапи
    }

    @FXML
    private void mapCityToTotalSpent() {
        outputArea.setText("Мапа: місто → сума витрат");
        // Додайте логіку побудови мапи витрат
    }

    @FXML
    public void initialize() {
        outputArea.setText("Готово до роботи!");
    }
}
