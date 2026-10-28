
class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

public class Practical7 {

    // Generic method
    static <T> void printValue(T value) {
        System.out.println(value);
    }

    // Bounded type parameter
    static <T extends Number> double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }

    // Upper-bounded wildcard
    static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }

    // Lower-bounded wildcard
    static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.set(100);

        Box<String> b2 = new Box<>();
        b2.set("Hello Java");

        System.out.println("Integer Box: " + b1.get());
        System.out.println("String Box: " + b2.get());

        printValue(50);
        printValue("Generic Method");

        System.out.println("Square: " + square(5));

        List<Double> numbers = Arrays.asList(10.5, 20.5);
        System.out.println("Sum: " + sum(numbers));

        List<Number> values = new ArrayList<>();
        addIntegers(values);
        System.out.println("Values: " + values);
    }
}

