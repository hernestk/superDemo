//BobcatDetector.java

import java.io.IO;

void main()
{
	String hockeyAnswer = IO.readln("Do you like hockey? ").toLowerCase();
	
	
	if(hockeyAnswer.equals("yes") || hockeyAnswer.equals("y"))
    {
		IO.println("You may be a bobcat. More information needed.");
	} else {
        IO.println("You are not a bobcat");
    }

    String potatoAnswer = IO.readln("Do you like Spuds baked potatoes? ").toLowerCase();

    if (potatoAnswer.equals("yes"))
    {
		IO.println("You are definitely a bobcat.");
	} else {
        IO.println("You are not a bobcat.");
    }
	
}
