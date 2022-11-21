package personRegisterMedBil;
import java.util.ArrayList;

public class Person 
{
	private String name;
	private String phoneNr;
	private ArrayList<Car> cars = new ArrayList<Car>();
	
	public Person(String theName, String thePhoneNr)
	{
		name = theName;
		phoneNr = thePhoneNr;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNr()
	{
		return phoneNr;
	}
	
	public void addCar(Car theCar)
	{
		cars.add(theCar);
	}
	
	public String getCarInfo(int position)
	{
		return cars.get(position).getInfo();
	}
	
	public ArrayList<Car> getAllCars()
	{
		return (ArrayList<Car>)cars.clone();
	}
	
	//Denna metod anropas implicit då ett Personobjekt ska visas 
	//i JList-komponenten i det grafiska gränssnittet
	public String toString()
	{
		return name;
	}
	
	public String getInfo()
	{
		return name + ", " + phoneNr;
	}
}
