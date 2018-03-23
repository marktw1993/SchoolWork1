
public class DessertItem implements Comparable<Object>
{
	protected String name;
	protected double cost;
	
	public DessertItem() {}
	public DessertItem(String name, double cost)
	{
		this.name = name;
		this.cost = cost;
	}
	public double getCost()
	{
		return cost;
	}
	public int compareTo(Object o)
	{
		if(this.getCost() < ((DessertItem)o).getCost())
			return -1;
		else if(this.getCost() > ((DessertItem)o).getCost())
			return 1;
		else
			return 0;
	}
	public String toString()
	{
		return name + " " + cost;
	}
}
