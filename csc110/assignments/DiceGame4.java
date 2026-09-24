void main()
{
    int[] scores = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int totalScore = 0;
    
    for(int i = 0; i < 10; i++)
    {
        playRound(scores);
    }
    
    for(int i = 0; i < scores.length; i++)
    {
        totalScore += scores[i];
    }

    IO.println("Game Over! Your total score is: " + totalScore + ".");
    int[] dices = new int[5];

    printScores(scores, dices);
}

void printScores(int[] tenScores, int[] dices)
{
    String[] names = new String[] 
    {
        "Aces", // 0
        "Twos", // 1
        "Threes", // 2
        "Fours", // 3
        "Fives", // 4
        "Sixes", // 5
        "3 of a Kind", // 6
        "4 of a Kind", // 7
        "Yahtzee", // 8
        "Chance" // 9
    };

    IO.println("Score Categories: ");
 
    for(int i = 0; i < names.length; i++)
    {
        if(tenScores[i] >= 0)
        {
            IO.println((i + 1) + ". " + names[i] + ": " + tenScores[i]);
        } else {
            IO.println((i + 1) + ". " + names[i] + ": available (" + calculateScore(dices, i + 1) + ")");
        }
    }
}

void playRound(int[] tenScores)
{
    // Initialization
    int[] diceRolls = new int[5];
    int rerolls = 2;
    rollAllDice(diceRolls);

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
            String diceToReroll = IO.readln("Which dice do you want to reroll? (a, b, c, d, e) ");
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
    printScores(tenScores, diceRolls);

    int userCategory = Integer.parseInt(IO.readln("Scoring | Enter a category (1 - 10): "));
    while(userCategory > 10 || userCategory < 1)
    {
        IO.println("ERROR: You cannot score category " + userCategory + ".");
        userCategory = Integer.parseInt(IO.readln("Enter a category (1 - 10): "));
    }

    if(tenScores[userCategory - 1] < 0)
    {
        IO.println("You scored " + calculateScore(diceRolls, userCategory) + " points!");
        tenScores[userCategory - 1] = calculateScore(diceRolls, userCategory);
    } else {
        IO.println("You scored " + tenScores[userCategory - 1] + " points!");
    }
}








int calculateScore(int[] array, int category)
{
    switch(category)
    {
        case 1:
            return scoreUpper(array, 1);
        case 2:
            return scoreUpper(array, 2);
        case 3:
            return scoreUpper(array, 3);
        case 4:
            return scoreUpper(array, 4);
        case 5:
            return scoreUpper(array, 5);
        case 6:
            return scoreUpper(array, 6);
        case 7:
            return score3OfAKind(array);
        case 8:
            return score4OfAKind(array);
        case 9:
            return scoreYahtzee(array);
        case 10:
            return scoreChance(array);
        default:
            return 0;
    }
}

int sumDice(int[] dices)
{
    int totalDiceValue = 0;

    for(int i = 0; i < dices.length; i++)
    {
        totalDiceValue += dices[i];
    }
    return totalDiceValue;
}

int countMostCommon(int[] dices)
{
    int firstTwo = Math.max(countDice(dices, 1), countDice(dices, 2));
    int secondTwo = Math.max(countDice(dices, 3), countDice(dices, 4));
    int thirdTwo = Math.max(countDice(dices, 5), countDice(dices, 6));

    int firstCommon = Math.max(firstTwo, secondTwo);
    int mostCommon = Math.max(firstCommon, thirdTwo);

    return mostCommon;
}

int scoreUpper(int[] dices, int dieValue)
{
    int bonus = countDice(dices, dieValue);

    return dieValue * bonus;
}

int scoreChance(int[] dices)
{
    return sumDice(dices);
}

int score3OfAKind(int[] dices)
{
    int threeOnes = countDice(dices, 1);
    int threeTwos = countDice(dices, 2);
    int threeThrees = countDice(dices, 3);
    int threeFours = countDice(dices, 4);
    int threeFives = countDice(dices, 5);
    int threeSixes = countDice(dices, 6);

    int[] threeOfAKind = {threeOnes, threeTwos, threeThrees, threeFours, threeFives, threeSixes};

    for(int i = 0; i < threeOfAKind.length; i++)
    {
        if(threeOfAKind[i] >= 3)
        {
            return sumDice(dices);
        }
    }
    return 0;
}

int score4OfAKind(int[] dices)
{
    int fourOnes = countDice(dices, 1);
    int fourTwos = countDice(dices, 2);
    int fourThrees = countDice(dices, 3);
    int fourFours = countDice(dices, 4);
    int fourFives = countDice(dices, 5);
    int fourSixes = countDice(dices, 6);

    int[] fourOfAKind = {fourOnes, fourTwos, fourThrees, fourFours, fourFives, fourSixes};

    for(int i = 0; i < fourOfAKind.length; i++)
    {
        if(fourOfAKind[i] >= 4)
        {
            return sumDice(dices);
        }
    }
    return 0;
}

int scoreYahtzee(int[] dices)
{
    int yahtzee = 50;

    int aDiceValue = dices[0];
    boolean allSame = true;
    
    for(int i = 0; i < dices.length; i++)
    {
        if(dices[i] != aDiceValue)
        {
            allSame = false;
            break;
        }
    }

    if(allSame)
    {
        return yahtzee;
    }
    return 0;
}

// Dice Game 1 - 2
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
