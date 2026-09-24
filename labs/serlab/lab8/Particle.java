package lab8;
// SER120L - Lab 8
// Hernest Koroli

import java.awt.Graphics2D;
import java.awt.Color;

public class Particle implements Animatable {
    private double xPosition, yPosition, xVelocity, yVelocity;
    private int heightOnScreen = 100;
    private int size;
    private Color color;
    private boolean useGravity;
    
    public Particle(double xPosition, double yPosition, double angle, double speed, boolean useGravity) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        xVelocity = Math.cos(angle) * speed;
        yVelocity = Math.sin(angle) * speed;
        size = (int) (Math.random() * 6) + 4;
        color = new Color((int) (Math.random() * 255) + 1, (int) (Math.random() * 255) + 1, (int) (Math.random() * 255) + 1);
        this.useGravity = useGravity;
    }

    public void update() {
        xPosition += xVelocity;
        yPosition += yVelocity;
        if(useGravity) {
            yVelocity += 0.2;
        }
            
        heightOnScreen -= 1;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) xPosition, (int) yPosition, size, size);
    }

    public boolean isOffScreen() {
        if(heightOnScreen <= 0) {
            return true;
        }
        return false;
    }
}
