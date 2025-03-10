import java.util.*;
class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next;
    Book prev;

    // Constructor to initialize a new book node
    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    private Book head;
    private Book tail;
    private int size;

    // Constructor to initialize the doubly linked list
    public LibraryManagementSystem() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        size++;
    }

    // Add a book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        size++;
    }

    // Add a book at a specific position
    public void addBookAtPosition(int position, String title, String author, String genre, int bookID, boolean isAvailable) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        
        if (position == size + 1) {
            addBookAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        Book current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newBook.next = current.next;
        newBook.prev = current;
        current.next.prev = newBook;
        current.next = newBook;
        size++;
    }

    // Remove a book by Book ID
    public void removeBookByID(int bookID) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                System.out.println("Book with ID " + bookID + " has been removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Search for a book by Book Title or Author
    public void searchBook(String searchQuery) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(searchQuery) || current.author.equalsIgnoreCase(searchQuery)) {
                System.out.println("Found: " + current.title + " by " + current.author + " (ID: " + current.bookID + ")");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found matching the search query.");
        }
    }

    // Update a book’s Availability Status
    public void updateAvailabilityStatus(int bookID, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = isAvailable;
                System.out.println("Availability status of book with ID " + bookID + " updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }
        Book current = head;
        while (current != null) {
            System.out.println("Book ID: " + current.bookID + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("The library is empty.");
            return;
        }
        Book current = tail;
        while (current != null) {
            System.out.println("Book ID: " + current.bookID + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return size;
    }
}

public class DoublyLL {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Add books
        library.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 2, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 3, true);
        
        // Display books
        System.out.println("All books (forward):");
        library.displayBooksForward();
        
        System.out.println("\nAll books (reverse):");
        library.displayBooksReverse();

        // Search for a book
        library.searchBook("1984");

        // Update availability status
        library.updateAvailabilityStatus(1, false);

        // Display books after update
        System.out.println("\nAll books (forward) after update:");
        library.displayBooksForward();

        // Remove a book
        library.removeBookByID(2);
        
        // Display books after removal
        System.out.println("\nAll books (forward) after removal:");
        library.displayBooksForward();
        
        // Count the total number of books
        System.out.println("\nTotal number of books in library: " + library.countBooks());
    }
}
