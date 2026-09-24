// Weights.java
// This program should convert between pounds and kilograms

void main()
{
	int pounds = 100;
	double kilos = pounds / 2.205;
	IO.println("A "+ pounds + " lb. weight is equal to " + kilos + " kilograms.");
	
	pounds = Integer.parseInt(IO.readln("Enter a weight in pounds ")); 
    kilos = pounds / 2.205;
	IO.println("That weight is equal to " + (kilos) + " kilograms.");
}