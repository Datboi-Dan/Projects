/**
 * This class is creates Rectangle objects and can output their stats.
 * I also added extra methods like getString that converts that stats of the rectangle to a string, as well as setters to change an objects stats.
 */
public class Rectangle 
{
	
	//data attributes
	private double length;
	private double width;
	
	//constructor
	public Rectangle(double l, double w) 
	{
		
		length = l;
		width = w;
		
	}
	
	public Rectangle(double side)
	{
		
		length = side;
		width = side;
		
	}
	
	//functionalities
	
	/**
	 * The method returns the length of the rectangle.
	 */
	public double getLength() 
	{
		
	return length;
	
	}
	
	/**
	 * This method returns the width of the rectangle.
	 */
	public double getWidth() 
	{
		
	return width;
	
	}
	
	/**
	 * This method returns the perimeter of the rectangle.
	 */
	public double getPerimeter() 
	{
		
		return (2*length) + (2*width);
		
	}
	
	/**
	 * This method returns the area of the rectangle.
	 */
	public double getArea() 
	{
		
		return length * width;
		
	}
	
	/**
	 * This method returns the shape's name.
	 */
	public static String getShape() 
	{
		
		return "Rectangle";
		
	}
	
	/**
	 * This turns everything about the rectangle object to a String.
	 */
	public String toString()
	{
		
		return "This is a rectangle. It has: "
				+ "\nA length of " + length 
				+ "\nA width of " + width
				+ "\nA perimeter of " + getPerimeter()
				+ "\nAnd an area of " + getArea();
		
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
}
