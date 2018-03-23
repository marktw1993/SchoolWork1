import java.util.Scanner;


public class BadSubscriptCaught 
{
	public static void main (String[] args)
	{
		String names[] = {"Bob","George","Jeff","Susie","Beth"};
		Scanner scan = new Scanner(System.in);
		
		try
		{
			System.out.println("Please enter the number of the name you'd like to see: ");
			int index = scan.nextInt();
			
			System.out.println(names[index]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array index out of bounds");
		}
		scan.close();
	}
}
