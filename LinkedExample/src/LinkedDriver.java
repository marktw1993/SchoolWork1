
public class LinkedDriver
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		LinkedNode<Integer> ln = new LinkedNode<Integer>();
		
		System.out.println("=================================");

		
		ln.push(4);
		ln.push(5);
		ln.push(1);
		ln.printList();
		System.out.println();
		
		System.out.println(ln.pop());
		System.out.println(ln.peek());
		System.out.println("=================================");
		
		ln.printList();
		
	}

}
