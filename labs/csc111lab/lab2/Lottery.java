package lab2;
// CSC 111L - Lab 2
// Hernest Koroli

import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lotteryNumbers = {21, 45, 76, 33, 70};
        int[] userNumbers = new int[lotteryNumbers.length];

        System.out.println("What numbers would you like to enter for the lottery?");
        for(int i = 0; i < userNumbers.length; i++) {
            int userGuess = input.nextInt();
            userNumbers[i] = userGuess;
        }

        boolean isLotteryWinner = true;
        for(int i = 0; i < userNumbers.length; i++) {
            if(userNumbers[i] != lotteryNumbers[i]) {
                isLotteryWinner = false;
                System.out.println("Dangggg, you didn't win, but you're still a winner in my book!");
                break;
            }
        }

        if(isLotteryWinner) {
            System.out.println("Congratulations! You've won the lottery!");
        }

        input.close();
    }
}
