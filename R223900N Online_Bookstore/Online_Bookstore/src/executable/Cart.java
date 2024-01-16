package executable;


import inventory.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private String cartId;
    private String customerId;
    private String bookstoreId;
    private String sellerId;
    private Map<Book, Integer> selectedBooks;

    public Cart(String cartId, String customerId, String bookstoreId, String sellerId) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.bookstoreId = bookstoreId;
        this.sellerId = sellerId;
        this.selectedBooks = new HashMap<>();
    }

    public Cart() {

    }

    public void addBook(Book book, int quantity) {
        if (selectedBooks.containsKey(book)) {
            int currentQuantity = selectedBooks.get(book);
            selectedBooks.put(book, currentQuantity + quantity);
        } else {
            selectedBooks.put(book, quantity);
        }
    }

    public void removeBook(Book book, int quantity) {
        if (selectedBooks.containsKey(book)) {
            int currentQuantity = selectedBooks.get(book);
            if (currentQuantity <= quantity) {
                selectedBooks.remove(book);
            } else {
                selectedBooks.put(book, currentQuantity - quantity);
            }
        }
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Map.Entry<Book, Integer> entry : selectedBooks.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            totalCost += book.getPrice() * quantity;
        }
        return totalCost;
    }

    // Getters and setters

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookstoreId() {
        return bookstoreId;
    }

    public void setBookstoreId(String bookstoreId) {
        this.bookstoreId = bookstoreId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void addBookToCart(Book bookToAdd) {
    }

    public List<Book> getCartItems() {
        return null;
    }

    public void removeBookFromCart(Book bookToRemove) {
    }

    public double checkout() {
        return 0;
    }
}