import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stuff {
    public static void main(String[] args) {
        Queue<String> cats = new LinkedList<>();
        Stack<String> kittens = new Stack<>();

        cats.add("Tuxedo");
        cats.add("Orange");
        cats.add("Black");

        kittens.add("Mittens");
        kittens.add("Aura Farmer");
        kittens.add("Muffin");

        System.out.println("### QUEUE ###");
        for (int i = 0; i <= cats.size(); i++) {
            System.out.println(cats.remove() + " is being petted");
        }
        System.out.println(cats.peek() + " is being petted");

        System.out.println("");

        System.out.println("### STACK ###");
        for (int i = 0; i <= cats.size(); i++) {
            System.out.println(kittens.pop() + " is being petted");
        }
        System.out.println(kittens.peek() + " is being petted");
    }
}