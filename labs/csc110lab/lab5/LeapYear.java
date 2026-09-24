public class LeapYear 
{
    void main()
    {
        int yearInput = Integer.parseInt(IO.readln("Enter a year: "));

        IO.println("Leap year detected: " + isLeapYear(yearInput));
    }

    boolean isLeapYear(int year)
    {
        boolean leapDetected = false;
        if(year % 100 == 0 && year % 400 == 0)
        {
            leapDetected = true;
        }
        return leapDetected;
    }
}
