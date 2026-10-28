
class StackADT {
    int[] arr;
    int top;
    int size;

    StackADT(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = value;
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

class QueueADT {
    int[] arr;
    int front, rear, size, count;

    QueueADT(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    void enqueue(int value) {
        if (count == size) {
            System.out.println("Queue Overflow");
            return;
        }

        rear = (rear + 1) % size;
        arr[rear] = value;
        count++;
    }

    int dequeue() {
        if (count == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = arr[front];
        front = (front + 1) % size;
        count--;
        return value;
    }

    int peek() {
        if (count == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    boolean isEmpty() {
        return count == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        StackADT stack = new StackADT(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack Peek: " + stack.peek());
        System.out.println("Stack Pop: " + stack.pop());
        System.out.println("Stack Pop: " + stack.pop());

        QueueADT queue = new QueueADT(3);

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        System.out.println("Queue Peek: " + queue.peek());
        System.out.println("Queue Dequeue: " + queue.dequeue());
        System.out.println("Queue Dequeue: " + queue.dequeue());

        System.out.println("Stack Empty: " + stack.isEmpty());
        System.out.println("Queue Empty: " + queue.isEmpty());
    }
}
