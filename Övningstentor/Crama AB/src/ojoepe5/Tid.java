/**
* Klass för att simulera tid. klockan startar vid 12.00 mitt på dagen.
* klassen använder sig av java.time.LocalTime
* 
* Källor: https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
* @author Johanna Petersson, ojoepe-5
*/
package ojoepe5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;

public class Tid implements Serializable
{
	private LocalTime klockan;
	
    // Konstruktor
    public Tid()
    {
    	klockan = LocalTime.NOON; //Sätt klockan initialt till 12.00 mitt på dagen
    }
    
    //-----------------------------------------------Get metoder--------------------------------------------------    
    
    public LocalTime getTid()
    {
        return klockan;
    }
    
//--------------------------------Metoder för IO--------------------------------------------
    
    /**
    * Metod för att kunna läsa objected från en stream. behövs för att implementera Serializable 
    * @param ObjectOutputStream streamUt
    * @return void
    */
    private void readObject(ObjectInputStream streamIn) throws ClassNotFoundException, IOException
    {
        try
        {

        	klockan = (LocalTime) streamIn.readObject();
        }
        catch (EOFException exc)
        {
            //Slut på inläsningen, 
        }
        catch (ClassNotFoundException ce)
        {
            throw new ClassNotFoundException();
        }
        catch (IOException e)
        {
            throw new IOException();
        }
    }
    
    /**
    * Metod för att kunna läsa objected till en stream. behövs för att implementera Serializable 
    * @param ObjectOutputStream streamUt
    * @return void
    */
    private void writeObject(ObjectOutputStream streamUt) throws IOException
    {
        try
        {
        	streamUt.writeObject(klockan);
        }
        catch (IOException e)
        {
            throw new IOException();
        }
    }
    
    //-----------------------------------------------Metoder-------------------------------------------------
    
    /**
    * Metod för att lägga till 5 minuter
    */
    public void laggTillFemMin()
    {
    	long addMinuteTime = 5L;
    	
    	klockan = klockan.plusMinutes(addMinuteTime);
    }
    
    /**
    * Metod för att lägga till jämföra om en tid är efter en annan
    */
    public boolean arTidEfter(LocalTime tidAttJamforaMed)
    {
    	return klockan.isAfter(tidAttJamforaMed);
    }
}
