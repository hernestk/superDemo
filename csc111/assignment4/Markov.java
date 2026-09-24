package assignment4;
import java.util.LinkedList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Markov {
    public static void main(String[] args) {
        // list of tokens that can begin a section of text
        LinkedList<String> startTokens = new LinkedList<>();

        // table mapping each token to a list of tokens that can follow it
        // you may want to try different sizes to see what difference they make
        Hash<String> hashFunction = Markov::hashFunction;
        HashTable<String, LinkedList<String>> table = new HashTable<>(hashFunction, 10_000);

        // build the table and start list
        for (String filename : args) {
            try {
                String fileText = Files.readString(Path.of(filename));
                processFile(fileText, table, startTokens);
            } catch (IOException e) {
                System.out.println("File could not be found.");
            }
        }

        // generate new text
        // to prevent excessively long text, we can cut it off after it exceeds some
        // max length (set this to whatever value you want)
        final int MAX_LENGTH = 100;

        // TODO: choose a random start token
        String token = startTokens.get((int) (Math.random() * startTokens.size()));
        String generatedText = "";

        // loop until we reach the max length or a null next token
        for (int i = 0; i < MAX_LENGTH && token != null; i++) {
            // TODO: add token to the generated text
            generatedText += token + " ";
            // TODO: get the list of next tokens for token
            LinkedList<String> nextTokenList = table.get(token);
            // TODO: get a new random token from the list
            token = nextTokenList.get((int) (Math.random() * nextTokenList.size()));
        }

        System.out.println("##################");
        System.out.println("# Generated Text #");
        System.out.println("##################");
        System.out.println(generatedText);
    }

    static int hashFunction(String s) {
        // decide on how to hash the string ypurself.
        // big switch statemnt inside of a for loop
        int hashValue = 0;

        for (int i = 0; i < s.length(); i++) {
            hashValue += s.charAt(i);
        }
        
        return hashValue;
    }

    // the functions below are a suggested structure, but you can organize this
    // however you want

    static void processFile(
            String fileText,
            HashTable<String, LinkedList<String>> table,
            LinkedList<String> startTokens) {

        String[] sections = fileText.split("\\s*\n\\s*\n\\s*");

        for (String section : sections) {
            processSection(section, table, startTokens);
        }
    }

    static void processSection(
            String sectionText,
                      // key value
            HashTable<String, LinkedList<String>> table,
            LinkedList<String> startTokens) {
        // TODO: split into tokens; see Regex.java
        String[] tokens = sectionText.split("\\s+");

        // TODO: add first token to the start list
        startTokens.add(0, tokens[0]);

        for (int i = 1; i < tokens.length; i++) {
            // descriptive variable names to make the rest of our code clearer
            String currentToken = tokens[i - 1];
            String nextToken = tokens[i];

            // TODO: if currentToken isn't in the table, make a new entry
            if (table.get(currentToken) == null) {
                // currentToken isn't in the table, so add it with an empty list
                table.set(currentToken, new LinkedList<>());
            }
            // TODO: get the list for currentToken from the table
            LinkedList<String> nextTokenList = table.get(currentToken);

            // TODO: add nextToken to the list
            nextTokenList.add(nextToken);
        }

        // descriptive variable name to make the following code clearer
        String lastToken = tokens[tokens.length - 1];

        // TODO: if lastToken isn't in the table, make a new entry
        if(table.get(lastToken) == null) {
            table.set(lastToken, new LinkedList<>());
        }
        // TODO: get the list for lastToken
        LinkedList<String> nextTokenList = table.get(lastToken);
        // TODO: add null to the list
        nextTokenList.add(null);
    }
}