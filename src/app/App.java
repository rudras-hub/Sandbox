package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] in = new int[] { 3, 4, 1, 5, 2 };
        int[] out = Sorting.bubbleSort(in);
        for (int number : out) {
            System.out.println(number);
        }
    }
}