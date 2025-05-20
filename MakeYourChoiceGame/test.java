import java.util.ArrayList;

public class test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Being test = new Being("test", "", 25, 1, 1, 21, 1, 1);

		
		Being foo = new Enemies.Direwolf();
 
		
		
		System.out.println(test.getHealthPoints());
		
		test.attack(foo);
		
		test.useSkill("leader", foo);
		
		test.castSpell("mana dart", foo);
		
		test.scan(foo);
		
		System.out.println(foo.getClass() == test.getClass());
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		
		for (int i : numbers)
		{
			
			System.out.print(i);
			if (numbers.get(numbers.size() - 1) != i)
			{
				
				System.out.print(", ");
				
			}
			
		}
		
		
	}

}
