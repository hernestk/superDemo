// package assignment3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Hernest Koroli (CSC111 Section 2)
 */

public class SortingExperiment {
    public static void main(String[] args) {
        SortHelper.setSeed(10000);
        // arrays to store our data
        int[] bubbleComps = new int[5];
        int[] bubbleSwaps = new int[5];

        int[] selectComps = new int[5];
        int[] selectSwaps = new int[5];

        int[] insertComps = new int[5];
        int[] insertSwaps = new int[5];

        int[] mergeComps = new int[5];
        int[] mergeSwaps = new int[5];

        int[] quickComps = new int[5];
        int[] quickSwaps = new int[5];
        
        // run the experiment
        for (int i = 0; i < 5; i++) {
            int length = (i + 1) * 50_000;

            int[] bubbleArray = SortHelper.randomArray(length);
            int[] selectArray = SortHelper.randomArray(length);
            int[] insertArray = SortHelper.randomArray(length);
            int[] mergeArray = SortHelper.randomArray(length);
            int[] quickArray = SortHelper.randomArray(length);

            BubbleSort bubble = new BubbleSort();
            SelectionSort select = new SelectionSort();
            InsertionSort insert = new InsertionSort();
            Mergesort merge = new Mergesort();
            Quicksort quick = new Quicksort();
        
            // feel free to check the 10,000 if you'd like
            // the numbers in the csv are a result of end being 50,000
            bubble.sort(bubbleArray, 0, 10000);
            select.sort(selectArray, 0, 50000);
            insert.sort(insertArray, 0, 50000);
            merge.sort(mergeArray, 0, 50000);
            quick.sort(quickArray, 0, 50000);

            // record results
            bubbleComps[i] = bubble.getComparisons();
            selectComps[i] = select.getComparisons();
            insertComps[i] = insert.getComparisons();
            mergeComps[i] = merge.getComparisons();
            quickComps[i] = quick.getSwaps();
            
            // don't forget swaps!
            bubbleSwaps[i] = bubble.getSwaps();
            selectSwaps[i] = select.getSwaps();
            insertSwaps[i] = insert.getSwaps();
            mergeSwaps[i] = merge.getSwaps();
            quickSwaps[i] = quick.getSwaps();
        }

        try (PrintWriter pw = new PrintWriter(new File("data.csv"))) {
            printData(pw, "bubble", bubbleComps, bubbleSwaps);
            printData(pw, "selection", selectComps, selectSwaps);
            printData(pw, "insertion", insertComps, insertSwaps);
            printData(pw, "mergesort", mergeComps, mergeSwaps);
            printData(pw, "quicksort", quickComps, quickSwaps);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE COULD NOT BE FOUND");
        }
    }

    

    // You could just copy-paste the print code a bunch of times in the try
    // block, but a function like this will make it less tedious.
    static void printData(PrintWriter pw, String name, int[] comparisons, int[] swaps) {
        pw.println(name + ",,,,,,");
        pw.print("comparisons,");
        for (int i : comparisons) {
            pw.print(i + ",");
        }
        pw.println();
        // print swaps
        pw.print("swaps,");
        for(int i : swaps) {
            pw.print(i + ",");
        }
        pw.println();
    }
}
