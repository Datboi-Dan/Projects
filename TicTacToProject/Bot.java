import java.util.ArrayList;

public class Bot
{
	
	/**
	 * The difficulty of the bot.
	 */
	String mode;
	
	/**
	 * A virtual board that the bot uses to plan its moves.
	 */
	static char[][] virtualBoard = 
		{
				
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '}
				
		};
	
	/**
	 * An array list of all the test moves that the bot has taken.
	 */
	ArrayList<Integer> moveStack = new ArrayList<Integer>();
	
	/**
	 * Constructor for Bot object.
	 * @param mode - The difficulty of the bot. Values other than "medium" and "hard" will default to the easy mode.
	 */
	public Bot(String mode)
	{
		
		//Set the bot's mode to the passed mode.
		this.mode = mode;
		
	}
	
	/**
	 * Method to make the bot choose a column to place a piece.
	 * May return different values depending on what the mode variable is, with values of "medium" and "hard" return smarter moves that are more planned out.
	 * @return - 
	 */
	public int act()
	{
		
		//Syncs the virtual board to the main board.
		syncBoard();
		
		//Returns a planned out move from smartMove() that has been double checked by the method lookAhead().
		if (mode.equals("hard"))
			return lookAhead(smartMove());
		
		//Returns a planned out move from smartMove().
		else if (mode.equals("medium"))
			return smartMove();
		
		//Randomly generates an integer from 0-2. If the integer is greater than 0, a planned out move from smartMove() is returned.
		else if ((int)(Math.random() * 3) > 1)
			return smartMove();
		
		//Otherwise, it places it in a random open spot, checking to see that it doesn't immediately lose.
		else
			return placeInOpen();
		
	}
	
	/**
	 * Method that the bot uses to plan out its move and before choosing a column.
	 * @return
	 */
	public int smartMove()
	{
		
		//Syncs the virtual board to the main board.
		syncBoard();
		
		//Win immediately if possible.
		if (predictWin('O') != -1)
			return predictWin('O');
		
		//If an immediate win is not possible, blocks any wins that the opponent can get on the next turn.
		if (predictWin('X') != -1)
			return predictWin('X');
		
		//If no wins were found, looks for the first sequence of two moves that allows the opponent to win, and blocks the first move in that sequence.
		if (findSetUps('X').size() > 0 && isSafe(findSetUps('X').get(0)))
			return findSetUps('X').get(0);
		
		//If no sequences of two moves were found for the opponent, looks for sequences that allows to the bot to win.
		if (findSetUps('O').size() > 0  && isSafe(findSetUps('O').get(0)))			
			return findSetUps('O').get(0);
		
		//If no sequences of two moves were found for the bot, chooses whatever placeInOpen returns. Method is explained in the javadoc as well as in the method itself.
		return placeInOpen();
		
		
		
		
	}
	
	/**
	 * Double checks the passed column, looking even further ahead to make sure it is safe.
	 * @param column - The column the bot initially chose to place their piece.
	 * @return
	 */
	public int lookAhead(int column)
	{
		
		//Syncs the virtual board to the main board.
		syncBoard();
		
		//Tests the move.
		testPlace(column, 'O');
		
		//Checks to see if a win occurred, and returns the column if so as the choice was the winning move.
		if (detectWin('O'))
			return column;
		
		//A win didn't occur, looks to see if there are any sequences of two moves that win for the opponent.
		if (findSetUps('X').size() > 0)
		{
			
			//Stores all the first moves of all the sequences in the potentialWins variable.
			ArrayList<Integer> potentialWins = findSetUps('X');
			
			//Runs until all the sequences have been tested to see if the bot can stop a win, or a value is returned.
			while (potentialWins.size() > 0)
			{
				
				//Test the move.
				testPlace(potentialWins.get(0), 'X');
				
				//Place to stop win.
				testPlace(predictWin('X'), 'O');
				
				//Check if the opponent can win in a different way.
				if (predictWin('X') != -1)
				{
					
					//At this point, this is the last resort. The method tries to find a safe move, but if it can't, it returns the first open column.
					return placeInOpen();
					
				}
				//Otherwise, the sequence can be stopped, so the next sequence is checked.
				else
				{
					
					//Rolls the two test moves.
					rollback();
					rollback();
					
					//Removes the current sequence from the queue.
					potentialWins.remove(0);
					
				}
				
			}
			
			//Returns the initial choice as it is possible to stop all sequences.
			return column;
			
		}
		//Otherwise returns the original choice as there were no setups for the opponent found.
		else
			return column;
		
	}
	
	/**
	 * Checks to see that a move doesn't lose on the next turn.
	 * @param column - The column where the piece would be placed in.
	 * @return Boolean representing if the move is safe, or doesn't lose on the next turn.
	 */
	public boolean isSafe(int column)
	{
		
		//Places a piece in a column and returns true, or if the column is full already, returns false and stores it in the placed variable. 
		boolean placed = testPlace(column, 'O');
		
		//Checks to see if a win is possible after a piece was placed, and returns false if so representing that the move was unsafe.
		if (predictWin('X') != -1 && placed)
		{
			
			//Rolls the move back.
			rollback();
			
			//Returns false.
			return false;
			
		}
		
		//Rolls the test move back if a piece was placed.
		if (placed)
			rollback();
		
		//Returns true, representing that the move was safe.
		return true;
		
	}
	
	/**
	 * Checks to see if a sequence of two moves can win.
	 * @param piece - The piece that is being checked for sequences.
	 * @return An arrayList with all possible setups, or sequences of two moves.
	 */
	public ArrayList<Integer> findSetUps(char piece)
	{
		
		//Instantiates a new ArrayList.
		ArrayList<Integer> possibleSetups = new ArrayList<Integer>();
		
		//Loops through each column of the virtualBoard, starting from the middle, then alternating to the left and right advancing towards the edge columns.
		int n = 0;
		for (int c = 3; c < virtualBoard[0].length && c >= 0; c += n)
		{
			
			//Places a piece in a column and returns true, or if the column is full already, returns false and stores it in the placed variable.
			boolean placed = testPlace(c, piece);
			
			//Checks to see if a win is possible after a piece was placed, and returns false if so representing that the move was unsafe.
			if ((predictWin(piece) != -1 || detectWin(piece)) && placed)
				possibleSetups.add(c);
		
			//Rolls the test move back if a piece was placed.
			if (placed)
				rollback();
			
			//Takes the absolute value of n and increments it.
			n = Math.abs(n) + 1;
			
			//Makes n negative if it is odd.
			if (n % 2 != 0)
				n *= -1;
			
			
		}
		
		//Returns the ArrayList containing all the first moves of each setup that was found.
		return possibleSetups;
		
	}
	
	/**
	 * Predicts if the passed piece can win with the current virtual board state.
	 * @param piece - The piece that is being checked for possible wins.
	 * @return The column that the piece should be placed in to win, or -1 if there is no way to win in the current position.
	 */
	public int predictWin(char piece)
	{
		
		//Loops through each column of the virtualBoard, starting from the middle, then alternating to the left and right advancing towards the edge columns.
		int n = 0;
		for (int c = 3; c < virtualBoard[0].length && c >= 0; c += n)
		{
			
			//Places a piece in a column and returns true, or if the column is full already, returns false and stores it in the placed variable.
			boolean placed = testPlace(c, piece);
			
			//Checks to see if there was a win after the piece was placed, and returns false if so representing that the move was unsafe.
			if (detectWin(piece) && placed)
			{
				
				//Rolls the test move back.
				rollback();
				
				//Returns the move that won.
				return c;
				
			}
			
			//Rolls the test move back if a piece was placed.
			if (placed)
				rollback();
			
			//Takes the absolute value of n and increments it.
			n = Math.abs(n) + 1;
			
			//Makes n negative if it is odd.
			if (n % 2 != 0)
				n *= -1;
				
			
		}
		
		//Returns -1 if a win was not able to be predicted.
		return -1;
		
	}
	
	/**
	 * Returns the first open column starting from the middle that would not result in a loss if a piece is placed in.
	 * If all columns would result in a loss if a piece were to be placed in it, it returns the first open column starting from the middle.
	 * @return
	 */
	public int placeInOpen()
	{
		
		//Loops through each column of the virtualBoard, starting from the middle, then alternating to the left and right advancing towards the edge columns.
		int n = 0;
		for (int c = 3; c < virtualBoard[0].length && c >= 0; c += n)
		{
			
			//Returns the current column if it's not full and placing a piece in it is safe.
			if (virtualBoard[0][c] == ' ' && isSafe(c))
				return c;
			
			n = Math.abs(n) + 1;
			
			if (n % 2 != 0)
				n *= -1;
			
		}
		
		n = 0;
		for (int c = 3; c < virtualBoard[0].length && c >= 0; c += n)
		{
			
			if (virtualBoard[0][c] == ' ')
				return c;
			
			//Takes the absolute value of n and increments it.
			n = Math.abs(n) + 1;
			
			//Makes n negative if it is odd.
			if (n % 2 != 0)
				n *= -1;
			
		}
		
		//Returns -1 if there are no open columns at all.
		return -1;
		
	}
	
	
	/**
	 * Places a piece in a column.
	 * @param column - The column the user wants to place the piece in.
	 * @param piece - The piece to be placed.
	 * @return A boolean representing if the piece was able to be placed.
	 */
	public boolean testPlace(int column, char piece)
	{
		
		//Loops through the rows starting from the bottom.
		for (int row = virtualBoard.length - 1; row >= 0; row--)
		{
			
			//Detects if the location at the row-column pair is empty, and places the piece if so.
			if (virtualBoard[row][column] == ' ') 
			{
				
				//Places the piece in the row-column position.
				virtualBoard[row][column] = piece;
				//Adds the move to the moveStack.
				moveStack.add(column);
				//Returns true, meaning the piece was placed, and ends the method.
				return true;
				
			}
			
		}
		
		//If nothing was returned, all the rows were looped through without placing a piece, meaning the column that was passed is full.
		//Returns false as no piece was placed.
		return false;
		
	}
	
	/**
	 * Detects if four in a row has occurred anywhere on the board with the passed piece.
	 * @param piece - The piece to detected if there is four in a row of.
	 * @return A boolean representing if there is four in a row of the passed piece.
	 */
	public boolean detectWin(char piece)
	{
		
		//Keeps track of how many pieces there are in a row horizontally.
		int count = 0;
		
		//Loops through each row, starting from the bottom.
		for (int r = virtualBoard.length - 1; r >= 0; r--)
		{
			
			//Loops through each column, starting from the left.
			for (int c = 0; c < virtualBoard[r].length; c++)
			{
				
				//Runs if the position at the row-column pair holds the passed piece.
				if (virtualBoard[r][c] == piece)
				{
					
					//Detects if there are three in a row above the piece (in all directions), and returns true if there is.
					if (detect3Above(r, c, piece))
						return true;
					
					//Increments the count variable.
					count++;
					
					//Returns true if count has been incremented four times in a row (meaning there were four consecutive pieces horizontally).
					if (count >= 4)
						return true;
					
				}
				//Runs if the position at the row-column pair does not hold the passed piece.
				else
				{
					
					//Resets the count.
					count = 0;
					
				}
				
			}
			
			//Resets the count before moving to the next row.
			count = 0;
			
		}
		
		//If true has not been returned by this time, there is no connect 4 of the passed piece, and thus false is returned.
		return false;
		
	}
	
	/**
	 * Logic heavy method detecting if there are four consecutive starting from the passed row-column position.
	 * @param row - The row that the method is starting from.
	 * @param column - The column the method is starting from.
	 * @param piece - The piece as the passed row-column position.
	 * @return A boolean representing if there were four consecutive pieces going upwards starting from the given row-column position.
	 */
	public boolean detect3Above(int row, int column, char piece)
	{
		
		//Detects if there is four in a row going northwest. Does not run if starting before column 3 or above row 3 to prevent IndexOutOfBoundsException.
		if (column >= 3 && row >= 3 && virtualBoard[row - 1][column - 1] == piece)
		{
			
			if (virtualBoard[row - 2][column - 2] == piece)
			{
				
				if (virtualBoard[row - 3][column - 3] == piece)
				{
					
					return true;
					
				}
				
			}
			
		}
		//Detects if there is four in a row going northeast. Does not run if starting after column 3 or above row 3 to prevent IndexOutOfBoundsException.
		if (column <= 3 && row >= 3 && virtualBoard[row - 1][column + 1] == piece)
		{
			
			if (virtualBoard[row - 2][column + 2] == piece)
			{
				
				if (virtualBoard[row - 3][column + 3] == piece)
				{
					
					return true;
					
				}
				
			}
			
		}
		//Detects if there is four in a row going straight up. Does not run if starting above row 3 to prevent IndexOutOfBoundsException.
		if (row >= 3 && virtualBoard[row - 1][column] == piece)
		{
			
			if (virtualBoard[row - 2][column] == piece)
			{
				
				if (virtualBoard[row - 3][column] == piece)
				{
					
					return true;
					
				}
				
			}
			
		}
		
		//If true has not been returned at this point, false is returned as there was no connect four detected going upwards in any direction.
		return false;
		
	}
	
	
	/**
	 * Syncs the virtualBoard with the main board.
	 */
	public void syncBoard()
	{
		
		//Loops through each row of the main board.
		for (int r = 0; r < ConnectFour.board.length; r++)
		{
			
			//Loops through each column in a row.
			for (int c = 0; c < ConnectFour.board[0].length; c++)
				//Sets the virtualBoard position at the row-column to the row-column position at the main board.
				virtualBoard[r][c] = ConnectFour.board[r][c];
			
		}
			
		
	}
	
	/**
	 * Rolls the most recent test move back.
	 * Only returns a value to stop the loop early, since you don't want us to use break.
	 * @return - true if a movie was rolled back, and false otherwise.
	 */
	public boolean rollback()
	{
		
		//Loops through each row starting from the bottom.
		for (int r = virtualBoard.length - 1; r >= 0; r--)
		{
			
			//If the current row is the top and the column is full, pops a column from the stack and uses it to remove the piece at the row-column pair. Returns true to end method.
			if (r == 0 && virtualBoard[r][moveStack.get(moveStack.size() - 1)] != ' ')
			{
				
				virtualBoard[r][moveStack.remove(moveStack.size() - 1)] = ' ';
				return true;
				
			}	
			//Otherwise, if the row-column pair is empty, goes one row down, pops the column from the move stack and removes the piece at the row column pair. Returns true to end method.
			else if (virtualBoard[r][moveStack.get(moveStack.size() - 1)] == ' ')
			{
				
				virtualBoard[r + 1][moveStack.remove(moveStack.size() - 1)] = ' ';
				return true;
				
			}	
			
		}
		
		//Returns false, but the code will never reach this point unless there's something wrong with the code.
		return false;
		
	}
	
	/**
	 * Prints the current board state to the console.
	 */
	public static void printBoard()
	{
		
		//Loops through each row in the board.
		for (char[] row : virtualBoard)
		{
			
			//Prints "[" for the start of the row.
			System.out.print("[");
			
			//Loops through each column in the row.
			for (int i = 0; i < row.length; i++)
			{
				
				//Prints out the element held at the row-column position.
				System.out.print(row[i]);
				
				//If the element is not the last element in the row, prints "|" to separate the current column from the next.
				if (i < row.length - 1)
					System.out.print("|");
				
			}
			
			//Prints "[" for the end of the row.
			System.out.println("]");
			
		}
		
		//Labels the columns.
		System.out.println(" 1 2 3 4 5 6 7");
		
	}
	
}
