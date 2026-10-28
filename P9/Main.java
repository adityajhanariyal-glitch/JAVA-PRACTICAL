
import java.util.Objects;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList<T> {
    private Node<T> head;
    private int size = 0;

    // Insert an element
    void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        size++;
    }

    // Delete an element
    void delete(T data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (Objects.equals(head.data, data)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> temp = head;

        while (temp.next != null &&
               !Objects.equals(temp.next.data, data)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
        } else {
            System.out.println("Element not found.");
        }
    }

    // Search an element
    boolean search(T data) {
        Node<T> temp = head;

        while (temp != null) {
            if (Objects.equals(temp.data, data)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // Display the list
    void display() {
        Node<T> temp = head;

        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Return list size
    int size() {
        return size;
    }

    // Check whether list is empty
    boolean isEmpty() {
        return head == null;
    }
}

// Main class for Programiz
public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        System.out.print("Integer List: ");
        list.display();

        System.out.println("Search 20: " + list.search(20));

        list.delete(20);

        System.out.print("After Deletion: ");
        list.display();

        System.out.println("Size: " + list.size());
        System.out.println("Is Empty: " + list.isEmpty());

        MyLinkedList<String> names = new MyLinkedList<>();

        names.insert("Rahul");
        names.insert("Aman");

        System.out.print("String List: ");
        names.display();
    }
}
