// package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    private char[][] mazeData;
    private int width;
    private int height; 

    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        mazeData = new char[height][width];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                mazeData[y][x] = ' ';
            }
        }
    }

    public Maze(char[][] userMaze) {
        height = userMaze[0].length;
        width = userMaze.length;

        mazeData = new char[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mazeData[y][x] = userMaze[x][y];
            }
        }
    }

    public Maze(File file) throws FileNotFoundException {
        try(Scanner input = new Scanner(file)) {
            width = input.nextInt();
            height = input.nextInt();
            mazeData = new char[height][width];
            input.nextLine();
            
            for (int y = 0; y < height; y++) {
                String line = input.nextLine();
                for (int x = 0; x < width; x++) {
                    mazeData[y][x] = line.charAt(x);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        }
    }

    // checked
    public boolean inBounds(int x, int y) {
        if(x < getWidth() && x > -1) {
            if(y < getHeight() && y > -1) {
                return true;
            }
        }
        return false;
    }

    public char get(int x, int y) {
        return mazeData[y][x];
    }

    public void set(char newChar, int x, int y) {
        this.mazeData[y][x] = newChar;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public String toString() {
        String stringMaze = "";

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                stringMaze += Character.toString(mazeData[y][x]);
            }
            stringMaze += "\n";
        }
        return stringMaze;
    }
}
