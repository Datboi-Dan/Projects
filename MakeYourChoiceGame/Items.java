

public final class Items
{
	
	private static final Item[] itemList = 
	{
			
		new Potion(),
		
		
	};
	

	
	public static Item[] getItemList()
	{
	
		return itemList;
	
	}


	/**
	 * Private because it doesn't need to 
	 */
	private static class Potion extends Item
	{
		
		Potion() 
		{
			
			this.setName("Potion");
			this.setDescription("A potion that restores health. Don't be stingy, use it.");
			
		}
		
		public void use(Being target)
		{
			
			int healValue = target.getHealthPoints() * 2 / 10;
			target.setHealthPoints(target.getHealthPoints() + healValue);
			System.out.println(target);
			
		}
		
	}
	
}
