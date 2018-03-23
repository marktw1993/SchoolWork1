
public abstract class ObjectStack extends LinkedList implements Stack
{
	private int size;
	private LinkedList listStack;
	
	public ObjectStack()
	{
		super();
	}
	public void push(Object item)
	{
		listStack.insertFront((valueData) item);
	}
	public Object pop() throws EmptyStackException
	{
		if(this.isEmpty())
			return null;
		Object o = head;
		head.setNext(head.getNext());
		return o;
	}
	public Object top() throws EmptyStackException
	{
		return listStack.getHead();
	}
	public boolean isEmpty()
	{
		 return listStack.getHead() == null;
	}
	public int getSize()
	{
		return size;
	}
	public void setSize(int i)
	{
		size = i;
	}
}
