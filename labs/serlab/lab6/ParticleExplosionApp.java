// SER120L - Lab 6
// Hernest Koroli
package lab6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ParticleExplosionApp extends JPanel implements MouseListener {

	private static final long serialVersionUID = 3543142096791169728L;
	
	private ArrayList<Animatable> objects = new ArrayList<>();

    public ParticleExplosionApp() {
    	//Set the background color to another color
        setBackground(Color.blue);
        addMouseListener(this);

        Timer timer = new Timer(16, e -> {
             update();
             repaint();
        });

        timer.start();
    }
    private void update() {
        Iterator<Animatable> it = objects.iterator();
        while (it.hasNext()) {
            Animatable obj = it.next();
            obj.update();
            if (obj.isOffScreen()) it.remove();
        }
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        for (Animatable obj : objects) {
            obj.draw(graphics2D);
        }
    }

    public void mouseClicked(MouseEvent e) {
        objects.add(new Explosion(e.getX(), e.getY()));
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
    	//Rename the jframe
        JFrame frame = new JFrame("The Majestic Particle Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setContentPane(new ParticleExplosionApp());
        frame.setVisible(true);
    }
}