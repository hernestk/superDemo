// SER120L - Lab 6
// Hernest Koroli
package lab6;

import java.awt.Graphics2D;

public interface Animatable {
    public void update();
    public void draw(Graphics2D graphics);
    public boolean isOffScreen();
}
