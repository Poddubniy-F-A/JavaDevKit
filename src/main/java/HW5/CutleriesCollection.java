package HW5;

import java.util.ArrayList;

public class CutleriesCollection {
    private final ArrayList<Cutlery> cutleries;

    public CutleriesCollection(int cutleriesNum) {
        cutleries = new ArrayList<>(cutleriesNum);
        for (int i = 1; i <= cutleriesNum; i++) {
            cutleries.add(new Cutlery(i));
        }
    }

    public synchronized boolean setAsUsed(Cutlery cutlery1, Cutlery cutlery2) {
        if (cutlery1.isUsed() || cutlery2.isUsed()) {
            return false;
        } else {
            cutlery1.use();
            cutlery2.use();
            return true;
        }
    }

    public void setAsUnused(Cutlery cutlery1, Cutlery cutlery2) {
        cutlery1.free();
        cutlery2.free();
    }

    public Cutlery getCutleryByIndex(int index) {
        return cutleries.get(index);
    }
}
