import java.util.ArrayList;

public class EnemyParty extends Party
{

	private ArrayList<Enemy> partyMembers = new ArrayList<Enemy>();
	private Enemy[] frontline = new Enemy[3];
	
	public EnemyParty(Enemy... enemys)
	{
		
		for (Enemy enemy : enemys)
		{
			
			addMember(enemy);
			
		}
		
	}
	
	public void addMember(Enemy enemy)
	{
		
		partyMembers.add(enemy);
		enemy.setParty(this);
		
	}
	
	
	public void addMembers(Enemy... enemys)
	{
		
		for (Enemy enemy : enemys)
		{
			
			addMember(enemy);
			
		}
		
	}
	
	
	private void removeMember(Enemy enemy)
	{
		
		partyMembers.remove(enemy);
		enemy.setParty(null);
		
	}
	
	
	public void removeMembers(Enemy... enemys)
	{
		
		for (Enemy enemy : enemys)
		{
			
			removeMember(enemy);
			
		}
		
	}
	
	
	public void configureFrontline(int index, Enemy enemy)
	{
		
		frontline[index] = enemy;
		
	}

	
	public ArrayList<Enemy> getEnemyPartyMembers()
	{
	
		return partyMembers;
	
	}
	
	public Enemy[] getFrontline()
	{
	
		return frontline;
	
	}
	
	
	public String frontlineString()
	{
		
		String frontline = "";
		
		for (Enemy e : this.frontline)
		{
			
			if (e != null)
			frontline += e.getName() + ", ";
			
		}
		
		if (frontline.length() != 0)
			return frontline.substring(0, frontline.length() - 2);
		else
			return frontline;
		
	}
	
}
