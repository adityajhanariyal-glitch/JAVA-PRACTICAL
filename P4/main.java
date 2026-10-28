
abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculateSalary();

    void display() {
        System.out.println("Employee: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

interface Payable {
    void pay();
}

class FullTimeEmployee extends Employee implements Payable {
    double monthlySalary;

    FullTimeEmployee(String name, double salary) {
        super(name);
        monthlySalary = salary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void pay() {
        System.out.println("Full-time employee payment processed.");
    }
}

class PartTimeEmployee extends Employee implements Payable {
    int hours;
    double rate;

    PartTimeEmployee(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculateSalary() {
        return hours * rate;
    }

    @Override
    public void pay() {
        System.out.println("Part-time employee payment processed.");
    }
}

public class Practical4 {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Rahul", 30000);
        Employee e2 = new PartTimeEmployee("Aman", 80, 200);

        e1.display();
        ((Payable) e1).pay();

        System.out.println();

        e2.display();
        ((Payable) e2).pay();
    }
}

