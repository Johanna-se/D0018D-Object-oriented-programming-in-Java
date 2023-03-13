/**
* Klass för att simulera tid. klockan startar vid 12.00 mitt på dagen.
* klassen använder sig av java.time.LocalTime
* 
* Jag funderade på om klockan skulle sparas i implements Serializable men då programmet egentligen ska vara beroende av reala tiden 
* (och där av ej ska sparas) så avstod jag.
* 
* Källor: https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
* @author Johanna Petersson, ojoepe-5
*/
package ojoepe5;

import java.io.Serializable;
import java.time.LocalTime;

public class Tid 
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
