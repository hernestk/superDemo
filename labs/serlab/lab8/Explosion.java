package lab8;
// SER120L - Lab 8
// Hernest Koroli

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Explosion implements Animatable {
    protected ArrayList<Particle> particles = new ArrayList<>();

    public Explosion(double xPosition, double yPosition) {
        generateParticles(xPosition, yPosition);
    }

    abstract void generateParticles(double xPosition, double yPosition);

    public void update() {
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle particle = it.next();
            particle.update();

            if(particle.isOffScreen()) {
                it.remove();
            }
        }
    }

    public void draw(Graphics2D graphics) {
        for(Particle particle : particles) {
            particle.draw(graphics);
        }
    }

    public boolean isOffScreen() {
        if(particles.isEmpty()) {
            return true;
        }
        return false;
    }
}
