
/**
 * This is a class that will include all the enemies in the game.
 */
public class Enemies
{
	
	/**
	 * Direwolf class.
	 */
	public static class Direwolf extends Enemy
	{
		
		/**
		 * Constructor for direwolf object.
		 */
		public Direwolf()
		{
			
			//Call the super constructor.
			super("Direwolf", "", 7, 1, 1, 0, 0, 5, Attribute.NEUTRAL);
			
			//Set its description.
			this.setDescription("A direwolf");
			
		}
		
		
		public void act(Party party)
		{
			
			
			int randomTarget = (int)(Math.random() * 3);
			while (party.getFrontline()[randomTarget] == null)
				randomTarget = (int)(Math.random() * 3);
			this.attack(party.getFrontline()[randomTarget]);
			
		}
		
	}
	
	
	public static class Slime extends Enemy
	{
		
		public Slime()
		{
			
			//TEMPORARY
			super("Slime", "", 7, 1, 1, 0, 0, 5, Attribute.NEUTRAL);
			this.setDescription("blank");
			
		}
		
		
		public void act(Party party)
		{
			
			//TENTATIVE
			this.attack(party.getFrontline()[(int)(Math.random() * 3)]);
			
		}
		
	}
	
}
