// CSC111L Lab 3
// Hernest Koroli
package lab3; // this file is in a folder thus package has to be mentioned

public class TestMonster {
	public static void main(String[] args) {
		
		//creates a new instance of monster with the no arg constructor
		Monster monster1 = new Monster();
		
		//sets the name, health, and strength for the first monster
		monster1.setName("Dom Simonetti");
		monster1.setHealth(67);
		monster1.setStrength(67);

		//prints out the first monsters name, health and strength using the Monster class getters
		System.out.println("Hello, my name is " + monster1.getName() 
			+ ".\nMy health is " + monster1.getHealth() + 
			" and my strength is " + monster1.getStrength() + "\n");
		
		//creates a new instance of monster using the 3 arg constructor
		Monster monster2 = new Monster("Johnson", 250, 75);
		
		//prints out the second monsters name, health and strength using the Monster class getters
		System.out.println("Hello " + monster1.getName() + " my name is " + monster2.getName() 
			+ ".\nMy health is " + monster2.getHealth() + 
			" and my strength is " + monster2.getStrength());
		
		//monster 2 attacks monster 1 and monster 1 takes damage
		double monster2attack = monster2.attack();
		System.out.println("I attack you with " + monster2attack + " points! \n");
		monster1.damage(monster2attack);
		
		//monster 1 attacks monster 2 and monster 2 takes damage
		double monster1attack = monster1.attack();
		System.out.println("That is diabolical " + monster2.getName()
			+ "! I attack you with " + monster1attack + " points!\n");
		monster2.damage(monster1attack);
		
		System.out.println("Let's tango!!\n");
		
		//monster 1 and monster 2 continue attacking to the end!
		while(monster1.isAlive() && monster2.isAlive()) {
			monster1attack = monster1.attack();
			monster2attack = monster2.attack();
			
			monster1.damage(monster2attack);
			System.out.println(monster2.getName() + " attacks " 
					+ monster1.getName() + " with " + monster2attack 
					+ " points! \n" + monster1.getName() + " health: " 
					+ monster1.getHealth() + "\n");
	
			if(monster1.isAlive()) {
			monster2.damage(monster1attack);
			System.out.println(monster1.getName() + " attacks " 
					+ monster2.getName() + " with " + monster1attack 
					+ " points!\n" + monster2.getName() + " health: " 
					+ monster2.getHealth() + "\n");
			}
		}
		
		//Print the final score for each monster
		System.out.println("Final score: " + monster1.getName() 
			+ ": " + monster1.getHealth() + "\n " + monster2.getName() 
			+ ": " + monster2.getHealth() + "\n");
		
		//Print the winner
		if(monster1.isAlive()) {
			System.out.println(monster1.getName() + " won!");
		} else {
			System.out.println(monster2.getName() + " won!");
	}
	}
}