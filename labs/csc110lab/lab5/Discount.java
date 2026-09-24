public class Discount 
{
    // Discount.java
// Use this code for #1 in Lab 5

void main(){
	double originalPrice = Double.parseDouble(IO.readln("Enter the original price of the item: "));
	int percentDiscount = Integer.parseInt(IO.readln("Enter the percentage of the discount: "));
	
	
	IO.println("The final price is " + discount(originalPrice, percentDiscount));
}

    // For #1, write your new function below.
    public double discount(double price, int percentDiscount)
    {
        double amountOff = price * (percentDiscount / 100.0);
	    double finalPrice = price - amountOff;

        return finalPrice;
    }
}
