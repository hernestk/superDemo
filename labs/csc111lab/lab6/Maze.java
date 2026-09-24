// CSC111L - Lab 6
// Hernest Koroli
package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    private int width; // for columns (left to right)
    private int height; // for rows (top to bottom)
    private char[][] mazeData;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        mazeData = new char[height][width];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                mazeData[i][j] = ' '; // adds a space
            }
        }
    }

    public Maze(char[][] userMaze) {
        width = userMaze.length;
        height = userMaze[0].length;
        mazeData = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                mazeData[i][j] = userMaze[i][j];
            }
        }
    }

    public Maze(File file) throws FileNotFoundException {
        try(Scanner input = new Scanner(file)) {
            width = input.nextInt();
            height = input.nextInt();
            mazeData = new char[height][width];
            input.nextLine();
            
            for (int i = 0; i < height; i++) {
                String line = input.nextLine();
                for (int j = 0; j < width; j++) {
                    mazeData[i][j] = line.charAt(j);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        }
    }

    
    // checks if the x and y are in the 2D array indices
    public boolean inBounds(int x, int y) {
        boolean inBounds = true;
        if(x <= getHeight() - 1 && x > -1) {
            if(y <= getWidth() - 1 && y > -1) {
                return inBounds;
            }
        }
        inBounds = false;
        return inBounds;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getChar(int x, int y) {
        return mazeData[x][y];
    }

    public void setChar(int x, int y, char newChar) {
         mazeData[x][y] = newChar;
    }

    public String toString() {
        String stringMaze = "";

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                stringMaze += Character.toString(mazeData[i][j]);
            }
            stringMaze += "\n";
        }
        
        return stringMaze;
    }
}
