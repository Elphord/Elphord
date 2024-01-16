package inventory;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private String bookstoreId;
    private String location;
    private List<Book> inventory;

    public Bookstore(String bookstoreId, String location) {
        this.bookstoreId = bookstoreId;
        this.location = location;
        this.inventory = new ArrayList<>();
    }

    public void addBookToInventory(Book book) {
        inventory.add(book);
    }

    public void removeBookFromInventory(Book book) {
        inventory.remove(book);
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Getters and setters

    public String getBookstoreId() {
        return bookstoreId;
    }

    public void setBookstoreId(String bookstoreId) {
        this.bookstoreId = bookstoreId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Book> getInventory() {
        return inventory;
    }

    public void setInventory(List<Book> inventory) {
        this.inventory = inventory;
    }
}