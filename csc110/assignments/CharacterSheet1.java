
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

    IO.println(playerName);
    IO.println(characterName);
    IO.println(characterClass);
    IO.println(ancestry);
    IO.println(level);
    IO.println(strength);
    IO.println(dexterity);
    IO.println(constitutionScore);

    IO.println(level + strength + dexterity + constitutionScore);
}
