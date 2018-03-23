/********************************************************************************************************************
 *   File Name: Dog.java
 *      Author: Mark Walters
 *        Date: 02/15/2015
 *       Class: CSCI 300
 * Description:
 * ******************************************************************************************************************/
public class Dog extends Pet
{
	private String type;
	
	public Dog(String n, String o, double w, String t) 
	{
		super(n,o,w);
		type = t;
		
	}
	public void visit(int numberOfShots)
	{
		if(type == "medium")
			totalCost += 100.0 + (numberOfShots*32.5);
		else if(type == "large")
			totalCost += 100.0 + (numberOfShots*35.00);
		else 
			totalCost += 100.0 + (numberOfShots*30.0);
		visits++;
	}
	public String toString()
	{
		if(type == "medium")
			return super.toString() + "[Medium Dog]";
		else if(type == "large")
			return super.toString() + "[Large Dog]";
		else
			return super.toString() + "[Small Dog]";
	}
}
