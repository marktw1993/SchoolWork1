
public class StackArray<E>
{
	private E[] sArray;
	private int top;
	
	public StackArray(int size)
	{
		sArray [size];
		top = -1;
	}
	
	public void push(E d)
	{
		if(top < sArray.length)	
			sArray[++top] = d;
	}
	public E pop()
	{
		if(top > -1)	
			return sArray[top--];
		else
			return null;
	}
	public E peek()
	{
		return sArray[top];
	}
}
