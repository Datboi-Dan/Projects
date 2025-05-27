

public abstract class Enemy extends Being
{
	
	private String description;
	private Attribute attribute;
	
	public Enemy(String firstName, String lastName, int level, int strength, int dexterity, int endurance, int intelligence, int agility, Attribute attribute)
	{
		
		super(firstName, lastName, level, strength, dexterity, endurance, intelligence, agility);
		this.attribute = attribute;
		
	}
	
	
	abstract void act(Party party);

	
	public Attribute getAttribute()
	{
	
		return attribute;
	
	}


	
	public String getDescription()
	{
	
		return description;
	
	}


	
	public void setDescription(String description)
	{
	
		this.description = description;
	
	}
	

}
