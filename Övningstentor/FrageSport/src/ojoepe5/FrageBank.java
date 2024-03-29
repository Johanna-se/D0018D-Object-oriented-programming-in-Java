/**
* Klass som hanterar kategorier och dessas frågor till spelet Trivia
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class FrageBank implements Serializable
{
	//Variabler
    private ArrayList<Kategori> kategoriLista;
    
  //konstruktor
    public FrageBank ()
    {
    	kategoriLista = new ArrayList<Kategori>();
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
        	kategoriLista = (ArrayList <Kategori>) streamIn.readObject();
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
        	 streamUt.writeObject(kategoriLista);
         }
         catch (IOException e)
         {
             throw new IOException();
         }
     }
    
    //-------------------------------Get metoder-----------------------------------
    public int getKategoriListaStorlek()
    {
        return kategoriLista.size();
    }
    
    
    //-------------------------------Publika metoder----------------------------------- 
    
    //-------------------------------Kategorier----------------------------------- 
    /**
    * Metod för att skapa en kategori
    * NOTE: Jag har antagit att man inte skapar två av samma kategori
    * @param String namn - kategorins namn
    * @return boolean skapad Ja/Nej.
    */
    public boolean skapaKategori(String namn)
    {
    	//variabler
    	String kontroll;
    	
    	//Kolla om kategorin finns
    	for(Kategori kategori : kategoriLista)
    	{
    		kontroll = kategori.getNamn();
    		
    		if (kontroll.equals(namn))
    		{
    			return false;
    		}
    	}
    	
    	//Skapa medicinen
    	Kategori kategori = new Kategori(namn);
    	
    	//Lägg till i listan
    	kategoriLista.add(kategori);
    	
    	return true;
    }
    
    /**
    * Metod för att hämta namnen på alla kategorier
    * NOTE: denna är till för att skapa en lista i GUI så att användaren kan välja en kategori frågan ska tillhöra när denne ska skapas
    * @return ArrayList<String> Lista med kategoriers namn.
    */
    public ArrayList<String> getKategoriNamn()
    {
    	//Variabel
        ArrayList<String> arrayAttReturnera = new ArrayList<String>();
        
        for (Kategori kategori : kategoriLista)
        {
            arrayAttReturnera.add(kategori.getNamn());
        }
        
        return arrayAttReturnera;
    }
    
    
    /**
     * Metod för att ta bort en kategori
     * @param String kategoriNamn - vilken kategorti 
     * @return boolean bortagen Ja/Nej.
     */
     public boolean taBortKategori(String kategoriNamn)
     {
    	//Variabler
 		int kategoriPos = -1;
 		
 		//Hitta kategoring
 		kategoriPos = finnsKategori(kategoriNamn);
 		
 		//Om kategorin ej hittades
 		if (kategoriPos == -1)
 		{
 			return false;
 		}
 		
 		kategoriLista.remove(kategoriPos);
 		
 		return true;
     }
     
     
    //-------------------------------Frågor----------------------------------- 
     
     
    /**
    * Metod för att skapa en fråga
    * NOTE: Jag kollar inte om frågan finns sedan tidigare
    * @param String text - frågan
    * @param String svar - svaret på frågan
    * @param String kategoriNamn - vilken kategorti frågan tillhör NOTE: I GUIet är det tänkt att en lista ska skapas såa att användaren kan välja och slipper skriva in denna
    * @return boolean skapad Ja/Nej.
    */
    public boolean skapaFraga(String text, String svar, String kategoriNamn)
    {
    	//Variabler
        int kategoriPos;
        
        //Hitta kategorins position
        kategoriPos = finnsKategori(kategoriNamn);

        //Om ej finns
        if (kategoriPos < 0)
        {
            return false; 
        }
        
        //Skapa frågan
        kategoriLista.get(kategoriPos).skapaFraga(text, svar);
        
        return true;
    }
    
    /**
	* Metod för att skapa en fråga
	* NOTE: Jag springer igenom alla kategorier så att användaren endast behöver skriva FrågeID
	* @param String nyText - frågan
	* @param String nySvar - svaret på frågan
	* @param int frageID
	* @return boolean editerad Ja/Nej.
	*/
	public boolean editeraFraga(String nyText, String nySvar, int frageID)
	{
		//Variabler
    	boolean andrad;
    	
    	//Loopa igenom kategoriLista
    	for (Kategori kategori : kategoriLista)
    	{
    		andrad = kategori.editeraFraga(nyText, nySvar, frageID);
    		
    		if (andrad == true)
    		{
    			return true; 
    		}
    	}
    	
    	return false;
	}
    
    /**
    * Metod för att skapa en fråga
    * NOTE: Jag springer igenom alla kategorier så att användaren endast behöver skriva FrågeID
    * @param int frageID - frågans ID
    * @return boolean borttagen Ja/Nej.
    */
    public boolean taBortFraga(int frageID)
    {
    	//Variabler
    	boolean borttagen;
    	
    	//Loopa igenom kategoriLista
    	for (Kategori kategori : kategoriLista)
    	{
    		borttagen = kategori.taBortFraga(frageID);
    		
    		if (borttagen == true)
    		{
    			return true; 
    		}
    	}
    	
    	return false;
    }
    
    /**
	* Metod för att hämta en kategoris frågor
	* NOTE: jag valde att ta det kategori för kategori för att det ska bli lättare att hitta frågan man vill ändra.
	* @param String kategoriNamn - vilken kategorti frågan tillhör 
	* @return ArrayList<String> - lista med frågeID, fråga och svar
	*/
	public ArrayList<String> hamtaListaMedFragor(String kategoriNamn)
	{
		//Variabler
    	int kategoriPos = -1;
    	ArrayList<String> arrayAttReturnera = new ArrayList<String>();
    	
    	//Hitta kategorin i listan
    	kategoriPos = finnsKategori(kategoriNamn);
    					
    	//Om kategorin ej hittades
    	if (kategoriPos == -1)
    	{
    		return arrayAttReturnera;
    	}
    	
    	arrayAttReturnera = kategoriLista.get(kategoriPos).hamtaAllaFrager();
    	
    	return arrayAttReturnera;

     }
    
	/**
	* Metod för att hämta nästa fråga
	* NOTE: Jag kollar inte om frågan finns sedan tidigare
	* @param int kategoriPos - positionen av den slumpade kategorin
	* @return ArrayList<String> med fråga och svar
	*/
	public ArrayList<String> hamtaNastaFraga(int kategoriPos)
	{
		return kategoriLista.get(kategoriPos).hamtaNastaFrager();
	}
        
	//-----------------------------------------Privata Metoder -------------------------------------------------    
        
	/**
	* Privat metod för att kolla om kategorin finns
	* @param String namn, 
	* @return int, om kategorin finns returnera position i lista, om ej returnera -1
	*/
	private int finnsKategori(String namn)
	{
		//Loopa igenom kategoriLista
		for (Kategori kategori : kategoriLista)
		{
			if (namn.equals(kategori.getNamn()))
			{
				return kategoriLista.indexOf(kategori); 
			}
		}
            
		//Om loopen ej hittar 
		return -1;
	}
    
}
