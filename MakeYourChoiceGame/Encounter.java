import java.util.ArrayList;
import java.util.HashMap;

/**
 * My magnum opus of a class. God this took so much effort just 500 lines.
 * So much errors and debugging with this class. I have a whole document that's just a log of the problems that I had. Half of it is from here.
 * But in the end, I'm really happy with it. That turn system was a nightmare to implement for no reason though. 
 */
public class Encounter
{

	/**
	 * An enumeration specifically for the encounter class, with the different constants representing whether the battle was won, lost, or still ongoing.
	 */
	private enum BattleStatus
	{
		
		WON,
		LOST,
		ONGOING
		
	}
	
	/**
	 * The party that the player is controlling.
	 */
	private Party playerParty;
	
	/**
	 * The party the the player is fighting.
	 */
	private EnemyParty enemyParty;
	
	/**
	 * A hash map that is randomly generated and holds all beings as keys mapped to integers.
	 * The higher the being's integer, the greater their priority, which determines which being goes first they have the same turn value.
	 * This makes it so that encounters are predictable by the game, and to an extent the player, but still are not exactly the same every encounter.
	 */
	private HashMap<Being, Integer> priority = new HashMap<Being, Integer>();
	
	/**
	 * An array list representing the next turns after the current turn, or at least the predicted next turns.
	 */
	private ArrayList<Being> nextTurns;
	
	/**
	 * An integer representing the lowest turn value among all beings in the frontlines, but excludes the reserves.
	 */
	private int lowestTurnValue;
	
	/**
	 * The status of the battle, which is set initially to ongoing because, well, it just started.
	 */
	private BattleStatus battleStatus = BattleStatus.ONGOING;
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Constructor
	//---------------------------------------------------------------------------------------------------------------------
		
	/**
	 * Constructor for an encounter.
	 * The main difficulty was trying to get all the moving parts in this to work.
	 * The moving parts come from two classes. The first is the Turn class, which is egregiously complex (to me) in it's own right.
	 * Additionally, the Being class with it's extensive functionalities is utilized to it's utmost in the Turn class. Beings are constantly acting and being acted on. 
	 * Also, the Party class is used. In fact, I realized that the party class wasn't enough, so I had to make another that inherited the Party class.
	 * Finally, getting the beings to take turns is so friggin hard. I'll get to the turn system in the predictNext7 method.
	 * @param playerParty - The party that the player controls during the encounter.
	 */
	public Encounter(Party playerParty)
	{
		
		//---------------------------------------------------------------------------------------------------------------------
		//Initialize the encounter!
		//---------------------------------------------------------------------------------------------------------------------
		
		//Sets the party the player is controlling to the party that is passed in the constructor.
		this.playerParty = playerParty;
		
		//Generates an enemy party and sets it to the enemy party attribute, representing the party the player fights against.
		enemyParty = generateEnemyParty();
		
		//Determines the priority values of all the characters in the priority hash map.
		determinePriority();
		
		//Determines the lowest turn value among the current beings in both of the frontlines.
		determineLowestTurnValue();
		
		//Prints a message telling the player how many enemies they encountered and what they are.
		Game.delayPrintln("You have encountered " + enemyParty.getEnemyPartyMembers().size() + " enemies!");
		Game.delay();
		Game.delayPrint("Enemies: ", 10);
		Game.shortDelay();
		Game.delayPrintln(enemyParty.frontlineString());
		Game.shortDelay();
		
		
		//---------------------------------------------------------------------------------------------------------------------
		//Play the encounter!
		//---------------------------------------------------------------------------------------------------------------------
		
		while (battleStatus == BattleStatus.ONGOING)
		{
			
			//---------------------------------------------------------------------------------------------------------------------
			//Pre-Turn:
			//---------------------------------------------------------------------------------------------------------------------
			
			//Predicts the next 7 turns and changes the nextTurns arrayList according.
			predictNext7();
			
			//Sets the current being to the being who has the highest turn value, or if tied with other beings, the one among those who has the highest priority.
			Being currentBeing = nextTurn();
			
			//Declares a wornOffEffects arrayList that tracks how many status effects wore off this turn.
			ArrayList<StatusEffect> wornOffEffects = new ArrayList<StatusEffect>();
			
			//Iterates through the status effects the current being has on them.
			for (StatusEffect statusEffect : currentBeing.getStatusEffects().keySet())
			{
				
				//Adds the current status effect to the wornOffEffects arrayList if the integer it is mapped is at or below zero. 
				if (currentBeing.getStatusEffect(statusEffect) <= 0)
					wornOffEffects.add(statusEffect);
				//Otherwise just decrements it.
				else
					currentBeing.decrementStatusEffect(statusEffect);
					
			}
			
			//Iterates through the list of status effects that have worn off.
			for (StatusEffect statusEffect : wornOffEffects)
			{
				
				//Removes the status effect from the being's status effect list.
				currentBeing.getStatusEffects().remove(statusEffect);
				
			}
			
			//Takes the defense boosts away if the character is defending by setting it to its original value.
			//Although, I do realize that I might need to fix this because they are some status effects and equipment that could affect this value.
			currentBeing.setPhysicalDamageMitigator(currentBeing.getBaseStats().getEndurance());
			currentBeing.setMagicDamageMitigator(currentBeing.getBaseStats().getEndurance());
			
			
			//---------------------------------------------------------------------------------------------------------------------
			//During Turn:
			//---------------------------------------------------------------------------------------------------------------------
			
			//Declares a boolean that represents if the current being is enemy or not.
			boolean isEnemy = false;
			
			//Searches the frontline of the enemy party if any of them match the current being.
			for (int i = 0; i < 3; i++)
			{
				
				//Runs the body if the character at the i index in the frontline array. Makes the enemy being act.
				if (enemyParty.getFrontline()[i] == currentBeing)
				{
					
					//Print out a line to separate the previous turn from the last turn.
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					Game.delay();
					
					//Prints out that it is the current being's turn.
					Game.delayPrintln("--" + currentBeing + "'s Turn--", 10);
					Game.delay();
					
					//Prints out the predicted next turns.
					System.out.println("Next Turns:");
					System.out.println(nextTurns);
					
					//Makes the enemy act.
					enemyParty.getFrontline()[i].act(playerParty);
					
					//Sets the isEnemy boolean to true because the current character is an enemy.
					isEnemy = true;
					
					//Breaks the for loop because it doesn't have to iterate anymore.
					break;
					
				}
					
			}
			
			//Runs if the current being is not an enemy.
			if (!isEnemy)
				//Creates a new turn for the current being in the player party.
				new Turn(currentBeing, enemyParty, this);
			
			//Wait. Let it cook.
			Game.delay();
			
			
			//---------------------------------------------------------------------------------------------------------------------
			//Post-Turn:
			//---------------------------------------------------------------------------------------------------------------------
			
			//Iterates through the frontline of the player's party to check if there are deaths.
			for (int i = 0; i < 3; i++)
			{
				
				//Runs the body if the being's health is at or below zero (downed). Implicit null check to prevent errors.
				if (playerParty.getFrontline()[i] != null && playerParty.getFrontline()[i].getHealthPoints() == 0)
				{
					
					//Iterates through the party members to see if there is a being than can take the downed being's place.
					for (Being ally : playerParty.getPartyMembers())
					{
						
						//Skips the iteration if the ally is already in the frontline.
						if (ally == playerParty.getFrontline()[0] || ally == playerParty.getFrontline()[1] || ally == playerParty.getFrontline()[2])
						{
							
							continue;
							
						}
						//Runs when the ally has a health greater than 0 (when the ally is not downed).
						else if (ally.getHealthPoints() > 0)
						{
							
							playerParty.getFrontline()[i] = ally;
							break;
							
						}
						//In any other case, sets the position the downed being is in to null, representing that there is no being in this position.
						else
						{
							
							playerParty.getFrontline()[i] = null;
							
						}
						
					}
					
				}
				
			}
			
			//Iterates through the frontline of the enemy party to check if there are deaths.
			for (int i = 0; i < 3; i++)
			{
				
				//Runs the body if the being's health is at or below zero (downed). Implicit null check to prevent errors.
				if (enemyParty.getFrontline()[i] != null && enemyParty.getFrontline()[i].getHealthPoints() == 0)
					//Sets the position the downed enemy is in to null, representing that there is no enemy in this position.
					enemyParty.getFrontline()[i] = null;
					
				
			}
			
			//Counts the number of defeated beings (in the playerParty).
			int defeatedBeings = 0;
			for (int i = 0; i < 3; i++)
			{
				
				//Does a null check on each being, and if it is null, it means the being at this position is downed and there is no other that can take its place.
				//Thus, defeatedBeings should be incremented.
				if (playerParty.getFrontline()[i] == null)
				{
					
					defeatedBeings++;
					
				}
				
			}
			
			//Counts the number of defeated enemies.
			int defeatedEnemies = 0;
			for (int i = 0; i < 3; i++)
			{
				
				//Does a null check on each being, and if it is null, it means the enemy at this position hs been slain.
				//Thus, defeatedEnemies should be incremented.
				if (enemyParty.getFrontline()[i] == null)
				{
					
					defeatedEnemies++;
					
				}
				
			}
			
			//Sets the battle status to won or lost if either of the parties' frontlines are completely empty. 
			//Is that proper apostrophe grammar? Idk, too lazy and tired to look rn.
			if (defeatedBeings == 3)
				battleStatus = BattleStatus.LOST;
			else if (defeatedEnemies == 3)
				battleStatus = BattleStatus.WON;
			
		}
		
		
		//---------------------------------------------------------------------------------------------------------------------
		//End the encounter!
		//---------------------------------------------------------------------------------------------------------------------
		//Runs if the battle was lost.
		if (battleStatus == BattleStatus.LOST)
		{
			
			//Lets the player know they lost.
			System.out.println("You Lost! Would you like to continue?");
			
			//Asks for a valid answer.
			//I should make a method that does this for me. I'll probably be doing this a lot.
			boolean validAnswer = false;
			while (!validAnswer)
			{
				
				//Makes a switch that takes in a user input converted to all lowercase.
				switch (Game.prompt().toLowerCase())
				{
				
				//If yes, generates a new encounter with the player party.
				//yeah I know that it won't work, but if you die to these weak enemies I don't know what to say. I purposefully nerfed them to not deal with this yet.
				case "yes":
					new Encounter(playerParty);
					validAnswer = true;
					break;
					
				//Prints out game over again.
				case "no":
					System.out.println("Game Over!");
					validAnswer = true;
					break;
					
				default:
					System.out.println("Invalid Input!");
					break;
				
				}
				
			}
			
		}
		//Runs if the battle was won.
		//Later I plan to add more after winning, like experience and loot drops. Right now you just get the joy of winning though.
		else if (battleStatus == BattleStatus.WON)
		{
			
			//Lets the player know they won. Yay!
			System.out.println("You won!");
			
		}	
		
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Data Attributes
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Generates an enemy party.
	 * Right now it only generates direwolves, but later on I want it to generate enemies depending on what location you're in.
	 * I'll probably do that by giving each location an arrayList with a list of enemies to pick from.
	 * @return The enemy party that the player has to fight.
	 */
	private static EnemyParty generateEnemyParty()
	{
		
		//Initialize a party object.
		EnemyParty enemyParty = new EnemyParty();
		
		//Repeats the following process a random number of times from 1 to 3.
		for (int i = (int)(Math.random() * 3); i < 3; i++)
		{
			
			//If the current location is the tutorial, it only iterates once.
			//Yeah it isn't graceful, but I'll fix it later.
			if (Dungeon.getCurrentLocation().getName().equals("Tutorial"))
			{
				
				i = 2;
				
			}
			
			//Initializes an Enemy object.
			Enemy enemy = new Enemies.Direwolf();
			
			//Adds that enemy to the enemy party and it's frontline.
			enemyParty.addMember(enemy);
			enemyParty.configureFrontline(i, enemy);
			
		}
			
		//Declares an int equal to the ASCII code of the character 'A'.
		int extraChar = 'A';
		
		//Iterates through the enemies in the enemy party to check if there are enemies of the same species.
		for (Enemy enemy : enemyParty.getEnemyPartyMembers())
		{
			
			//Iterates through the enemy party again.
			for (Enemy otherEnemy : enemyParty.getEnemyPartyMembers())
			{
			
				//Skips the current enemy if it is the same enemy in the nested loop.
				if (enemy == otherEnemy)
				{
					
					continue;
					
				}
				//Checks if the two enemies are the same class.
				//I probably could have just had it check the name but. Oh well.
				else if (enemy.getClass() == otherEnemy.getClass())
				{
					
					//Adds extraChar to the enemy's name and first name to tell the enemies apart.
					//Also sets extraChar to the next character in the alphabet, then breaks the loop.
					enemy.setName(enemy.getName() + (char)(extraChar));
					enemy.setFirstName(enemy.getName() + (char)(extraChar++));
					break;
					
				}
				
			}
			
		}
		
		//Returns the generated enemy party.
		return enemyParty;
		
	}
	
	/**
	 * Determines the lowest turn value among all the beings in the both front lines.
	 */
	public void determineLowestTurnValue()
	{
		
		//Creates an array list of all the beings in the frontlines.
		ArrayList<Being> beings = new ArrayList<Being>();
		
		//Iterates through all the beings in the player party frontline.
		for (Being being : playerParty.getFrontline())
		{
			
			//Null check.
			if (being != null)
				beings.add(being);
			
		}
		
		//Iterates through all the beings in the enemy party frontline.
		for (Being enemy : enemyParty.getFrontline())
		{
			
			//Null check.
			if (enemy != null)
				beings.add(enemy);
			
		}
		
		//Sorts the beings array from those with the lowest agility to those with the highest agility, as agility corresponds to initial turn value.
		beings.sort
		(
			
			//Lambda expression to pass a comparator. 
			//Returns -1 if the first object should go first, 1 if the second object should go first, and 0 if it doesn't matter.
			(being1, being2) -> 
			{
					
				if (being1.getBaseStats().getAgility() < being2.getBaseStats().getAgility())
					return -1;
				else if (being1.getBaseStats().getAgility() > being2.getBaseStats().getAgility())
					return 1;
				else
					return 0;
					
			}	
				
		);
		
		//Sets the lowest turn value to the first being's agility in the beings array.
		lowestTurnValue = beings.get(0).getBaseStats().getAgility();
		
	}
	
	/**
	 * Determines which being gets the next turn and returns that being after decrementing their turn value.
	 * I explained this in the Beings class, but to reiterate, each being has their own turn value that decrements each time they get a turn.
	 * The beings with the highest turn value gets the next turn, and their turn value is initially determined by the agility, allowing for certain beings to go multiple times in a row.
	 * Once each being has had a turn, every being's turn value resets.
	 * @return The being who the next turn goes to.
	 */
	private Being nextTurn()
	{
		
		//Creates an array list of all the beings in the frontlines.
		ArrayList<Being> beings = new ArrayList<Being>();
		
		//Iterates through all the beings in the player party frontline.
		for (Being being : playerParty.getFrontline())
		{
			
			//Null check.
			if (being != null)
				beings.add(being);
			
		}
		
		//Iterates through all the beings in the enemy party frontline.
		for (Being enemy : enemyParty.getFrontline())
		{
			
			//Null check.
			if (enemy != null)
				beings.add(enemy);
			
		}
		
		//Determines the lowest turn value again, in case a switch occurred.
		determineLowestTurnValue();
		
		/*--Checks if all the beings have had a turn.--*/
		{
			
			//Declares an allAtMinValue boolean that is initially set to true.
			boolean allAtMinValue = true;
			
			//Iterates through all the beings in the beings arrayList.
			for (Being being : beings)
			{
				
				//Sets allAtMin to false if any of the characters have a turn value greater than or equal to the lowest turn value
				//If all of them have a turn value lower than the lowest initial turn value, it means that every being has had a turn
				//Thus the turn values should be reset.
				if (being.getTurnValue() >= lowestTurnValue)
				{
					
					allAtMinValue = false;
					break;
					
				}
				
			}
		
			//Resets everyone's turn values if being has a turn value below the lowest initial turn value.
			if (allAtMinValue)
				resetTurnValues();
			
		}
		
		//Sorts the beings array according from those with the highest turn value to the lowest, factoring in priority to deal with cases of equal values.
		beings.sort
		(
				
			//Lambda expression to pass a comparator.
			//Returns -1 if the first object should go first and 1 if the second object should go first.
			(being1, being2) -> 
			{
					
				if (being1.getTurnValue() > being2.getTurnValue())
					return -1;
				else if (being1.getTurnValue() < being2.getTurnValue())
					return 1;
				else if (priority.get(being1) > priority.get(being2))
					return -1;
				else
					return 1;
					
			}	
				
		);
		
		//Decrements the first being's turn value in the beings array.
		beings.get(0).setTurnValue(beings.get(0).getTurnValue() - 1);
		
		//Returns the first being in the beings array.
		return beings.get(0);
		
	}
	
	/**
	 * Method to reset everyone's turn values.
	 * Only resets those in the frontline, so it doesn't effect those in reserve. 
	 * This is to present exploits where one switches a character with low agility just before a reset to a character with high agility.
	 * They will proceed to spend all those turns, then switch them back and recover the high character's turn value while from the reserve
	 */
	public void resetTurnValues()
	{
		
		//Creates an array list of all the beings in the frontlines.
		ArrayList<Being> beings = new ArrayList<Being>();
		
		//Iterates through all the beings in the player party frontline.
		for (Being being : playerParty.getFrontline())
		{
			
			//Null check.
			if (being != null)
				beings.add(being);
			
		}
		
		//Iterates through all the beings in the enemy party frontline.
		for (Being enemy : enemyParty.getFrontline())
		{
			//Null check.
			if (enemy != null)
				beings.add(enemy);
			
		}
		
		//Iterates through all the beings in the beings arrayList.
		for (Being being : beings)
		{
			
			//Sets the being's turn value to their initial turn value.
			being.setTurnValue(being.getBaseStats().getAgility());
			
		}
		
	}
	
	/**
	 * Determines the priority of all the beings.
	 */
	public void determinePriority()
	{
		
		//Creates an array list of all the beings.
		ArrayList<Being> beings = new ArrayList<Being>();
		
		//Iterates through all the beings in the player party.
		for (Being being : playerParty.getPartyMembers())
		{
			
			if (being != null)
				beings.add(being);
			
		}
		
		//Iterates through all the beings in the enemy party.
		for (Enemy enemy : enemyParty.getEnemyPartyMembers())
		{
			
			if (enemy != null)
				beings.add(enemy);
			
		}
		
		//Iterates until the priority size matches the size of beings.
		for (int i = 0; priority.size() < beings.size(); i++)
		{
			
			//Takes a random being from the beings arrayList.
			Being randomBeing = beings.get((int)(Math.random() * beings.size()));
			
			//Iterates whenever priority already contains a key corresponding to the random being that was generated.
			while (priority.keySet().contains(randomBeing))
			{
				
				//Sets the random being to a new randomly generated being.
				randomBeing = beings.get((int)(Math.random() * beings.size()));
				
			}
			
			//Puts the random being into the priority map with i as it's priority value.
			//The beings that were drawn last have the highest priority.
			priority.put(randomBeing, i);
			
		}
		
	}
	
	/**
	 * Predicts what the next 7 turns will be if nothing alters the turn values of the beings in the frontline.
	 */
	public void predictNext7()
	{
		
		//Creates an array list of all the beings.
		ArrayList<Being> beings = new ArrayList<Being>();
		
		//Iterates through all the beings in the player party.
		//Technically I only had to iterate through the frontline, but it's actually more easier to iterate through partyMembers since it's an arrayList.
		for (Being being : playerParty.getPartyMembers())
		{
			
			//Null check.
			if (being != null)
				beings.add(being);
			
		}
		
		//Iterates through all the beings in the enemy party.
		for (Enemy enemy : enemyParty.getEnemyPartyMembers())
		{
			
			//Null check.
			if (enemy != null)
				beings.add(enemy);
			
		}
		
		
		//Declares an array list that will keep track of the original turn values.
		ArrayList<Integer> originalTurnValues = new ArrayList<Integer>();
		
		//Iterates through the beings array list.
		for (Being being : beings)
			//Adds their turn value to the original turn values.
			originalTurnValues.add(being.getTurnValue());
		
		//Declares an array list that will store the predicted turns.
		ArrayList<Being> predictedTurns = new ArrayList<Being>();
		
		//Iterates 7 times.
		for (int i = 0; i < 7; i++)
			//Adds the next turn to the predicted turns array list.
			predictedTurns.add(nextTurn());
			
		//Iterates for an amount of iterations equal to the size of the beings array list.
		for (int i = 0; i < beings.size(); i++)
			//Sets all the beings's turn values back to their original values.
			beings.get(i).setTurnValue(originalTurnValues.get(i));
		
		//Sets next turns the turns that were predicted.
		nextTurns = predictedTurns;
		
	}

	/**
	 * Getter for the next turns array list.
	 * @return The next seven turns.
	 */
	public ArrayList<Being> getNextTurns()
	{
	
		return nextTurns;
	
	}
	
}
