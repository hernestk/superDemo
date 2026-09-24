
void main()
{
    String playerName = IO.readln("Player Name: ");
    String characterName = IO.readln("Character Name: ");
    int level = 0;
    int strength = 0;
    int dexterity = 0;
    int constitution = 0;

    String charClass = IO.readln("Character Class: ");
    if(classSupported(charClass) == false)
    {
        IO.println("WARNING: The class \"" + charClass + "\" is not supported by this program.");
    }

    String ancestry = IO.readln("Ancestry: ");
    if(ancestrySupported(ancestry) == false)
    {
        IO.println("WARNING: The ancestry \"" + ancestry + "\" is not supported by this program.");
    }

    level = Integer.parseInt(IO.readln("Level: "));

    boolean userChoosing = true;
    while(userChoosing)
    {
        String userChoice = IO.readln("Do you want to choose your own scores? \"y\" or \"n\": ");
        if(userChoice.equals("y"))
        {
            int[] userScores = buyScores();
            strength = userScores[0];
            dexterity = userScores[1];
            constitution = userScores[2];
            
            userChoosing = false;
        } else if (userChoice.equals("n")) 
        {
            int[] randomScores = rollScores();
            strength = randomScores[0];
            dexterity = randomScores[1];
            constitution = randomScores[2];
            userChoosing = false;
        } else {
            IO.println("ERROR: You need to answer y or n.");
        }
    }
    
    if(ancestry.equals("Orc"))
    {
        strength += 2;
    } else if(ancestry.equals("Elf"))
    {
        dexterity += 2;
    } else if(ancestry.equals("Gnome"))
    {
        constitution += 2;
    }

    IO.println("Player: " + playerName 
    + "\n" + characterName + ", Level " + level + " " + ancestry + " " + charClass
    + "\n" + "Hit Points (D" + hitDie(charClass) + "): " + hitPoints(level, hitDie(charClass), abilityMod(constitution))
    + "\n" + "Armor Class: " + armorClass(calcProficiencyBonus(level), abilityMod(dexterity))
    + "\n" + "Attack: " + attack(calcProficiencyBonus(level), abilityMod(strength))
    + "\n" + "Proficiency: " + calcProficiencyBonus(level)
    + "\n" + "Strength: " + strength + ", " + abilityMod(strength)
    + "\n" + "Dexterity: " + dexterity + ", " + abilityMod(dexterity)
    + "\n" + "Constitution: " + constitution + ", " + abilityMod(constitution));
}

// Methods
int[] buyScores()
{
    int[] scores = new int[3];
    int strength = Integer.parseInt(IO.readln("Strength value: "));
    int dexterity = Integer.parseInt(IO.readln("Dexterity value: "));
    int constitution = Integer.parseInt(IO.readln("Constitutiion score: "));
    int totalScore = strength + dexterity + constitution;
    int maxScore = 36;

    while(totalScore > maxScore)
    {
        IO.println("ERROR: Ability scores must sum to 36 or less! Try again.");
        strength = Integer.parseInt(IO.readln("Strength value: "));
        dexterity = Integer.parseInt(IO.readln("Dexterity value: "));
        constitution = Integer.parseInt(IO.readln("Constitutiion score: "));
        totalScore = strength + dexterity + constitution;
    } 
    scores[0] = strength;
    scores[1] = dexterity;
    scores[2] = constitution;
    return scores;
}

int[] rollScores()
{
    int[] rolledScores = new int[3];
    
    for(int i = 0; i < rolledScores.length; i++)
    {
        int scoreRoll = roll();
        rolledScores[i] = scoreRoll;
    }
    
    return rolledScores;
}

int roll()
{
    int score1 = (int) (Math.random() * 6) + 1;
    int score2 = (int) (Math.random() * 6) + 1;
    int score3 = (int) (Math.random() * 6) + 1;
    int score4 = (int) (Math.random() * 6) + 1;
    int totalScore = score1 + score2 + score3 + score4;

    int lowestFirstTwo = Math.min(score1, score2);
    int lowestSecondTwo = Math.min(score3, score4);
    int lowestNum = Math.min(lowestFirstTwo, lowestSecondTwo);
    
    totalScore -= lowestNum;
    return totalScore;
}

int calcProficiencyBonus(int level)
{
    return (level + 3) / 4 + 1;
}

int abilityMod(int score)
{
    return score / 2 - 5;
}

int hitPoints(int lvl, int hitDie, int constituitionMod)
{
    return lvl * (hitDie + constituitionMod);
}

int armorClass (int profBonus, int dexMod)
{
    return 10 + profBonus + dexMod;
}

int attack(int profBonus, int strengthMod)
{
    return profBonus + strengthMod;
}

int hitDie(String characterClass)
{
    int hitDie = 0;
    if(characterClass.equals("Fighter"))
    {
        hitDie = 10;
    }

    if(characterClass.equals("Rogue"))
    {
        hitDie = 8;
    }

    if(characterClass.equals("Barbarian"))
    {
        hitDie = 12;
    } else if(classSupported(characterClass) == false)
    {
        hitDie = 6;
    }
    return hitDie;
}

boolean classSupported(String characterClass)
{
    boolean classSupported = false;
    if(characterClass.equals("Fighter") || characterClass.equals("Rogue") || characterClass.equals("Barbarian"))
    {
        classSupported = true;
        return classSupported;
    }
    return classSupported;
}

boolean ancestrySupported(String ancestry)
{
    boolean ancestrySupported = false;
    if(ancestry.equals("Orc") || ancestry.equals("Elf") || ancestry.equals("Gnome"))
    {
        ancestrySupported = true;
        return ancestrySupported;
    }
    return ancestrySupported;
}