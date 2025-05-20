
/**
 * THIS CLASS HAS NOT BEEN IMPLEMENTED YET.
 * However, the plan is to make it so that each character can equip armor 
 */
public abstract class Armor
{
	
	//---------------------------------------------------------------------------------------------------------------------
	//Data Attributes
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * The name of the armor.
	 */
	private String name;
	
	/**
	 * A description of the armor.
	 */
	private String description;
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Functionalities
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Equips the armor to the user.
	 * @param user - The person the armor is being equipped to.
	 */
	public void equip(Being user)
	{
		
		user.equipArmor(this);
		raiseStats(user);
		
	}
	
	/**
	 * Unequips the armor from the user.
	 * @param user - The person the armor is being unequipped from.
	 */
	public void unequip(Being user)
	{
		
		user.equipArmor(null);
		revertStats(user);
		
	}
	
	/**
	 * Raises the stats of the user.
	 * @param user - The person who has the armor equipped.
	 */
	abstract void raiseStats(Being user);
	
	/**
	 * Reverts the stats of the user back to what they were.
	 * @param user - The person whose stats are being reverted.
	 */
	abstract void revertStats(Being user);

	/**
	 * Getter for the name of the armor.
	 * @return The name of the armor.
	 */
	public String getName()
	{
	
		return name;
	
	}

	/**
	 * Getter for the description of the armor.
	 * @return
	 */
	public String getDescription()
	{
	
		return description;
	
	}

	/**
	 * Setter for the name of the armor.
	 * @param name
	 */
	public void setName(String name)
	{
	
		this.name = name;
	
	}

	/**
	 * Setter for the description of the armor. 
	 * @param description
	 */
	public void setDescription(String description)
	{
	
		this.description = description;
	
	}

}
