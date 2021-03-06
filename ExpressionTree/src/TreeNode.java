package expressionTree;

public class TreeNode extends ExpressionTree
{
	public char data;
	public TreeNode parent;
	public TreeNode leftChild;
	public TreeNode rightChild;
	public float order;        //Precedence level (we know what we are talking about)
	
	public TreeNode()
	{
		data = ' ';
		parent = null;
		leftChild = null;
		rightChild = null;
		order = 1;
	}
	public TreeNode(char d)
	{
		data = d;
		parent = null;
		leftChild = null;
		rightChild = null;
		order = 1;
	}
	/*
	 * *****new******
	 *  Parses the string that is inputted
	 * 
	 */

	public void add(TreeNode tn)
	{
		setOrder(tn.data);
		if(tn instanceof OpNode)
		{
			tn.push(on);
		}
		else if(tn instanceof NumNode)
		{
			tn.push(nn);
		}
	}
	public void setOrder(char c)
	{
		if(c == '(')
		{
			multiplier *= 10;
		}
		else if(c == ')')
		{
			multiplier /= 10;
		}
		else if(c == '*' || c == '/')
		{
			order = 10;
		}
		else if(c == '+' || c == '-')
		{
			order = 20;
		}
	}
}