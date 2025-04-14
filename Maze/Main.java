import java.util.ArrayList;
import java.util.Scanner;

/**
 * I learned that I actually hate random generation. That dice rolling project that I saw you having the last AP Class do might be irksome. Or not. Who knows.
 * MILCS
 * @author Daniel B)
 */
public class Main
{

	/*
	 * 3. Use a Main class in which you create a 5x5 2-D array of GameTile objects. 
	 * Use the setters for isWall on each object to determine which tiles are walls and which tiles are not walls. 
	 * You may build the maze in any configuration you would like, but make sure there is a path of GameTile objects that are not walls that connects the starting point to the finish point. 
	 */
	
	/**
	 * The maze.
	 */
	static GameTile[][] maze = new GameTile[5][5];
	
	/**
	 * Scanner to take in user inputs.
	 */
	static Scanner myReader = new Scanner(System.in);
	
	/**
	 * Fills the maze with tiles, sets up the game with generateMaze(), then runs the game with runGame().
	 * @param args - A parameter that does something that I don't know.
	 */
	public static void main(String[] args)
	{
		
		//Sets each row in the maze to a new GameTile object.
		for (GameTile[] row : maze)
			for (int t = 0; t < row.length; t++)
				row[t] = new GameTile();
		
		//Generates a random maze.
		generateMaze();
		
		//Runs the game.
		runGame();
		
	}
	
	/**
	 * Runs the game.
	 */
	public static void runGame()
	{
		
		//Introduces the game.
		System.out.println("You are 大.");
		printMaze();
		System.out.println("　　　　　^");
		System.out.println("　　　　　|");
		System.out.println("　　　　　|");
		System.out.println("Get here.");
		System.out.println("\nInput, \"left\", \"right\", \"up\", or \"down\" to move.");
		
		//Instantiates a new player object.
		Player player = new Player();
		
		//Lets the user input moves to move the player object until they reach the winning tile.
		while (player.getPos()[0] != maze.length - 1 || player.getPos()[1] != maze[0].length - 1)
			move(validInput(myReader.nextLine().toLowerCase()), player);
		
		//Prints a congratulations message.
		System.out.println("You did it. Yippee.");
		
		//Reveals every tile so that the player can see what the maze looked like.
		for (GameTile[] row : maze)
			for (GameTile tile : row)
				tile.setRevealed(true);
		
		//Prints out the revealed board.
		System.out.println("\nRevealed Board:");
		printMaze();
		
		
	}
	
	/**
	 * Personally I feel that this method should be in the player class, and be called from main. But, since the instructions say to do it in main, I'll follow them.
	 * Moves the player based off of what was passed. 
	 * @param direction - The direction that the player will be moved in.
	 * @param player - The player that will be moved.
	 */
	public static void move(String direction, Player player)
	{
		
		//Moves the player down if the user inputted down, unless at the bottom row.
		if (direction.equals("down") && player.getPos()[0] < maze.length - 1)
		{
			
			//Reveals the tile under the player.
			maze[player.getPos()[0] + 1][player.getPos()[1]].setRevealed(true);
			
			//Moves the player if the tile under the player is not a wall.
			if (!maze[player.getPos()[0] + 1][player.getPos()[1]].isWall())
			{
				
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(false);
				player.setrPos(player.getPos()[0] + 1);
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(true);
				
			}
			
		}
		
		//Moves the player right if the user inputted right, unless at the last column.
		if (direction.equals("right") && player.getPos()[1] < maze[0].length - 1)
		{
			
			//Reveals the tile to the right of the player.
			maze[player.getPos()[0]][player.getPos()[1] + 1].setRevealed(true);
			
			//Moves the player if the tile to the right of the player is not a wall.
			if (!maze[player.getPos()[0]][player.getPos()[1] + 1].isWall())
			{
				
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(false);
				player.setcPos(player.getPos()[1] + 1);
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(true);
				
			}
			
		}
		
		
		//Move the player up if the user inputted up, unless at the top row.
		if (direction.equals("up") && player.getPos()[0] > 0)
		{
			
			//Reveals the tile above the player.
			maze[player.getPos()[0] - 1][player.getPos()[1]].setRevealed(true);
			
			//Moves the player if the tile above the player is not a wall.
			if (!maze[player.getPos()[0] - 1][player.getPos()[1]].isWall())
			{
				
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(false);
				player.setrPos(player.getPos()[0] - 1);
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(true);
				
			}
			
		}
		
		//Moves the player left if the user inputted left, unless at the first column.
		if (direction.equals("left") && player.getPos()[1] > 0)
		{
			
			//Reveals the tile to the left of the player.
			maze[player.getPos()[0]][player.getPos()[1] - 1].setRevealed(true);
			
			//Moves the player if the tile to the left of the player is not a wall.
			if (!maze[player.getPos()[0]][player.getPos()[1] - 1].isWall())
			{
				
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(false);
				player.setcPos(player.getPos()[1] - 1);
				maze[player.getPos()[0]][player.getPos()[1]].setHasPlayer(true);
				
			}
			
		}
		
		//Prints the maze so the user can see what happened.
		printMaze();
		
	}
	
	/**
	 * Validates an input so that the player doesn't break the game, purposefully or accidentally.
	 * @param input - The input to be validated.
	 * @return A valid input. Return statement may not be what was originally inputted, as the method will as for a new input if the original was invalid.
	 */
    public static String validInput(String input) 
    {

    	//Detects if input is "down", "up", "left", or "right". Returns the input as it is if so.
		if (input.equals("down") || input.equals("up") || input.equals("left") || input.equals("right"))
			return input;
		
		//If the input was none of them, asks for a new input, and keeps doing that until the input is valid, in which case that input is returned.
		System.out.println("Invalid Input. Please input something else.");
		return validInput(myReader.nextLine());

    }
	
	/**
	 * Okay, so this along with the pathfind method together is simultaneously the worst and funniest code I've ever written.
	 * I also left in my original idea as a block comment, which I was trying to get working before scrapping the idea and doing this instead.
	 * Basically, this method just keeps completely random mazes until one that's possible to clear shows up.
	 * You don't have to check the block comment if you don't want to read an uncommented mess. It's only there to show the original idea.
	 */
	public static void generateMaze()
	{
		
		/*
		int rng = (int)(Math.random() * 4);
		
		if (rng == 0 && !lastDirection.equals("down") && mazePointer[0] > 0 && getAdjacent(mazePointer[0] - 1, mazePointer[1]) <= 2)
		{
			
			mazePointer[0]--;
			lastDirection = "up";
			System.out.println(lastDirection);
			
		}
		
		if (rng == 1 && !lastDirection.equals("left") && mazePointer[1] < maze[0].length - 1 && getAdjacent(mazePointer[0], mazePointer[1] + 1) <= 2)
		{
			
			mazePointer[1]++;
			lastDirection = "right";
			System.out.println(lastDirection);
			
		}
		
		if (rng == 2 && !lastDirection.equals("up") && mazePointer[0] < maze.length - 1 && getAdjacent(mazePointer[0] + 1, mazePointer[1]) <= 2)
		{
			
			mazePointer[0]++;
			lastDirection = "down";
			System.out.println(lastDirection);
			
		}
		
		if (rng == 3 && !lastDirection.equals("right") && mazePointer[1] > 0 && getAdjacent(mazePointer[0], mazePointer[1] - 1) <= 2) hey mr trauger if you see this reply with your opinion on how funny this terrible maze generator is or else physics isn't a science
		{
			
			mazePointer[1]--;
			lastDirection = "left";
			System.out.println(lastDirection);
			
		}
		
		currentTile.setRevealed(true);
			
		//Check softlock with recursion
		if (getAdjacent(mazePointer[0], mazePointer[1]) > 3)
			return false;
		
		//Call again if not successful yet
		if (mazePointer[0] != maze.length - 1 || mazePointer[1] != maze[0].length - 1)
			generateMaze(maze[mazePointer[0]][mazePointer[1]]);
		
		//Return if success
			return true;
			*/
		
		
		//Sets everything to a wall.
		for (GameTile[] row : maze)
			for (GameTile tile : row)
				tile.setWall(true);
		
		//Sets random tiles to non walls.
		for (GameTile[] row : maze)
			for (GameTile tile : row)
				if (Math.random() >= 0.75)
					tile.setWall(false);
		
		//Keeps generating random mazes until the pathfind method can find a path. 
		if (!pathfind(0, 0, new ArrayList<int[]>()))
			generateMaze();
		else
		{
			
			//Top-left tile holds the player.
			maze[0][0].setHasPlayer(true);
			//Top left tile is revealed.
			maze[0][0].setRevealed(true);
			//Top left tile is not a wall.
			maze[0][0].setWall(false);
			
		}
		
	}
	
	/**
	 * Determines if finding a path through the current maze is possible or not.
	 * Recursively calls itself for each tile until a dead end is found, in which case it will go back to where a split was and go in that direction.
	 * @param row - The row coordinate that the method is looking at.
	 * @param column - The column coordinate that the method is looking at.
	 * @param traveled - The coordinates that have been traveled through by pathfind.
	 * @return Whether or not finding a path through the current maze is possible or not.
	 */
	public static boolean pathfind(int row, int column, ArrayList<int[]> traveled)
	{
		
		//Boolean variable representing if a path was found.
		boolean pathFound = false;
		
		//Adds the passed coordinate to the traveled ArrayList.
		traveled.add(new int[] {row, column});
				
		//Returns true if the coordinate is the bottom right (winning) coordinate.
		if (row == maze.length - 1 && column == maze[0].length - 1)
			return true;
		
		//Checks if the coordinate below the passed one is open or not, and path finds from that coordinate if so.
		if (row < maze.length - 1 && !maze[row + 1][column].isWall() && !coordinateTraveled(row + 1, column, traveled))
			pathFound = pathfind(row + 1, column, traveled);
		
		//Checks if the coordinate to the right of the passed one is open or not, and path finds from that coordinate if so. Skips if a path was already found or the coordinate was already traveled.
		if (column < maze[0].length - 1 && !maze[row][column + 1].isWall() && !pathFound && !coordinateTraveled(row, column + 1, traveled))
			pathFound = pathfind(row, column + 1, traveled);
		
		
		//Checks if the coordinate above the passed one is open or not, and path finds from that coordinate if so. Skips if a path was already found or the coordinate was already traveled.
		if (row > 0 && !maze[row - 1][column].isWall() && !pathFound && !coordinateTraveled(row - 1, column, traveled))
			pathFound = pathfind(row - 1, column, traveled);
		
		//Checks if the coordinate to the left of the passed one is open or not, and path finds from that coordinate if so. Skips if a path was already found or the coordinate was already traveled.
		if (column > 0 && !maze[row][column - 1].isWall() && !pathFound && !coordinateTraveled(row, column - 1, traveled))
			pathFound = pathfind(row, column - 1, traveled);
		
		//Returns if a path was found.
		return pathFound;
		
		
	}
	
	/**
	 * Checks if the passed coordinate is contained in the passed ArrayList of coordinates.
	 * @param row - The passed row coordinate.
	 * @param column - The passed column coordinate
	 * @param traveled - The ArrayList of traveled coordinates.
	 * @return Whether or not the passed coordinate is contained in the passed ArrayList.
	 */
	public static boolean coordinateTraveled(int row, int column, ArrayList<int[]> traveled)
	{
		
		//Iterates through every coordinate in traveled.
		for (int[] coordinate : traveled)
			//Returns true if the coordinate is the same as the passed one.
			 if (coordinate[0] == row && coordinate[1] == column)
				 return true;
		
		//Returns false if there was no match.
		return false;
		
	}
	
	/**
	 * Prints the maze.
	 */
	public static void printMaze()
	{
		
		//Iterates through each row.
		for (GameTile[] row : maze)
		{
			
			//Prints a bracket to signify start of row.
			System.out.print('[');
			
			//Prints out each tile.
			for (GameTile tile : row)
				System.out.print(tile);
			
			//Prints a bracket to signify end of row.
			System.out.println(']');
			
		}	
		
	}
	
}
