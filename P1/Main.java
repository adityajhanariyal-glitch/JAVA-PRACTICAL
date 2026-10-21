
class Student {
    private int rollNo;
    private String name;
    private int age;
    private double marks;
    public Student() {
        rollNo = 0;
        name = "Unknown";
        age = 0;
        marks = 0.0;
    }
    public Student(int rollNo, String name, int age, double marks) {
        setRollNo(rollNo);
        setName(name);
        setAge(age);
        setMarks(marks);
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        if (rollNo > 0) {
            this.rollNo = rollNo;
        } else {
            System.out.println("Invalid roll number!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid student name!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 20 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Enter 0 to 100.");
        }
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("--------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

      
        Student s2 = new Student(1, "Aditya", 20, 85.5);
        System.out.println("Student 1 (Default Constructor):");
        s1.displayDetails();

        System.out.println("Student 2 (Parameterized Constructor):");
        s2.displayDetails();

      
        s1.setRollNo(6);
        s1.setName("Manav");
        s1.setAge(20);
        s1.setMarks(79);

        System.out.println("Student 1 After Updating Details:");
        s1.displayDetails();

        // Accessing data using getters
        System.out.println("Student Name: " + s2.getName());
        System.out.println("Student Marks: " + s2.getMarks());
        s2.setMarks(150);
        s2.setAge(20);
    }
}
