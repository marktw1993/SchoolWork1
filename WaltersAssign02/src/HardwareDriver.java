/**********************************************************************************************************************************************************************************
 *   File Name: HardwareDriver.java
 *      Author:	Mark Walters
 *        Date: 03/5/2015
 *       Class: CSCI 300
 * Description: Populates an ArrayList from information inputed via producList.dat and does one of two things. First option is to reprint out the information in a visually friendly
 * format or preforms the "end of day routine" which updates the current list, archives the old one, and creates a new file with up-to-date information.
 * ********************************************************************************************************************************************************************************/
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class HardwareDriver 
{
	public static void main(String[] args) 
	{
		// Arraylist constructing of all the products taken in from productList.dat
		ArrayList<Product> productList = new ArrayList<Product>();
		File fileToProcess = new File("productList.dat");
		try
		{
			Scanner datIn = new Scanner(fileToProcess);
			while(datIn.hasNext())
			{
				String line = datIn.nextLine();
				String[] s = line.split(",");
				Product p = new Product(s[0],s[1],Double.parseDouble(s[2]),Integer.parseInt(s[3]));
				productList.add(p);
			}
			System.out.println("1.	View Product List \n2.	Run end of day routine");		
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			//choice 1, printing out the arraylist
			if(choice == 1)
			{
				System.out.println("SKU	Product\t\t\tCost\t Qty\n-----------------------------------------------");
				for(Product p: productList)
					System.out.println(p);
			}
			//choice 2, end of day operations
			else if (choice == 2)
			{
				// renames old .dat file
				DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
				Calendar cal = Calendar.getInstance();
				File oldFile = new File(dateFormat.format(cal.getTime()) + "_productList.dat");
				fileToProcess.renameTo(oldFile);
				
				// updates productList quantity according to the file given by user
				System.out.println("Please enter a file name: ");
				File updateFile = new File("\"" + scan.next() + "\"");
				Scanner updateScanner = new Scanner(updateFile);
				int i = 0;
				while(updateScanner.hasNext())
				{
					String line = updateScanner.nextLine();
					String[] s = line.split(",");
					for(Product p: productList)
					{
						if(s[i] == p.getSKU())							
							p.setQty(p.getQty() - Integer.parseInt(s[i+1]));
						i+=2;
					}
				}
				// writes new file with updated quantity
				File newFile = new File("productList.txt");
				PrintWriter outputStream = new PrintWriter(newFile);
				outputStream.println("SKU	Product\t\t\tCost\t Qty\n-----------------------------------------------");
				for(Product p: productList)
					outputStream.println(p);
				// printing out updated inventory
				System.out.println("SKU	Product\t\t\tCost\t Qty\n-----------------------------------------------");
				for(Product p: productList)
					System.out.println(p);
				
				outputStream.close();
				updateScanner.close();
			}
			datIn.close();
			scan.close();
		}
		catch(Exception e)
		{
			System.out.println("Error processing file");
		}
	}
}