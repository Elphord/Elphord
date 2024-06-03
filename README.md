Online bookstore Exam

You are tasked with developing an online bookstore application in java. The application should allow users to browse and purchase books from various categories .you need to design and implement the system using OOP principles.

1.	Packages:
Package	Classes
Accounts	-User.java
-Administrator.java
-Customer.java

Inventory	-Bookstore.java
-Book.java
-Category.java
-All category classes(Fiction, Non-fiction, Mystery)
Executable	-Cart.java
-Main.java

2.	User Class + (Customer and Administrator classes)
•	User auto-generated ID, firstname ,lastname ,address, phone
•	Implement two child classes namely (customer and administrator classes) with appropriate distinct fields ,e.g, administrators must have login privileges (username, role, password) and customers may further have credit points at every purchase and will determine discounts in future purchases.
•	Customer profile should also have a collection of books bought
•	
3.	Book Class
•	Create a Book class that represents a book with attributes such as auto -generated ID,title, author ,price, and isbn(International Standard Book Number)
•	Implement proper encapsulation for these attributes.


4. Category Class
•	Create a Category class that represents a category of books (e.g, Fiction,Non-fiction,Mystery).
•	Use inheritance to ensure that each category inherits common attributes from a parent class ,such as name and description.

5.Bookstore Class:
•	Create a Bookstore class that manages the collection of books available for purchase.
•	The bookstore must have an ID and a location.
•	Implement a method to add to the books to the store’s inventory, taking into consideration quantities of books stored
•	Implement a method to search for books by title or author within a specific category.
•	Allow store administrators to manage the inventory ,adding and removing books.


6. Shopping Cart:
•	Design a shopping cart that allows customers to add and remove books.
•	The cart must have an auto-generated ID, Customer ID, store ID and seller ID
•	It must have a list of books selected and their quantities ,also, ensure that the shopping cart can calculate the total cost of the items added.
•	The cart must invoke methods in the bookstore class toc check whether required quantities to be purchased are available and reduce the stock when purchases are made.

7.  Exception Handling , Abstraction and Polymorphism
•	Implement exception handling for scenarios like adding duplicate books to the shopping cart or searching for a book that doesn’t exist.
•	Utilize abstraction to hide the internal implementation details of the Book class while providing a public interface to access its attributes.
•	Implement polymorphism by creating different subclasses of Category (e.g., FictionCategory , NonFictionCategory) that override methods like getDescription.

Guidelines:

•	Start by creating a class diagram that outlines the relationships between classes and their attributes /methods.
•	Use appropriate exception classes for exception handling(e.g., DuplicateBookException, BookNotFoundException)
•	Test your application thoroughly with a menu driven method by:
	Create bookstore.
	Create category.
	Create books.
	Manage Inventory
	Customer Shopping

You may add other menus you dim necessary to demonstrate your creativity.






