/********************************************************************************************************************
 *   File Name: Pet.java
 *      Author:	Mark Walters
 *        Date: 02/15/2015
 *       Class: CSCI 300
 * Description: 
 * ******************************************************************************************************************/
public class Pet 
{
	protected String name, owner;
	protected double weight, totalCost;
	protected int visits;
	public Pet()
	{
		
	}
	public Pet(String n, String o, double w)
	{
		name = n;
		owner = o;
		weight = w;
		visits = 0;
		totalCost = 0;
	}
	public void visit(int numberOfShots)
	{
		totalCost += 85.0 + (numberOfShots*30.0);
		visits++;
	}
	public String toString()
	{
		if(visits == 0)
			return name + " : " + owner + " : " + weight + " lbs : " + visits + " visit(s) ";
		else
			return name + " : " + owner + " : " + weight + " lbs : " + visits + " visit(s), "
					+ "Average cost / visit: $" + totalCost/visits + " ";
	}
}
