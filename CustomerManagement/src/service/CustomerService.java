package service;

import model.Customer;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerService {
    public List<Customer> filterByNamePrefix(List<Customer> customers, String prefix) {
        return customers.stream()
                .filter(c -> c.getFullName().startsWith(prefix))
                .collect(Collectors.toList());
    }

    public List<Customer> filterByCreditCardRange(List<Customer> customers, String start, String end) {
        return customers.stream()
                .filter(c -> c.getCreditCardNumber().compareTo(start) >= 0 &&
                        c.getCreditCardNumber().compareTo(end) <= 0)
                .collect(Collectors.toList());
    }

    public List<Customer> filterByNegativeBalance(List<Customer> customers) {
        return customers.stream()
                .filter(c -> c.getBalance() < 0)
                .collect(Collectors.toList());
    }

    public List<Customer> sortByTotalSpentAndName(List<Customer> customers) {
        return customers.stream()
                .sorted(Comparator.comparingDouble(Customer::getTotalSpent).reversed()
                        .thenComparing(Customer::getFullName))
                .collect(Collectors.toList());
    }

    public Optional<Customer> findExactCustomerByName(List<Customer> customers, String name) {
        return customers.stream()
                .filter(c -> c.getFullName().equalsIgnoreCase(name.trim())) // Полное совпадение
                .findFirst();
    }
}