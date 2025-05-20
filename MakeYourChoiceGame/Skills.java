import java.util.ArrayList;
import java.util.List;

public final class Skills
{
	
	
	private static final ArrayList<String> partySkills = new ArrayList<String>
	(
			
		List.of
		(
				
			"cheer",
			"embolden",
			"fortify",
			"aim"
		
		)
			
	);
	
	
	private static final Ability[] skillList = 
	{
			
		new Cheer(), //1
		new Embolden(), //2
		new Fortify(), //3
		new Aim() //4
	};
	
	
	
	public static ArrayList<String> getPartySkills()
	{
	
		return partySkills;
	
	}

	
	public static Ability[] getSkillList()
	{
	
		return skillList;
	
	}


	/**
	 * Private because it doesn't need to be called outside of this class.
	 */
	private static class Cheer extends Ability
	{
		
		Cheer() 
		{
			
			this.setName("Cheer");
			this.setDescription("description");
			this.setCost(50);
			
		};
		
		
		public void activate(Being user, Being target)
		{
		
			for (Being ally : user.getParty().getPartyMembers())
			{
				
				ally.addStatusEffect(StatusEffect.PUMP, 1);
				ally.addStatusEffect(StatusEffect.PRECISION, 1);
				ally.addStatusEffect(StatusEffect.FOCUS, 1);
				ally.addStatusEffect(StatusEffect.HARDEN, 1);
				ally.addStatusEffect(StatusEffect.SHELL, 1);
				
			}
			
			System.out.println(user + " raised everyone's stats!");
		
		}
		
	}
	
	private static class Embolden extends Ability
	{
		
		Embolden() 
		{
			
			this.setName("Embolden");
			this.setDescription("description");
			this.setCost(20);
			
		};
		
		
		public void activate(Being user, Being target)
		{
		
			for (Being ally : user.getParty().getPartyMembers())
			{
				
				ally.addStatusEffect(StatusEffect.PUMP, 1);
				ally.addStatusEffect(StatusEffect.FOCUS, 1);
				
			}
			
			System.out.println(user + " raised everyone's offense!");
		
		}
		
	}
	
	
	private static class Fortify extends Ability
	{
		
		Fortify() 
		{
			
			this.setName("Fortify");
			this.setDescription("description");
			this.setCost(20);
			
		};
		
		
		public void activate(Being user, Being target)
		{
		
			for (Being ally : user.getParty().getPartyMembers())
			{
				
				ally.addStatusEffect(StatusEffect.HARDEN, 1);
				ally.addStatusEffect(StatusEffect.SHELL, 1);
				
			}
			
			System.out.println(user + " raise everyone's defense!");
		
		}
		
	}
	
	
	private static class Aim extends Ability
	{
		
		Aim() 
		{
			
			this.setName("Aim");
			this.setDescription("description");
			this.setCost(20);
			
		};
		
		
		public void activate(Being user, Being target)
		{
		
			for (Being ally : user.getParty().getPartyMembers())
			{
				
				ally.addStatusEffect(StatusEffect.PRECISION, 1);
				
			}
			
			System.out.println(user + " raised everyone's accuracy!");
		
		}
		
	}
	
	
}
