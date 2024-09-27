/**
 * This class is creates Cylinder objects and can output their stats.
 */
public class Cylinder 
{
	
	//data attributes
	private final double pi = 3.1415926535897932384626433832795028841971693993751;
	private double radius;
	private double height;
		
	//constructor
	public Cylinder(double r, double h) 
	{
		
		radius = r;
		height = h;
	
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
	 * This method returns the height of the cylinder.
	 */
	public double getHeight() 
	{
		
		return height;

	}
	
	/**
	 * This method returns the surface area of the cylinder.
	 */
	public double getSurface() 
	{
		
		return (2*pi*radius*height) + (2*pi*(radius*radius));
	
	}
	
	/**
	 * This method returns the volume of cylinder.
	 */
	public double getVolume() 
	{
		
		return pi*(radius*radius)*height;
	
	}
	
	/**
	 * This method returns the shape's name.
	 */
	public static String getShape() 
	{
		
	return "Cylinder";
	
	}

}
