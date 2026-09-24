// SER120L - Lab 5
// Hernest Koroli

public class Cat extends Animal implements Pet {
    private String name;
    private int age;
    private String color;
    private boolean isAdopted;
    private String ownerName;
    private final String type = "Cat";

    public Cat(String name, int age, String color) {
        super(name, age, color);
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setIsAdopted(boolean newAdoptionStatus) {
        isAdopted = newAdoptionStatus;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String newOwnerName) {
        ownerName = newOwnerName;
    }

    public final String getType() {
        return type;
    }

    public void speak() {
        IO.println(getName() + " says meow meow.");
    }

    public void action() {
        IO.println(getName() + " plays with a ball of yarn.");
    }

    public void eat() {
        IO.println(getName() + " is eating nom nom nom... fish");
    }

    public void sleep() {
        IO.println(getName() + " sleeps on the cat tower menacingly");
    }

    public void printAboutMe() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Color: " + getColor());
    }
}
