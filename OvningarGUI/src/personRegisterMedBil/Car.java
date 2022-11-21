package personRegisterMedBil;

public class Car 
{
	private String brand;
	private String color;
	private String regNumber;
	
	public Car(String brand, String color, String regNumber)
	{
		this.brand = brand;
		this.color = color;
		this.regNumber = regNumber;
	}
	
	public String toString()
	{
		return regNumber;
	}
	
	public String getInfo()
	{
		return brand + ", " + color + ", " + regNumber;
	}
}
