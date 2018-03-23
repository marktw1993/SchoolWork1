
public class LinkedList
{
	protected LinkedListNode head;
	
	public LinkedList()
	{
		head = null;
	}
	public LinkedList(LinkedListNode node)
	{
		head = node;
	}
	public LinkedListNode getHead()
	{
		return head;
	}
	public void setHead(LinkedListNode head)
	{
		this.head = head;
	}
	public void insertFront(valueData o)
	{
		LinkedListNode node = new LinkedListNode(o);
		node.setNext(head);
		head = node;
	}
	public void insertBack(valueData o)
	{
		if(head == null)
			this.setHead(new LinkedListNode(o));
		else
		{
			LinkedListNode temp = new LinkedListNode(o);
			temp.setNext(head);
			while(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			temp.setNext(new LinkedListNode(o));
		}
	}
	public valueData removeFront()
	{
		if(head == null)
			return null;
		LinkedListNode remove = head;
		this.setHead(head.getNext());
		System.out.println("The node with variable " + remove.getData().getVariable() + " and float " + remove.getData().getValue() + " has been removed from the front.");
		return remove.getData();
	}
	public valueData removeBack()
	{
		if(head == null)
			return null;
		LinkedListNode current = head;
		LinkedListNode prev = null;
		while(current.getNext() != null)
		{
			prev = current;
			current = current.getNext();
		}
		prev.setNext(null);
		System.out.println("The node with variable " + current.getData().getVariable() + " and float " + current.getData().getValue() + " has been removed from the back.");
		return current.getData();
	}
	public float find(LinkedListNode head, String s)
	{
		LinkedListNode current = head;
		while(current.getNext() != null)
		{
			if(current.getData().getVariable().equalsIgnoreCase(s))
				return current.getData().getValue();
			else
				current = current.getNext();
		}
		return 1234567890;

	}
}
