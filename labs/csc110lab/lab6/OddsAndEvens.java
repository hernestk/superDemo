// Hernest Koroli
// OddsAndEvens.java

public class OddsAndEvens
{
    void main()
    {
        int[] arrayOfOdds = {3,5,7,11,13,17,19,23,1,99};
	    int[] arrayOfEvens = {8,12,18,24,30,36,42,26,10,40};
	    int[] mixedArray = {11, 17, 42, 50, 64, 9, 21, 100, 2000, 90};

        IO.println("Odd List (true): " + isArrayOdd(arrayOfOdds));
        IO.println("Even List (false): " + isArrayOdd(arrayOfEvens));
        IO.println("Mixed List (false): " + isArrayOdd(mixedArray) + "\n");

        IO.println("Odd List (false): " + isArrayEven(arrayOfOdds));
        IO.println("Even List (true): " + isArrayEven(arrayOfEvens));
        IO.println("Mixed List (false): " + isArrayEven(mixedArray) + "\n");

        IO.println("Odd List (10): " + countOdds(arrayOfOdds));
        IO.println("Even List (0): " + countOdds(arrayOfEvens));
        IO.println("Mixed List (4): " + countOdds(mixedArray));

    }

    public boolean isArrayOdd(int[] numArray)
    {
        boolean isOdd = true;

        for(int i = 0; i < numArray.length; i++)
        {
            if(numArray[i] % 2 == 0)
            {
                isOdd = false;
                return isOdd;
            }
        }
        return isOdd;
    }

    public boolean isArrayEven(int[] numArray)
    {
        boolean isEven = true;

        for(int i = 0; i < numArray.length; i++)
        {
            if(numArray[i] % 2 != 0)
            {
                isEven = false;
                return isEven;
            }
        }
        return isEven;
    }

    public int countOdds(int[] numArray)
    {
        int oddsCounted = 0;

        for(int i = 0; i < numArray.length; i++)
        {
            if(numArray[i] % 2 != 0)
            {
                oddsCounted++;
            }
        }
        return oddsCounted;
    }
}