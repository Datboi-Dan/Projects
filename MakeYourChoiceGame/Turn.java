

public class Turn
{
	
	
	public Turn(Being being, EnemyParty enemyParty, Encounter currentEncounter)
	{
		
		//Print out a line to separate the previous turn from the last turn.
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		//Prints out the turn order.
		Game.delayPrintln("--" + being + "'s Turn--", 10);
		Game.delay();
		System.out.println("Next Turns:");
		System.out.println(currentEncounter.getNextTurns());
		System.out.println("\nMake your move!");
		System.out.println("Valid inputs: attack, defend, skills, magic, items, scan, switch");
		switch (Game.prompt().toLowerCase())
		{
		
		case "attack":
			int attackTarget = targetEnemy(enemyParty);
			
			if (attackTarget == -1)
				new Turn(being, enemyParty, currentEncounter);
			else
				being.attack(enemyParty.getFrontline()[attackTarget]);
			
			break;
			
		case "defend":
			being.defend();
			break;
			
		case "skills":
			boolean skillUsed = false;
				
			while (!skillUsed)
			{
				System.out.println("Which skill would you like to use?");
				System.out.println("Valid inputs: ");
				for (Ability skill : being.getLearnedSkills())
				{
					
					System.out.println(skill.getName() + " (" + skill.getCost() + " skillPoints): " + skill.getDescription());
					
				}
				System.out.println("back");

				String input = Game.prompt();
				if (input.equals("back"))
				{
						
					new Turn(being, enemyParty, currentEncounter);
					skillUsed = true;
						
				}
				else
				{
					
					boolean skillLearned = false;
					for (Ability skill : being.getLearnedSkills())
						if (skill.getName().equalsIgnoreCase(input))
							skillLearned = true;
					
					if (skillLearned)
					{
			
						
						if (!Skills.getPartySkills().contains(input.toLowerCase()))
						{
							
							int skillTarget = targetEnemy(enemyParty);
							
							if (skillTarget == -1)
								new Turn(being, enemyParty, currentEncounter);
							else
								being.useSkill(input, enemyParty.getFrontline()[skillTarget]);
					
						}
						else
						{
							
							for (Being enemy : enemyParty.getFrontline())
							{
								
								if (enemy != null)
								{
									
									being.useSkill(input, enemy);
									break;
									
								}
								
							}
							
						}
						skillUsed = true;
			
					}
					else
					{
					
						System.out.println("This skill either has not been learned yet or doesn't exist. Try again.");
						
					}
						
				}
					
			}
			break;
			
		case "magic":
			boolean spellCast = false;
			
			while (!spellCast)
			{
				System.out.println("Which spell would you like to use?");
				System.out.println("Valid inputs: ");
				for (Ability spell : being.getLearnedSpells())
				{
					
					System.out.println(spell.getName() + " (" + spell.getCost() + " mana): " + spell.getDescription());
					
				}
				System.out.println("back");
			
				String input = Game.prompt();
				
				if (input.equals("back"))
				{
						
					new Turn(being, enemyParty, currentEncounter);
					spellCast = true;
						
				}
				else
				{
					boolean spellLearned = false;
					for (Ability spell : being.getLearnedSpells())
						if (spell.getName().equalsIgnoreCase(input))
							spellLearned = true;
					
					if (spellLearned)
					{
			
						
						if (input.equalsIgnoreCase("heal"))
						{
							
							System.out.println("Which ally would you like to target?");
							System.out.print("Valid Inputs: ");
							for (Being ally : being.getParty().getPartyMembers())
							{
								
								if (ally.getHealthPoints() > 0)
									System.out.print(ally.getName() + ", ");
								
							}
							System.out.println("back");
							int spellTarget = targetAlly(being);
							
							while (spellTarget != -1 && being.getParty().getPartyMembers().get(spellTarget).getHealthPoints() <= 0)
							{
									
								System.out.println("That character is downed!");
								spellTarget = targetAlly(being);
								
							}
							//Runs if the user inputted back, restarts the turn.
							if (spellTarget == -1)
							{
								
								new Turn(being, enemyParty, currentEncounter);
								spellCast = true;
								
							}
							
							
							//Uses the item on the given target.
							else
							{
								
								being.castSpell("heal", being.getParty().getPartyMembers().get(spellTarget));
								spellCast = true;
								
							}
							
						}
						else if (!Spells.getPartySpells().contains(input.toLowerCase()))
						{
							
							int spellTarget = targetEnemy(enemyParty);
							
							if (spellTarget == -1)
								new Turn(being, enemyParty, currentEncounter);
							else
								being.castSpell(input, enemyParty.getFrontline()[spellTarget]);
					
						}
						else
						{
							
							for (Being enemy : enemyParty.getFrontline())
							{
								
								if (enemy != null)
									being.castSpell(input, enemy);
								
							}
							
						}
						spellCast = true;
			
					}
					else
					{
					
						System.out.println("This spell either has not been learned yet or doesn't exist. Try again.");
						
					}
						
				}
					
			}
			break;
			
		case "items":
			
			System.out.println("Which item would you like to use?");
			for (Item i : Inventory.getItems().keySet())
			{
				
				System.out.print(i.getName() + ", ");
				
			}
			System.out.println("back");
			
			String item = Game.prompt();
			boolean itemUsed = false;
			
			while (!itemUsed)
			{
				
				if (item.equals("back"))
				{
						
					new Turn(being, enemyParty, currentEncounter);
					itemUsed = true;
						
				}
				//Runs if the inventory contains the given item.
				else if (Inventory.contains(item))
				{
				
					System.out.println("Which ally would you like to target?");
					System.out.print("Valid Inputs: ");
					for (Being ally : being.getParty().getPartyMembers())
					{
							
						System.out.print(ally + ", ");
							
					}
					System.out.println("back");
					
					//Sets the item target to an ally's index in the party list.
					int itemTarget = targetAlly(being);
						
					//Check to see if the character is downed.
					while (itemTarget != -1 && being.getParty().getPartyMembers().get(itemTarget).getHealthPoints() <= 0)
					{
							
						System.out.println("That character is downed!");
						itemTarget = targetAlly(being);
						
					}
					//Runs if the user inputted back, restarts the turn.
					if (itemTarget == -1)
					{
						
						new Turn(being, enemyParty, currentEncounter);
						itemUsed = true;
						
					}
					
					//Uses the item on the given target.
					else
					{
						
						Inventory.useItem(item, being.getParty().getPartyMembers().get(itemTarget));
						itemUsed = true;
						
					}
						
				}
				else
				{
					
					System.out.println("This item is either not in your inventory or doesn't exist. Try again.");
					item = Game.prompt();
					
				}
					
			}
			break;
			
		
		case "scan":
			System.out.println("Would like to scan an enemy or ally?");
			System.out.println("Valid Inputs: ally, enemy, back");
			
			boolean validInput = false;
			while (!validInput) 
			{
				
				int scanTarget;
				switch (Game.prompt())
				{
				
				case "ally":
					System.out.println("Which ally would you like to target?");
					System.out.print("Valid Inputs: ");
					for (Being ally : being.getParty().getPartyMembers())
					{
						
						System.out.print(ally + ", ");
						
					}
					System.out.println("back");
					
					//Target an ally
					scanTarget = targetAlly(being);
					
					if (scanTarget != -1)
						being.scan(being.getParty().getPartyMembers().get(scanTarget));
					new Turn(being, enemyParty, currentEncounter);
					
					validInput = true;
					break;
					
				case "enemy":
					scanTarget = targetEnemy(enemyParty);
				
					if (scanTarget == -1)
						new Turn(being, enemyParty, currentEncounter);
					else
						being.scan(enemyParty.getFrontline()[scanTarget]);
					
					validInput = true;
					break;
				
				case "back":
					new Turn(being, enemyParty, currentEncounter);
					validInput = true;
					break;
					
				default:
					System.out.println("Invalid input!");
					
				}
				
			}
			break;
		
		case "switch":
			System.out.println("Which ally would you like to target?");
			System.out.print("Valid Inputs: ");
			for (Being ally : being.getParty().getPartyMembers())
			{
				
				if (ally.getHealthPoints() > 0)
					System.out.print(ally.getName() + ", ");
				
			}
			System.out.println("back");
			
			
			int switchTarget = targetAlly(being);
			
			
			while (switchTarget != -1 && being.getParty().getPartyMembers().get(switchTarget).getHealthPoints() <= 0)
			{
				
				System.out.println("That character is downed!");
				switchTarget = targetAlly(being);
				
			}
			
			if (switchTarget == -1)
				new Turn(being, enemyParty, currentEncounter);
			
			else
			{
				
				//Switches the current being with the switch target in the frontline.
				for (int i = 0; i < 3; i++)
				{
					
					if (being == being.getParty().getFrontline()[i])
						being.getParty().getFrontline()[i] = being.getParty().getPartyMembers().get(switchTarget);
					
				}
				
				currentEncounter.predictNext7();
				
				//Give current being their turn point back, and take away one from the switch target.
				being.setTurnValue(being.getTurnValue() + 1);
				being.getParty().getPartyMembers().get(switchTarget).setTurnValue(being.getParty().getPartyMembers().get(switchTarget).getTurnValue() - 1);
				
				//Switch target gets their turn, then this turn ends.
				currentEncounter.determineLowestTurnValue();
				new Turn(being.getParty().getPartyMembers().get(switchTarget), enemyParty, currentEncounter);
				
			}
			break;
			
		default:
			System.out.println("Invalid Input! Try again!");
			new Turn(being, enemyParty, currentEncounter);
			break;
			
		}
		

		
	}
	
	/**
	 * Allows a being to target an enemy in the current encounter.
	 * Returns an int instead of an Enemy to enable a back option, which returns -1.
	 * @param enemyParty
	 * @return
	 */
	public static int targetEnemy(EnemyParty enemyParty)
	{
		
		System.out.println("Which enemy would you like to target?");
		System.out.println("Valid inputs: " + enemyParty.frontlineString() + ", back");
		String input = Game.prompt();
		
		if (input.equals("back"))
			return -1;
		else
		{
			
			for (int i = 0; i < 3; i++)
			{
				
				if (enemyParty.getFrontline()[i] != null && (enemyParty.getFrontline()[i].getName().equalsIgnoreCase(input) || enemyParty.getFrontline()[i].getFirstName().equalsIgnoreCase(input) || enemyParty.getFrontline()[i].getLastName().equalsIgnoreCase(input)))
				{
					
					return i;
					
				}
				
			}
			
			System.out.println("Invalid Target! Input a new target!");
			return targetEnemy(enemyParty);
			
		}
		
	}
	
	
	public static int targetAlly(Being being)
	{
		
		String scanTarget = Game.prompt();
			
		for (int i = 0; i < being.getParty().getPartyMembers().size(); i++)
		{
				
			if (being.getParty().getPartyMembers().get(i).getName().equalsIgnoreCase(scanTarget) || being.getParty().getPartyMembers().get(i).getFirstName().equalsIgnoreCase(scanTarget) || being.getParty().getPartyMembers().get(i).getLastName().equalsIgnoreCase(scanTarget))
			{
				
				return i;
					
			}
			
		}
		if(scanTarget.equals("back"))
		{
				
			return -1;
				
		}
		else
		{
			
			System.out.println("Invalid Target! Input a new target!");
			return targetAlly(being);
			
		}
		
	}
	
}
