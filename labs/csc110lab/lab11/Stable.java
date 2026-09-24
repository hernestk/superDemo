// Hernest Koroli
// Stable.java

void main()
{
    Horse myHorse = new Horse("Shizzy", "golden", 2023);
    Horse oNielsHorse = new Horse("Buttercup", "white", 2021);
    Horse jaredsHorse = new Horse("Clues", "brown", 1964);

    Stable stable = new Stable("Stable", 2);

    stable.addHorse(myHorse);
    stable.addHorse(oNielsHorse);
    stable.addHorse(jaredsHorse); // Full stable. This horse wasn't added.

    IO.println("The horse name you requested (not null): " + stable.getHorse("Shizzy"));
    IO.println("The horse name you requested (null): " + stable.getHorse("Clues")); // Third horse wasm't added to the stable
    // Happy Thanksgiving Break :) HK
}

class Stable
{
    String name;
    Horse[] stable;
    int horsesKept;

    Stable(String name, int stableCapacity)
    {
        this.name = name;
        stable = new Horse[stableCapacity];
        horsesKept = 0;
    }

    void addHorse(Horse horseObject)
    {
        for(int i = 0; i < stable.length; i++)
        {
            if(stable[i] == null)
            {
                stable[i] = horseObject;
                horsesKept += 1;
                IO.println(horseObject.getName() + " has been added to the stable");
                break;
            }
        }
    }

    String getHorse(String horseName)
    {
        for(int i = 0; i < stable.length; i++)
        {
            if(stable[i].getName().equals(horseName))
            {
                return stable[i].getName();
            }
        }
        return null;
    }
}