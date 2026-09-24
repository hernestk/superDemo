
void main()
{
    String playerName = IO.readln("Player Name: ");
    String characterName = IO.readln("Character Name: ");
    String characterClass = IO.readln("Character Class: ");
    String ancestry = IO.readln("Ancestry: ");
    int level = Integer.parseInt(IO.readln("Level: "));
    int strength = Integer.parseInt(IO.readln("Strength value: "));
    int dexterity = Integer.parseInt(IO.readln("Dexterity value: "));
    int constitutionScore = Integer.parseInt(IO.readln("Constitutiion score: "));


    IO.println("Player: " + playerName 
    + "\n" + characterName + ", Level " + level + " " + ancestry + " " + characterClass 
    + "\n" + "Proficiency: " + calcProficiencyBonus(level)
    + "\n" + "Strength: " + strength + ", " + abilityMod(strength)
    + "\n" + "Dexterity: " + dexterity + ", " + abilityMod(dexterity)
    + "\n" + "Constitution: " + constitutionScore + ", " + abilityMod(constitutionScore));
}

int calcProficiencyBonus(int level)
{
    return (level + 3) / 4 + 1;
}

int abilityMod(int score)
{
    return score / 2 - 5;
}