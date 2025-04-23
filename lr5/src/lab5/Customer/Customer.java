package lab6.Customer;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private long creditCardNumber;
    private double creditCardBalance;
    private static int tempID;

    public Customer(String surname, String name, String middleName, String address, long creditCardNumber, double creditCardBalance) {
        tempID++;
        this.id = tempID;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.creditCardBalance = creditCardBalance;
    }

    public Customer() {
        this("", "", "", "", 0L, 0.0);
    }

    // Гетери, сетери, toString, equals та hashCode тут...
}