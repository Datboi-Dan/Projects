

public abstract class Weapon
{
	
	private String name;
	private String description;
	
	public void equip(Being user)
	{
		
		user.equipWeapon(this);
		raiseStats(user);
		
	}
	
	public void unequip(Being user)
	{
		
		user.equipWeapon(null);
		returnStats(user);
		
	}
	
	abstract void raiseStats(Being user);
	
	abstract void returnStats(Being user);

	
	public String getName()
	{
	
		return name;
	
	}

	
	public String getDescription()
	{
	
		return description;
	
	}

	
	public void setName(String name)
	{
	
		this.name = name;
	
	}

	
	public void setDescription(String description)
	{
	
		this.description = description;
	
	}

}
