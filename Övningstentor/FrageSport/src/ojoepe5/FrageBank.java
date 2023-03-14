/**
* Klass som hanterar kategorier och dessas frågor till spelet Trivia
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FrageBank 
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
	* @param String nyText - frågan
	* @param String nySvar - svaret på frågan
	* @param String kategoriNamn - vilken kategorti frågan tillhör NOTE: I GUIet är det tänkt att en lista ska skapas såa att användaren kan välja och slipper skriva in denna
	* @return boolean editerad Ja/Nej.
	*/
	public boolean editeraFraga(String nyText, String nySvar, int frageID, String kategoriNamn)
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
		
		return kategoriLista.get(kategoriPos).editeraFraga(nyText, nySvar, frageID);
	}
    
    /**
    * Metod för att skapa en fråga
    * NOTE: Jag kollar inte om frågan finns sedan tidigare
    * @param String kategori - vilken kategori frågan tillhör
    * @param int frageID - frågans ID
    * @return boolean borttagen Ja/Nej.
    */
    public boolean taBortFraga(String kategori, int frageID)
    {
    	//Variabler
    	int kategoriPos = -1;
    	
    	kategoriPos = finnsKategori(kategori);
    					
    	//Om kategorin ej hittades
    	if (kategoriPos == -1)
    	{
    		return false;
    	}
    	
    	//Ta bort frågan
    	return kategoriLista.get(kategoriPos).taBortFraga(frageID);
    }
    
    /**
	* Metod för att skapa en fråga
	* @param String kategoriNamn - vilken kategorti frågan tillhör 
	* @return ArrayList<String> - lista med frågeID, fråga och svar
	*/
	public ArrayList<String> hamtaListaMedFragor(String kategoriNamn)
	{
		//Variabler
    	int kategoriPos = -1;
    	
    	kategoriPos = finnsKategori(kategori);
    					
    	//Om kategorin ej hittades
    	if (kategoriPos == -1)
    	{
    		return false;
    	}

		//TODO
     }
    
    
     
	/**
	* Metod för att skapa en fråga
	* NOTE: Jag kollar inte om frågan finns sedan tidigare
	* @param String text - frågan
	* @param String svar - svaret på frågan
	* @param String kategoriNamn - vilken kategorti frågan tillhör NOTE: I GUIet är det tänkt att en lista ska skapas såa att användaren kan välja och slipper skriva in denna
	* @return boolean skapad Ja/Nej.
	*/
	//public boolean hamtaNastaFraga(String kategoriNamn)
	{
		//Variabler
		//int kategoriPos;
	
		//TODO
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
