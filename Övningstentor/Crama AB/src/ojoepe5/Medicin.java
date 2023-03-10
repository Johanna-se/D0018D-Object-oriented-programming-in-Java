/**
* Klass för att hantera en patients medicin
* 
* Psudokod:
* 
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medicin 
{
    private String medicinNamn;
    private int mangd;
    private boolean medicinKlar; //När en patient har tagit alla omgångar av sin medicin så ändras denna till sant.
    private long tidsIntervall;
    private LocalTime tidAttTaMedicin;
    private int antalGanger;
    
    // Konstruktorer
    public Medicin (String namn, int hurMycket, long intervall, int antal, LocalTime tidNu)
    {
    	medicinNamn = namn;
    	mangd = hurMycket;
    	medicinKlar = false;
    	antalGanger = antal;
    	tidsIntervall = intervall;
    	tidAttTaMedicin = tidNu.plusMinutes(intervall); //Första gången medicinen ska tas
    }
    
    //-----------------------------------------------Get metoder--------------------------------------------------    
    
    public String medicinNamn()
    {
        return medicinNamn;
    }
    
    
    //-----------------------------------------------metoder--------------------------------------------------
    /**
	* Metod för att hämta information om patentens medicin
	* @return ArrayList<String> - namn ; mängd; tid
	*/
    public ArrayList<String> medicinInfo()
    {
    	//Variabler
    	ArrayList<String> arrayAttReturnera = new ArrayList<String>();
    	
    	//Lägg till info
    	arrayAttReturnera.add(medicinNamn);
    	arrayAttReturnera.add(String.valueOf(mangd) + "ml ");
    	arrayAttReturnera.add(String.valueOf(tidAttTaMedicin));
    	
    	return arrayAttReturnera;
    }
    
	/**
	* Metod för att kolla att det är tid att ta medicin och, om sant, ta den
	* @param LocalTime tidNu - utgår från vad klockan inom programmet är nu för att kolla om det är tid att ta medicinen
	* @return boolean medicin tagen ja/nej
	*/
    public boolean taMedicin(LocalTime tidNu)
    {
    	boolean medicinTagen = false;
    	
    	//Kontrollera att medicinen ej är klar
    	if (medicinKlar == false)
    	{
    		//Kolla om tiden stämmer
    		if (tidAttTaMedicin.equals(tidNu))
        	{
        		medicinTagen = true;
        		antalGanger = antalGanger -1;
        		
        		//Kolla om det var sista gången att ta medicinen
        		if (antalGanger <= 0)
        		{
        			medicinKlar = true;
        		}
        		
        		//Uppdatera tiden för nästa gång
        		tidAttTaMedicin = tidNu.plusMinutes(tidsIntervall);
        		
        		medicinTagen = true;
        	}
    	}
    	return medicinTagen;
    }
    
    
}
