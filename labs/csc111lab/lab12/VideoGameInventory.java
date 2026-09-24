// CSC111L - Lab 12
// Hernest Koroli
package lab12;

import java.util.HashMap;
public class VideoGameInventory {
    private HashMap<String, Integer> inventory;
    private int maxCapactiy;

    public VideoGameInventory(int maxCapactiy) {
        inventory = new HashMap<>();
        this.maxCapactiy = maxCapactiy;
    }

    public int getTotalItems() {
        int totalItems = 0;

        for(int value : inventory.values()) {
            totalItems += value;
        }
        return totalItems;
    }

    public void printInventory() {
        for(HashMap.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }
    }

    public void useItem(String item, int amount) {
        if(inventory.get(item) == null) {
            System.out.println("You do not have any " + item + " in your inventory. Why don't you go pick some up!");
        } else if(inventory.get(item) - amount >= 1) {
            inventory.put(item, inventory.get(item) - amount);
            System.out.println("Used " + amount + " " + item + ". Remaining " + inventory.get(item));
        } else {
            System.out.println("You do not have any " + item + " in your inventory. Why don't you go pick some up!");
        }
    }

    public void pickUpItem(String item, int amount) {
        int remainingCapacity = maxCapactiy - getTotalItems();

        if(remainingCapacity <= 0) {
            System.out.println("Inventory full! Cannot pick up " + amount + " " + item + "(s).");
        } else {
            inventory.put(item, amount);
            System.out.println("Picked up " + amount + " " + item + "(s).");
        }
    }

    public void dropItem(String item, int amount) {
        // first if checks if the item exists to avoid a null pointer exception
        if(inventory.get(item) == null) {
            System.out.println("You don't have " + item + " in your inventory.");
        } else if(amount >= inventory.get(item)) {
            inventory.remove(item);
            System.out.println("Dropped all " + item + "(s).");
        } else {
            inventory.put(item, inventory.get(item) - amount);
            System.out.println("Dropped " + amount + " " + item + "(s). Remaining " + inventory.get(item));
        }
    }

    public int size () { 
        return inventory.size(); 
    }

    public int hashCode() {
        return inventory.hashCode();
    }

    public static void main(String[] args) {
        VideoGameInventory bag = new VideoGameInventory(10);
       
        System.out.println("Starting Inventory: ");
        bag.printInventory(); // should print nothing since I didn't add anything
        
        System.out.println();

        bag.pickUpItem("Health Potion", 5);
        bag.pickUpItem("Steak", 5);
        bag.pickUpItem("Elytra", 3);

        System.out.println();

        System.out.println("Current Inventory: ");
        bag.printInventory();

        System.out.println();

        bag.useItem("Steak", 2);
        bag.useItem("Health Potion", 1);
        bag.useItem("Netherite Sword", 1);

        System.out.println();

        bag.dropItem("Health Potion", 1);
        bag.dropItem("Health Potion", 100);

        System.out.println();
        
        System.out.println("Current Inventory: ");
        bag.printInventory();

        System.out.println();

        System.out.println("Total Items: " + bag.getTotalItems());
        System.out.println("Unique Items: " + bag.size());
        System.out.println("Hashcode of inventory: " + bag.hashCode());
    }
}
