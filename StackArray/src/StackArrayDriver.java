
public class StackArrayDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		StackArray<Integer> s = new StackArray<Integer>(10);
		s.push(5);
		s.push(15);
		s.push(9);
		s.push(7);
		
		System.out.println(s.pop());
	}

}
