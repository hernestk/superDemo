// SER 120L - Lab 2
// Hernest Koroli
package lab2;

public class RectangleTester {
    public static void main(String[] args) {
        Rectangle defaultRect = new Rectangle();
        Rectangle myRect = new Rectangle(2, 6);

        System.out.println("My rectangle has:");
        System.out.println("width: " + defaultRect.getWidth());
        System.out.println("height: " + defaultRect.getLength());
        System.out.println("area: " + defaultRect.getArea());
        System.out.println("perimeter: " + defaultRect.getPerimeter() + "\n");

        System.out.println("My rectangle has:");
        System.out.println("width: " + myRect.getWidth());
        System.out.println("height: " + myRect.getLength());
        System.out.println("area: " + myRect.getArea());
        System.out.println("perimeter: " + myRect.getPerimeter());

    }
}
