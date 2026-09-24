import java.io.IO;

void main()
{
    String cookies = IO.readln("How many cookies do you want to make: ");
    double flour = 2.25/60 * Double.parseDouble(cookies);
    double butter = 0.01666666667 * Double.parseDouble(cookies);
    double sugar = 0.75/60 * Double.parseDouble(cookies);

    IO.println(flour + " cups of flour");
    IO.println(butter + " cups of butter");
    IO.println(sugar + " cups of sugar");

}
