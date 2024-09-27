/**
 * This class is creates Sphere objects and can output their stats.
 */
public class Sphere 
{
	
	//data attributes
	private final double pi = 3.1415926535897932384626433832795028841971693993751;
	private double radius;
	
	//constructor
	public Sphere(double r) 
	{
		
		radius = r;
		
	}
	
	//functionalities
	
	/**
	 * This method returns the radius of the cylinder.
	 */
	public double getRadius() 
	{
		
		return radius;
		
	}
	
	/**
	 * This method returns the diameter of the cylinder.
	 */
	public double getDiameter() 
	{
		
		return 2 * radius;
		
	}
	
	/**
	 * This method returns the circumference of the sphere.
	 */
	public double getCircumference() 
	{
		
		return pi * 2 * radius;
		
	}
	
	/**
	 * This method returns the surface area of the sphere.
	 */
	public double getSurface() 
	{
		
		return 4 * pi * (radius * radius);
		
	}
	
	/**
	 * This method returns the volume of the sphere.
	 */
	public double getVolume() 
	{
		
		return (4/3)*pi*(radius * radius * radius);
		
	}
	
	/**
	 * This method returns the shape's name.
	 */
	public static String getShape() 
	{
		
		return "Sphere";
		
	}
	
}
