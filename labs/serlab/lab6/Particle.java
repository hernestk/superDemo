// SER120L - Lab 6
// Hernest Koroli
package lab6;

import java.awt.Graphics2D;
import java.awt.Color;

public class Particle implements Animatable {
    private double xPosition, yPosition, xVelocity, yVelocity;
    private int heightOnScreen = 100;
    private int size;
    private Color color;
    
    public Particle(double xPosition, double yPosition, double angle, double speed) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        xVelocity = Math.cos(angle) * speed;
        yVelocity = Math.sin(angle) * speed;
        size = (int) (Math.random() * 6) + 4;
        color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    public void update() {
        xPosition += xVelocity;
        yPosition += yVelocity;
        yVelocity += 0.2;
        heightOnScreen -= 1;
    }

    public boolean isOffScreen() {
        if(heightOnScreen <= 0) {
            return true;
        }
        return false;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) xPosition, (int) yPosition, size, size);
    }
}
