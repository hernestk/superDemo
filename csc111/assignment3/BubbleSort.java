// package assignment3;

public class BubbleSort {
    private int comparisons;
    private int swaps;

    /*
    My sort method deviates from your pseudocode for bubble sort.
    My method just goes through the array starting at start + 1.
    My sort method works by checking the start index and the one before it.
    If start was 0 without increasing it then an ArrayOutOfBoundsException would
    be thrown.
    It goes up to what the user specified to end the sorting algorithim

    The index still gets checked when a user puts 0 when it's actually 1
    because the other number compared has to be i - 1 or j - 1

    This shouldn't be too complex considering I've written similar code for
    one of my csc labs dedicated to sorting algorithms
    Bubble Sort feels intuitive to write for me personally.
    I don't have to copy my csc lab code because it's easy to remember

    -Hernest K, CSC 111 Section 2
     */

    public void sort(int[] array, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            for (int j = start + 1; j < end; j++) {
                comparisons++;
                if(array[j - 1] > array[j]) {
                    swaps++;
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
