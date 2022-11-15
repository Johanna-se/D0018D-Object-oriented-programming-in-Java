package personRegister;
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
	
	public ArrayList<Person> getAllPersons()
	{
		// Vi vill inte att någon annan förändrar vår lista
		// Därför gör vi en kopia av listan och alla ingående objekt
		ArrayList<Person> copy = new ArrayList<Person>();
		for(Person p : persons)
			copy.add(new Person(p.getName(), p.getPhoneNr()));
		return copy;
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
