// package assignment3;

public class Mergesort {
    private int comparisons;
    private int swaps;
    
    public void sort(int[] array, int start, int end) {
        if(end - start < 2) {
            return;
        }

        sort(array, start, (start + end) / 2);
        sort(array, (start + end) / 2, end);
        merge(array, start, end);
    }

    public void merge(int[] array, int start, int end) {
        int[] mergeArray = new int[end - start];
        int mid = (start + end) / 2;
        int index1 = start;
        int end1 = mid;
        int index2 = mid;
        int end2 = end;

        for (int i = 0; i < mergeArray.length; i++) {
            comparisons++;
            if(index1 < end1 && index2 < end2) {
                comparisons++;
                if(array[index2] < array[index1]) {
                    swaps++;
                    mergeArray[i] = array[index2];
                    index2++;
                } else {
                    swaps++;
                    mergeArray[i] = array[index1];
                    index1++;
                }
                comparisons++;
            } else if (index1 < end1) {
                    swaps++;
                    mergeArray[i] = array[index1];
                    index1++;
            } else {
                    swaps++;
                    mergeArray[i] = array[index2];
                    index2++;
            }
        }
        
        for (int i = 0; i < mergeArray.length; i++) {
            swaps++;
            array[start + i] = mergeArray[i];
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
