// SER120L - Lab 3
// Hernest Koroli

public class Cat extends Animal {
    private String name;

    public Cat(String name) {
        super(name);
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
}