import java.util.concurrent.TimeUnit;
import java.util.Scanner;


/**
 * Start date for coding: October 13, 2024.
 */
public class Game 
{
	
	static Scanner myReader = new Scanner(System.in);
	static String dialogue;
	static boolean endReached = false;
	static Party playerParty;
	static String lostName;
	static String lastName;
	
	public static void main(String[] args)
	{
		
		Dungeon.generateDungeon();
		Being maios = new Being("Maios", "Otus", 25, 5, 5, 5, 5, 5);
		Being gladius = new Being("Gladius", "", 25, 7, 4, 5, 4, 5);
		Being may = new Being("May", "Gia", 25, 4, 5, 4, 7, 5);
		Being sana = new Being("Sana", "Medi", 25, 4, 4, 4, 7, 6);
		Being servio = new Being("Servio", "Custodio", 25, 6, 4, 7, 4, 4);
		Being cel = new Being("Cel", "Hawkins", 25, 4, 7, 4, 4, 6);
		playerParty = new Party(maios);
		playerParty.configureFrontline(0, maios);
		maios.getLearnedSkills().add(Skills.getSkillList()[0]);
		gladius.getLearnedSkills().add(Skills.getSkillList()[1]);
		servio.getLearnedSkills().add(Skills.getSkillList()[2]);
		cel.getLearnedSkills().add(Skills.getSkillList()[3]);
		may.getLearnedSpells().add(Spells.getSpellList()[0]);
		sana.getLearnedSpells().add(Spells.getSpellList()[1]);
		
		//--------------------------------------------------------------------------------------------------------
		//Introductory Sequence
		//--------------------------------------------------------------------------------------------------------
		
		delayPrintln
		(
				
			"""
			A voice, so close and yet so far, rings out in my head. I’m sure it belongs to someone important to me. 
			Or does it? 
			I can't quite place it. 
			It digs into my brain, like a worm through an apple, struggling persistently to get to the core. But it can never seem to reach, as if there were something blocking it.
			
			What was it?
			"""
		
		);
				
		delayPrintln("What was her name?", 100);
		System.out.print("Enter name (Leave blank for default name Elphe): ");
		
		lostName = myReader.nextLine();
		lostName = lostName.length() > 0? lostName.substring(0, 1).toUpperCase() + lostName.substring(1) : "Elphe";
		lastName = " Otrio";
		
		delayPrintln("\nI keep calling it out, over and over again.");
		delayPrintln(lostName + "!");
		delay();
		delayPrintln(lostName + "!");
		delay();
		delayPrintln((lostName.length() < 2? lostName : lostName.substring(0, 2)) + "-\n");
		
		System.out.println("MAIOS!!!");
		delay();
		delayPrintln
		(
				
			"""
			I jerk awake. A tall man hovers above me, sword in hand. His eyebrows are furrowed, wrinkling the scar in the middle of his face. 

			This man, Gladius, is the swordsman of my party.
			
			”What do you think a party is supposed to do without their leader? You’re not usually this irresponsible,” Gladius nags. 
			He’s a man of few words outside the party, but it seems that he makes an exception for me personally.
			
			I sit up groggily and clutch my head. What was I even dreaming about agai-
			"""
			
		);
		
		System.out.println("\"HURRY UP!!!\"");
		shortDelay();
		delayPrintln("I roll out of bed, falling onto my face, then clutch at it as I scramble to get ready.\n");
		delay();
		delayPrintln("Why does he seem scarier than when he’s fighting monsters when he does this?");
		delay();
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------\n");
		//--------------------------------------------------------------------------------------------------------
		//Status Tutorial:
		//--------------------------------------------------------------------------------------------------------
		/*delayPrintln("Tutorial - Stat:");
		shortDelay();
		delayPrintln
		(
				
			"Before Maios puts on his equipment, let’s learn the basics of stats.\n" + 
			"To pull up a character’s stats, type the name of the character displayed on the character list provided.\n" +
			"For this tutorial, only Maios is available to you.\n" +
			"Please select him from the character list."
				
		);
		shortDelay();
		
		System.out.println("\nSelect the character who you want to manage:");
		System.out.println(maios);
		*/
		
		//--------------------------------------------------------------------------------------------------------
		//Dungeon Introduction:
		//--------------------------------------------------------------------------------------------------------
		
		delayPrintln
		(
				
			"""
			I exit the inn I was sleeping at, and am greeted by my party. 
			Sana Medi, our white mage, is fixing up breakfast, with our tank, Servio Custodio, and black mage, May Gia, are taking their fill from the soup. 
			Cel Hawkins, our rogue, sits impatiently on a box, her eyes fixed on my disheveled hair and tired eyes.
			
			”You don’t usually wake up this late, cap’n,” she remarks.
			
			”Yeah, I got an earful from Gladius,” I reply with a grin as Gladius stands beside me, arms crossed.
			
			“I didn’t think you’d miss Sana’s cooking for the world Maios. Come and get some of this!” Servio shouts to me while slurping up the soup. 
			
			He’s not wrong. Sana’s cooking is top class. 
			Even May, who talks about as often as she breathes, sits silently while shoveling spoonfuls of the soup into her mouth––to the point where I’m afraid she’ll choke.
			
			My fears aren’t unfounded, as she starts coughing from a chunk of carrot in the soup going down the wrong pipe.
			
			”Hey don’t waste that! That’s a national treasure!” Servio cries in despair, watching some of the soup spill from her bowl as she heaves violently. 
			Cel howls in laughter, and even the stoic Gladius wears a grin on his face.
			
			Sana runs to her and performs an expert heimlich. 
			
			”How many times do I have to tell you? Take your time eating!” Sana chides to an embarrassed May.
			
			I smiled at the scene, but I couldn’t shake the feeling that something seemed off. 
			Ever since I got to this town, Memento, I’ve had that feeling. And it’s only gotten stronger after waking up. 
			
			Then again, I haven’t fought in a while since there wasn’t much action while traveling to this town. Maybe I just need to take the edge off. 
			Fortunately, we’re going to start working on the dungeon near the town, and clear it of monsters. It’s a rather easy dungeon, but it should be enough to warm up.
			
			
			I quickly wolf down Sana’s soup, in part because of its deliciousness, but also because of my excitement to take on the dungeon.
			
			“Alright guys, let’s move out!”
			"""	
		
		);
		
		delay();
		
		System.out.println("--------------------------------------------------------------------------------------------------------\n");
		
		delayPrintln
		(
			
			"""
			We enter the dungeon, with Sana and May summoning light orbs to light the way. We soon come across a small direwolf, only a little bigger than a puppy.

			”Awww, it’s actually kinda cute. Can we keep it?” May asks.
			
			”Don’t be absurd. It’s a monster. No matter how small it is, you mustn't go easy on them,” Gladius says.
			
			As if to prove him right, the direwolf lunges fiercely at May, which is casually blocked by Servio. Yet, May remained unfazed.
			
			”Aw come on, if we have Servio, it can’t hurt us can it?” she says.
			
			”Oi. I’m not your babysitter,” Servio replies.
			
			“Well, cap’n, I don’t think you’ll need us to fight this one. Go ahead and take care of it, oh fearless leader,” Cel says lazily with her hands behind her head.
			
			I sigh, but I guess some action is better than none.
			"""
				
		);
		
		System.out.println("--------------------------------------------------------------------------------------------------------\n");
		
		delayPrintln("Tutorial: Encounters");
		shortDelay();
		delayPrintln("During your exploration of a dungeon, you may encounter enemies along your way. Let’s learn how to fight them.");
		
		System.out.println
		(
				
			"""
			--Maios Otus's Turn--
			Next Turns:
			[Maios Otus, Direwolf, Maios Otus, Direwolf, Maios Otus, Direwolf, Maios Otus]
			
			Make your move!
			Valid inputs: attack, defend, skills, magic, items, scan, switch
			"""
				
		);
		shortDelay();
		
		delayPrintln
		(
			
			"""
			This is an example display of what you might see in an encounter.
			
			At all times, you will have three characters on the frontline, and the rest will be on standby. (Unless there isn't enough characters to fill the frontline)
			Those in reserve cannot act until they are put on the frontline.
			
			At the top it will display whose turn it is, followed by the next turns.
			The next are the following turns.
			Keep in mind that certain actions in the game may change the turn order, like having an enemy or ally be downed, being affected by certain spells, or switching characters.
			
			Below that, if it is not an enemy's turn, it will display whose turn it currently is, followed by a list of inputs that you can input into the console to perform an action.
			
			Attack will have you target an enemy to attack, and then have that character make a physical attack on that enemy.
			
			Defend will make the character defend themself, raising their defense until their next turn.
			
			Skills will show a list of the skills that the character has, then ask you to pick which one to use in exchange for an amount of skill points.
			
			Magic will show a list of the spells that the character has, then ask you to pick which one to use in exchange for an amount of skill points.
			
			Items will show a list of items in the inventory, then ask you to pick which one to use.
			
			Scan allows you to see information on an ally or an enemy. Using it on an ally does not use up the turn, but using it on an enemy does.
			
			Switch allows you to switch the character currently in the frontline with one of the characters in reserve.
			
			Use this information to defeat the direwolf!
			
			"""		
		
		);
		
		new Encounter(playerParty);
		
		Dungeon.setCurrentLocation(Dungeon.getCurrentLocation().move("forward"));
		playerParty.addMembers(gladius, may, sana, servio, cel);
		playerParty.configureFrontline(1, gladius);
		playerParty.configureFrontline(2, cel);
		
		delayPrintln
		(
				
			"""
				
			Great! Now that you've defeated the direwolf, I'm gonna be honest, I couldn't really get to the making the game, so you get to go through a maze.
			Also, all the characters have joined back into your party, so you can switch characters now. Maios doesn't have spells, but May and Sana are mages, so they do!
			Skills are a bit boring right now, but Gladius, Cel, and Servio have them. They raise stats!
			I would have put in some puzzles, but I can't get that in on time, so uh. Yeah. Have fun!!!111 :)
			"""
				
		);
		delay();
		
		while(!endReached)
		{
			
			System.out.println("Current Location: " + Dungeon.getCurrentLocation());
			delayPrintln("Which path would you like to take?");
			System.out.print("Possible Paths: ");
			for(int i = 0; i < 4; i++)
			{
				
				if (Dungeon.getCurrentLocation().getPaths()[i] != null)
				{
					
					System.out.print(Dungeon.getCurrentLocation().getPaths()[i]);
					for (int j = i; j < 4; j++)
					{
						
						if (j == i)
						{
							
							continue;
							
						}
						else if (Dungeon.getCurrentLocation().getPaths()[j] != null)
						{
							
							System.out.print(", ");
							break;
						}
						
					}
					
				}
				
			}
			System.out.println();
			
			Location originalLocation = Dungeon.getCurrentLocation();
			
			Dungeon.setCurrentLocation(Dungeon.getCurrentLocation().move(Game.prompt().toLowerCase()));
			
			while (Dungeon.getCurrentLocation() == originalLocation)
			{
				
				System.out.println("Invalid input!");
				Dungeon.setCurrentLocation(Dungeon.getCurrentLocation().move(Game.prompt().toLowerCase()));
				
			}
			
			if ((int)(Math.random() * 100) + 1 >= 50)
			{
				
				new Encounter(playerParty);
				
			}
			
			System.out.println();
			
		}
		delayPrintln("Yay you won!\nOkay now there's nothing else. Sorry for the anticlimactic ending.");
		prompt();
		delayPrintln("You're still here. Okay fine. Here. Take this trophy.");
		shortDelay();
		System.out.println("You have obtained: Dinky ahh trophy!");
		delayPrintln("Alright bye bye for real, I'm gonna close the scanner now.");
		myReader.close();
		
	}
	
	/**
	 * This method prints the string index by index with a time increment of 20 milliseconds.
	 * I'm gonna be completely honest. I had it autogenerate that try catch block when I first created it.
	 * Hopefully by the time I finished the game I know how try catch works.
	 * Edit: Yeah I know how try catch works now, it's just if else but for errors.
	 * @param string - The string that is being printed out.
	 */
	public static void delayPrintln(String string)
	{
		
		for (int index = 0; index < string.length(); index++)
		{
			
			String character = string.substring(index, index + 1);
					
			System.out.print(character);
			if (character.equals(".") || character.equals("?") || character.equals("!"))
			{
				
				delay();
				
			}
			else if (character.equals(","))
			{
				
				shortDelay();
			}
			else
			{
				
				shortDelay(20);
				
			}
			
		}
		
		System.out.print("\n");
		
	}
	
	
	/**
	 * Overloaded method of delayPrintln for control over millisecond delay between index output.
	 * @param string - The string that is being printed out.
	 * @param milliseconds - The amount of delay you want between each index being printed in milliseconds.
	 */
	public static void delayPrintln(String string, int milliseconds)
	{
		
		for (int index = 0; index < string.length(); index++)
		{
			
			String character = string.substring(index, index + 1);
					
			System.out.print(character);
			if (character.equals(".") || character.equals("?") || character.equals("!"))
			{
				
				delay();
				
			}
			else if (character.equals(","))
			{
				
				shortDelay();
				
			}
			else
			{
				
				shortDelay(milliseconds);
				
			}
			
		}
		
		System.out.print("\n");
		
	}
	
	
	/**
	 * For when you don't need another line afterward.
	 * @param string - The string that is being printed out.
	 */
	public static void delayPrint(String string)
	{

		for (int index = 0; index < string.length(); index++)
		{
			
			String character = string.substring(index, index + 1);
					
			System.out.print(character);
			if (character.equals(".") || character.equals("?") || character.equals("!"))
			{
				
				delay();
				
			}
			else if (character.equals(","))
			{
				
				shortDelay();
				
			}
			else
			{
				
				shortDelay(20);
				
			}
			
		}
		
	}
	
	
	/**
	 * Overloaded method of delayPrint.
	 * @param string - The string that is being printed out.
	 */
	public static void delayPrint(String string, int milliseconds)
	{
		
		for (int index = 0; index < string.length(); index++)
		{
			
			String character = string.substring(index, index + 1);
					
			System.out.print(character);
			if (character.equals(".") || character.equals("?") || character.equals("!"))
			{
				
				delay();
				
			}
			else if (character.equals(","))
			{
				
				shortDelay();
				
			}
			else
			{
				
				shortDelay(milliseconds);
				
			}
			
		}
		
	}
	
	
	/**
	 * A method that delays output for 1 second.
	 */
	public static void delay()
	{
		
		try 
		{
			
			TimeUnit.SECONDS.sleep(1);
			
		} 
		catch (InterruptedException e) 
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 * Overloaded method of delay for control over output delay in seconds.
	 * @param seconds - The amount of time that you want to halt output for in seconds.
	 */
	public static void delay(int seconds)
	{
		
		try 
		{
			
			TimeUnit.SECONDS.sleep(seconds);
			
		} 
		catch (InterruptedException e) 
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * A method that delays output for half a second.
	 */
	public static void shortDelay()
	{
		
		try 
		{
			
			TimeUnit.MILLISECONDS.sleep(500);
			
		} 
		catch (InterruptedException e) 
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 * Overloaded method of shortDelay for control over output delay in milliseconds.
	 * @param milliseconds - The amount of time that you want to halt output for in milliseconds.
	 */
	public static void shortDelay(int milliseconds)
	{
		
		try 
		{
			
			TimeUnit.MILLISECONDS.sleep(milliseconds);
			
		} 
		catch (InterruptedException e) 
		{
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	
	public static String prompt() 
	{  
		
		return myReader.nextLine().toLowerCase().trim();
		
	}

	
	public static Party getPlayerParty()
	{
	
		return playerParty;
	
	}  
	
	
	
}
