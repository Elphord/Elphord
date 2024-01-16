package accounts;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private int creditPoints;
    private List<String> purchasedBooks;

    public Customer(String userId, String firstName, String lastName, String address, String phone) {
        super(userId, firstName, lastName, address, phone);
        this.creditPoints = 0;
        this.purchasedBooks = new ArrayList<>();
    }

    // Getters and setters

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public List<String> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(List<String> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    public void setCustomerId(String customerId) {
    }

    public void setPhoneNumber(String phoneNumber) {
    }

    public String getCustomerId() {
        return null;
    }
}