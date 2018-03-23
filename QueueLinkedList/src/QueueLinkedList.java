
public class QueueLinkedList<T>
{
	private class Node
	{
		private T data;
		private Node next;
		
		public Node(T data)
		{
			this.data = data;
		}
	}
	
	private Node head;
	private Node tail;
	
	public QueueLinkedList()
	{
		head = null;
		tail = null;
	}
	
	public void enqueue(T data)
	{
		Node newNode = new Node(data);
		newNode.next = null;
		
		if (tail == null)
		{
			tail = newNode;
			head = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
	
	}
	
	public T dequeue()
	{
		Node n = null;
		if (head != null)
		{
			n = head;
			head = head.next;
		}
		
		return n.data;
	}
	
	
	
	
}
