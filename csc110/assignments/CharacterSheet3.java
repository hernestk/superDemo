
void main()
{
    String playerName = IO.readln("Player Name: ");
    String characterName = IO.readln("Character Name: ");

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

    int level = Integer.parseInt(IO.readln("Level: "));
    int strength = Integer.parseInt(IO.readln("Strength value: "));
    int dexterity = Integer.parseInt(IO.readln("Dexterity value: "));
    int constitution = Integer.parseInt(IO.readln("Constitutiion score: "));

    boolean running = true;
    while(running)
    {
        if(passedMaxScores(strength, dexterity, constitution) == true)
        {
            IO.println("ERROR: Ability scores must sum to 36 or less! Try again.");
            strength = Integer.parseInt(IO.readln("Strength value: "));
            dexterity = Integer.parseInt(IO.readln("Dexterity value: "));
            constitution = Integer.parseInt(IO.readln("Constitutiion score: "));
        } else {
            running = false;
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

boolean passedMaxScores(int ability1, int ability2, int ability3)
{
    boolean maxSurpassed = false;
    int totalAbilityValue = ability1 + ability2 + ability3;
    
    if(totalAbilityValue > 36)
    {
        maxSurpassed = true;
        return maxSurpassed;
    }
    return maxSurpassed;
}