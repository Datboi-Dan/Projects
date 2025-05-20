

public class Location
{
	
	String name;
	Location left;
	Location forward;
	Location right;
	Location back;
	
	public Location(String name)
	{
		
		this.name = name;
		
	}
	
	public Location(String name, Location left, Location forward, Location right, Location back)
	{
		
		this.name = name;
		this.left = left;
		this.forward = forward;
		this.right = right;
		this.back = back;
		
	}
	
	public Location move(String direction)
	{
		
		switch (direction)
		{
		
		case "left":
			if (left == null)
				return this;
			return left;
			
			
		case "forward":
			if (forward == null)
				return this;
			return forward;
			
		case "right":
			if (right == null)
				return this;
			return right;
			
		case "back":
			if (back == null)
				return this;
			return back;
		
		default:
			return this;
		
		}
		
	}
	
	/**
	 * Order is left, forward, right, back by the way
	 * @return
	 */
	public String[] getPaths()
	{
		
		String[] paths = new String[4];

		if (left != null)
			paths[0] = "Left";
		
		if (forward != null)
			paths[1] = "Forward";
	
		if (right != null)
			paths[2] = "Right";
		
		if (back != null)
			paths[3] = "Back";
		
		return paths;
		
	}

	public String getName()
	{
	
		return name;
	
	}

	
	public Location getLeft()
	{
	
		return left;
	
	}

	
	public void setLeft(Location left)
	{
	
		this.left = left;
	
	}

	
	public Location getForward()
	{
	
		return forward;
	
	}

	
	public void setForward(Location forward)
	{
	
		this.forward = forward;
	
	}

	
	public Location getRight()
	{
	
		return right;
	
	}

	
	public void setRight(Location right)
	{
	
		this.right = right;
	
	}

	
	public Location getBack()
	{
	
		return back;
	
	}

	
	public void setBack(Location back)
	{
	
		this.back = back;
	
	}
	
	public String toString()
	{
		
		return name;
		
	}
	
}
