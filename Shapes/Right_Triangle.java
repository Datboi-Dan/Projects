/**
 * This class is creates Right_Triangle and can output their stats.
 */
public class Right_Triangle 
{
	
	//data attributes
	private double base;
	private double height;
	final private double hypotenuse = Math.sqrt((base*base)+(height*height));
	
	//constructor
	public Right_Triangle(double b, double h) 
	{
		
		base = b;
		height = h;
		
	}
	
	//functionalities
	
	/**
	 * This method returns the base of the right triangle.
	 */
	public double getBase() 
	{
		
		return base;
		
	}
	
	/**
	 * This method returns the height of the right triangle.
	 */
	public double getHeight() 
	{
		
		return height;
		
	}
	
	/**
	 * This method returns the hypotenuse of the right triangle.
	 */
	public double getHypotenuse() 
	{
		
		return hypotenuse;
		
	}
	
	/**
	 * This method returns the perimeter of the right triangle.
	 */
	public double getPerimeter() 
	{
		
		return base + height + hypotenuse;
		
	}
	
	/**
	 * This method returns the area of the triangle.
	 */
	public double getArea() 
	{
		
		return (base*height)/2;
		
	}
	
	/**
	 * This method returns the shape's name.
	 */
	public static String getShape() 
	{
		
		return "Triangle (Right)";
		
	}
	
}
