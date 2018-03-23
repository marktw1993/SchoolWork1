
public class MapDriver
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Map<Integer, String> m1 = new Map<Integer, String>(265, "Computer Science II");
		Map<Integer, String> m2 = new Map<Integer, String>(202, "Computer Science I");
		
		LinkedNode<Map<Integer,String>> ll = new LinkedNode<Map<Integer, String>>();
		
		ll.insert(m1);
		ll.insert(m2);
		
		ll.printList();
		
	}

}
