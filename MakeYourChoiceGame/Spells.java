import java.util.ArrayList;
import java.util.List;

public final class Spells
{

	private static final ArrayList<String> partySpells = new ArrayList<String>
	(
			
		List.of
		(
				
			"placeholder1",
			"placeholder2"
		
		)
			
	);
	
	
	private static final Ability[] spellList = 
	{
			
		new ManaDart(), //1
		new Heal() //2
		
	};
	
	
	
	
	public static ArrayList<String> getPartySpells()
	{
	
		return partySpells;
	
	}

	
	public static Ability[] getSpellList()
	{
	
		return spellList;
	
	}





	private static class ManaDart extends Ability
	{
		
		public ManaDart() 
		{
			
			this.setName("Mana Dart");
			this.setDescription("description");
			this.setCost(5);
			
		};
		
		@Override
		public void activate(Being user, Being target)
		{
		
			int magicDamage = 300 * user.getMagicEfficacy() + (300 * user.getMagicEfficacy()) / 100;
			magicDamage += (magicDamage * (int)(Math.random() * 6) / 100) - (magicDamage * (int)(Math.random() * 6) / 100);
			
			//Decides whether the attack is critical by randomly picking a number from 1-100.
			//If the character's critChance attribute is greater than or equal to that randomly generated number, the hit is critical. 
			if (user.getCritChance() >= (int)(Math.random() * 100) + 1)
			{
				
				magicDamage *= user.getCritDamageMultiplier();
				System.out.println("Critical! Multiplier:" + user.getCritDamageMultiplier());
				
			}
			
			target.setHealthPoints(target.getHealthPoints() - magicDamage);
			
			user.setMana(user.getMana() - this.getCost());
			System.out.println(user + " dealt " + magicDamage + " damage to " + target);
		
		}
		
	}
	
	
	private static class Heal extends Ability
	{
		
		public Heal() 
		{
			
			this.setName("Heal");
			this.setDescription("description");
			this.setCost(5);
			
		};
		
		@Override
		public void activate(Being user, Being target)
		{
		
			int healing = 300 * user.getMagicEfficacy() + (300 * user.getMagicEfficacy()) / 100;
			healing += (healing * (int)(Math.random() * 6) / 100) - (healing * (int)(Math.random() * 6) / 100);
			
			
			user.setMana(user.getMana() - this.getCost());
			System.out.println(user + " healed " + healing + " health to " + target);
		
		}
		
	}
	
	
}
