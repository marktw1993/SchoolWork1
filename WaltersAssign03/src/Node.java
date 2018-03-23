
public class Node<E>
{
	E data;
	Node<E> next;	
	Node<E> last;
	
	public Node(E d)
	{
		next = null;
		last = null;
		data = d;
	}
	public Node()
	{
		next = null;
		last = null;
	}
}
