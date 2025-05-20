

public class Stats
{

	//Data Attributes
	private int level;
	private int strength;
	private int dexterity;
	private int endurance;
	private int intelligence;
	private int agility;
	
	
	/**
	 * Constructor
	 * @param health
	 * @param strength
	 * @param dexterity
	 * @param endurance
	 * @param intelligence
	 * @param agility
	 */
	public Stats(int level, int strength, int dexterity, int endurance, int intelligence, int agility)
	{
		
		this.level = level;
		this.strength = strength;
		this.dexterity = dexterity;
		this.endurance = endurance;
		this.intelligence = intelligence;
		this.agility = agility;
		
		if (level != strength + dexterity + endurance + intelligence + agility)
		{
			
			System.out.println("Invalid stats created!");
			
		}
		
	}

	
	
	public int getLevel()
	{
	
		return level;
	
	}


	
	public void setLevel(int level)
	{
	
		this.level = level;
	
	}

	
	public int getStrength()
	{
	
		return strength;
	
	}


	
	public void setStrength(int strength)
	{
	
		this.strength = strength;
	
	}


	
	public int getDexterity()
	{
	
		return dexterity;
	
	}


	
	public void setDexterity(int dexterity)
	{
	
		this.dexterity = dexterity;
	
	}


	
	public int getEndurance()
	{
	
		return endurance;
	
	}


	
	public void setEndurance(int endurance)
	{
	
		this.endurance = endurance;
	
	}


	
	public int getIntelligence()
	{
	
		return intelligence;
	
	}


	
	public void setIntelligence(int intelligence)
	{
	
		this.intelligence = intelligence;
	
	}



	
	public int getAgility()
	{
	
		return agility;
	
	}



	
	public void setAgility(int agility)
	{
	
		this.agility = agility;
	
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		
		return 
				"Level: " + level + "\n" +
				"Strength: " + strength + "\n" +
				"Dexterity: " + dexterity + "\n" +
				"Endurance: " + endurance + "\n" +
				"Intelligence: " + intelligence + "\n"+
				"Agility: " + agility + "\n";
		
	}
	
}
