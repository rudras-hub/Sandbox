package app;

/**
 * Sorting algorithms
 */
public final class Sorting {

    /**
     * Performs selection sort
     * 
     * @param inputArray Array to sort.
     * @return Sorted array.
     */
    public static int[] selectionSort(int[] inputArray) {
        int length = inputArray.length;
        for (int i = 0; i < length; ++i) {
            int minValue = inputArray[i];
            int minIndex = i;
            for (int j = i + 1; j < length; ++j) {
                if (inputArray[j] < minValue) {
                    minValue = inputArray[j];
                    minIndex = j;
                }
            }
            int temp = inputArray[i];
            inputArray[i] = minValue;
            inputArray[minIndex] = temp;
        }
        return inputArray;
    }

    /**
     * Performs bubble sort.
     * 
     * @param inputArray Array to sort.
     * @return Sorted array.
     */
    public static int[] bubbleSort(int[] inputArray) {
        int length = inputArray.length;
        for (int i = 0; i < length; ++i) {
            int numberOfSwaps = 0;
            int loopLimit = length - i - 1;
            for (int j = 0; j < loopLimit; ++j) {
                if (inputArray[j + 1] < inputArray[j]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                    numberOfSwaps++;
                }
            }
            if (numberOfSwaps == 0) {
                return inputArray;
            }
        }
        return inputArray;
    }

}