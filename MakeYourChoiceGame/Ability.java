
/**
 * This class is meant to be a basic outline for skills an spells.
 * Each skill/spell is its own class that inherits this class.
 */
public abstract class Ability
{
	
	//---------------------------------------------------------------------------------------------------------------------
	//Data Attributes
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * The name of the skill/spell.
	 */
	private String name;
	
	/**
	 * A description of the skill/spell.
	 */
	private String description;
	
	/**
	 * How much the skill/spell costs in terms of skillPoints/mana.
	 */
	private int cost;
	
	
	//---------------------------------------------------------------------------------------------------------------------
	//Functionalities
	//---------------------------------------------------------------------------------------------------------------------
	
	/**
	 * The method that is called whenever a character activates the ability.
	 * @param user - The user of the ability.
	 * @param target - Whoever the ability is being used on.
	 */
	abstract void activate(Being user, Being target);

	/**
	 * Getter for the name of the ability.
	 * @return The name of the ability.
	 */
	public String getName()
	{
	
		return name;
	
	}

	/**
	 * Getter for the description of the ability.
	 * @return A description of the ability.
	 */
	public String getDescription()
	{
	
		return description;
	
	}

	/**
	 * Getter for the cost of the ability.
	 * @return The cost of the ability.
	 */
	public int getCost()
	{
	
		return cost;
	
	}

	/**
	 * Setter for the name of the ability.
	 * @param name - The name that you will set the ability's name to.
	 */
	public void setName(String name)
	{
	
		this.name = name;
	
	}

	/**
	 * Setter for the description of the ability.
	 * @param name - The description that you will set the ability's description to.
	 */
	public void setDescription(String description)
	{
	
		this.description = description;
	
	}

	/**
	 * Setter for the cost of the ability.
	 * @param cost- The number that you will set the ability's cost to.
	 */
	public void setCost(int cost)
	{
	
		this.cost = cost;
	
	}
	
	
}
