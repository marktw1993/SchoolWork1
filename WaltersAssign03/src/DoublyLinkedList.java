/* 	Filename: DoublyLinkedList.java
 * 	  Author: Mark Walters
 * 		Date: 04-12-2015
 * 	 Purpose: Demonstrates the utility of DoublyLinkedList that and
 * is also used by Assign04Driver.java in a text editor format.
 */
public class DoublyLinkedList<E> implements TextEditor<E>
{
	Node<E> head; 
	
	public DoublyLinkedList()
	{		
		head = null;
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}
	// ***Completed***
	//insert: this method will take the line of text as a string and add it to the end of the list
	public void insert(E line)
	{
		Node<E> newNode = new Node<E>(line);
		
		if(isEmpty())
			head = newNode;
		
		else
		{
			Node<E> current = head;
			while(current.next != null)
			{
				current.last = current;
				current = current.next;
			}
			current.next = newNode;
			newNode.last = current;			
		}
	}
	// ***Completed***	
	//insertAfter: this method takes an integer parameter (used to indicate a line number) 
	// and a string parameter,  and inserts the text after the appropriate node.

	public void insertAfter(int lineNum, E line)
	{
		Node<E> newNode = new Node<E>(line);
		
		if(isEmpty())
		{
			System.out.println("List is empty, list created.");
			head = newNode;
		}
		
		else
		{
			int i = 1;
			Node<E> current = head;
			while(current.next != null)
			{
				if(i == lineNum)
				{
					newNode.last = current;
					newNode.next = current.next;
					current.next = newNode;
					current.next.last = newNode;
				}
				current.last = current;
				current = current.next;
				i++;
			}
			if(lineNum == i)
			{
				newNode.last = current;
				current.next = newNode;
			}
		}
		
	}
	// ***Completed***
	//insertBefore: this method takes an integer parameter (used to indicate a line number) and a 
	// string parameter,  and inserts the text before the appropriate node
	public void insertBefore(int lineNum, E line)
	{
		Node<E> newNode = new Node<E>(line);
		
		if(isEmpty())
		{
			head = newNode;
			System.out.println("List is empty, list created.");
		}
		else
		{
			int i = 1;
			Node<E> current = head;
			while(current.next != null)
			{

				if((i+1) == lineNum)
				{
					newNode.last = current;
					newNode.next = current.next;
					current.next = newNode;
					current.next.last = newNode;
				}
				current.last = current;
				current = current.next;
				i++;
			}
			if(lineNum == 1)
			{
				newNode.next = head;
				head.last = newNode;
				head = newNode;		
			}
		}

		
	}
	// ***Completed***
	//deleteByPosition: this method will take an integer parameter indicating which element should
	// be deleted. For example, if 3 is passed in, the 3rd element should be deleted.
	public void deleteByPosition(int position)
	{
		if(isEmpty())
			System.out.println("The list is empty.");
		else
		{
			Node<E> current = head;
			int i = 1;
			while(current.next != null)
			{

				if(position == 1 && i == 1)	
				{
					head = current.next;
					current.next = current.next.next;
				}
				else if(i == position && current.next == null)
				{
					current.last.next = null;
					System.out.println("2");
				}
				else if(i==position)
				{
					current.last.next = current.next;
					current.next.last = current.last;
				}
				
				current.last = current;
				current = current.next;
				i++;
			}
		}
		
	}	
	// ***Completed***
	//printNode: this method takes an integer parameter of the node to print. 
	// for example, if 3 is passed in, it will print the 3rd node.
	public void printNode(int position)
	{
		if(isEmpty())
		{
			System.out.println("The Linked List is empty.");
		}
		else
		{
			Node<E> current = head;
			int i = 1;
			while(current.next != null)  
			{
				if(i == position)
					System.out.println(current.data);
				
				current.last = current;
				current = current.next;
				i++;
			}
			if(i == position)
				System.out.println(current.data);
		}
	}
	// ***Completed***
	//printAllNodes: this method takes no parameters and prints all nodes in the list.
	public void printAllNodes()
	{
		if (isEmpty())
			System.out.println("The list is empty.");
			
		else
		{
			Node<E> current = head;
			int pos=1;
			while (current != null)
			{
				System.out.println(pos + "> " + current.data);
				current = current.next;
				pos++;
			}
		}
	}
}
