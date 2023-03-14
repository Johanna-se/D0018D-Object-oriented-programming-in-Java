/**
* Klass för kategorier
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Kategori
{
	//Variabler
    private ArrayList<Fraga> frageLista;
    private String kategori;
    private int nastaFraga;
    
    //konstruktor
    public Kategori(String kategoriNamn)
    {
    	frageLista = new ArrayList<Fraga>();
    	kategori = kategoriNamn;
    	nastaFraga = 0;
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
        	frageLista = (ArrayList <Fraga>) streamIn.readObject();
        	kategori = streamIn.readUTF();
        	nastaFraga = 0;
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
        	 streamUt.writeObject(frageLista);
             streamUt.writeUTF(kategori);
         }
         catch (IOException e)
         {
             throw new IOException();
         }
     }
    
    //-------------------------------Get metoder-----------------------------------
    public String getNamn()
    {
        return kategori;
    }
    
    //-------------------------------Publika metoder----------------------------------- 
    /**
    * Metod för att skapa en fråga
    * @param String text - frågan
    * @param String svar - svaret på frågan
    */
    public void skapaFraga(String text, String svar)
    {
        //Skapa frågan
    	Fraga fraga = new Fraga(text, svar);
    	
    	//Lägg till i listan
    	frageLista.add(fraga);
    }
    
    /**
	* Metod för att editera en fråga
	* @param String text - ny text till frågan
	* @param String svar - svaret på frågan
	* @param int frageID 
	* @return boolean ändrad Ja/Nej.
	*/
	public boolean editeraFraga(String text, String svar, int frageID)
	{
		//Variabler
		int pos = -1;
		
		//Hitta korrekt fråga
		pos = finnsFrageID(frageID);
		
		//Om frågeID ej hittades
		if (pos == -1)
		{
			return false;
		}
     	
     	//Om det finns text
		if (text.isEmpty())
		{
			//Skippa om tom
		}
		else
		{
			frageLista.get(pos).setFraga(text);
		}
		
		//Om det finns svar
		if (svar.isEmpty())
		{
			//Skippa om tom
		}
		else
		{
			frageLista.get(pos).setSvar(svar);
		}
		
		return true;
	
     }
	
	/**
	* Metod för att ta bort en fråga
	* @param int frageID 
	* @return boolean borttagen Ja/Nej.
	*/
	public boolean taBortFraga(int frageID)
	{
		//Variabler
		int pos = -1;
		
		//Hitta korrekt fråga
		pos = finnsFrageID(frageID);
		
		//Om frågeID ej hittades
		if (pos == -1)
		{
			return false;
		}
		
		//Ta bort frågan
		frageLista.remove(pos);
		
		return true;
	
     }
	
	/**
	* Metod för att hämta lista med frågor
	* @param int frageID 
	* @return ArrayList<String> lista med frågor
	*/
	public ArrayList<String> hamtaAllaFrager()
	{
		//Variabler
    	ArrayList<String> arrayAttReturnera = new ArrayList<String>();
		
    	for (Fraga fraga : frageLista)
    	 {
    		 arrayAttReturnera.add(fraga.toString());
    	 }
    	 
    	 return arrayAttReturnera;
	
     }
	
	//-----------------------------------------Privata Metoder -------------------------------------------------    
    
	/**
	* Privat metod för att kolla om frågan finns
	* @param int frageID 
	* @return int, om frågeID finns returnera position i lista, om ej returnera -1
	*/
	private int finnsFrageID(int frageID)
	{
		//Hitta korrekt fråga
		for (Fraga fraga : frageLista)
		{
			if (frageID == fraga.getfrageID())
			{
				return frageLista.indexOf(fraga);
			}
		}
	            
		//Om loopen ej hittar 
		return -1;
	}
    
    
    
    
}
