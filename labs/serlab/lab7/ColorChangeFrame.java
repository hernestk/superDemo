// SER120l - Lab 7
// Hernest Koroli
package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangeFrame {
	
	// Add private variables
	private JFrame frame;
    private int clickCount;
    private JLabel clickLabel;
    private JPanel mainPanel;
    private JPanel clickCountPanel;
    private Color newColor;

    public ColorChangeFrame(String frameTitle, int frameWidth, int frameHeight) {

    	//Set clickCount equal to 0
        clickCount = 0;
    	// Set the frame equal to a new JFrame and argument frameTitle
    	// Set the frame width and frame height using the frame's setSize method and arguments frameWidth and frameHeight
        frame = new JFrame(frameTitle);
        frame.setSize(frameWidth, frameHeight);
        
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Use the frame's setLayout method and pass in a new GridBagLayout()
        frame.setLayout(new GridBagLayout());
        

        // Main center panel (holds button and label)
        // Set mainPanel equal to a new JPanel
        mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false); // Allows background color changes

        // Create button
        // create a new JButton called button and set to a new JButton with the 
        // argument being the words you want on the button

        JButton button = new JButton("Click here to change the background!");

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Click label
        clickLabel = new JLabel("Clicks: 0", SwingConstants.CENTER);
        clickLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // White background panel for click count
        // Set clickCountPanel equal to a new JPanel
        // Then use the clickCountPanel's setBackground method and add an argument of Color.WHITE
        clickCountPanel = new JPanel();
        clickCountPanel.setBackground(Color.WHITE);
        clickCountPanel.setMaximumSize(new Dimension(150, 40));
        clickCountPanel.add(clickLabel);

        // Adds components with spacing
        // Add the button to the mainPanel
        mainPanel.add(button);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
        
        // Add the clickCountPanel to the mainPanel
        mainPanel.add(clickCountPanel);
        // Add the mainPanel to the frame
        frame.add(mainPanel);
        addButtonListener(button);
        frame.setVisible(true);
    }

    private void addButtonListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call changeBackgroundColor
                changeBackgroundColor();
            }
        });
    }

    private void changeBackgroundColor() {
        // Set newColor equal to a new random color 
        newColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    	
        frame.getContentPane().setBackground(newColor);
        
        // Up the clickCount by 1
        clickCount++;
 
        clickLabel.setText("Clicks: " + clickCount);
    }

    public static void main(String[] args) {
    	new ColorChangeFrame("Click Away!!", 500, 500);
    }
}
