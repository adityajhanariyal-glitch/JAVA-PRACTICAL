
class Shape {
    double area() {
        return 0;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return length * breadth;
    }
}

class Calculator {
    // Method overloading
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Practical3 {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println("Integer Sum: " + c.add(10, 20));
        System.out.println("Double Sum: " + c.add(2.5, 3.5));

        Shape s;

        s = new Circle(5);
        System.out.printf("Circle Area: %.2f%n", s.area());

        s = new Rectangle(4, 6);
        System.out.println("Rectangle Area: " + s.area());
    }
}

