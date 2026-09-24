// package assignment3;

public class SelectionSort {
    private int comparisons;
    private int swaps;

    public void sort(int[] array, int start, int end) {
        for (int swapIndex = end - 1; swapIndex >= start; swapIndex--) {
            int greatestElementIndex = start;
            for (int i = start + 1; i <= swapIndex; i++) {
                comparisons++;
                if(array[i] > array[greatestElementIndex]) {
                    greatestElementIndex = i;
                }
                swaps++;
                swap(array, greatestElementIndex, swapIndex);
            }
        }
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
