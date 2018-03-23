package expressionTree;

public class ExpressionTree 
{
	public TreeNode[] nodeArray = new TreeNode[50];
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
				NN.setOrder(c);
				nodeArray[index++] = NN;
				
			}
			else if (this.isOperator(c))
			{
				OpNode ON = new OpNode(c);
				ON.setOrder(c);
				nodeArray[index++] = ON;
			}
		}
	}
	public boolean isEmpty()
	{
		return root == null;
	}
	public boolean isOperator(char c)
	{
		return c == '/' || c == '*' || c == '-' || c == '+';
	}
	
	
	// ****** Needs work **********
	public void printArray()
	{
		for(int i = 0; i < index; i++)
			System.out.println(nodeArray[i].data + " " + nodeArray[i].order);
	}
}
