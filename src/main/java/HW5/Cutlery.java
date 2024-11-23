package HW5;

public class Cutlery {
    private final int id;

    private volatile boolean isUsed;

    public Cutlery(int id) {
        this.id = id;

        isUsed = false;
    }

    @Override
    public String toString() {
        return "столовый прибор " + id;
    }

    public void use() {
        isUsed = true;
    }

    public void free() {
        isUsed = false;
    }

    public boolean isUsed() {
        return isUsed;
    }
}
