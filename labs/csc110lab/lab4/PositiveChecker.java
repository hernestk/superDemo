import java.io.IO;

void main()
{
    boolean running = true;

    while (running)
    {
        int number = Integer.parseInt(IO.readln("Enter a number: "));

        if(number > 0)
        {
            IO.println("This is a positive number");
        } else if (number < 0)
        {
            IO.println("This is a negative number");
        } else {
            IO.println("Program Ended.");
            running = false;
        }
    }
}
        
