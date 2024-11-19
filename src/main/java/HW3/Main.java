package HW3;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(1f, 2.0));

        System.out.println(compareArrays(new Number[]{1.0, 2.0}, new Double[]{3.0, 4.0}));

        Pair<Integer, Double> pair = new Pair<>(1, 2.0);
        System.out.println(pair.getFirst() + " " + pair.getSecond());
        System.out.println(pair);
    }

    private static <T, V> boolean compareArrays(T[] arr1, V[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].getClass().equals(arr2[i].getClass())) {
                    return false;
                }
            }
            return true;
        }
    }
}
