import java.util.Scanner;


public class Assign04Driver
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DoublyLinkedList<String> editor = new DoublyLinkedList<String>();
		
		Scanner scan = new Scanner(System.in);
		String command = "";
		do
		{
			System.out.print(": ");
			command = scan.nextLine();			
			
			executeCommand(command.toLowerCase(), editor);			
		}
		while (!command.equalsIgnoreCase("q"));
		
		System.out.println("Editor ended.");
		scan.close();
	}
	
	public static <E> void executeCommand(String command, DoublyLinkedList<E> dll)
	{
		try
		{					
			if (command.startsWith("ia"))
			{
				String[] commandArray = command.split(" ", 3);
				dll.insertAfter(Integer.parseInt(commandArray[1]), (E)commandArray[2]);
			}	
			else if (command.startsWith("ib"))
			{
				String[] commandArray = command.split(" ", 3);
				dll.insertBefore(Integer.parseInt(commandArray[1]), (E)commandArray[2]);
			}
			else if (command.startsWith("i"))
			{	
				String[] commandArray = command.split(" ", 2);
				dll.insert((E)commandArray[1]);
			}			
			else if (command.startsWith("d"))
			{		
				String[] commandArray = command.split(" ");
				dll.deleteByPosition(Integer.parseInt(commandArray[1]));				
			}
			else if (command.startsWith("la"))
			{
				dll.printAllNodes();
			}
			else if (command.startsWith("l"))
			{
				String[] commandArray = command.split(" ");
				dll.printNode(Integer.parseInt(commandArray[1]));
			}		
			else
			{
				if (!command.equalsIgnoreCase("q"))
				{
					System.out.println("Invalid command.");
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Invalid command.");
		}
	}
	
	
}
