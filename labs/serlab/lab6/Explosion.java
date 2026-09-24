// SER120L - Lab 6
// Hernest Koroli
package lab6;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

public class Explosion implements Animatable {
    private ArrayList<Particle> particles = new ArrayList<>();

    public Explosion(double xPosition, double yPosition) {
        generateParticles(xPosition, yPosition);
    }

    public void generateParticles(double xPosition, double yPosition) {
        for (int i = 0; i < (int) (Math.random() * 100) + 50; i++) {
            double angle = ((Math.random() * 100) + 50) * 2 * Math.PI;
            double speed = (Math.random() * 8) + 1;
            Particle generatedParticle = new Particle(xPosition, yPosition, angle, speed);
            particles.add(generatedParticle);
        }
    }

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

    public boolean isOffScreen() {
        if(particles.isEmpty()) {
            return true;
        }
        return false;
    }

    public void draw(Graphics2D graphics) {
        for(Particle particle : particles) {
            particle.draw(graphics);
        }
    }
}
