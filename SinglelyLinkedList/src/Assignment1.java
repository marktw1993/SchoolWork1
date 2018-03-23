import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment1 
{
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException
	{
		// Beginning file prompt and opening scanner
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		System.out.println("Please enter the file name:");
		String filename = scan.nextLine();
		// Reading from file
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String fileCurrentLine;
		
			while((fileCurrentLine = br.readLine()) != null)
			{
				String str = fileCurrentLine.substring(0, fileCurrentLine.indexOf(" ")).trim();
				float val = Float.parseFloat(fileCurrentLine.substring(fileCurrentLine.indexOf(" ")+3));
				valueData temp = new valueData(str,val);
				list.insertBack(temp);
			}
	
		} catch (IOException e) 
		{
			System.out.println("File error has occured. Please check filename or location and try again!");
		} finally
		{
			fr.close();
			br.close();
		}
		String userResponse = " ";
		// Beginning Menu Loop
		while(!userResponse.equalsIgnoreCase("Q"))
		{
			printMenu();
			System.out.print("Please enter your selection now: ");
			userResponse = scan.next();
			// Add to the front
			if(userResponse.equalsIgnoreCase("A"))
			{
				System.out.print("Please enter the string: ");
				String s = scan.next();
				System.out.print("Please enter the float value: ");
				Float f = scan.nextFloat();
				list.insertFront(new valueData(s,f));
				System.out.println("The node with values " + s + " and " + f + " were added at the begining!\n");
			}
			// Add to the end
			else if(userResponse.equalsIgnoreCase("B"))
			{
				System.out.print("Please enter the string: ");
				String s = scan.next();
				System.out.print("Please enter the float value: ");
				Float f = scan.nextFloat();
				list.insertBack(new valueData(s,f));
				System.out.println("The node with values " + s + " and " + f + " were added at the end!\n");
			}
			// Remove from the front
			else if(userResponse.equalsIgnoreCase("C"))
			{				
				list.removeFront();
			}
			// Remove from the back
			else if(userResponse.equalsIgnoreCase("D"))
			{
				list.removeBack();
			}
			// Search function
			else if(userResponse.equalsIgnoreCase("E"))	
			{
				System.out.print("Please enter the string you wish to search for: ");
				String s = scan.next();
				float f = list.find(list.getHead(),s);
				if( f == 1234567890)
					System.out.println("String " + s + " does not exist in the current list");
				else
					System.out.println("The float value corresponding with " + s + " is " + f + ".\n");
			}
			// Execute postfix expression from expression.txt
			else if(userResponse.equalsIgnoreCase("F"))
			{
				String exp = null;
				ObjectStack stack = null;
				try{
					fr = new FileReader("expression.txt");
					br = new BufferedReader(fr);
					exp = br.readLine();
					
					char[] arr = exp.toCharArray();
					int varCount = 0, opCount = 0;
					for(int i = 0; i < arr.length; i++)
					{
						stack.push(arr[i]);
						if(Character.isLetter(arr[i]))
						{
							stack.push(list.find(list.getHead(), exp.substring(i, i))); 
							varCount++;
						}
						else
						{
							stack.push(arr[i]);
							opCount++;
						}
					}
					if(varCount != opCount + 1)
					{
						exp = null;
					}
			
				} catch (IOException e) 
				{
					System.out.println("File error has occured. Please check filename or location and try again!");
				} finally
				{
					fr.close();
					br.close();
				}
				// If null, exp is invalid, you terminate option, and return to menu.
				if (exp != null)
				{
					float expSum = 1234567890;
					while(!stack.isEmpty())
					{
						float[] overFlow = null;
						int oFSize = 0;
						Object o = stack.pop();
						if(expSum == 1234567890)
							expSum = (float) o;
						else if ((char) o == '+')
						{
							expSum += overFlow[oFSize--];
						}
						else if ((char) o == '-')
						{
							expSum -= overFlow[oFSize--];
						}
						else if ((char) o == '*')
						{
							expSum *= overFlow[oFSize--];
						}
						else if ((char) o == '/')
						{
							expSum /= overFlow[oFSize--];
						}
						else
						{
							overFlow[oFSize++] = (float) o;
						}
					}
				}
				else
				{
					System.out.println("Expression does not exist or invalid.");
				}
			}
			// Terminating Response
			else if(userResponse.equalsIgnoreCase("Q")) {
				System.out.println("Program is terminating, Good bye.");
			}
			// For debugging
			else if(userResponse.equalsIgnoreCase("P"))
			{
				printList(list);
			}
			// Catch all that do not have a valid input
			else
			{
				System.out.println(userResponse + " is not a valid response, please try again.\n");
			}
			
		}
		scan.close();
	}
	// for debugging
	private static void printList(LinkedList list) {
		LinkedListNode cur = list.getHead();
		while(cur.getNext() != null)
		{
			System.out.println(cur.getData().getVariable() + " " + cur.getData().getValue());
			cur = cur.getNext();
		}
		System.out.println(cur.getData().getVariable() + " " + cur.getData().getValue());
		
	}
	//prints mainmenu
	private static void printMenu()
	{
		System.out.println("------------- Main Menu -------------");
		System.out.println("A - Insert to the front.");
		System.out.println("B - Insert to the end.");
		System.out.println("C - Delete and print the first node.");
		System.out.println("D - Delete and print the last node.");
		System.out.println("E - Search for value of a string.");
		System.out.println("F - Execute postfix expression.");
		System.out.println("Q - Terminate program.");
		System.out.println("-------------------------------------");
	}
}
