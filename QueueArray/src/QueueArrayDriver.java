
public class QueueArrayDriver
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		QueueArray<Integer> qa = new QueueArray<Integer>(5);
		
		qa.enqueue(6);
		qa.enqueue(7);
		qa.enqueue(8);
		qa.enqueue(9);
		qa.enqueue(10);
		System.out.println(qa.dequeue());
		qa.enqueue(11);
		qa.enqueue(12); //Queue should be full here...
		System.out.println(qa.dequeue());

	}

}
