/**
* Klass för att hantera en patients medicin
* 
* Psudokod:
* 
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medicin implements Serializable
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
    
    public String getMedicinNamn()
    {
        return medicinNamn;
    }
    
    public boolean getMedicinKlar()
    {
        return medicinKlar;
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
        	medicinNamn = streamIn.readUTF();
        	mangd = streamIn.readInt();
        	medicinKlar = streamIn.readBoolean();
        	tidsIntervall = streamIn.readLong();
        	tidAttTaMedicin = (LocalTime) streamIn.readObject();
        	antalGanger = streamIn.readInt();
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
        	streamUt.writeUTF(medicinNamn);
        	streamUt.writeInt(mangd);
        	streamUt.writeBoolean(medicinKlar);
        	streamUt.writeLong(tidsIntervall);
        	streamUt.writeObject(tidAttTaMedicin);
        	streamUt.writeInt(antalGanger);
        }
        catch (IOException e)
        {
            throw new IOException();
        }
    }
    
    
    //-----------------------------------------------metoder--------------------------------------------------
    /**
	* Metod för att skriva över toString
	* @param LocalTime tidNu - utgår från vad klockan inom programmet är nu för att kolla om det är tid att ta medicinen
	* @return String
	*/
    @Override
    public String toString()
    {
    	return medicinNamn + " " + String.valueOf(mangd) + "ml " + String.valueOf(tidAttTaMedicin);
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
