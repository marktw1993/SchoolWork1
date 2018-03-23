
public class LinkedListNode
{
	private valueData data;
	private LinkedListNode next;
	
	public LinkedListNode (valueData data)
	{
		this.data = data;
		next = null;
	}
	public LinkedListNode getNext()
	{
		if(next == null)
			return null;
		else
			return next;
	}
	public void setNext(LinkedListNode next)
	{
		this.next = next;
	}
	public valueData getData()
	{
		return data;
	}
	public void setData(valueData data)
	{
		this.data = data;
	}
}
