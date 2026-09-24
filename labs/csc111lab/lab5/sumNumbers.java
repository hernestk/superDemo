// CSC111L - Lab 5
// Hernest Koroli
package lab5;
import java.util.Scanner;

public class sumNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any number: ");

        int userInt = input.nextInt();
        System.out.println("The sum of all numbers from 1 to " + userInt + " is " + calculateSum(userInt));
        input.close();
    }

    public static int calculateSum(int number) {
        int result = 0;
        if(number == 0) {
            return result;
        } else {
            result += number;
            return number + calculateSum(number - 1);
        }
    }
}


