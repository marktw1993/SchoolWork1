package expressionTree;

public class OpNode extends TreeNode
{
	public OpNode(char c)
	{
		super(c);
	}
	public void push(OpNode op)
	{
		ExpressionTree et = new ExpressionTree();
		TreeNode current = new TreeNode();
		if(isEmpty())
		{
			et.root = op;
			nodeArray[i++] = op;
		}
		else if(root.order < op.order)
		{
			TreeNode temp = new TreeNode();
			temp = root;
			op.leftChild = temp;
			root = op;
		}
		else
		{
			current = root.leftChild;
			current.leftChild = root.leftChild.leftChild;
			current.rightChild = root.leftChild.rightChild;
		}
	}	
}