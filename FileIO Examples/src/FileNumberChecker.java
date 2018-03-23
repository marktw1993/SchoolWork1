import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileNumberChecker 
{
	public static void main(String[] args) 
	{
		File inputFile = new File("in.txt");
		File outputFile = new File("out.txt");
	
		ArrayList<Integer> currentNumbers = new ArrayList<Integer>();
		Scanner scan = null;
		PrintWriter outputStream = null;
		try 
		{
			scan = new Scanner(inputFile);
			outputStream = new PrintWriter(outputFile);
			
			while(scan.hasNext())
			{
				if(!currentNumbers.contains(scan.next()))
				{
					int temp = scan.nextInt();
					currentNumbers.add(temp);
					outputStream.println(temp + " ");
				}
			}
		}
		catch (FileNotFoundException e)
		{	
			System.out.println("File accessor error");
		}
		finally
		{
			scan.close();
			outputStream.close();	
		}
	}
}
