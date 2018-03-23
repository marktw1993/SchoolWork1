import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class BasicIO 
{
	public static void main(String[] args) 
	{
		File fileToProcess = new File("out.txt");
		PrintWriter outputStream = null;
		Scanner scan = new Scanner(System.in);
		try
		{
			System.out.println("Enter the text to be added to the file: ");
			outputStream = new PrintWriter(fileToProcess);
			outputStream.println(scan.nextLine());
			outputStream.println("Entering all the info to the texts cause yeah i can?");
		}
		catch(Exception e)
		{
			System.out.println("Error processing file");
		}
		finally
		{
			outputStream.close();
			scan.close();
		}
	}
}
