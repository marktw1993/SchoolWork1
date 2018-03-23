
public class LinkedNode<E>
{
	Node<E> head;  //reference to the first element in the list
	
	public LinkedNode()
	{		
		head = null;
	}
	
	public boolean isEmpty()
	{
		if (head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		//return (head == null);  <-- the if else structure can be condensed to this
	}
	
	//insert at the end
	public void insert (E d)
	{
		Node<E> newNode = new Node<E>(d);
		newNode.next = null;		
		
		// if list is empty, point head to new node
		if (isEmpty())
		{
			head = newNode;	//with empty list, add as the first element			
		}
		else
		{
			Node<E> current = head;
			while (current.next != null) //while not at the end of the list
			{
				current = current.next; //move over to next node
			}
			
			current.next = newNode; //attach new node to last item (which current now points to) in list	
		}		
	}
	
	public boolean delete(E d)
	{
		Node<E> current = head; //reference to keep track of which node being looked at
		Node<E> prev = head; //reference to keep track of the node before the one being looked at
		boolean isFound = false; //value to keep track of whether the data was found in the list
		
		if (!isEmpty())
		{		
			if (head.data == d) //data was found at first element in the list
			{
				head = head.next; //if at the beginning move the head reference to the next element
				isFound = true;
			}
			else
			{
				while (current.data != d && current.next != null) //while the data is not found and we are not at the end of the list
				{
					current = current.next; //move current to next node
					
					if (current.data != d) //after moving to next node, if that isn't the data either, move prev to next node
					{
						prev = prev.next;
					}
				}
				
				if (current.data == d) //if data is found
				{
					prev.next = current.next; //set the previous node to the node after the one to delete
					isFound = true;
				}
			}
		}
		return isFound;
	}
	public void push(E d)
	{
		Node<E> newNode = new Node<E>(d);
		newNode.next = null;
		if (isEmpty())
		{
			head = newNode;	//with empty list, add as the first element			
		}
		else
		{
			newNode.next = head;
			head = newNode;
		}	
	}
	public E pop()
	{
		if(isEmpty())
		{
			System.out.println("The Linked List is empty.");
			return null;
		}
		else
		{	
			Node<E> current = (Node<E>) head;
			head = head.next;
			current.next = null;
			return current.data;
		}
	}
	public E peek()
	{
		if(isEmpty())
		{
			System.out.println("The Linked List is empty.");
			return null;
		}
		else
			return head.data;
	}
	
	public void printList()
	{
		if (!isEmpty())
		{
			Node<E> current = head;
			while (current != null)
			{
				System.out.println(current.data);
				current = current.next;
			}
		}
		else
		{
			System.out.println("The list is empty.");
		}
	}

}











