// SER120L - Lab 5
// Hernest Koroli

public abstract class Animal {
    private String name;
    private int age;
    private String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color; 
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor) {
        color = newColor;
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

