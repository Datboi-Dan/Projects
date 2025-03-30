import java.util.Scanner;

/**
 * This would have taken much longer if I hadn't done tic-tac-toe and just used that code as a sort of base.
 * If you look at the code for that (found in the personal repository) you an find some similarities.
 * I feel like I could probably write this a lot more efficiently, and with a lot less logic but, ah well.
 * MILCS
 * @author Daniel B)
 */
public class ConnectFour
{
	
	/**
	 * The reader that will scan the user input from System.in.
	 */
	static Scanner myReader = new Scanner(System.in);
	
	/**
	 * Keeps track of how many turns have passed.
	 */
    static int turnCount = 0;
    
    /**
     * The Connect4 board, represented as a 2d array of 6 rows and 7 columns.
     */
	static char[][] board = 
		{
				
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' '}
				
		};
	
	/**
	 * The main method. Most of the game is handled in the playGame() method, but the main method does stuff like introduce the game and announcing the results.
	 * @param args
	 * @throws DumbassException
	 */
	public static void main(String args[]) throws DumbassException
	{
		
		//Introduces the game.
		System.out.println("When entering a column, please just use the number and don't type it out. You won't like what happens if ignore this warning. Now then.");
		
		//Prints the board, which is empty at the start.
		printBoard();
		
		//Runs the game and records the winner.
		String winner = playGame();
		
		//If playGame() returns tie, that means that all the squares are filled without an occurrence of four in a row, in which case, "Tie!" will be printed out.
		if (winner == "tie")
			System.out.println("Tie!");
		//Otherwise it will return the winner and the else block will print out who won.
		else
			System.out.println("\n" + winner + " wins!");
		
	}
	
	/**
	 * Where most of the methods are called and the game is played. Recursively calls itself until a winner is found.
	 * @return The winner of the game as a string, or if there is no winner, returns "tie".
	 */
	public static String playGame()
	{
		
		//Player 1's turn.
		System.out.println("Player 1's turn.");
		//Player 1's pieces are represented by the char 'X', which is why 'X' is passed into the turn method, which will give Player 1 their turn.
		turn('X');
		
		//After the turn has concluded, the board is printed, showing where the piece is placed.
		printBoard();
		
		//Skips a line for console readability.
		System.out.println();
		
		//Detects if the game was won by Player 1, in which case "Player 1" is returned and the method breaks.
		if (gameWon('X'))
			return "Player 1";
		
		//Player 2's turn.
		System.out.println("Player 2's turn.");
		//Player 2's pieces are represented by the char 'X', which is why 'X' is passed into the turn method, which will give Player 1 their turn.
		turn('O');
		
		//After the turn has concluded, the board is printed, showing where the piece is placed.
		printBoard();
		
		//Skips a line for console readability.
		System.out.println();
		
		//Detects if the game was won by Player 2, in which case "Player 2" is returned and the method breaks.
		if (gameWon('O'))
			return "Player 2";
		
		//Detects if a tie has occurred, and if so, returns "tie". Detection works by keeping track of how many turns have passed. 
		//When it hits 42 (the amount of squares on the board), the board has been filled without a connect 4, and thus the game is a tie.
		//Since there are an even number of pieces, a tie can only occur after Player 2's turn, so there is only a detection after every turn of Player 2.
		if (turnCount >= 42)
			return "tie";
		
		//If nothing has been returned, calls itself again until something does get returned.
		return playGame();
		
	}
	
	/**
	 * Gives a player their turn.
	 * @param piece - The piece that the player is using this turn.
	 */
	public static void turn(char piece)
	{
		
		//Prompts the player to select a column to place their piece in.
		System.out.println("Select a column to place your piece: 1 | 2 | 3 | 4 | 5 | 6 | 7");
		
		//Validates the player's input (making sure it's a number from 1 - 7) and stores it in the column variable.
		int column = validInput(myReader.nextLine().toLowerCase());
		
		/*
		 * From the following code onward in this method, I realized that there's probably a more efficient way to write it in retrospect.
		 * However, if you're still seeing this message, that means I was too lazy to rewrite it.
		 */
		
		//Places the piece in the specified column. 
		boolean placed = place(column - 1, piece);
		//If the column is full, asks the player to input a different column. 
		while (!placed)
		{
			
			placed = place(validInput(myReader.nextLine().toLowerCase()), piece);
			
		}
		
	}
	
	/**
	 * Places a piece in a column.
	 * @param column - The column the user wants to place the piece in.
	 * @param piece - The piece to be placed.
	 * @return A boolean representing if the piece was able to be placed.
	 */
	public static boolean place(int column, char piece)
	{
		
		//Loops through the rows starting from the bottom.
		for (int row = board.length - 1; row >= 0; row--)
		{
			
			//Detects if the location at the row-column pair is empty, and places the piece if so.
			if (board[row][column] == ' ') 
			{
				
				board[row][column] = piece;
				//Increments the turn count.
				turnCount++;
				//Returns true, meaning the piece was placed, and ends the method.
				return true;
				
			}
			
		}
		
		//If nothing was returned, all the rows were looped through without placing a piece, meaning the column that was passed is full.
		//Returns false as no piece was placed.
		System.out.println("This column is full! Please select another column.");
		return false;
		
	}
	
	/**
	 * Validates an input so that the player doesn't break the game, purposefully or accidentally.
	 * @param input - The input to be validated.
	 * @return A valid input. Return statement may not be what was originally inputted, as the method will as for a new input if the original was invalid.
	 */
	public static int validInput(String input) 
	{

		//Detects if the player inputted a column, but as word. Punishes them by not letting them play anymore. I warned them in the introduction. :P
		if (input.equals("one") || input.equals("two") || input.equals("three") || input.equals("four") || input.equals("five") || input.equals("six") || input.equals("seven")) 
        {
			
			//Infinite loop of printing, "Whoah guys, we got smartie here. Tell you what. No more game for you."
			while (true)
				System.out.println("Whoah guys, we got smartie here. Tell you what. No more game for you.");

        }
		
		//Detects if the input is an int using the isInt() method. Necessary so that parseInt does not incur NumberFormatException and end the game prematurely.
		if (isInt(input))
		{
			
			//Parses the input as an int.
	        int column = Integer.parseInt(input);
	
	        //Asks the player for a new input if the inputted column was outside of the range of 1 - 7 inclusive.
	        if (!(column >= 1 && column <= 7)) 
	        {
	
	        	System.out.println("Pick a column 1 through 7.");
		        column = validInput(myReader.nextLine().toLowerCase());
	
	        }
	        
	        //Returns the column that was inputted.
	        return column;
        
		} 
		//If this block runs, their input was not a valid integer input, and asks them for a new input.
		else
		{
				
	        System.out.println("Not an integer. Please make a new input.");
	        return validInput(myReader.nextLine().toLowerCase());
        
		}
        
	}
	
	/**
	 * Detects if four in a row has occurred anywhere on the board with the passed piece.
	 * @param piece - The piece to detected if there is four in a row of.
	 * @return A boolean representing if there is four in a row of the passed piece.
	 */
	public static boolean gameWon(char piece)
	{
		
		//Keeps track of how many pieces there are in a row horizontally.
		int count = 0;
		
		//Loops through each row, starting from the bottom.
		for (int r = board.length - 1; r >= 0; r--)
		{
			
			//Loops through each column, starting from the left.
			for (int c = 0; c < board[r].length; c++)
			{
				
				//Runs if the position at the row-column pair holds the passed piece.
				if (board[r][c] == piece)
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
	public static boolean detect3Above(int row, int column, char piece)
	{
		
		//Detects if there is four in a row going northwest. Does not run if starting before column 3 or above row 3 to prevent IndexOutOfBoundsException.
		if (column >= 3 && row >= 3 && board[row - 1][column - 1] == piece)
		{
			
			if (board[row - 2][column - 2] == piece)
			{
				
				if (board[row - 3][column - 3] == piece)
				{
					
					return true;
					
				}
				
			}
			
		}
		//Detects if there is four in a row going northest. Does not run if starting after column 3 or above row 3 to prevent IndexOutOfBoundsException.
		else if (column <= 3 && row >= 3 && board[row - 1][column + 1] == piece)
		{
			
			if (board[row - 2][column + 2] == piece)
			{
				
				if (board[row - 3][column + 3] == piece)
				{
					
					return true;
					
				}
				
			}
			
		}
		//Detects if there is four in a row going straight up. Does not run if starting above row 3 to prevent IndexOutOfBoundsException.
		else if (row >= 3 && board[row - 1][column] == piece)
		{
			
			if (board[row - 2][column] == piece)
			{
				
				if (board[row - 3][column] == piece)
				{
					
					return true;
					
				}
				
			}
			
		}
		
		//If true has not been returned at this point, false is returned as there was no connect four detected going upwards in any direction.
		return false;
		
	}
	
	/**
	 * Detects if the passed string is valid int that can be parsed.
	 * @param string - The string to be determined as an int or not.
	 * @return A boolean representing if the string is a valid int that can be parsed.
	 */
	public static boolean isInt(String string)
	{
		
		//Loops through each character of the string.
		for (int i = 0; i < string.length(); i++)
		{
			
			//Detects if the character is not a number, and returns false if so.
			if (string.charAt(i) != '0' && 
				string.charAt(i) != '1' && 
				string.charAt(i) != '2' && 
				string.charAt(i) != '3' && 
				string.charAt(i) != '4' && 
				string.charAt(i) != '5' && 
				string.charAt(i) != '6' && 
				string.charAt(i) != '7' && 
				string.charAt(i) != '8' && 
				string.charAt(i) != '9')
				return false;
			
		}
		
		//If false has not been returned at this point, each character is a valid numeral, meaning the string is a valid int that can be parsed; thus true is returned.
		return true;
		
	}
	
	/**
	 * Prints the current board state to the console.
	 */
	public static void printBoard()
	{
		
		//Loops through each row in the board.
		for (char[] row : board)
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
		
	}
																																																						                                                                                                                                                                                                                                                              //If you see this message, type, "I found you. :)" in the reply.
}
