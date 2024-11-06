import java.util.Scanner;

/**
 * This class is my submission to the Wordle project for AP Comp Sci.
 * MILCS
 * @author Daniel B)
 */
public class WordleGameSimple {
	
	//class attributes
	static String soln = new String("basic");
	static Scanner gameReader = new Scanner(System.in);
	static String playerGuess;

	public static void main(String[] args)
	{
		
		//determine what the answer should be, coder gets to decide this LOWERCASE ONLY
		System.out.print("Welcome to Wordle! ");
	
		//run the game
		playGame();

	}

	/**
	 * You decide how to comment this!
	 * Yeah, that's right, I decide how to comment this. Well, I mean, this method plays the game. I guess.
	 */
	private static void playGame() 
	{
		
		//prompt and allow user to give an input, set a String equal to it (it is the guess)
		System.out.println("Make a guess (five letters, no repeating characters): ");
		playerGuess = new String(gameReader.nextLine().toLowerCase());

		/*
		 * This is where all the code you write should be. You can write it all
		 * in here or you can write separate methods to accomplish the task.
		 * My only suggestion is to make methods that cheack each letter individially (Yes, you made those typos. Bask in your failure.)
		 * and prints out the letter, an X or a ? respectively. 
		 */
		
		//Checks if the user failed or not.
		failCheck();
		
		//Prints that the user has successfully guessed the solution.
		System.out.print("Congrats! You successfully guessed that the solution was " + soln + ".");
		
		//Closes the scanner.
		gameReader.close();
		
	}
	
	
	/**
	 * Method that checks whether the user's input matches the solution.
	 */
	private static void failCheck()
	{
		
		//Immediately makes the user input a new guess if their guess is not five characters, or has repetitions.
		if (playerGuess.length() != 5 || hasReps(playerGuess))
		{
		
			System.out.println("Invalid guess. Input a new guess that is five letters with no repititive characters: ");
			playerGuess = gameReader.nextLine().toLowerCase();
			failCheck();
			
		}
		//Runs the following code if the player guess does not match
		else if (!soln.equals(playerGuess))
		{
			
			//Iterates through the user's input to print out clues based on what they input.
			for (int i = 0; i < 5; i++)
			{
			
				//Prints X if the current character is not in the solution.
				if (soln.indexOf(playerGuess.charAt(i)) < 0)
				{
				
					System.out.print("X");
					
				}
				//Prints the current character if it matches with the position it is in for the solution.
				else if (playerGuess.charAt(i) == soln.charAt(i))
				{
					
					System.out.print(playerGuess.charAt(i));
					
				}
				//Prints a question mark if the character is in the string but not at the right position.
				else
				{
					
					System.out.print("?");
					
				}
				
			}
			
			//Informs the user that their guess was wrong, and they should input a new guess.
			System.out.println("\nWrong! Make a new guess: ");
			playerGuess = gameReader.nextLine().toLowerCase();
			failCheck();
				
		}
		
	}
	
	

	
	/**
	 * Checks the amount of repetitions of characters in a giving string input.
	 * @param input - The string to be inputted.
	 * @return - The amount of repetitive characters the input.
	 */
	private static boolean hasReps(String input)
	{
		
		//Iterates through the given string.
		for (int i = 0; i < input.length(); i++)
		{
			
			//Iterates through the given string again, so that the string is iterated through once for each character inside.
			for (int j = i; j < input.length(); j++)
			{
				
				//Skips the current iteration if it is the character being examined.
				if (i == j)
				{
					
					continue;
					
				}
				//Returns true if the examined character matches any of the other characters.
				else if (input.charAt(i) == input.charAt(j))
				{
					
					return true;
					
				}
				
			}
			
		}
		
		//Returns false if none of characters matched each other.
		return false;
		
	}

}
