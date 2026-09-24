// Hernest Koroli
// DiceGame.java

void main()
{
    playGame(5);
}

void playGame(int rounds)
{
    int playerWins = 0;
    int computerWins = 0;
    int ties = 0;

    for(int i = 0; i < rounds; i++)
    {
        int playerValue = (int)(Math.random() * 6) + 1;
        int computerValue = (int)(Math.random() * 6) + 1;
        
        if(playerValue > computerValue)
        {
            IO.println("Round " + (i + 1) + ": PLAYER WINS. " + playerValue + " (User). " + computerValue + " (Computer).");
            playerWins++;
        }

        if(computerValue > playerValue)
        {
            IO.println("Round " + (i + 1) + ": COMPUTER WINS. " + playerValue + " (User). " + computerValue + " (Computer).");
            computerWins++;
        }

        if(playerValue == computerValue)
        {
            IO.println("Round " + (i + 1) +  ": TIED. " + playerValue + " (User). " + computerValue + " (Computer).");
            ties++;
        }
    }

    IO.println("Player won " + playerWins + " round(s)! " + "Computer won " + computerWins + " rounds(s)! "  + "Ties: " + ties);
}