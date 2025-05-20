import java.util.ArrayList;

public class Party
{

	private ArrayList<Being> partyMembers = new ArrayList<Being>();
	private Being[] frontline = new Being[3];
	
	public Party(Being... beings)
	{
		
		for (Being being : beings)
		{
			
			addMember(being);
			
		}
		
	}
	
	public void addMember(Being being)
	{
		
		partyMembers.add(being);
		being.setParty(this);
		
	}
	
	
	public void addMembers(Being... beings)
	{
		
		for (Being being : beings)
		{
			
			addMember(being);
			
		}
		
	}
	
	
	private void removeMember(Being being)
	{
		
		partyMembers.remove(being);
		being.setParty(null);
		
	}
	
	
	public void removeMembers(Being... beings)
	{
		
		for (Being being : beings)
		{
			
			removeMember(being);
			
		}
		
	}
	
	
	public void configureFrontline(int index, Being being)
	{
		
		frontline[index] = being;
		
	}

	
	public ArrayList<Being> getPartyMembers()
	{
	
		return partyMembers;
	
	}

	
	public Being[] getFrontline()
	{
	
		return frontline;
	
	}
	
	
	public String frontlineString()
	{
		
		String frontline = "";
		
		for (Being c : this.frontline)
		{
			
			if(c != null)
				frontline += c.getName() + ", ";
			
		}
		
		if (frontline.length() != 0)
			return frontline.substring(0, frontline.length() - 2);
		else
			return frontline;
		
	}
	
}
