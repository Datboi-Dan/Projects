import java.util.HashMap;
import java.util.Map;

public class Inventory
{

	private static HashMap<Item, Integer> items = new HashMap<Item, Integer>
	(
			
		Map.ofEntries
		(
				
			Map.entry(Items.getItemList()[0], 1)
		
		)
			
	);

	
	public static HashMap<Item, Integer> getItems()
	{
	
		return items;
	
	}
	
	public static void useItem(String itemName, Being target)
	{
		
		for (Item i : items.keySet())
		{
			
			if (i.getName().equalsIgnoreCase(itemName))
			{
				
				i.use(target);
				items.replace(i, items.get(i) - 1);
				if (items.get(i) < 1)
					items.remove(i);
				break;
				
			}
			else
			{
				
				System.out.println("didn't work :(");
				
			}
			
		}
		
	}
	
	public static boolean contains(String item)
	{
		
		for (Item i : items.keySet())
		{
			
			if(i.getName().equalsIgnoreCase(item))
				return true;
			
		}
		return false;
			
	}
	
}
