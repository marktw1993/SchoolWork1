public class dp_lcs {

	public String X, Y;
	public int lengthX=0, lengthY=0;
	public String lcsString="";
	
	//Constructor
	public dp_lcs(String xString, String yString){
		X = xString;
		Y = yString;
		lengthX = X.length();
		lengthY = Y.length();	
	}
	
	// find the longest common subsequence.
	public void findLCS(){
		
		// m = lengthX ----- n = lengthY
		// table to record the movement.
		int [][] b = new int [lengthX+1][lengthY+1];
		
		// table to record the length of LCS in prefixes Xi and Yj
		int [][] c = new int [lengthX+1][lengthY+1];
		
		// empty string Y0
		for(int i=1; i<lengthX+1; i++){
			c[i][0] = 0;
		}
		
		//empty string X0
		for(int j=0; j<lengthY+1; j++){
			c[0][j] = 0;
		}
		
		// implement your code here based on Pseudo code.
		
		for(int i = 1; i < lengthX+1; i++)
		{
			for(int j = 1; j < lengthY+1; j++)
			{
				if(this.X.charAt(i-1) == this.Y.charAt(j-1))
				{
					c[i][j] = c[i-1][j-1] + 1;
					b[i][j] = 100;
				}
				else if(c[i-1][j] >= c[i][j-1])
				{
					c[i][j] = c[i-1][j];
					b[i][j] = 101;
				}
				else
				{
					c[i][j] = c[i][j-1];
					b[i][j] = 102;
				}
			}
		}
		//createLCS(b,X,lengthX,lengthY);
		int i = lengthX;
		int j = lengthY;		
		while(i > 0 || j > 0)
		{
//			System.out.println("i = " + i + " j = " + j);
			if(b[i][j] == 100)
			{
//				System.out.println(i + " " + j);
				lcsString = this.X.charAt(i-1) + lcsString;
				i--;
			}
			else if(b[i][j] == 101)
			{
//				System.out.println(i + " " + j);
				i--;
			}
			else
			{
//				System.out.println(i + " " + j);
				j--;
			}
		}
		
	}
	public void createLCS(int[][] b, String xWord, int i, int j)
	{
		if (i == 0 || j == 0)
			return;
		if(b[i][j] == 100)
		{
			createLCS(b, xWord, i--, j--);
			lcsString += X.charAt(i);
		}
		else if( b[i][j] == 101)
		{
			createLCS(b, xWord, i--, j);
		}
		else
		{
			createLCS(b, xWord, i, j--);
		}
	}
	
	public String returnLCS(){
		findLCS();
		return lcsString;
	}
	
}