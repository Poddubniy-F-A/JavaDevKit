package HW3;

public class Pair <T, V> {
    private final T a;
    private final V b;

    public Pair(T a, V b) {
        this.a = a;
        this.b = b;
    }

    public T getFirst() {
        return a;
    }

    public V getSecond() {
        return b;
    }

    @Override
    public String toString() {
        return a.toString() + " " + b.toString();
    }
}
