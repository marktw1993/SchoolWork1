
public class WaltersLab04 
{

	public static void main(String[] args) 
	{
		String s = "mississippi";
		s = reverse(s);
		System.out.println(s);
		
		int array[]={2,3,1,5,6,2,7};
	}
	public static String reverse(String s)
	{
		if(0 == s.length())
			return "";
		else
			return reverse(s.substring(1,s.length())) + s.substring(0,1);
	}
}
	