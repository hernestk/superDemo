package assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// this program uses our hash table to track word counts for whatever text files
// we feed to it while timing the construction and then querying of the hash
// table
//
// this can be used to compare different hash table implementations and
// different hash functions
//
// note that the program prints a progress tracker, which it has to check every
// word, adding some additional work while we time the hash table

public class WordCount {
    public static void main(String[] args) {
        // functional interface, covered during class and also shown in SortTest
        Hash<String> hashFunction = WordCount::hash;
        HashTable<String, Integer> wordCounts = new HashTable<>(hashFunction, 10_000);

        System.out.println("Loading files...");
        // read files and create arrays before starting the timer
        // we only want to time the construction and querying of the hash table
        // also note that each file's contents will be loaded into a separate array
        String[][] wordArrays = new String[args.length][];
        int size = 0;
        for (int i = 0; i < args.length; i++) {
            try {
                wordArrays[i] = Files.readString(Path.of(args[i])).split("\\s+");
                size += wordArrays[i].length;
            } catch (IOException e) {
                System.err.println("Error reading " + args[i] + ".");
                wordArrays[i] = new String[0];
            }
        }
        System.out.println("Done loading files!");
        System.out.println("Loaded " + size + " words.");

        int i = 0, percent = 0;
        System.out.printf("Constructing hash table... %2d%%", percent);
        long startCons = System.nanoTime();
        for (String[] words : wordArrays) {
            for (String word : words) {
                Integer count = wordCounts.get(word);
                if (count == null) {
                    count = 0;
                }
                count++;
                wordCounts.set(word, count);
                i++;
                if (i * 100 / size > percent) {
                    percent++;
                    System.out.printf("\rConstructing hash table... %2d%%", percent);
                }
            }
        }
        long endCons = System.nanoTime();
        System.out.println("\rConstructing hash table... done!");

        long sum = 0;
        i = 0;
        percent = 0;
        // this sums squared word counts because if a word appeared 10 times,
        // then its count will be added to the sum 10 times
        System.out.printf("Summing squared word counts... %2d%%", percent);
        long startSum = System.nanoTime();
        for (String[] words : wordArrays) {
            for (String word : words) {
                sum += wordCounts.get(word);
                i++;
                if (i * 100 / size > percent) {
                    percent++;
                    System.out.printf("\rSumming squared word counts... %2d%%", percent);
                }
            }
        }
        long endSum = System.nanoTime();
        System.out.println("\rSumming squared word counts... done! sum = " + sum);

        long timeCons = endCons - startCons;
        long timeSum = endSum - startSum;
        System.out.printf(
                "Construction took: %6d.%06d ms.\n", timeCons / 1_000_000, timeCons % 1_000_000);
        System.out.printf(
                "Summation took:    %6d.%06d ms.\n", timeSum / 1_000_000, timeSum % 1_000_000);
    }

    public static int hash(String s) {
        // TODO: put your hash function here
        // NOTE: a hash function that just returns 0 will effectively turn the table
        // into a linked list that looks up elements with a linear search, providing
        // a good baseline to demonstrate how much faster a real hash table is.
        return 0;
    }
}
