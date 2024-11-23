package HW5;

public class Philosopher extends Thread {
    private static int examplesNum = 0;

    private static final int iterationsNumber = 3;

    private final int id;
    private final Cutlery cutlery1, cutlery2;
    private final CutleriesCollection cutleries;

    public Philosopher(Cutlery cutlery1, Cutlery cutlery2, CutleriesCollection cutleries) {
        id = ++examplesNum;

        this.cutlery1 = cutlery1;
        this.cutlery2 = cutlery2;

        this.cutleries = cutleries;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterationsNumber; i++) {
            while (!cutleries.setAsUsed(cutlery1, cutlery2)) {
                onSpinWait();
            }
            System.out.println(id + " философ ест с помощью " + cutlery1 + " и " + cutlery2);
            System.out.println(id + " философ поел, " + cutlery1 + " и " + cutlery2 + " освободились");
            cutleries.setAsUnused(cutlery1, cutlery2);
            System.out.println(id + " философ размышляет");
        }
    }
}
