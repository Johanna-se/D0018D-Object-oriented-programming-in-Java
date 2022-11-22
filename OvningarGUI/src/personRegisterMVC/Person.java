package personRegisterMVC;

public class Person 
{
    private String name;
    private String phoneNr;

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

    public String toString()
    {
        return name;
    }
}
