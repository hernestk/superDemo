// Hernest Koroli
// ArrayFunctions.java
public class ArrayFunctions 
{
    void main()
    {
        int[] numsToTriple = {20, 10, 50, 80};
        int[] numsToReduce = {20, 10, 50, 80};
        int[] positivesNegatives = {13, -10, 85, -3, -8, 41, 17};

        int[] tripledList = tripleIt(numsToTriple);
        int[] reducedList = reduceValues(numsToReduce);
        int[] filteredList = filterPositives(positivesNegatives);


        IO.println("Triple List: ");
        for(int i = 0; i < tripledList.length; i++)
        {
            IO.println(tripledList[i]);
        }

        IO.println("Reduced Values: ");
        for(int i = 0; i < reducedList.length; i++)
        {
            IO.println(reducedList[i]);
        }

        IO.println("Filtering Positives: ");
        for(int i = 0; i < filteredList.length; i++)
        {
            IO.println(filteredList[i]);
        }
    }

    public int[] tripleIt(int[] numArray)
    {
        int[] tripleList = new int[numArray.length];
        for(int i = 0; i < numArray.length; i++)
        {
            tripleList[i] = numArray[i] * 3;
        }
        return tripleList;
    }

    public int[] reduceValues(int[] numArray)
    {
        int[] reducedList = new int[numArray.length];
        int smallestNum = numArray[0];

        // adds values from numArray to new array
        for(int i = 0; i < numArray.length; i++)
        {
            reducedList[i] = numArray[i];
        }

        // finds the smallest num
        for(int i = 0; i < numArray.length; i++)
        {
            if(smallestNum >= numArray[i])
            {
                smallestNum = numArray[i];
            }
        }

        // subtracts all nums by the smallest num (num - 10)
        for(int i = 0; i < numArray.length; i++)
        {
            reducedList[i] -= smallestNum;
        }
        return reducedList;
    }

    public int[] filterPositives(int[] numArray)
    {
        int positivesCounted = 0;

        // tracks num of positive to determine new list.
        for(int i = 0; i < numArray.length; i++)
        {
            if(numArray[i] >= 0)
            {
                positivesCounted++;
            }
        }

        int[] filteredList = new int[positivesCounted];
        int compareIndex = 0;

        // makes a filtered list. numArray gets a differ index to check for a positive
        for(int i = 0; i < filteredList.length;)
        {
            if(numArray[compareIndex] >= 0)
            {
                filteredList[i] = numArray[compareIndex];
                i++;
                compareIndex++;
            } else {
                compareIndex++;
            }
        }
        return filteredList;
    }
}