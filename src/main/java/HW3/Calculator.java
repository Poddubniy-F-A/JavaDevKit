package HW3;

public class Calculator {
    public static double sum(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static double multiply(Number a, Number b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static double divide(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }

    public static double subtract(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }
}
