// Hernest Koroli
// PointDemo.java

void main() 
{
    Point a = new Point(5, 10);
    Point b = new Point(0, 0);
    Point c = new Point(0, 0);

    a.printMe("a");
    b.printMe("b");

    // getter methods printing
    IO.println("Point A (X): " + a.getX());
    IO.println("Point B (Y): " + b.getY());

    // Point A coordinates have been changed.
    a.setCoords(3, 4);
    IO.println("Point A (X): " + a.getX());
    IO.println("Point A (Y): " + a.getY());

    // Checking if coordinates are equal to another point's coordinates
    IO.println("Coordinates equal for A and B (False): " + a.equals(b));
    IO.println("Coordinates equal for B and C (true): " + b.equals(c));

    double distance = a.distanceTo(b);
    a.printMe("a");
    b.printMe("b");
    IO.println("Distance from a to b: " + distance + ".");
}

// declare class
class Point 
{
    // declare instance variables
    double x;
    double y;

    // constructor
    Point(double initX, double initY) 
    {
        // initialize instance variables
        this.x = initX;
        this.y = initY;
    }

    // method to calculate distance to a second point
    double distanceTo(Point other) 
    {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // getter methods for X and Y
    double getX()
    {
        return x;
    }

    double getY()
    {
        return y;
    }

    // Set coordinates for a point
    void setCoords(double newX, double newY)
    {
        x = newX;
        y = newY;
    }

    boolean equals(Point otherPoint)
    {
        if(getX() == otherPoint.getX() && getY() == otherPoint.getY())
        {
            return true;
        }
        return false;
    }

    void printMe(String label) 
    {
        IO.println(String.format("%s(%.3f, %.3f)", label, this.x, this.y));
    }
}
