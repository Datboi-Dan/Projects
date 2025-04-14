
/**
 * 1. Create a Player class that has just two attributes, rPos and cPos which translate into the player's row and column position on the board. 
 * Make a constructor to set the initial values for both attributes to 0. For the functionalities (methods), just make setters and getters.
 */
public class Player
{
	
	/**
	 * Row position in the maze.
	 */
	int rPos;
	
	/**
	 * Column position in the maze.
	 */
	int cPos;
	
	/**
	 * Constructor for player, where rpos and cpos are both set to 0 initially.
	 */
	public Player()
	{
		
		rPos = 0;
		cPos = 0;
		
	}

	/**
	 * Gets the position of the player in the maze as an array of two ints, where the 0th index is the rpos and the 1st index is the cpos.
	 * @return The position of the player object as an array.
	 */
	public int[] getPos()
	{
	
		return new int[] {rPos, cPos};
	
	}

	/**
	 * Sets the rpos attribute to whatever is passed.
	 * @param rPos - The number the rpos attribute will be set to.
	 */
	public void setrPos(int rPos)
	{
	
		this.rPos = rPos;
	
	}

	/**
	 * Sets the cpos attribute to whatever is passed.
	 * @param cPos - The number the cpos attribute will be set to.
	 */
	public void setcPos(int cPos)
	{
	
		this.cPos = cPos;
	
	}		
	
}
