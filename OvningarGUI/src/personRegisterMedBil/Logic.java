package personRegisterMedBil;
import java.util.ArrayList;

public class Logic 
{
	private ArrayList<Person> persons;
	
	public Logic()
	{
		persons = new ArrayList<Person>();
	}
	
	public void addPerson(String theName, String thePhoneNr)
	{
		persons.add(new Person(theName, thePhoneNr));
	}
	
	public void addCar(int position, String theBrand, String theColor, String theRegNumber)
	{
		Person person = persons.get(position);
		person.addCar(new Car(theBrand, theColor, theRegNumber));
	}
	
	public String getCarInfo(int position, int carPosition)
	{
		Person person = persons.get(position);
		return person.getCarInfo(carPosition);
	}
	
	public String getPersonInfo(int position)
	{
		Person person = persons.get(position);
		return person.getInfo();
	}
	
	public ArrayList<Person> getAllPersons()
	{
		return (ArrayList<Person>)persons.clone();
	}
	
	public ArrayList<Car> getAllCars(int position)
	{
		Person person = persons.get(position);
		return person.getAllCars();
	}
	
	public String getNameForPersonAt(int position)
	{
		return (persons.get(position)).getName();
	}
	
	public String getPhoneNrForPersonAt(int position)
	{
		return (persons.get(position)).getPhoneNr();
	}
}
