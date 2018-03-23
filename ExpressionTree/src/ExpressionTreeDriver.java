package expressionTree;
import java.util.*;

public class ExpressionTreeDriver
{

	public static void main(String[] args) 
	{
		ExpressionTree expressionTree = new ExpressionTree();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter expression now:");
		String expString = scan.nextLine();
		expressionTree.parseNodes(expString);
		
		scan.close();
	}
}
