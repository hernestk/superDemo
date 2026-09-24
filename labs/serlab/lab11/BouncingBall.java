// SER120L - Lab 11
// Hernest Koroli
package lab11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

public class BouncingBall extends JPanel implements ActionListener {

    private static final long serialVersionUID = -7910963351334026459L;

    Image ball;
    int xPosition = 100;
    int yPosition = 100;
    int xSpeed = 1;
    int ySpeed = 1;
    Timer timer;

    public BouncingBall() {
    	try {
            File ballFile = new File("dvd.png");
            if(!ballFile.exists()) {
                throw new FileNotFoundException("Image file not found");
            } else {
                ball = new ImageIcon(ballFile.getPath()).getImage();
            }

            if(ball == null) {
                throw new Exception("Image failed to load");
            } else {
                System.out.println("Image loaded successfully");
            }
        } catch(Exception e) {
            e.getMessage();
        }
    	//TODO Update 
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(ball, xPosition, yPosition, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//TODO Update 
        xPosition += xSpeed;
        yPosition += ySpeed;

        int width = ball.getWidth(this);
        int height = ball.getHeight(this);

        // horizontal
        if(xPosition <= 0 || (xPosition + width) >= getWidth()) {
            xSpeed = -xSpeed;
        }

        // vertical
        if(yPosition <= 0 || (yPosition + height) >= getHeight()) {
            ySpeed = -ySpeed;
        }
        repaint();
    }

    public static void main(String[] args) {

    	SwingUtilities.invokeLater(new Runnable() {
    	    @Override
    	    public void run() {

    	        JFrame frame = new JFrame("Baller Program");
                

    	        BouncingBall bouncingballpanel = new BouncingBall();
    	        bouncingballpanel.setBackground(Color.BLACK);
    	        
    	        frame.add(bouncingballpanel);
    	        frame.setSize(800, 600);
    	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        frame.setLocationRelativeTo(null);
    	        frame.setVisible(true);
                frame.setResizable(false);
            }
    	});
    }
}
