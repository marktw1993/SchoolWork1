import java.util.ArrayList;
import java.util.HashMap;


public class HashMapExample
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//Adding and geting things from HashMap
		/*HashMap<Integer, String> hm = new HashMap<Integer,String>();
		
		
		hm.put(265, "Computer Science II");
		hm.put(202, "Introduction to Computers");
		hm.put(203, "C++");
		hm.put(265, "VB");
		
		System.out.println(hm.get(265)); */
		
		HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();		
		
		ArrayList<String> tmp1 = new ArrayList<String>();
		tmp1.add("Computer Science II");
		hm.put(265, tmp1);
		
		ArrayList<String> tmp2 = hm.get(265);
		tmp2.add("VB");
		hm.put(265, tmp2);
				
		System.out.println(hm.get(265));

	}

}
