package lab8;
// CSC111L - Lab 8
// Hernest Koroli

public class SortMethods {
    // swap
    public static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Insertion Sort O(n^2)
    public static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String key = array[i];
            
            int j = i - 1;
            while(j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Bubble Sort O(n^2)
    public static void bubbleSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if(array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public static void printArrayGrouped(String[] array) {
    	// < 0 = comes before
        // > 0 = comes after
        for (int i = 1; i < array.length; i++) {
            if(array[i - 1].compareTo(array[i]) < 0) {
                System.out.print(array[i - 1] + " ");
                System.out.println();
                if(i == array.length - 1) {
                    System.out.print(array[i] + " ");
                    System.out.println();
                }
            }

            if(array[i - 1].compareTo(array[i]) == 0) {
               System.out.print(array[i - 1] + " ");
               if(i == array.length - 1) {
                    System.out.print(array[i]);
               }
            }
        }
        System.out.println();
    }

    //Print array
    public static void printArray(String[] array) {	
        for(String word : array) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
    
    //Main method
    public static void main(String[] args) {
        String[] favColors = {
                "blue", "blue", "navy","navy blue","red", "purple", "blue",
                "green", "purple", "blue", "forrest green", "blue", "green",
                "blue", "blue", "green", "red", "green", "blue", "red", "blue",
                "dark green","blue", "yellow", "purple", "purple", "blue",
                "green", "blue", "dark blue", "blue","green", "blue", "red",
                "green", "blue", "magenta","blue", "red", "green", "purple",
                "blue", "sky blue", "indigo", "yellow", "orange", "black"
        };

        insertionSort(favColors);
        System.out.println("Sorted Colors:");
        printArrayGrouped(favColors);
        
        String[] animals = {"dog", "alligator","frog", "cat", "horse", 
        					"bear", "tiger", "dragon", "wolf", "giraffe", 
        					"koala", "sloth", "ferret", "sheep"};
        
        System.out.println("\nUnsorted Animals:");
        printArray(animals);
        
        bubbleSort(animals);
        
        System.out.println("\nSorted Animals:");
        printArray(animals); 
        
    }
    
}