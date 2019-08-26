package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] in = new int[] { 3, 4, 1, 5, 2, 6 };
        int[] out = Sorting.getMergeSortedArray(in);
        for (int number : out) {
            System.out.println(number);
        }
    }
}