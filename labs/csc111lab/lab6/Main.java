// CSC111L - Lab 6
// Hernest Koroli
package lab6;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Testing File Constructor...");
        System.out.println("");

        try {
            File file = new File("myMaze.txt");
            Maze maze = new Maze(file);

            for (int i = 0; i < maze.getHeight(); i++) {
                for (int j = 0; j < maze.getWidth(); j++) {
                    System.out.print(maze.getChar(i, j));
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND.");
        }
        
    }
}