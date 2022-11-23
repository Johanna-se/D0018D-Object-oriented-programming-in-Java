package Ovning6;
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Person> getAllPersons()
	{
		// Vi vill inte att någon annan förändrar vår lista
		// Därför returnerar vi en referens till en kopia av listan
		return (ArrayList<Person>) persons.clone();
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
