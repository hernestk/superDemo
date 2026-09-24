// SER120L - Lab 3
// Hernest Koroli

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void speak();

    public abstract void action();

    public void eat() {
        IO.println(getName() + " is eating some food.");
    }

    public void sleep() {
        IO.println(getName() + " is getting some sleep.");
    }
}
