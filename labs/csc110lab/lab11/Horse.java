// Hernest Koroli
// Horse.java

class Horse
{
    String name;
    String color;
    int birthYear;

    Horse(String name, String color, int birthYear)
    {
        this.name = name;
        this.color = color;
        this.birthYear = birthYear;
    }

    String getName()
    {
        return name;
    }


    String getColor()
    {
        return color;
    }

    int getBirthYear()
    {
        return birthYear;
    }

    int getAgeAt(int currentYear)
    {
        int age = currentYear - getBirthYear();
        return age;
    }

    public String toString()
    {
        return name + " " + color + " " + birthYear;
    }
}