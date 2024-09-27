/**
 * This class is a submission to the shapes project. 
 * In this class, you are meant to declare various shapes objects from different shape classes.
 * You then call the stats of the different shapes using the convenient methods inside the Shapes_main class.
 * @author Daniel B)
 */
public class Shapes_Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub]
		
		//Instantiates three rectangle objects, then outputs their stats.
		Rectangle rectangle1 = new Rectangle(1, 2);
		Rectangle rectangle2 = new Rectangle(2, 3);
		Rectangle rectangle3 = new Rectangle(3, 4);
		
		getRectangleStats(rectangle1, "rectangle1");
		System.out.print("\n");
		getRectangleStats(rectangle2, "rectangle2");
		System.out.print("\n");
		getRectangleStats(rectangle3, "rectangle3");
		System.out.print("\n");
		
		
		//--------------------------------------------------------------------------------------------------------
		
		
		//Separates the last section from the current section.
		System.out.println("----------------------------------------------------");
		System.out.print("\n");
		
		//Instantiates three right triangle objects, then outputs their stats.
		Right_Triangle rtri1 = new Right_Triangle(1, 1);
		Right_Triangle rtri2 = new Right_Triangle(2, 2);
		Right_Triangle rtri3 = new Right_Triangle(3, 3);
		
		getRight_TriangleStats(rtri1, "rtri1");
		System.out.print("\n");
		getRight_TriangleStats(rtri2, "rtri2");
		System.out.print("\n");
		getRight_TriangleStats(rtri3, "rtri3");
		System.out.print("\n");
		
		
		//--------------------------------------------------------------------------------------------------------
		
		
		//Separates the last section from the current section.
		System.out.println("----------------------------------------------------");
		System.out.print("\n");
		
		//Instantiates three rectangular prism objects, then outputs their stats.
		Rec_Prism rprism1 = new Rec_Prism(1, 1, 1);
		Rec_Prism rprism2 = new Rec_Prism(2, 2, 2);
		Rec_Prism rprism3 = new Rec_Prism(3, 3, 3);
				
		getRec_PrismStats(rprism1, "rprism1");
		System.out.print("\n");
		getRec_PrismStats(rprism2, "rprism2");
		System.out.print("\n");
		getRec_PrismStats(rprism3, "rprism3");
		System.out.print("\n");

		
		//--------------------------------------------------------------------------------------------------------
		
		
		//Separates the last section from the current section.
		System.out.println("----------------------------------------------------");
		System.out.print("\n");
		
		//Instantiates three cylinder objects, then outputs their stats.
		Cylinder cylinder1 = new Cylinder(1, 1);
		Cylinder cylinder2 = new Cylinder(2, 2);
		Cylinder cylinder3 = new Cylinder(3, 3);
				
		getCylinderStats(cylinder1, "cylinder1");
		System.out.print("\n");
		getCylinderStats(cylinder2, "cylinder2");
		System.out.print("\n");
		getCylinderStats(cylinder3, "cylinder3");
		System.out.print("\n");
		
		
		//--------------------------------------------------------------------------------------------------------
		
		
		//Separates the last section from the current section.
		System.out.println("----------------------------------------------------");
		System.out.print("\n");
		
		//Instantiates three sphere objects, then outputs their stats.
		Sphere sphere1 = new Sphere(1);
		Sphere sphere2 = new Sphere(2);
		Sphere sphere3 = new Sphere(3);
				
		getSphereStats(sphere1, "sphere1");
		System.out.print("\n");
		getSphereStats(sphere2, "sphere2");
		System.out.print("\n");
		getSphereStats(sphere3, "sphere3");
		System.out.print("\n");
		
		
		//--------------------------------------------------------------------------------------------------------
		
		
		//Separates the last section from the current section.
		System.out.println("----------------------------------------------------");
		System.out.print("\n");
		
		//Uses the .toString method in the Rectangle class that we learned during class.
		System.out.print(rectangle1.toString());
		
	}
	
	
	/**
	 * This method prints a rectangle's stats.
	 * @param obj is the object.
	 * @param objName is the object's name in a string.
	 */
	public static void getRectangleStats(Rectangle obj, String objName) 
	{
		
		System.out.println("The length of " + objName + " is " + obj.getLength());
		System.out.println("The width of " + objName + " is " + obj.getWidth());
		System.out.println("The perimeter of " + objName + " is " + obj.getPerimeter());
		System.out.println("The area of " + objName + " is " + obj.getArea());
		System.out.println("The shape of " + objName + " is " + obj.getShape());
		
	}
	
	
	/**
	 * This method prints a right triangle's stats.
	 * @param obj is the object.
	 * @param objName is the object's name in a string.
	 */
	public static void getRight_TriangleStats(Right_Triangle obj, String objName) 
	{
		
		System.out.println("The  of " + objName + " is " + obj.getBase());
		System.out.println("The height of " + objName + " is " + obj.getHeight());
		System.out.println("The hypotenuse of " + objName + " is " + obj.getHypotenuse());
		System.out.println("The perimeter of " + objName + " is " + obj.getPerimeter());
		System.out.println("The area of " + objName + " is " + obj.getArea());
		System.out.println("The shape of " + objName + " is " + obj.getShape());
	
	}
	
	
	/**
	 * This method prints a rectangular prism's stats.
	 * @param obj is the object.
	 * @param objName is the object's name in a string.
	 */
	public static void getRec_PrismStats(Rec_Prism obj, String objName)
	{
		
		System.out.println("The length of " + objName + " is " + obj.getLength());
		System.out.println("The width of " + objName + " is " + obj.getWidth());
		System.out.println("The height of " + objName + " is " + obj.getHeight());
		System.out.println("The surface area of " + objName + " is " + obj.getSurface());
		System.out.println("The volume of " + objName + " is " + obj.getVolume());
		System.out.println("The shape of " + objName + " is " + obj.getShape());
	
	}
	
	
	/**
	 * This method prints a cylinder's stats.
	 * @param obj is the object.
	 * @param objName is the object's name in a string.
	 */
	public static void getCylinderStats(Cylinder obj, String objName)
	{
		
		System.out.println("The radius of " + objName + " is " + obj.getRadius());
		System.out.println("The diameter of " + objName + " is " + obj.getDiameter());
		System.out.println("The circumference of " + objName + " is " + obj.getCircumference());
		System.out.println("The height of " + objName + " is " + obj.getHeight());
		System.out.println("The surface area of " + objName + " is " + obj.getSurface());
		System.out.println("The volume of " + objName + " is " + obj.getVolume());
		System.out.println("The shape of " + objName + " is " + obj.getShape());
	
	}
	
	
	/**
	 * This method prints a cylinder's stats.
	 * @param obj is the object.
	 * @param objName is the object's name in a string.
	 */
	public static void getSphereStats(Sphere obj, String objName) 
	{
		
		System.out.println("The radius of " + objName + " is " + obj.getRadius());
		System.out.println("The diameter of " + objName + " is " + obj.getDiameter());
		System.out.println("The circumference of " + objName + " is " + obj.getCircumference());
		System.out.println("The surface area of " + objName + " is " + obj.getSurface());
		System.out.println("The volume of " + objName + " is " + obj.getVolume());
		System.out.println("The shape of " + objName + " is " + obj.getShape());
	
	}
	
}
