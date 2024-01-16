package inventory;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private double price;
    private String isbn;

    // constructors
    public Book(String bookId, String title, String author, double price, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    // Getters and setters

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}