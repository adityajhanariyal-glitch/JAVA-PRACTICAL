import java.util.*;

interface Borrowable {
    void borrow();
}

abstract class Item {
    private int id;
    private String title;

    Item(int id, String title) {
        this.id = id;
        this.title = title;
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    abstract void display();
}

class Book extends Item implements Borrowable {
    private boolean borrowed = false;

    Book(int id, String title) {
        super(id, title);
    }

    public void borrow() {
        if (borrowed) {
            System.out.println("Book already borrowed.");
        } else {
            borrowed = true;
            System.out.println("Book borrowed: " + getTitle());
        }
    }

    void display() {
        System.out.println(getId() + " - " + getTitle()
                + " - " + (borrowed ? "Borrowed" : "Available"));
    }
}

class ItemNotFoundException extends Exception {
    ItemNotFoundException(String message) {
        super(message);
    }
}

class Repository<T> {
    private List<T> items = new ArrayList<>();

    void add(T item) {
        items.add(item);
    }

    List<T> getAll() {
        return items;
    }
}

class HistoryStack<T> {
    private Stack<T> stack = new Stack<>();

    void push(T item) {
        stack.push(item);
    }

    T pop() {
        if (stack.empty()) {
            return null;
        }
        return stack.pop();
    }
}

class Library {
    private Repository<Book> books = new Repository<>();
    private HistoryStack<String> history = new HistoryStack<>();

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        for (Book book : books.getAll()) {
            book.display();
        }
    }

    void borrowBook(int id) throws ItemNotFoundException {
        for (Book book : books.getAll()) {
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

public class Main {
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
