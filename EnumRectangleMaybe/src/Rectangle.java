public class Rectangle 
{
	private double length, width;	
	public Rectangle(double l, double w)
	{
		length = l;
	    width = w;
	}
	public void setLength(double l){ length = l;}
	public void setWidth(double w){ width = w;}
	public double getLength(){return length;}
	public double getWidth(){return width;}
	public double getArea(){return length * width;}
}
