
/**
 * THIS CLASS HAS NOT BEEN IMPLEMENTED YET
 * However, this is a class that includes all the armors in the game.
 */
public final class Armors
{
	
	//---------------------------------------------------------------------------------------------------------------------
	//Data Attributes
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * A array of objects of all the armors in the game.
	 */
	private static final Armor[] armorList = 
	{
			
		new LeatherArmor(),	
		
	};
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Functionalities
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Getter for the armor list.
	 * @return The armor list.
	 */
	public static Armor[] getArmorList()
	{
	
		return armorList;
	
	}

	
	//---------------------------------------------------------------------------------------------------------------------
	//Inner Classes
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Private because it doesn't need to be accessed outside the class.
	 */
	private static class LeatherArmor extends Armor
	{
		
		/**
		 * Constructor for Leather Armor.
		 */
		LeatherArmor() 
		{
			
			this.setName("Leather Armor");
			this.setDescription("Standard adventurer's armor. Not amazing, but solid and reliable.");
			
		}
		
		/**
		 * Implementation of the raise stats method.
		 */
		public void raiseStats(Being user)
		{
			
			//Sets the endurance to the user's base endurance + 2.
			user.getBaseStats().setEndurance(user.getBaseStats().getEndurance() + 2);
			
		}
		
		/**
		 * Implementation of the revert stats method.
		 */
		public void revertStats(Being user)
		{
			
			//Sets the endurance back to what it was.
			user.getBaseStats().setStrength(user.getBaseStats().getEndurance() - 2);
			
		}
		
		
	}
	
}
