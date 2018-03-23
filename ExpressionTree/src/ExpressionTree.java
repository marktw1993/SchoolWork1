package expressionTree;

public class ExpressionTree 
{
	public TreeNode[] nodeArray;
	public TreeNode root;
	public int index;
	public float multiplier;
	
	public ExpressionTree()
	{
		root = null;
		index = 0;
		multiplier = 1;
	}
	
	public void parseNodes(String expression)
	{
		for(char c : expression.toCharArray())
		{
			if(Character.isDigit(c))
			{
				NumNode NN = new NumNode(c);
				nodeArray[index++] = NN;
			}
			else if (this.isOperator(c)))
			{
				OpNode OP = new OpNode(c);
				nodeArray[index++] = OP;
			}
		}
	}
	public boolean isEmpty()
	{
		return (root == null);
	}
	public boolean isOperator(char c)
	{
		return c == '/' || c == '*' || c == '-' || c == '+';
	}
}
