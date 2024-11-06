import java.util.Scanner;
import java.util.HashMap;

/**
 * This class is the closest thing that I could get to Wordle that I made for fun.
 * MILCS
 * @author Daniel B)
 */
public class WordleGame {
	
	//Class Attributes
	
	//Sets the solution word to a random word from the Words class.
	static String soln;
	
	//Instantiates a scanner to read user input from System.in.
	static Scanner gameReader = new Scanner(System.in);
	
	//Declares a playerGuess and chances attribute that can be used in all the methods of this class.
	static String playerGuess;
	static int extraChances;

	public static void main(String[] args) 
	{
		
		//Welcomes the user to Wordle.
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
		
		//Picks a random word from the word list.
		soln = Words.getRandomWord();
		
		//Asks the user how many chances they would like to have.
		System.out.println("How many extra chances would you like to have?");
		playerGuess = gameReader.nextLine();
		
		//If the input is not a number, or the number is negative, it will repeatedly prompt the user to input something valid until they do. 
		while (!isInt(playerGuess) || Integer.parseInt(playerGuess) < 0)
		{
			
			//Sets an string based on whether their input is an integer or not. If it is an integer, then their number was negative.
			String extra = !isInt(playerGuess)? "." : " that is not negative.";
			
			//Message telling the reader their input is invalid, with extra at the end to inform the user what they did wrong.
			System.out.println("Invalid input. Please input a whole number" + extra);
			playerGuess = gameReader.nextLine();
			
		}
		//Sets chances to the value of playerGuess.
		extraChances = Integer.valueOf(playerGuess);
		
		//prompt and allow user to give an input, set a String equal to it (it is the guess)
		System.out.println("Make a guess (five letters): ");
		playerGuess = new String(gameReader.nextLine().toLowerCase());

		/*
		 * This is where all the code you write should be. You can write it all
		 * in here or you can write separate methods to accomplish the task.
		 * My only suggestion is to make methods that cheack each letter individially (Yes, you made those typos. Bask in your failure.)
		 * and prints out the letter, an X or a ? respectively. 
		 */
		
		//Checks if what the player guessed is the solution.
		failCheck();
		
		
		//Decides whether to say they won or lost depending on if the solution matches 
		if (playerGuess.equals(soln))
		{
			
			System.out.println(soln);
			System.out.println("Congrats! You successfully guessed that the solution was " + soln + ".");
		
		}
		else
		{
			
			System.out.println("You lost! The solution was " + soln + ".");
			
		}
		
		//Asks if the user wants to player again.
		System.out.println("\nWould you like to play again?");
		
		//Repeatedly prompts the user to input something new if their input is not yes or no.
		while (!(playerGuess.equals("yes") || playerGuess.equals("no")))
		{
			
			System.out.println("Please input either yes or no.");
			playerGuess = gameReader.nextLine();
			
		}
		
		//Runs the game again if the player has inputted yes. Otherwise, it says goodbye and stops running.
		if (playerGuess.equals("yes"))
		{
			
			playGame();
			
		}
		else
		{
			
			System.out.print("Goodbye!");
			
		}
		
		//Closes Scanner object.
		gameReader.close();
		
	}
	
	
	/**
	 * Method that checks whether the user's input matches the solution.
	 */
	private static void failCheck()
	{
		
		
		//Instantiates a HashMap with the keys being the characters in the solution and the values being the number of times they occur in the solution.
		HashMap<Character, Integer> solnChars = new HashMap<Character, Integer>();
		for (int i = 0; i < 5; i++)
		{
			
			solnChars.put(soln.charAt(i), checkOccurrences(soln, soln.charAt(i)));
			
		}
		
		//Declares a char array called display, which will be displayed in the the console after every guess. The initial values are all set to 'X'.
		char[] display = {'X', 'X', 'X', 'X', 'X'};
		
		
		//Makes sure that the player's guess is five characters, and not quit. Inputting quit will skip the if and else if block. Five characters calls the method again.
		if (playerGuess.length() != 5 && !playerGuess.equals("quit"))
		{
		
			System.out.println("Your guess was not five characters. Please make a new guess, or type quit to give up: ");
			playerGuess = gameReader.nextLine().toLowerCase();
			failCheck();
			
		}
		//Runs if the player did not guess solution and they still have chances left. Skips if the player inputted quit.
		else if (!soln.equals(playerGuess) && extraChances > 0 && !playerGuess.equals("quit"))
		{
			
			//Iterates through the playerGuess.
			for (int i = 0; i < 5; i++)
			{
			
				//Checks if the character at the index corresponding to the current iteration matches the solution's character at that index.
				if (playerGuess.charAt(i) == soln.charAt(i))
				{
					
					//Modifies the occurrences of the current character in the solnChars HashMap to be one less.
					solnChars.replace(playerGuess.charAt(i), solnChars.get(playerGuess.charAt(i)) - 1);
					
					//Changes the display at the index corresponding to the current iteration to instead be the current character.
					display[i] = playerGuess.charAt(i);
					
				}
				
			}
			
			//Iterates through the playerGuess again.
			for (int i = 0; i < 5; i ++)
			{
				
				//Skips the current character if matches the solution.
				if (playerGuess.charAt(i) == soln.charAt(i))
				{
					
					continue;
					
				}
				//Checks if the current character can even be found in the solution, then checks if there are still occurrences left in the hashMap.
				else if (soln.indexOf(playerGuess.charAt(i)) != -1 && solnChars.get(playerGuess.charAt(i)) > 0)
				{
					
					//Modifies the occurrences of the current character in the solnChars HashMap to be one less.
					solnChars.replace(playerGuess.charAt(i), solnChars.get(playerGuess.charAt(i)) - 1);
					
					//Changes the display at the index corresponding to the current iteration to a question mark.
					display[i] = '?';
					
				}
				
			}
			
			//Iterates through the display array and prints out its characters.
			for (char c : display)
			{
				
				System.out.print(c);
				
			}
			
			//Informs the user that their guess was wrong and gives them how many chances they have left. Then asks for a new input and calls the method.
			System.out.println("\nWrong! Make a new guess, or input quit to give up! (" + --extraChances + " extra chances left): ");
			playerGuess = gameReader.nextLine().toLowerCase();
			failCheck();
				
		}
		
	}

	
	/**
	 * Checks how many times the passed character occurs in the passed string.
	 * @param input - The string that is checked for the character.
	 * @param character - The character that the method checks for.
	 * @return The amount of times the character occurs in the string.
	 */
	private static int checkOccurrences(String input, char character)
	{
		
		int occurrences = 0;
		
		for (int i = 0; i < input.length(); i++)
		{
				
			occurrences += input.charAt(i) == character? 1 : 0;
				
		}
			
		return occurrences;
		
		
	}
	
	
	/**
	 * Checks if the passed string is a number.
	 * @param input - The string to be checked.
	 * @return A boolean representing whether or not the string is an int or not.
	 */
	private static boolean isInt(String input)
	{
		
		//Tries to convert the input to a number, and then return true. If it fails, false is instead returned.
		try
		{
			
			Integer.valueOf(input);
			return true;
			
		}
		catch (Exception e)
		{
			
			return false;
			
		}
		
	}

}
