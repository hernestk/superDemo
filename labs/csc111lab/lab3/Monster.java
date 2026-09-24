// CSC111L Lab 3
// Hernest Koroli
package lab3; // this file is in a folder thus package has to be mentioned

public class Monster {
    private String name;
    private double health;
    private double strength;

    public Monster(String name, double health, double strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public Monster() {
        name = "";
        health = 0;
        strength = 0;
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

    public void setName(String newName) {
        name = newName;
    }

    public void setHealth(double newHealth) {
        health = newHealth;
    }
    
    public void setStrength(double newStrength) {
        strength = newStrength;
    }

    public double attack() {
        return strength * (Math.random() * 5) + 1;
    }

    public void damage(double damage) {
        health -= damage;
    }

    public boolean isAlive() {
        if(health > 0) {
            return true;
        }
        return false;
    }
    
}
