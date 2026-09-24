package assignment1;

public class Monster {
    private String name;
    private double health;
    private double strength;

    public Monster(String name, double health, double strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getStrength() {
        return strength;
    }

    public double attack() {
        return (Math.random() * strength) + 0.0; 
    }

    public void damage(double attack) {
        health -= attack;
    }
    
    public boolean isAlive() {
        if(getHealth() <= 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return name + ", Health: " + Math.round(health) + ", Strength: " + Math.round(strength);
    }
}
