// ArraySearch.java
// Use this code for #2 in Lab 5

// REARRANGE THE LINES BELOW SO THAT THE arraySearch() FUNCTION BEHAVES PROPERLY
public class ArraySearch
{
    
    public boolean arraySearch(int[] numbers, int target)
    {
        int index = 0;
        boolean foundIt = false;

        while(index < numbers.length)
        {
            int currentNumber = numbers[index]; 

            if(currentNumber == target) 
            {
                foundIt = true; 
            }
            index = index + 1;
        }
        return foundIt;
    }

// LINES TO REARRANGE END HERE


// DO NOT MODIFY ANYTHING BELOW THIS LINE
    void main(){
	    int[] testArray = {377, 1, 233, 1, 144, 2, 89, 3, 45, 5, 34, 8, 21, 13};
	
	    IO.println("89 is inside testArray (should be true): " + arraySearch(testArray, 89));
	    IO.println("42 is inside testArray (should be false): " + arraySearch(testArray, 42));
    }
}
