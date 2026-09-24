// package assignment3;

public class InsertionSort {
    private int comparisons;
    private int swaps;
    
    public void sort(int[] array, int start, int end) {
        for (int sortedEnd = start + 1; sortedEnd < end; sortedEnd++) {
            for (int i = sortedEnd; i > start; i--) {
                comparisons++;
                if(array[i] < array[i - 1]) {
                    swaps++;
                    swap(array, i, i - 1);
                } else {
                    break;
                }
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
