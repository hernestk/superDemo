// Hernest Koroli
// SER120L - Lab 12
package lab12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DraggableImage extends JPanel {
	private static final long serialVersionUID = -8645634744350993870L;
	
	private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;

    private Image piece;
    private int pieceXPosition = 0;
    private int pieceYPosition = 0;
    private int dragOffsetX;
    private int dragOffsetY;
    private int mouseX;
    private int mouseY;
    boolean dragging = false;

    public DraggableImage() {
    	setPreferredSize(new Dimension(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE));
    	  
        piece = new ImageIcon("triangle.png").getImage();

        MouseAdapter mouseHandler = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
            	//TODO create int pressedXPosition and set equal to the piece X position(class variable) multiplied by TILE_SIZE
            	int pressedXPosition = pieceXPosition * TILE_SIZE;
            	
            	//TODO create int pressedYPosition and set equal to the piece Y position(class variable) multiplied by TILE_SIZE
            	int pressedYPosition = pieceYPosition * TILE_SIZE;

                if (e.getX() >= pressedXPosition && e.getX() <= pressedXPosition + TILE_SIZE &&
                    e.getY() >= pressedYPosition && e.getY() <= pressedYPosition + TILE_SIZE) {

                	//TODO set dragging equal to true
                	dragging = true;
                	//TODO set the x drag offset equal to e.getX() minus the x pressed position
                	dragOffsetX = e.getX() - pressedXPosition;
                	//TODO set the y drag offset equal to e.getY() minus the y pressed position
                    dragOffsetY = e.getY() - pressedYPosition;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            	/* TODO if dragging is true
            	 * 		set mouse X position equal to e(event)'s getX method
            	 * 		set mouse Y position equal to e(event)'s getY method
            	 * 		call method repaint
            	 */

                if(dragging) {
                    mouseX = e.getX();
                    mouseY = e.getY();
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (dragging) {
                    // Snap to nearest tile
                    int newGridX = (e.getX() - dragOffsetX + TILE_SIZE / 2) / TILE_SIZE;
                    int newGridY = (e.getY() - dragOffsetY + TILE_SIZE / 2) / TILE_SIZE;
                    
                    //prevent piece from going offscreen
                    pieceXPosition = Math.max(0, Math.min(BOARD_SIZE - 1, newGridX));
                    pieceYPosition = Math.max(0, Math.min(BOARD_SIZE - 1, newGridY));
                    
                    //TODO set dragging equal to false
                    dragging = false;
                    //TODO call repaint
                    repaint();
                }
            }
        };

      //TODO add mouseHandler to the class using the addMouseListener method
        addMouseListener(mouseHandler);
      //TODO add mouseHandler to the class using the addMouseMotionListener method
        addMouseMotionListener(mouseHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draws chessboard
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        // Determines where to draw the image
        int drawX, drawY;

        /* TODO
         * If dragging is true
         * 		set drawX equal to the mouse X position minus the X drag offset
         * 		set drawY equal to the mouse Y position minus the Y drag offset
         * Else
         * 		set drawX equal to the piece X position multiplied by the TILE_SIZE
         * 		set drawY equal to the piece Y position multiplied by the TILE_SIZE
         */

        if(dragging) {
            drawX = mouseX - dragOffsetX;
            drawY = mouseY - dragOffsetY;
        } else {
            drawX = pieceXPosition * TILE_SIZE;
            drawY = pieceYPosition * TILE_SIZE;
        }
        // Draws the image scaled to fit the tile
        g.drawImage(piece, drawX, drawY, TILE_SIZE, TILE_SIZE, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
    	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //TODO add a new instance of DraggableImage to the frame
        DraggableImage interactiveImage = new DraggableImage();
        frame.add(interactiveImage);
        //TODO call frame's pack method
        frame.pack();

        frame.setLocationRelativeTo(null);
        
        //TODO set the frame's visibility to be true
        frame.setVisible(true);
    }
}