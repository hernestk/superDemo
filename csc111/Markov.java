import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Markov {
    public static void main(String[] args) {
        Hash<String> hashFunction = Markov::hash;
        LinkedList<String> startTokens;
        HashTable<String, LinkedList<String>> table = new HashTable<>(hashFunction, 10_000);

        // TODO: read and process each file



        // read file
        // String text;
        // try {
        //     text = Files.readString(Path.of("sample.txt"));
        // } catch (IOException e) {
        //     return;
        // }
        // // split into "paragraphs"
        // String[] paragraphs = text.split("\\s*\n\\s*\n\\s*");
        // // print each paragraph

        // for (int i = 0; i < paragraphs.length; i++) {
        //     String[] tokens = paragraphs[i].split("\\s+");
        //     System.out.println("# Paragraph: " + (i + 1) + " | " + tokens.length + " tokens");
        //     System.out.println(paragraphs[i]);
        //     System.out.println();
        // }
    }

    static int hash(String s) {
        // TODO: put your hash function here
        return 0;
    }

    static void processFile(
        String fileText,
        HashTable<String, LinkedList<String>> table,
        LinkedList<String> startTokens) {
            String[] sections; // = ???
        }

    // NOTE: break up the program however you want, these functions are only 
    // my suggestion for a structure
}
