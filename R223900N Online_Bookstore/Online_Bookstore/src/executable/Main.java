package executable;

import accounts.Administrator;
import accounts.Customer;
import inventory.Book;
import inventory.Bookstore;
import inventory.Category;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Bookstore
        Bookstore bookstore = new Bookstore("B1", "Address");

        // Create Categories
        Category fictionCategory = new Category("Fiction", "Books of horror film.");
        Category nonFictionCategory = new Category("Non-Fiction", "History book.");
        Category mysteryCategory = new Category("Mystery", "My mystery book");

        // Create Books
        Book book1 = new Book("B1", "Book 1", "Author 1", 25, "ISBN1");
        Book book2 = new Book("B2", "Book 2", "Author 2", 17.69, "ISBN2");
        Book book3 = new Book("B3", "Book 3", "Author 3", 14, "ISBN3");

        // Add Books to Inventory
        bookstore.addBookToInventory(book1);
        bookstore.addBookToInventory(book2);
        bookstore.addBookToInventory(book3);

        // Create an Administrator
        Administrator administrator = new Administrator("A1", "Elphord", "Machida", "Pendennis", "0773562596",
                "admin", "Programmer", "admin123");

        // Create a Customer
        Customer customer = new Customer("C1", "Ropa", "Mubaiwa", "Mt Pleasant", "077232232");

        // Main Menu
        boolean exit = false;
        while (!exit) {
            System.out.println(">>>>>>BOOKSTORE APPLICATION <<<<<<<");
            System.out.println("1. Manage Inventory");
            System.out.println("2. Create Customer");
            System.out.println("3. Create Shopping Cart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    manageInventoryMenu(scanner, bookstore, administrator);
                    break;
                case 2:
                    createCustomerMenu(scanner, customer);
                    break;
                case 3:
                    createShoppingCartMenu(scanner, bookstore, customer);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thanks for using the Bookstore Application!");
    }

    private static void manageInventoryMenu(Scanner scanner, Bookstore bookstore, Administrator administrator) {
        System.out.println(">>>>> MANAGE INVENTORY <<<<<<");
        System.out.print("Enter your administrator username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your administrator password: ");
        String password = scanner.nextLine();

        if (username.equals(administrator.getUsername()) && password.equals(administrator.getPassword())) {
            boolean exit = false;
            while (!exit) {
                System.out.println("===== INVENTORY MENU =====");
                System.out.println("1. Add Book to Inventory");
                System.out.println("2. Remove Book from Inventory");
                System.out.println("3. Search Books by Title");
                System.out.println("4. Search Books by Author");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the book ID: ");
                        String bookId = scanner.nextLine();
                        System.out.print("Enter the book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter the book author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter the book price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter the book ISBN: ");
                        String isbn = scanner.nextLine();

                        Book newBook = new Book(bookId, title, author, price, isbn);
                        bookstore.addBookToInventory(newBook);
                        System.out.println("Book added to inventory successfully.");
                        break;
                    case 2:
                        System.out.print("Enter the book ID to remove: ");
                        String removeBookId = scanner.nextLine();

                        List<Book> inventory = bookstore.getInventory();
                        Book bookToRemove = null;
                        for (Book book : inventory) {
                            if (book.getBookId().equals(removeBookId)) {
                                bookToRemove = book;
                                break;
                            }
                        }

                        if (bookToRemove != null) {
                            bookstore.removeBookFromInventory(bookToRemove);
                            System.out.println("Book removed from inventory successfully.");
                        } else {
                            System.out.println("Book not found in inventory.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter the book title to search: ");
                        String searchTitle = scanner.nextLine();

                        List<Book> booksByTitle = bookstore.searchBooksByTitle(searchTitle);
                        if (booksByTitle.isEmpty()) {
                            System.out.println("No books found with the given title.");
                        } else {
                            System.out.println("Books found:");
                            for (Book book : booksByTitle) {
                                System.out.println(book);
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Enter the book author to search: ");
                        String searchAuthor = scanner.nextLine();

                        List<Book> booksByAuthor = bookstore.searchBooksByAuthor(searchAuthor);
                        if (booksByAuthor.isEmpty()) {
                            System.out.println("No books found with the given author.");
                        } else {
                            System.out.println("Books found:");
                            for (Book book : booksByAuthor) {
                                System.out.println(book);
                            }
                        }
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid administrator username or password.");
        }
    }

    private static void createCustomerMenu(Scanner scanner, Customer customer) {
        System.out.println("===== CREATE CUSTOMER =====");
        System.out.print("Enter the customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter the customer first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the customer last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter the customer address: ");
        String address = scanner.nextLine();
        System.out.print("Enter the customer phone number: ");
        String phoneNumber = scanner.nextLine();

        customer.setCustomerId(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setPhoneNumber(phoneNumber);

        System.out.println("Customer created successfully.");
    }

    private static void createShoppingCartMenu(Scanner scanner, Bookstore bookstore, Customer customer) {
        System.out.println(">>>>>> CREATE SHOPPING CART <<<<<<");
        System.out.print("Enter the customer ID: ");
        String customerId = scanner.nextLine();

        if (customerId.equals(customer.getCustomerId())) {
            List<Book> inventory = bookstore.getInventory();
            Cart cart = new Cart();

            boolean exit = false;
            while (!exit) {
                System.out.println(">>>>>> SHOPPING CART MENU <<<<<");
                System.out.println("1. Add Book to Cart");
                System.out.println("2. Remove Book from Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Checkout");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the book ID to add to cart: ");
                        String bookId = scanner.nextLine();

                        Book bookToAdd = null;
                        for (Book book : inventory) {
                            if (book.getBookId().equals(bookId)) {
                                bookToAdd = book;
                                break;
                            }
                        }

                        if (bookToAdd != null) {
                            cart.addBookToCart(bookToAdd);
                            System.out.println("Book added to cart successfully.");
                        } else {
                            System.out.println("Book not found in inventory.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter the book ID to remove from cart: ");
                        String removeBookId = scanner.nextLine();

                        Book bookToRemove = null;
                        List<Book> cartItems = cart.getCartItems();
                        for (Book book : cartItems) {
                            if (book.getBookId().equals(removeBookId)) {
                                bookToRemove = book;
                                break;
                            }
                        }

                        if (bookToRemove != null) {
                            cart.removeBookFromCart(bookToRemove);
                            System.out.println("Book removed from cart successfully.");
                        } else {
                            System.out.println("Book not found in cart.");
                        }
                        break;
                    case 3:
                        List<Book> cartItemsList = cart.getCartItems();
                        if (cartItemsList.isEmpty()) {
                            System.out.println("Cart is empty.");
                        } else {
                            System.out.println("Cart items:");
                            for (Book book : cartItemsList) {
                                System.out.println(book);
                            }
                        }
                        break;
                    case 4:
                        double totalAmount = cart.checkout();
                        System.out.println("Checkout completed. Total amount: $" + totalAmount);
                        exit = true;
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}