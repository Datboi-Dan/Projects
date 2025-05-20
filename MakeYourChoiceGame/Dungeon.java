
/**
 * Class representing the dungeon that the characters will have to traverse.
 */
public class Dungeon
{
	
	//---------------------------------------------------------------------------------------------------------------------
	//Data Attributes
	//---------------------------------------------------------------------------------------------------------------------
	
	
	//The entrance to the dungeon.
	private static Location entrance = new Location("Dungeon Entrance");
	
 	//These are all the paths to the left of the dungeon from the entrance.
	private static Location leftPath = new Location("Left Path");
	private static Location athenaeum = new Location("Dungeon Athenaeum");
	static Location laboratory = new Location("Laboratory");
	
	
	//These are all the paths to the center of the dungeon from the entrance.
	private static Location centerPath = new Location("Center Path");
	private static Location alpha = new Location("Hallway Alpha");
	private static Location omega = new Location("Hallway Omega");
	private static Location rotunda = new Location("Dungeon Rotunda");
		
	
	//These are the paths to the right of the dungeon from the entrance.
	private static Location rightPath = new Location("Right Path");
	private static Location tunnel = new Location("Tunnel");
	private static Location storage = new Location("Storage");
	private static Location secretRoom = new Location("Secret Room (Yeah it's not very secret nor special; this game's a huge work in progress don't worry about it");
	
	//The exit from the dungeon. It's gonna lead to the next floor when I complete the game, but right now it just beats the game.
	private static Location exit = new Location("Dungeon Exit");
	
	//Location that represents the tutorial of the game.
	private static Location currentLocation = new Location("Tutorial", null, entrance, null, null);
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Functionalities
	//---------------------------------------------------------------------------------------------------------------------

	public static void generateDungeon()
	{
		
		//I feel like the method kind of explains itself, but uh, I'll still comment it I guess.
		
		//Sets the path to the left of the entrance to the left path.
		entrance.setLeft(leftPath);
		//Sets the path forward from the entrance to the center path.
		entrance.setForward(centerPath);
		//Sets the path right from the entrance to the right path.
		entrance.setRight(rightPath);
		
		//Sets the path forward from the left path to the athenaeum.
		leftPath.setForward(athenaeum);
		//Sets the path backward from the left path to the entrance.
		leftPath.setBack(entrance);
		
		//Sets the path forward from the athenaeum to the laboratory.
		athenaeum.setForward(laboratory);
		//Sets the path backward from the athenaeum to the left path.
		athenaeum.setBack(leftPath);
		
		//Sets the path backward from the laboratory to the athenaeum.
		laboratory.setBack(athenaeum);
		
		//Sets the path to the left of the the center path to hallway alpha.
		centerPath.setLeft(alpha);
		//Sets the path to the right of the center path to hallway omega.
		centerPath.setRight(omega);
		//Sets the path backward from the center path to the entrance.
		centerPath.setBack(entrance);
		
		//Sets the path forward from hallway alpha to the dungeon rotunda.
		alpha.setForward(rotunda);
		//Sets the path backward from hallway alpha to the center path.
		alpha.setBack(centerPath);
		
		//Sets the path backward from hallway omega to the center path.
		omega.setBack(centerPath);
		
		//Sets the path backward from the dungeon rotunda to hallway alpha.
		rotunda.setBack(alpha);
		
		//Sets the path forward from the right path to a tunnel.
		rightPath.setForward(tunnel);
		//Sets the path to the right from the right path to storage.
		rightPath.setRight(storage);
		//Sets the path backward from the right path to the entrance.
		rightPath.setBack(entrance);
		
		//Sets the path forward from the tunnel to the exit.
		tunnel.setForward(exit);
		
		//Sets the path the right of storage to the "secret" room.
		storage.setRight(secretRoom);
		//Sets the path backward from storage to the right path.
		storage.setBack(rightPath);
		
		//Sets the path backward from the secret room to storage.
		secretRoom.setBack(storage);
		
	}

	/**
	 * Getter for the current location the characters are in.
	 * @return The current location the characters are in.
	 */
	public static Location getCurrentLocation()
	{
	
		return currentLocation;
	
	}

	/**
	 * Setter for the current location the characters are in.
	 * @param currentLocation - The location the characters will move to.
	 */
	public static void setCurrentLocation(Location currentLocation)
	{
	
		Dungeon.currentLocation = currentLocation;
	
	}
	
	
	
	
}
