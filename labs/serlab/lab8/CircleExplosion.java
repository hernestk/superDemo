package lab8;
// SER120L - Lab 8
// Hernest Koroli

public class CircleExplosion extends Explosion {
    public CircleExplosion(double xPosition, double yPosition) {
        super(xPosition, yPosition);
    }

    protected void generateParticles(double xPosition, double yPosition) {
        for (int i = 0; i < (int) (Math.random() * 100) + 50; i++) {
            double angle =  (Math.random() * 2) * Math.PI;
            double speed = 5;
            Particle generatedParticle = new Particle(xPosition, yPosition, angle, speed, false);
            particles.add(generatedParticle);
        }
        System.out.println("CIRCLE!"); // added this extra line to tell you what's generated.
    }
}
