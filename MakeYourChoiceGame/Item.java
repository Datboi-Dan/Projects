

public abstract class Item
{
	
	private String name;
	private String description;
	
	abstract void use(Being target);

	
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
