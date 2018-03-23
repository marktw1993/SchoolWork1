package expressionTree;

public class OpNode extends TreeNode
{
	public OpNode(char c)
	{
		super(c);
	}
	public void push(OpNode op)
	{
		ExpressionTree expTree = new ExpressionTree();
		TreeNode current = new TreeNode();
		for(int i = 0; i < index; i++)
		{
			
		}
		/*
		if(isEmpty())
		{
			et.root = op;
			nodeArray[index++] = op;
		}
		else if(root.order < op.order)
		{
			TreeNode temp = new TreeNode();
			temp = root;
			op.leftChild = temp;
			root = op;
		}			
		current = root.leftChild;
		current.leftChild = root.leftChild.leftChild;
		current.rightChild = root.leftChild.rightChild;
		*/
	}	
}