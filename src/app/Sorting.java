package app;

/**
 * Sorting algorithms
 */
public final class Sorting {

    private static int[] mergeSortArray;

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

    /**
     * Performs insertion sort.
     * 
     * @param inputArray Array to sort.
     * @return Sorted array.
     */
    public static int[] insertionSort(int[] inputArray) {
        int length = inputArray.length;
        for (int i = 1; i < length; ++i) {
            int valueToInsert = inputArray[i];
            int insertPosition = i;
            while (insertPosition > 0 && inputArray[insertPosition - 1] > valueToInsert) {
                inputArray[insertPosition] = inputArray[insertPosition - 1];
                insertPosition--;
            }
            inputArray[insertPosition] = valueToInsert;

        }
        return inputArray;
    }

    /**
     * Performs merge sort,
     * and returns sorted array
     * @param inputArray Array to sort.
     * @return Sorted array.
     */
    public static int[]  getMergeSortedArray(int[] inputArray){
        mergeSort(inputArray);
        return mergeSortArray;
    }


    private static void mergeSort(int[] inputArray){
        if(inputArray.length < 2){
            return;
        }
        int originalLength = inputArray.length;
        int halfLength = Math.round(originalLength / 2);
        int[] leftArray = new int[halfLength];
        int[] rightArray = new int[originalLength - halfLength];

        for(int i = 0; i < halfLength; ++i){
            leftArray[i] = inputArray[i];
        }

        for(int j = 0; j < originalLength - halfLength; ++j){
            rightArray[j] = inputArray[halfLength +j];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        mergeArrays(leftArray, rightArray);
    }   
    

    private static void mergeArrays(int[] input1, int[] input2) {
        int lengthOfFirst = input1.length;
        int lengthOfSecond = input2.length;
        int finalLength = lengthOfFirst + lengthOfSecond;

        mergeSortArray = new int[finalLength];
        int positionOnFirst = 0;
        int positionOnSecond = 0;
        int insertPosition = 0;

        while (positionOnFirst < lengthOfFirst && positionOnSecond < lengthOfSecond) {
            if (input1[positionOnFirst] < input2[positionOnSecond]) {
                mergeSortArray[insertPosition] = input1[positionOnFirst];
                positionOnFirst++;
            } else{
                mergeSortArray[insertPosition] = input2[positionOnSecond];
                positionOnSecond++;
            }
            insertPosition++;
        }

        while(positionOnFirst < lengthOfFirst){
            mergeSortArray[insertPosition] = input1[positionOnFirst];
            positionOnFirst++;
            insertPosition++;
        }

        while(positionOnSecond < lengthOfSecond){
            mergeSortArray[insertPosition] = input2[positionOnSecond];
            positionOnSecond++;
            insertPosition++;
        }
    }

}