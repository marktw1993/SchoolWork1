import java.util.Arrays;
public class Checkout 
{
	public static void main(String[] args)
	{
		DessertItem ticket[] = new DessertItem[3];
		
		ticket[0] = new DessertItem("Cupcake", 1.25);
		ticket[1] = new Cookie("Chocolate Chip", 3, 3.99);
		ticket[2] = new Candy("Skittles", 1, 2.99);
		
		Arrays.sort(ticket);
		
		System.out.println("Lowest cost item is " + ticket[0]);
	}
}
