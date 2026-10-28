
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }
}

class MyLinkedList<T> {
    private Node<T> head;
    private int size = 0;

    void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
        size++;
    }

    void delete(T data) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (java.util.Objects.equals(head.data, data)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;

        while (current.next != null &&
               !java.util.Objects.equals(current.next.data, data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        } else {
            System.out.println("Element Not Found");
        }
    }

    boolean search(T data) {
        Node<T> current = head;

        while (current != null) {
            if (java.util.Objects.equals(current.data, data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    void display() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

public class Practical9 {
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

