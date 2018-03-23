
public class valueData{

	private String variable;
	private float value;
	
	public valueData(String variable, float value)
	{
		this.variable = variable;
		this.value = value;
	}
	public float getValue()
	{
		return value;
	}
	public void setValue(float value)
	{
		this.value = value;
	}
	public String getVariable()
	{
		return variable;
	}
	public void setVariable(String variable)
	{
		this.variable = variable;
	}
}
