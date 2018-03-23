
public class Fruit implements Comparable<Object>
{
	private String name;
	
	public Fruit(String name)
	{
		this.name = name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int compareTo(Object o)
	{
		if(o instanceof Fruit)
		{
			Fruit f = (Fruit)o;
			return this.name.compareTo(f.name);
		}
		return -1;
	}
	public String getName()
	{
		return name;
	}
}
