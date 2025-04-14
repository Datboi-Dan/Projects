
/**
 * 2. Create a GameTile class that has the following attributes:
 * 
 * boolean hasPlayer
 * 
 * boolean isRevealed
 * 
 * boolean isWall
 * 
 * Make a constructor in which the default value for each attribute is false. 
 * Make setters and getters for each attribute. 
 * Also create a toString() method. 
 * Remember that if you try to print an object, it will instead call the toString() method if the class has one. 
 */
public class GameTile
{

	/**
	 * Boolean representing if the player is at this tile or not.
	 */
	private boolean hasPlayer;
	
	/**
	 * Boolean representing if this tile has been revealed or not.
	 */
	private boolean isRevealed;
	
	/**
	 * Boolean representing if this tile is a wall or not.
	 */
	private boolean isWall;
	
	/**
	 * Constructor for a GameTile object, in which all attributes (hasPlayer, isRevealed, isWall) are initially set to false.
	 */
	public GameTile()
	{
		
		hasPlayer = false;
		isRevealed = false;
		isWall = false;
		
	}
	
	/**
	 * Getter for the hasPlayer attribute.
	 * @return - The hasPlayer attribute (Whether or not the player is at this tile).
	 */
	public boolean hasPlayer()
	{
	
		return hasPlayer;
	
	}

	/**
	 * Setter for the hasPlayer attribute.
	 * @param hasPlayer - What the hasPlayer attribute will be set as (Whether or not the player is at this tile).
	 */
	public void setHasPlayer(boolean hasPlayer)
	{
	
		this.hasPlayer = hasPlayer;
	
	}

	/**
	 * Getter for the isRevealed attribute.
	 * @return The isRevealed attribute (Whether or not this tile is revealed).
	 */
	public boolean isRevealed()
	{
	
		return isRevealed;
	
	}

	/**
	 * Setter for the isRevealed attribute.
	 * @param isRevealed - What the isRevealed attribute will be set as (Whether or not this tile is revealed).
	 */
	public void setRevealed(boolean isRevealed)
	{
	
		this.isRevealed = isRevealed;
	
	}

	/**
	 * Getter for the isWall attribute.
	 * @return The isWall attribute (Whether or not this tile is a wall).
	 */
	public boolean isWall()
	{
	
		return isWall;
	
	}

	/**
	 * Setter for the setWall attribute.
	 * @param isWall - What the isWall attribute will be set as (Whether or not this tile is a wall).
	 */
	public void setWall(boolean isWall)
	{
	
		this.isWall = isWall;
	
	}
	
	public String toString()
	{
		
		//Returns Japanese space if it is not revealed.
		if (!isRevealed)
			return "　";
		
		//Returns kanji for mouth if it is a wall.
		if (isWall)
			return "口";
		
		//Returns kanji for big if the player is on the tile.
		if (hasPlayer)
			return "大";
		
		//Returns the Japanese censor/correct symbol if it is open.
		return "〇";
		
	}
	
}
