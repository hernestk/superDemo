package lab8;
// SER120L - Lab 8
// Hernest Koroli

public class LineExplosion extends Explosion {
    public LineExplosion(double xPosition, double yPosition) {
        super(xPosition, yPosition);
    }

    protected void generateParticles(double xPosition, double yPosition) {
        double[] randomNumbers = {0, Math.PI};
        for (int i = 0; i < (int) (Math.random() * 100) + 50; i++) {
            double angle = randomNumbers[(int) (Math.random() * 2)];
            double speed = (Math.random() * 8) + 1;
            Particle generatedParticle = new Particle(xPosition, yPosition, angle, speed, true);
            particles.add(generatedParticle);
        }
        System.out.println("LINE!"); // added this extra line to tell you what's generated.
    }
}
