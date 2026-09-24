package assignment1;
import java.util.Scanner;
import java.io.*;

public class MonsterBattle {
    public static void main(String[] args) {
        Monster hero = loadMonster("Hero.txt");
        Monster weakEnemy = loadMonster("Minion1.txt");
        Monster enemy = loadMonster("Minion2.txt");
        Monster boss = loadMonster("Boss.txt");

        battle(hero, weakEnemy);
        battle(hero, enemy);
        battle(hero, boss);

        // summary of the battles
        if(hero.isAlive()) {
            System.out.println("The Hero WON! Here is a summary:");
            System.out.println("\tWeak Enemy: " + weakEnemy.getName() + "\n\tEnemy: " + enemy.getName() + "\n\tBoss: " + boss.getName());
            System.out.println("Hero's current stats after the journey: " + hero.getName() + ", " + hero.getHealth() + " HP, " + hero.getStrength() + " strength.");
        } else {
            if(weakEnemy.isAlive()) {
                System.out.println(weakEnemy.getName() + " has killed " + hero.getName());
                System.out.println(weakEnemy.getName() + "'s stats: " + weakEnemy.toString());
            } else if(enemy.isAlive()) {
                System.out.println(enemy.getName() + " has killed " + hero.getName());
                System.out.println(enemy.getName() + "'s stats: " + enemy.toString());
            } else {
                System.out.println(boss.getName() + " has killed " + hero.getName());
                System.out.println(boss.getName() + "'s stats: " + boss.toString());
            }
        }
    }
    
    public static void battle(Monster hero, Monster enemy) {
        System.out.println("The battle begins between " + hero.getName() + " and " + enemy.getName());

        while(hero.isAlive() && enemy.isAlive()) {
            double heroDMG = hero.attack();
            double enemyDMG = enemy.attack();

            enemy.damage(heroDMG);
            System.out.println("\t" + hero.getName() + " attacks " + enemy.getName() + " with " + heroDMG + " damage.");

            hero.damage(enemyDMG);
            System.out.println("\t" + enemy.getName() + " attacks " + hero.getName() + " with " + enemyDMG + " damage.");
        }

        if(hero.isAlive()) {
            System.out.println(enemy.getName() + " has died.");
        } else {
            System.out.println(hero.getName() + " has died.");
        }
    }

    public static Monster loadMonster(String fileName) {
        File userFile = new File(fileName);

        try(Scanner fileInput = new Scanner(userFile)) {
            String loadedName = fileInput.nextLine();
            double loadedHealth = fileInput.nextDouble();
            double loadedStrength = fileInput.nextDouble();
            Monster loadedMonster = new Monster(loadedName, loadedHealth, loadedStrength);
            fileInput.close();

            return loadedMonster;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}