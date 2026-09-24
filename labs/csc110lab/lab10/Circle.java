// Hernest Koroli
// Circle.java

void main()
{
	Circle myCirc = new Circle(2);
	IO.println(myCirc.getDiameter());

    myCirc.setRadius(5);
    IO.println("myCirc Radius: " + myCirc.getRadius());

    IO.println("Area of myCirc: " + myCirc.getArea());
    IO.println("Circumfrence of myCirc: " + myCirc.getCircumfrence());

}

class Circle
{
	double radius;
	
	Circle(double rad)
    {
		this.radius = rad;
	}
	
	double getRadius()
    {
		return this.radius;
	}

    void setRadius(double newRadius)
    {
        radius = newRadius;
        IO.println("The radius has changed to " + radius);
    }

    double getArea()
    {
        double area = Math.PI * getRadius() * getRadius();

        return area;
    }

    double getCircumfrence()
    {
        double circumfrence = 2 * Math.PI * getRadius();

        return circumfrence;
    }
	
	double getDiameter()
    {
		return this.radius * 2;
	}
}
