import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOfLife extends JFrame {

    public GameOfLife() {
        setTitle("Conway's Game of Life - The Illusion of Movement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GridPanel gridPanel = new GridPanel(80, 60, 10); // 80x60 grid, 10px per cell
        add(gridPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameOfLife().setVisible(true);
        });
    }
}

class GridPanel extends JPanel implements ActionListener {
    private final int rows;
    private final int cols;
    private final int cellSize;
    
    // Notice: No "Cell" objects. Just a raw 2D array of booleans representing state.
    private boolean[][] currentState;
    private final Timer timer;

    public GridPanel(int cols, int rows, int cellSize) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        this.currentState = new boolean[cols][rows];

        setPreferredSize(new Dimension(cols * cellSize, rows * cellSize));
        setBackground(Color.BLACK);

        // Allow users to click and drag to "draw" life before starting
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { toggleCell(e); }
            @Override
            public void mouseDragged(MouseEvent e) { toggleCell(e); }
        };
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);

        // The Global Clock: Updates the entire universe synchronously every 100ms
        timer = new Timer(100, this);
        
        // Press SPACE to start/pause, C to clear
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (timer.isRunning()) timer.stop();
                    else timer.start();
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    currentState = new boolean[cols][rows];
                    repaint();
                }
            }
        });
    }

    private void toggleCell(MouseEvent e) {
        int x = e.getX() / cellSize;
        int y = e.getY() / cellSize;
        if (x >= 0 && x < cols && y >= 0 && y < rows) {
            currentState[x][y] = true;
            repaint();
        }
    }

    // This is the "Tick" - The mathematical function mapping time t to time t+1
    @Override
    public void actionPerformed(ActionEvent e) {
        // Crucial: We do not mutate currentState in place. 
        // We create a brand new matrix for the next generation.
        boolean[][] nextState = new boolean[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                int aliveNeighbors = countAliveNeighbors(x, y);

                // The Global Rules of the Universe applied to a stationary cell
                if (currentState[x][y]) {
                    // Underpopulation or Overpopulation causes death
                    nextState[x][y] = (aliveNeighbors == 2 || aliveNeighbors == 3);
                } else {
                    // Reproduction causes birth
                    nextState[x][y] = (aliveNeighbors == 3);
                }
            }
        }

        // Swap the old universe for the new universe
        currentState = nextState;
        repaint();
    }

    private int countAliveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the cell itself

                int col = x + i;
                int row = y + j;

                // Check boundaries to avoid ArrayOutOfBounds
                if (col >= 0 && col < cols && row >= 0 && row < rows) {
                    if (currentState[col][row]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        
        // Drawing the static grid locations that happen to be "alive"
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (currentState[x][y]) {
                    g.fillRect(x * cellSize, y * cellSize, cellSize - 1, cellSize - 1);
                }
            }
        }
    }
}
