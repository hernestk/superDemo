// Hernest Koroli
// MoreArrays.java

void main()
{
	int[] testArray = {54, 32, 71, 95};
	
	String[] array1 = {"bobcat", "hawk", "yellowjacket"};
	String[] array2 = {"gold", "blue", "crimson", "gray", "green"};

	// Write code to test your functions here
    IO.println(indexOf(testArray, 71)); // returns index 2

    String[] concatArray = concat(array1, array2); 
    for(int i = 0; i < concatArray.length; i++)
    {
        IO.println(concatArray[i]);
    }
}

// returns the num target back to the user
int indexOf(int[] numArray, int target)
{
    for(int i = 0; i < numArray.length; i++)
    {
		int number = numArray[i];
        if(number == target)
        {
            return i; 
        }
    }
    return -1;
}

// Combines first array with the second array making a new array.
String[] concat(String[] array1, String[] array2)
{
    int totalIndex = 0;
    String[] combinedStringArray = new String[array1.length + array2.length];
    
    for(int i = 0; i < array1.length; i++, totalIndex++)
    {
        combinedStringArray[i] = array1[i];
    }

    for(int i = 0; i < array2.length; i++, totalIndex++)
    {
        combinedStringArray[totalIndex] = array2[i]; 
    }
    return combinedStringArray;
}
