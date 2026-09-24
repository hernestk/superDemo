// package assignment3;

public class Quicksort {
    private int comparisons;
    private int swaps;

    public void sort(int[] array, int start, int end) {
        comparisons++;
        if(end - start < 2) {
            return;
        }

        int pivot = partition(array, start, end);
        sort(array, start, pivot);
        sort(array, pivot + 1, end);
    }

    public int partition(int[] array, int start, int end) {
        int pivot = (int) (Math.random() * (end - start)) + start;
        swaps++;
        swap(array, start, pivot);

        int secondPartitionStart = start + 1;
        for (int i = start + 1; i < end; i++) {
            comparisons++;
            if(array[i] < array[start]) {
                swaps++;
                swap(array, i, secondPartitionStart);
                secondPartitionStart++;
            }
        }

        pivot = secondPartitionStart - 1;
        swaps++;
        swap(array, start, pivot);
        return pivot;
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
