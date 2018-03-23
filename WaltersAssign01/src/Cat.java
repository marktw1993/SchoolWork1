/********************************************************************************************************************
 *   File Name: Cat.java
 *      Author: Mark Walters
 *        Date: 02/15/2015
 *       Class: CSCI 300
 * Description:
 * ******************************************************************************************************************/
public class Cat extends Pet
{
	private boolean goesOutside;
	
	public Cat(String n, String o, double w, boolean goesOutside) 
	{
		super(n,o,w);
		this.goesOutside = goesOutside;
	}
	public void visit(int numberOfShots)
	{
		totalCost += 105.0 + (numberOfShots*30.0);
		if(goesOutside)
			totalCost += 30.0;
		visits++;
	}
	public String toString()
	{
		if(goesOutside)
			return super.toString() + "[Outside Cat]";
		else
			return super.toString() + "[Inside Cat]";
	}
}
