package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String fullName;
    private String city;
    private String creditCardNumber;
    private double balance;
    private int purchaseCount;
    private double totalSpent;

    public Customer(int id, String fullName, String city, String creditCardNumber,
                    double balance, int purchaseCount, double totalSpent) {
        this.id = id;
        this.fullName = fullName;
        this.city = city;
        this.creditCardNumber = creditCardNumber;
        this.balance = balance;
        this.purchaseCount = purchaseCount;
        this.totalSpent = totalSpent;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getCity() { return city; }
    public String getCreditCardNumber() { return creditCardNumber; }
    public double getBalance() { return balance; }
    public int getPurchaseCount() { return purchaseCount; }
    public double getTotalSpent() { return totalSpent; }
    public double getAveragePurchase() {
        return purchaseCount == 0 ? 0 : totalSpent / purchaseCount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", balance=" + balance +
                ", purchaseCount=" + purchaseCount +
                ", totalSpent=" + totalSpent +
                '}';
    }
}