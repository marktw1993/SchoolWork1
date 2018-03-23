
public interface TextEditor<E>
{	
	public void insert(E line);
	
	public void insertAfter(int position, E line); 
	
	public void insertBefore(int position, E line);
	
	public void deleteByPosition(int position);
	
	public void printNode(int position);
	
	public void printAllNodes();
	
}
