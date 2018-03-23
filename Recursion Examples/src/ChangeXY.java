
public class ChangeXY 
{
	private String changeXY(String s)
	{
		if(s.length() == 0)
			return "";
		else
			if(s.substring(0,1).equals("x"))
				return "y" + changeXY(s.substring(1,s.length()));
			else
				return s.substring(0,1) + changeXY(s.substring(1,s.length()));
	}
	private int countX(String s)
	{
		if(s.length() == 0)
			return 0;
		else
			if(s.substring(0,1).equals("x"))
				return 1 + countX(s.substring(1,s.length()));
			else
				return 0 + countX(s.substring(1,s.length()));
	}
	private int count11(int a[], int index)
	{
		if(index == a.length)
			return 0;
		else
			if(a[index] == 11)
				return 1 + count11(a,index++);
			else
				return 0 + count11(a,index++);
	}
}
