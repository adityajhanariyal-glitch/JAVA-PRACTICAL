
import java.util.*;

// Interface
interface Borrowable {
    void borrow();
}

// Abstract class
abstract class Item {
    private int id;
    private String title;

    Item(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    abstract void display();
}

// Inheritance and interface implementation
class Book extends Item implements Borrowable {
    private boolean borrowed = false;

    Book(int id, String title) {
        super(id, title);
    }

    @Override
    void display() {
        System.out.println(getId() + " - " + getTitle()
                + " - " + (borrowed ? "Borrowed" : "Available"));
    }

    @Override
    public void borrow() {
        if (borrowed) {
            System.out.println("Book already borrowed.");
        } else {
            borrowed = true;
            System.out.println("Book borrowed: " + getTitle());
        }
    }
}

// Custom exception
class ItemNotFoundException extends Exception {
    ItemNotFoundException(String message) {
        super(message);
    }
}

// Generic repository
class Repository<T> {
    private List<T> items = new ArrayList<>();

    void add(T item) {
        items.add(item);
    }

    List<T> getAll() {
        return items;
    }
}

// Stack ADT
class HistoryStack<T> {
    private Stack<T> stack = new Stack<>();

    void push(T item) {
        stack.push(item);
    }

    T pop() {
        if (stack.empty()) {
            System.out.println("History is empty.");
            return null;
        }
        return stack.pop();
    }
}

// Library contains a repository and history stack
class Library {
    private Repository<Book> repository = new Repository<>();
    private HistoryStack<String> history = new HistoryStack<>();

    void addBook(Book book) {
        repository.add(book);
    }

    void showBooks() {
        for (Book book : repository.getAll()) {
            book.display();
        }
    }

    void borrowBook(int id) throws ItemNotFoundException {
        for (Book book : repository.getAll()) {
            if (book.getId() == id) {
                book.borrow();
                history.push("Borrowed book ID: " + id);
                return;
            }
        }

        throw new ItemNotFoundException("Book not found!");
    }

    void showLastAction() {
        System.out.println("Last Action: " + history.pop());
    }
}

public class Practical10 {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1, "Java Programming"));
        library.addBook(new Book(2, "Data Structures"));

        System.out.println("Library Books:");
        library.showBooks();

        try {
            library.borrowBook(1);
            library.borrowBook(5);
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Library operation completed.");
        }

        System.out.println("\nUpdated Book List:");
        library.showBooks();

        library.showLastAction();
    }
}

