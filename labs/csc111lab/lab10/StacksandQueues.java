// CSC111L - Lab 10
// Hernest Koroli
package lab10;
import java.util.Stack;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StacksandQueues {	
	/*
	  1. Which data structure would you use for each situation, stack or queue?

			Reversing a string - stack
			Printing documents in the order they were sent - queue
			Storing and reading instructions for a recipe - queue
			Undo feature - stack
			Processing customer orders - queue
						
	   2. Given the following stack pseudocode, fill in the expected results
			push "Scott Pilgrim"
			push "Spiderman"
			push "Interstellar"
		 	push "Spongebob"
			pop		Spongebob
			pop		Interstellar
	
	   3. Given the following queue pseudocode, fill in the expected results
			add "Scott Pilgrim"
			add "Spiderman"
			add "Interstellar"
		 	add "Spongebob"
			remove		Scott Pilgrim
			remove		Spiderman
	*/
	
	//Determine the correct data structure for each method and implement 
	
	/* 
	     Palindrome checker - a palindrome is a word spelled the same way forwards and backwards
	 	 Which data structure should you use to determine if a word is a palindrome?
	*/
    public static boolean isPalindrome(String word) { 
        Stack<Character> list = new Stack<>();
    
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
			list.add(c);
        }
    	
    	// TODO: Remove(from the queue) or pop(from the stack) each character and 
    	// compare to the characters in the original word
    	// If the characters do not match at any point, return false
		for (int i = 0; i < word.length(); i++) {
			if(list.pop() != word.charAt(i)) {
				return false;
			}
		}
		return true;
    }
    
	/* 
	     Car Wash - wash cars in the order they arrive
	 	 Which data structure should you use to wash cars?
	*/
    public static void carWash(String[] cars) {
    	//TODO create a new stack or queue of type String
    	//Reminder a queue is an interface and you'll need to set a new instance using another data structure. 
		Queue<String> queue = new LinkedList<>();

    	//TODO add(to the queue) or push(to the stack) each car in the array cars(in order)
    	for (int i = 0; i < cars.length; i++) {
			queue.add(cars[i]);
		}
    	//TODO change the variable name here to your stack/queue variable name
        System.out.println("Cars waiting: " + queue + "\n");

        //TODO while your stack/queue is not empty, remove(from the queue) or pop(from the stack)
        //each car and print the car's name + " is being washed" 
		for (int i = 0; i < cars.length; i++) {
			queue.remove();
			System.out.println(cars[i] + " is being washed");
		}

        System.out.println("\nAll cars have been washed!");
    }
    
    public static void main(String[] args) {
    	
    	//Tests if an array of words are palindromes
    	String[] words = {"racecar", "hello", "tattarrattat"};
    	
    	System.out.println("Are these words palindromes?\n" + Arrays.toString(words)+"\n");

    	for(String word:words) {
    		System.out.print(word);
        	if(isPalindrome(word))
        		System.out.println(" is a palindrome");
        	else
        		System.out.println(" is not a palindrome");
    	}
    	
    	//wash an array of cars in order
    	System.out.println();
    	
    	String[] cars = {"Hyundai", "Jeep", "Honda", "Truck"};
        carWash(cars);
    }
}
