//BrokenLoop.java
void main()
{
	int number = 23;
	int loops = 0;
    
	while(number >= 0)
    {
		loops = loops + 1;
		IO.println("This is loop #" + loops + " and number is " + number);
		number = number - 3;
	}
}
