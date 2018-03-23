
public class QueueArray<T>
{
	private T[] arr;
	
	private int head, tail;
	private int maxSize, count;
	
	public QueueArray(int size)
	{
		maxSize = size;
		arr = (T[]) new Object[size];
		head = -1;
		tail = -1;
		count = 0;
	}
	
	public void enqueue(T data)
	{
		if (count < maxSize)
		{
			if (count == 0)
			{
				head = 0;
			}
			
			if (tail != maxSize - 1) //if not at the end of the array
			{
				arr[++tail] = data;
			}
			else
			{
				tail = 0;
				arr[tail] = data;
			}
			count++;
		}
		else
		{
			System.out.println("Queue is full.");
		}
	}
	
	public T dequeue()
	{
		T ele = null;
		if (count > 0)
		{
			ele = arr[head];
			if (++head == maxSize)
			{
				head = 0;
			}
			count--;
		}
		return ele;
	}
	

}
