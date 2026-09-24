// Hernest Koroli
// SwitchPractice.java

void main()
{
	int choice = Integer.parseInt(IO.readln("Enter choice: "));
	choicePrinter(choice);
}

void choicePrinter(int choice)
{
	switch(choice)
    {
        case 1:
		    IO.println("You selected 1.");
            break;
	    case 2:
        case 3:
		    IO.println("You selected 2 or 3.");
            break;
	    case 4:
		    IO.println("You selected 4.");
            break;
	    default:
		    IO.println("Select again please.");
            break;
    }
    
}
