void main()
{
    // Initialization
    int[] diceRolls = new int[5];
    rollAllDice(diceRolls);

    int rerolls = 2;

    // Rerolling
    while(rerolls != 0)
    {
        printDice(diceRolls);
        IO.println();

        String decision = IO.readln("What would you like to do? (roll or skip): ");
        if(decision.equals("skip"))
        {
            rerolls = 0;
        } 
        else if (decision.equals("roll"))
        {
            String diceToReroll = IO.readln("Which dice do you want to reroll? (a, b, c, d, e, f) ");
            boolean[] rerollDice = parseReroll(diceToReroll);
            rollSomeDice(diceRolls, rerollDice);
            rerolls--;
        } else {
            IO.println("ERROR: The command \"" +  decision + "\" is not recognized.");
        }

    }
    // Scoring
    printDice(diceRolls);
    IO.println();

    int dieScore = Integer.parseInt(IO.readln("Scoring | Enter an integer (1 - 6): "));
    while(dieScore > 6 || dieScore < 1)
    {
        IO.println("ERROR: The number \"" + dieScore + "\" doesn't appear on a six-sided die.");
        dieScore = Integer.parseInt(IO.readln("Enter an integer (1 - 6): "));
    }
    IO.println("You scored " + calculateScore(diceRolls, dieScore) + " points!");
}

void printDice(int[] array)
{
    IO.println(" A   B   C   D   E");
    for(int index = 0; index < array.length; index++) 
    {
        IO.print("+-+");
        if (index < array.length - 1) 
        {
            IO.print(" ");
        }
    }
    IO.println();

    for(int index = 0; index < array.length; index++)
    {
        if(index < array.length)
        {
            IO.print("|" + array[index] + "| ");
        }
    }
    IO.println();

    for(int index = 0; index < array.length; index++) 
    {
        // print the die and vertical lines
        IO.print("+-+");
        // only print a space if we're not on the last index of the array
        if (index < array.length - 1) 
        {
            IO.print(" ");
        }
    }
}

int countDice(int[] array, int dieValue)
{
    int dieCount = 0;
    for(int i = 0; i < array.length; i++)
    {
        if(array[i] == dieValue)
        {
            dieCount++;
        }
    }

    return dieCount;
}

int calculateScore(int[] array, int dieValue)
{
    int bonus = countDice(array, dieValue);

    return dieValue * bonus;
}

void rollAllDice(int[] array)
{
    for(int i = 0; i < array.length; i++)
    {
        array[i] = (int)(Math.random() * 6) + 1;
    }
}

void rollSomeDice(int[] array, boolean[] ableToRoll)
{ 
    for(int i = 0; i < array.length; i++)
    {
        if(ableToRoll[i] == true)
        {
            array[i] = (int)(Math.random() * 6) + 1;
        }
    }
}

boolean[] parseReroll(String character)
{
    boolean[] foundLetters = new boolean[5];
    String letters = "abcde";

    
    for(int i = 0; i < foundLetters.length; i++)
    {
        if(character.indexOf(letters.charAt(i)) != -1)
        {
            foundLetters[i] = true;
        }
    }
    return foundLetters;
}