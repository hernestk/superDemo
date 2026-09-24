public class Main {
    public static void main(String[] args) {
        Cat myCat = new Cat("Fluff Ball");

        IO.println("My cat's name is " + myCat.getName());
        IO.println(myCat.getName() + " speak.");
        myCat.speak();
        myCat.action();
        myCat.eat();
        myCat.sleep();

        // If you want generic methods to test
        // remove the eat() and sleep() methods from the Cat class
        // making the eat() and sleep avaiable from the Animal class
    }
}
