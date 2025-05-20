

public final class Weapons
{
	
	private static final Weapon[] weaponList = 
	{
			
		new Broadsword(),
		
		
	};
	

	
	public static Weapon[] getWeaponList()
	{
	
		return weaponList;
	
	}




	/**
	 * Private because it doesn't need to 
	 */
	private static class Broadsword extends Weapon
	{
		
		Broadsword() 
		{
			
			this.setName("Broadsword");
			this.setDescription("A standard broadsword.");
			
		}
		
		public void raiseStats(Being user)
		{
			
			user.setPhysicalDamage(user.getPhysicalDamage() + (user.getPhysicalDamage() * 5 / 100));
			
		}
		
		public void returnStats(Being user)
		{
			
			user.getBaseStats().setStrength(user.getBaseStats().getStrength() - 2);
			
		}
		
		
	}
	
}
