
public class Candy extends DessertItem
{
	private double weight;
	private double pricePerPound;
	
	public Candy(String name, double weight, double pricePerPound)
	{
		super(name, weight * pricePerPound);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}
	public double getCost()
	{
		return cost;
	}
}
