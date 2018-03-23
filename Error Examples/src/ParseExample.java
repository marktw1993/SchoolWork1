import java.util.Scanner;


public class ParseExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		try
		{
		System.out.println("Please enter a decimal: ");
		String dString = scan.next();
		double d = Double.parseDouble(dString);
		System.out.println(d);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid input format. ");
		}
		scan.close();
	}

}
