// Hernest Koroli
// Lab7.java
void main()
{
	int[] someIntegers = {74, 235, 13, 982, 1, 458, 233, 407, 333, 129, 856, 11, 909};
	String[] someWords = {"Abacus", "bottle", "clock", "Hawk", "Bobcat", "monopoly", "Zeppelin",
						  "ingredient", "Connecticut", "typewriter", "rectangle", "oops", "artisan"};
	
	int func1Result = functionOne(someIntegers);
	IO.println(func1Result); // Should be 982

	int func2Result = functionTwo(someWords);
	IO.println(func2Result); // Should be 5
}

// Put your answer to Q1 here. What does functionOne do?
// Returns biggest num by comparing first index to all indexes
int functionOne(int[] array)
{
	int valueToReturn = array[0];
    for(int i = 0; i < array.length; i++)
    {
        int number = array[i];
		if(valueToReturn < number)
        {
			valueToReturn = number;
		}
    }
	return valueToReturn;
}

// Put your answer to Q3 here. What does functionTwo do?
// Returns count based on how many words have beginning capital letters.
int functionTwo(String[] array)
{
	int count = 0;

    for(String word : array)
    {
		char firstChar = word.charAt(0);
		if(firstChar >= 'A' && firstChar <= 'Z')
        {
			count += 1;
		}		
	}
	return count;
}
