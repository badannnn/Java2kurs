package app.model;

public class Customer {
    private int id;
    private String fullName;
    private String city;
    private String cardNumber;
    private double balance;
    private int purchaseCount;
    private double totalSpent;

    public Customer(int id, String fullName, String city, String cardNumber,
                    double balance, int purchaseCount, double totalSpent) {
        this.id = id;
        this.fullName = fullName;
        this.city = city;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.purchaseCount = purchaseCount;
        this.totalSpent = totalSpent;
    }

    // Геттери та сеттери
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getCity() { return city; }
    public String getCardNumber() { return cardNumber; }
    public double getBalance() { return balance; }
    public int getPurchaseCount() { return purchaseCount; }
    public double getTotalSpent() { return totalSpent; }

    public double getAveragePurchase() {
        return purchaseCount == 0 ? 0 : totalSpent / purchaseCount;
    }

    @Override
    public String toString() {
        return fullName + " (" + city + ")";
    }
}
