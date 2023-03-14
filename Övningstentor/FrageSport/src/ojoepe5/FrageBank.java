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
    	
    	//Kolla så att patienten inte redan har medicinen
    	for(Kategori kategori : kategoriLista)
    	{
    		kontroll = kategori.getNamn();
    		
    		if (kontroll.equals(namn))
    		{
    			return false; //Medicinen finns sedan tidigare
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
     * Metod för att skapa en fråga
     * NOTE: Jag kollar inte om frågan finns sedan tidigare
     * @param String text - frågan
     * @param String svar - svaret på frågan
     * @param String kategoriNamn - vilken kategorti frågan tillhör NOTE: I GUIet är det tänkt att en lista ska skapas såa att användaren kan välja och slipper skriva in denna
     * @return boolean skapad Ja/Nej.
     */
     //public boolean taBortKategori(String text, String svar, String kategoriNamn)
     {
    	 //Variabler
    	 //int kategoriPos;

         //TODO
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
    * NOTE: Jag kollar inte om frågan finns sedan tidigare
    * @param String text - frågan
    * @param String svar - svaret på frågan
    * @param String kategoriNamn - vilken kategorti frågan tillhör NOTE: I GUIet är det tänkt att en lista ska skapas såa att användaren kan välja och slipper skriva in denna
    * @return boolean skapad Ja/Nej.
    */
    //public boolean taBortFraga(String text, String svar, String kategoriNamn)
    {
    	//Variabler
        //int kategoriPos;

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
	//public boolean hamtaListaMedFragor(String text, String svar, String kategoriNamn)
	{
		//Variabler
		//int kategoriPos;

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
	//public boolean editeraFraga(String nyText, String NySvar, int posFraga, String kategoriNamn)
	{
		//Variabler
		//int kategoriPos;

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
		//Loopa igenom patientlista
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
