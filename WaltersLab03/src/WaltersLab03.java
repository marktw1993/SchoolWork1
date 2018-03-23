import java.util.Scanner;
import java.util.*;

public class WaltersLab03
{

	/**
	 * @param args
	 * @throws DataException 
	 */
	public static void main(String[] args) throws DataException
	{
		System.out.println("Welcome to the Part Number Emporium, where you buy part numbers ... not parts!");
		System.out.println("Please enter the Part Number and then the quantity.");
		
		Scanner scan = new Scanner(System.in);
		int partNumber = -1, quantity = -1;
		try
		{
			partNumber = scan.nextInt();
			if(partNumber < 0 || partNumber > 9999)
				throw new DataException();
			quantity = scan.nextInt();
			if(quantity < 1 || quantity > 5000)
				throw new DataException();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid data type");
			System.out.println(e.getMessage());
		}
		catch(DataException e)
		{
			System.out.println(e.getMessage());
		}
		//System.out.println("You have ordered " + quantity + " of part number " + partNumber + ".");
	}
}
