// SER120L - Lab 5
// Hernest Koroli
import java.util.ArrayList;
import java.util.Scanner;

public class AdoptionCenter {
	private String name;
	private ArrayList<Pet> adoptionList;
	
	public AdoptionCenter(String name) {
		this.name = name;
		adoptionList = new ArrayList<>();
	}
	
	public void addPet(Pet pet) {
		adoptionList.add(pet);
	}
	
	public void removePet(Pet pet) {
		adoptionList.remove(pet);
	}
	
	public ArrayList<Pet> getAdoptionList(){
		return adoptionList;
	}
	public String getName() {
		return name;
	}
	
	public void adopt(String ownerName, String adoptionPick) {
		for(Pet pet : getAdoptionList())	{
			if(adoptionPick.equalsIgnoreCase(pet.getName())&& pet.isAdopted()){
					System.out.println(pet.getName() + " has already been adopted.");
					break;
				}
			else if (adoptionPick.equalsIgnoreCase(pet.getName())&& !pet.isAdopted()){
				pet.setIsAdopted(true);
				pet.setOwnerName(ownerName);
				System.out.println("Congratulations! You adopted " + pet.getName());
				removePet(pet);
				break;
			}
		}
	}
	public static void main(String [] args) {
		
		// Change the name of the adoption center
		AdoptionCenter adoptionCenter = new AdoptionCenter("Cat Haven Center");
				
		// 5 new instances of <your animal type>
		Cat mocha = new Cat("Mocha", 1, "Orange and White");
        Cat mittens = new Cat("Mittens", 1, "Black and White");
        Cat sniffle = new Cat("Sniffle", 3, "Calico");
        Cat muffin = new Cat("MMuffina", 2, "Grey");
        Cat tiger = new Cat("Tiger", 4, "Orange");
		
		// Use the adoptioncenter's addPet method to add 
		// 5 instances to the adoption center
		adoptionCenter.addPet(mocha);
        adoptionCenter.addPet(mittens);
        adoptionCenter.addPet(sniffle);
        adoptionCenter.addPet(muffin);
        adoptionCenter.addPet(tiger);

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Hello!! Welcome to " + adoptionCenter.getName() + " :) \n\nWhat is your name?");
		String userName = myScanner.nextLine();
		
		// TODO in this while loop, change the instances of 
		//		dog1 to be one of your instances of <your animal type> (3 places need updating)
		while(true) {
			System.out.println("Would you like to adopt one of our " + mocha.getType() 
								+ "s? (Please enter yes or no)");
	
			String adoptionDecision = myScanner.next();
			if(adoptionDecision.equalsIgnoreCase("no")) {
				System.out.println("Wowwwwwwwww");
				break;
			}
			else if(adoptionDecision.equalsIgnoreCase("yes")) {
				if(adoptionCenter.getAdoptionList().isEmpty()) {
					System.out.println("Come back tomorrow and we'll have more pets to adopt!");
					break;
				}
				System.out.println("Amazing! We have " + adoptionCenter.getAdoptionList().size() 
					+ " " + mocha.getType() + "s! \n\nWhich " + mocha.getType() 
					+ " would you like to adopt?\n");
				
				for(Pet pet : adoptionCenter.getAdoptionList())	{	
					pet.printAboutMe();
				}
				
				String adoptionPick = myScanner.next();
				adoptionCenter.adopt(userName, adoptionPick);
	
			}
			else {
				System.out.println("Please enter yes or no");
			}
			
		}
		myScanner.close();
	}
}
