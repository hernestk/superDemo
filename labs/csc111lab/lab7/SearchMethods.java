// CSC111L - Lab 7
// Hernest Koroli
package lab7;

public class SearchMethods {
    public static void main(String[] args) {
        int[] myNums = {2, 4, 9, 19, 32, 43, 59, 60, 78, 99};
        int[] otherNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};

        System.out.println("Test Array 1");
        for (int i = 0; i < myNums.length; i++) {
            if(i < myNums.length - 1) {
                System.out.print(myNums[i] + ", ");
            } else {
                System.out.print(myNums[i]);
                System.out.println("\n");
            }
        }

        linearSearch(myNums, 43);
        linearSearch(myNums, 80);
        binarySearch(myNums, 9);
        binarySearch(myNums, 80); // log2(10) --> 3.32 is close to 4 search attempts done

        System.out.println("Test Array 2");
        for (int i = 0; i < otherNums.length; i++) {
            if(i < otherNums.length - 1) {
                System.out.print(otherNums[i] + ", ");
            } else {
                System.out.print(otherNums[i]);
                System.out.println("\n");
            }
        }

        // output will differ since my array length is 30. Your array cuts off in your screenshot.
        linearSearch(otherNums, 43);
        linearSearch(otherNums, 80);
        binarySearch(otherNums, 9);
        binarySearch(otherNums, 80); // log2(30) --> 4.91 is close to 5 search attempts
        
    }

    public static boolean linearSearch(int[] array, int numToFind) {
        int comparisons = 0;

        System.out.println("Linear search for " + numToFind);
        for (int i = 0; i < array.length; i++) {
            comparisons++;
            if(array[i] == numToFind) {
                System.out.println("Found\nComparisons = " + comparisons);
                System.out.println();
                return true;
            }
        }
        System.out.println("Not found\nComparisons = " + comparisons);
        System.out.println();
        return false;
    }

    // COPY THIS ALGORITHM BELOW
    public static boolean binarySearch(int[] array, int numToFind) {
        int comparisons = 0;
        int min = 0;
        int max = array.length - 1;

        System.out.println("Binary search for " + numToFind);
        while(min <= max) {
            int mid = (min + max) / 2;

            comparisons++;
            if(numToFind == array[mid]) {
                System.out.println("Found\nComparisons = " + comparisons);
                System.out.println();
                return true;
            }
            
            else if(numToFind < array[mid]) {
                max = mid - 1;
            }

            else if(numToFind > array[mid]) {
                min = mid + 1;
            }

        }
        System.out.println("Not found\nComparisons = " + comparisons + "\n");
        return false;
    }
}

// The difference between linear and binary search
// A linear search is way less efficient as each index has to get checked.
// You just make an if statement to check if that index value
// equals the target. It's easy to implement without much thinking.
// Best case: the first index is the target
// Average case: target is found around the middle of the array
// Worst case: the target is in the last index or not found
// Imagine a billion elements in an array and using a linear search method
// The method can perform up to a billion if statements to check if an index value equals the target value

// A binary search is more efficient as you start in the middle of an array.
// Check if the target is in the middle and return true
// If it is not and the value is either greater or less than mid...
// you get rid of the left side (when greater) or right side (when less)
// you start in the middle of that new positon of mid.
// you keep getting rid of half of the array till target is found or doesnt exist assuming the array is sorted
// Best case: target is in the middle
// Worst case log2(n) where n is the amount of elements/indices in the array