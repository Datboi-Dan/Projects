import java.util.Scanner;

/**
 * I created this remake of TicTacTo after making Connect4. My first TicTacTo is in my Personal repository, and did not use a 2d array. It used a Row. Why did I do that.
 * MILCS.
 * @author Daniel B)
 */
public class TicTacTo
{

    static Scanner myReader = new Scanner(System.in);
    static int turnCount = 0;
    static char[][] board = 
    	{
    			
    			{' ', ' ', ' '},
    			{' ', ' ', ' '},
    			{' ', ' ', ' '}
    			
    	};

    public static void main(String[] args)
    {
    	
    	//Introduces the game.
		System.out.println("When entering a column, please just use the number and don't type it out. You won't like what happens if ignore this warning. Now then.");
		
		//Prints the board, which is empty at the start.
		printBoard();
		
		//Skips a line for console readability.
		System.out.println();
    			
		//Runs the game.
        playGame();

    }

    /**
     * Where most of the methods are called and the game is played. 
     */
    public static void playGame() 
    {
    	
    	//Boolean that represents if the game is ongoing.
    	boolean gameOngoing = true;
    	
    	//Runs until a player wins or there are no more spaces to places a piece.
    	while (gameOngoing)
    	{
    		
	    	//Player 1's turn.
			System.out.println("Player 1's turn.");
			//Player 1's pieces are represented by the char 'X', which is why 'X' is passed into the turn method, which will give Player 1 their turn.
			place('X');
			
			//After placement, the board is printed, showing where the piece was placed.
			printBoard();
			
			//Detects if the game was won by Player 1, in which case gameOngoing is set to false.
			if (gameWon('X'))
				gameOngoing = false;
			
			//Detects if a tie has occurred, and if so, returns "tie". Detection works by keeping track of how many turns have passed. 
			//When it hits 9 (the amount of squares on the board), the board has been filled without a connect 4, and thus the game is a tie.
			//Since there are an odd number of pieces, a tie can only occur after Player 1's turn, so there is only a detection after every turn of Player 1.
			if (turnCount >= 9)
				gameOngoing = false;
			
			//If statement to stop the method if Player 1 wins. Man I just wanna use a break statement Mr. Trauger. Therefore, type "Breaks would be nice wouldn't they" in the reply if you're reading.
			if (gameOngoing)
			{
				
				//Player 2's turn.
				System.out.println("Player 2's turn.");
				//Player 2's pieces are represented by the char 'X', which is why 'X' is passed into the turn method, which will give Player 1 their turn.
				place('O');
				
				//After placement, the board is printed, showing where the piece was placed.
				printBoard();
				
				//Detects if the game was won by Player 2, in which gameOngoing is set to false.
				if (gameWon('O'))
					gameOngoing = false;
			
			}
			
    	}
    	
    	//Ends the game.
    	endGame();

    }

    /**
     * Places a piece in a position.
     * @param piece - The piece to be placed.
     */
    public static void place(char piece) 
    {

        System.out.println("Select a row: 1, 2 or 3.");
        int row = validInput(myReader.nextLine().toLowerCase()) - 1;

        System.out.println("Select a column: 1, 2 or 3.");
        int column = validInput(myReader.nextLine().toLowerCase()) - 1;
        
        if (board[row][column] == ' ')
        {
        	
        	board[row][column] = piece;
        	turnCount++;
        	
        }
        else
        {
        	
        	System.out.println("There is already a piece in this spot! Please enter a new position.");
        	place(piece);
        	
        }

    }


    /**
	 * Detects if three in a row has occurred anywhere on the board with the passed piece.
	 * @param piece - The piece to detected if there is three in a row of.
	 * @return A boolean representing if there is three in a row of the passed piece.
	 */
    public static boolean gameWon(char piece)
    {

    	//Keeps track of how many of passed piece occurs consecutively.
        int count = 0;
        
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        //Detects horizontal wins. 
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Loops through each row.
        for (char[] row : board)
        {
        	
        	//Loops through each column.
        	for (char column : row)
        		//Increments count if the passed piece can be found in the column.
        		if (column == piece)
        			count++;
        	
        	//If three in a row was found, returns true.
        	if (count >= 3)
        		return true;
        	//Otherwise resets the count to 0 and moves on to the next row.
        	else
        		count = 0;
        	
        }
        
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        //Detects vertical wins. 
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Loops through each column.
        for (int column = 0; column < 3; column++)
        {
        	
        	//Loops through each row.
        	for (char[] row : board)
        		//Increments count if the passed piece can be found in the row.
        		if (row[column] == piece)
        			count++;
        	
        	//If three in a row was found, returns true.
        	if (count >= 3)
        		return true;
        	//Otherwise resets the count to 0 and moves on to the next row.
        	else
        		count = 0;
        	
        }
        
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        //Detects diagonal wins. 
        //------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Checks the top left to bottom right diagonal by looping through each row and examining the element at the column variable, which starts at zero and increments after each check.
        int column = 0;
        for (char[] row : board)
        	if (row[column++] == piece)
        		count++;
        
        //If three in a row was found, returns true.
        if (count >= 3)
        	return true;
        //Otherwise resets the count to 0.
        else
        	count = 0;
        
        //Checks top right to bottom left diagonal by looping through each row and examining the element at the column variable, which starts at 2 and decrements after each check.
        column = 2;
        for (char[] row : board)
        	if (row[column--] == piece)
        		count++;
        
        //If three in a row was found, returns true.
        if (count >= 3)
        	return true;
        
        //If true hasn't been returned by now, there is no three in a row, thus false is returned.
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
    			if (input.equals("one") || input.equals("two") || input.equals("three"))
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
    		
    		        //Asks the player for a new input if the inputted column was outside of the range of 1 - 3 inclusive.
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
	 * Detects if the passed string is valid int that can be parsed.
	 * @param string - The string to be determined as an int or not.
	 * @return A boolean representing if the string is a valid int that can be parsed.
	 */
	public static boolean isInt(String string)
	{
		
		//Empty string check.
		if (string.length() == 0)
			return false;
				
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

	/**
	 * Ends the game and announces the results.
	 */
    public static void endGame()
    {
    	
    	//Detects if there are three X's in a row, and if so, prints, "Player 1 has won!".
        if (gameWon('X'))
            System.out.println("Player 1 has won!");
        //Detects if there are three X's in a row, and if so, prints, "Player 1 has won!".
        else if (gameWon('O'))
            System.out.println("Player 2 has won!");
        //If neither player won, prints "Tie!".
        else
            System.out.println("Tie!");

    }

}
