import java.io.File;
import java.io.FileNotFoundException;

public class MazeSolver {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        try {
            Maze maze = new Maze(new File(args[0]));
            System.out.println(maze.toString());
            System.out.printf("X: %d Y: %d\n", x, y);
            boolean mazeSolved = solveMaze(maze, x, y);

            if(mazeSolved) {
                System.out.println("The maze was solved");
            } else {
                System.out.println("A path couldn't be found");
            }
            maze.set(MazeConstants.START, x, y);
            System.out.println(maze.toString());
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FILE NOT FOUND");
        }
    }

    public static boolean solveMaze(Maze m, int x, int y) {
        
        if(!m.inBounds(x, y)) {
            return true;
        }

        if(m.get(x, y) != MazeConstants.EMPTY) {
            return false; 
        }
        // start of recursive case
        m.set(MazeConstants.VISITED, x, y);
        
        // (x - 1, y), (x + 1, y), (x, y - 1), and (x, y + 1)
        if(solveMaze(m, x - 1, y)) {
            m.set(MazeConstants.PATH, x, y);
            return true;
        } else if (solveMaze(m, x + 1, y)) {
            m.set(MazeConstants.PATH, x, y);
            return true;
        } else if (solveMaze(m, x, y - 1)) {
            m.set(MazeConstants.PATH, x, y);
            return true; 
        } else if(solveMaze(m, x, y + 1)){
            m.set(MazeConstants.PATH, x, y);
            return true;
        }

        return false;
    }
}
