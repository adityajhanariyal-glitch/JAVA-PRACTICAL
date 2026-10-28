
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    int rollNo;

    Student(String name, int age, int rollNo) {
        super(name, age);
        this.rollNo = rollNo;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Roll No: " + rollNo);
    }
}

class Faculty extends Person {
    String subject;

    Faculty(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Subject: " + subject);
    }
}

public class Practical2 {
    public static void main(String[] args) {
        Student s = new Student("Aman", 20, 101);
        Faculty f = new Faculty("Mr. Sharma", 40, "Java");

        System.out.println("Student Details:");
        s.display();

        System.out.println("\nFaculty Details:");
        f.display();
    }
}

