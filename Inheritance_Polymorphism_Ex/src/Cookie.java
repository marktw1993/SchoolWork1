
public class Cookie extends DessertItem
{
	private int number;
	private double pricePerDozen;
	
	public Cookie(String name, int number, double pricePerDozen)
	{
		this.name = name;
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}
	public double getCost()
	{
		return (number / 12.0) * pricePerDozen;
	}
}
