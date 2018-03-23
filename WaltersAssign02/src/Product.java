/**********************************************************************************************************************************************************************************
 *   File Name: Product.java
 *      Author:	Mark Walters
 *        Date: 03/5/2015
 *       Class: CSCI 300
 * Description: Child class to HardwareDriver.java consisting of the product object which contains String SKU, int qty, double price, and String item(description)
 * ********************************************************************************************************************************************************************************/
import java.text.NumberFormat;

public class Product 
{
	private String SKU;
	private int qty;
	private double price;
	private String item;
	
	public Product(String s, String i, double p, int q)
	{
		SKU = s;
		item = i;
		price = p;
		qty = q;		
	}
	public String toString()
	{
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
		String returnString = SKU + "\t" + appendTab(item) + "\t" + qty + "\t" + moneyFormat.format(price);
		return returnString;
	}
	public String appendTab(String t)
	{
		if(t.length() < 8)
			return t +"\t\t";
		else
			return t +"\t";
	}
	public String getSKU(){return SKU;}
	public int getQty(){return qty;}
	public void setQty(int q){qty = q;}
}