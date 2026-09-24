// SER 120L - Lab 2
// Hernest Koroli
package lab2;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        length = 5;
        width = 2.5;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return (length * 2) + (width * 2);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double newLength) {
        length = newLength;
    }

    public void setWidth(double newWidth) {
        width = newWidth;
    }
}