package HW5;

public class Main {
    public static void main(String[] args) {
        int number = 5;

        CutleriesCollection cutleries = new CutleriesCollection(number);
        for (int i = 0; i < number; i++) {
            new Philosopher(cutleries.getCutleryByIndex(i), cutleries.getCutleryByIndex((i + 1) % number), cutleries).start();
        }
    }
}
