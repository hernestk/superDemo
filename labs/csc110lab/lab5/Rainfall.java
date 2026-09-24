// Rainfall.java
// Use this file to complete #4-6 in Lab 5
public class Rainfall
{
    void main()
    {
	    int entries = 0;
	    double[] rainfall = new double[12];
	
	    while(entries < 12)
        {
		    double nextRain = Double.parseDouble(IO.readln("Enter rainfall for the month: "));
            if(isNegative(nextRain) == false)
            {
                rainfall[entries] = nextRain;
		        entries += 1;
            } else {
                IO.println("Bad input.");
            }
	    }
        
	    // For #4, call the average method here and print the result.
        IO.println("Average rain fall: " + average(rainfall));
    }

    double average(double[] myArray)
    {
	    // For #4, write the code for the average method here
        double total = 0;
        double average = 0;
        int index = 0;
        while(index < myArray.length)
        {
            total += myArray[index];
            index += 1;
        }
        average = total / myArray.length;
	
	    return average;
    }

// For #5, write your isNegative() function here
    boolean isNegative(double number)
    {
        boolean isNegative = false;
        if(number < 0)
        {
            isNegative = true;
        }
        return isNegative;
    }
}
