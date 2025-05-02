package service;

import model.Customer;
import java.util.*;
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
                .filter(c -> c.getFullName().equalsIgnoreCase(name.trim()))
                .findFirst();
    }

    // 🚀 Новая функция: города с количеством покупок > n
    public Set<String> filterCitiesWithPurchases(List<Customer> customers, int minPurchases) {
        return customers.stream()
                .filter(c -> c.getPurchaseCount() > minPurchases)
                .map(Customer::getCity)
                .collect(Collectors.toSet());
    }

    // 🚀 Map: Группировка покупателей по городам
    public Map<String, List<Customer>> groupByCity(List<Customer> customers) {
        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity));
    }

    // 🚀 Map: Общая сумма трат по городам
    public Map<String, Double> totalSpentByCity(List<Customer> customers) {
        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getCity,
                        Collectors.summingDouble(Customer::getTotalSpent)));
    }
}