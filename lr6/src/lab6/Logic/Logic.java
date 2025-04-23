package lab6.Logic;

import lab6.Customer.Customer;

import java.util.*;

public class Logic {
    public void addEll(List<Customer> customers, String surname, String name, String middleName, String address, long creditCardNumber, double creditCardBalance) {
        customers.add(new Customer(surname, name, middleName, address, creditCardNumber, creditCardBalance));
    }

    public void remEll(List<Customer> customers, int id) {
        customers.removeIf(customer -> customer.getId() == id);
    }

    public List<Customer> defineName(String xName, List<Customer> customers) {
        List<Customer> customersWithName = new ArrayList<>();
        for (Customer customer : customers) {
            if (xName.equals(customer.getName())) {
                customersWithName.add(customer);
            }
        }
        return customersWithName;
    }

    public List<Customer> compareCreditCardNumbers(long x1, long x2, List<Customer> customers) {
        List<Customer> customersInRange = new ArrayList<>();
        for (Customer customer : customers) {
            if (x1 <= customer.getCreditCardNumber() && customer.getCreditCardNumber() <= x2) {
                customersInRange.add(customer);
            }
        }
        return customersInRange;
    }

    public List<Customer> customersWithDept(List<Customer> customers) {
        List<Customer> customersWithDebt = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getCreditCardBalance() < 0) {
                customersWithDebt.add(customer);
            }
        }
        return customersWithDebt;
    }
}