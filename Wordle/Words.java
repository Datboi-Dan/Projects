import java.util.HashSet;
import java.util.Iterator;

/**
 * A class with a list of words and a method that randomly picks from the list.
 * MILCS
 * @author Daniel B)
 */
public class Words 
{

	//Instantiates a word list HashSet.
	public static HashSet<String> wordList = new HashSet<String>();
	
	
	/**
	 * Adds words to the word list.
	 */
	public static void addWords()
	{
		
		wordList.add("fifty");
		wordList.add("basic");
		wordList.add("stilt");
		wordList.add("break");
		wordList.add("flush");
		wordList.add("geese");
		wordList.add("mamma");
		wordList.add("artsy");
		wordList.add("stare");
		wordList.add("cloud");
		wordList.add("pinky");
		wordList.add("cream");
		wordList.add("pzazz");
		wordList.add("forge");
		wordList.add("clamp");
		wordList.add("bingo");
		wordList.add("flick");
		wordList.add("crass");
		wordList.add("coins");
		wordList.add("smile");
		wordList.add("donor");
		wordList.add("honor");
		wordList.add("flask");
		wordList.add("fanny");
		wordList.add("strip");
		wordList.add("tardy");
		wordList.add("amber");
		wordList.add("shake");
		wordList.add("laity");
		wordList.add("brief");
		wordList.add("demur");
		wordList.add("zesty");
		wordList.add("ouija");
		wordList.add("adieu");
		wordList.add("enoki");
		wordList.add("azure");
		wordList.add("abuzz");
		wordList.add("boast");
		wordList.add("imbue");
		wordList.add("xenon");
		wordList.add("argon");
		wordList.add("peony");
		wordList.add("grass");
		wordList.add("gravy");
		wordList.add("organ");
		wordList.add("xylem");
		wordList.add("quest");
		wordList.add("queue");
		wordList.add("blast");
		wordList.add("kayak");
		wordList.add("zoner");
		wordList.add("mushy");
		wordList.add("poise");
		wordList.add("mound");
		wordList.add("unity");
		wordList.add("inert");
		wordList.add("index");
		wordList.add("opium");
		wordList.add("apple");
		wordList.add("freon");
		wordList.add("reign");
		wordList.add("trout");
		wordList.add("scald");
		wordList.add("splat");
		wordList.add("latin");
		wordList.add("bogey");
		wordList.add("muggy");
		wordList.add("frank");
		wordList.add("donut");
		wordList.add("ennui");
		wordList.add("thorn");
		wordList.add("clout");
		wordList.add("alloy");
		wordList.add("shell");
		wordList.add("gamma");
		wordList.add("dizzy");
		wordList.add("tribe");
		wordList.add("music");
		wordList.add("onion");
		wordList.add("music");
		wordList.add("eerie");
		wordList.add("notch");
		wordList.add("scrub");
		wordList.add("broom");
		wordList.add("vinyl");
		wordList.add("creep");
		wordList.add("forgo");
		wordList.add("cajon");
		wordList.add("bongo");
		wordList.add("viola");
		wordList.add("voila");
		wordList.add("flute");
		wordList.add("piano");
		wordList.add("drums");
		wordList.add("bones");
		wordList.add("saxes");
		wordList.add("picky");
		wordList.add("bogus");
		wordList.add("sulky");
		wordList.add("silky");
		wordList.add("chalk");
		wordList.add("goofy");
		wordList.add("words");
		
	}
	
	
	/**
	 * Gets a random word from the word list.
	 * @return A random word from the word list.
	 */
	public static String getRandomWord()
	{
		
		//Adds the words to the word list.
		addWords();
		
		//Declares a string called that will be used in the for loop and that we will eventually return as the random word.
		String word = "";
		
		//Generates a random number.
		int randomNumber = (int)(Math.random() * wordList.size());
		
		//Instantiates an iterate to iterate through the HashSet.
		Iterator<String> myIterator = wordList.iterator();
		
		//Runs a number of times equal to the random number generated earlier.
		for (int i = 0; i <= randomNumber; i++)
		{
			
			//Sets word as equal to the next value in the HashSet.
			word = myIterator.next();
			
		}
		
		//Returns the word.
		return word;
		
	}
	
}
