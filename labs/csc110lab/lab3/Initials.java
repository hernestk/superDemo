import java.io.IO;

void main()
{
    String name = IO.readln("Enter your first name: ");
    
    String middleName = IO.readln("Enter your middle name: ");

    String lastName = IO.readln("Enter your last name: ");

    IO.print("Your initials are " + name.substring(0, 1) + ".");
    IO.print(middleName.substring(0, 1) + ".");
    IO.print(lastName.substring(0, 1) + ".");
}
