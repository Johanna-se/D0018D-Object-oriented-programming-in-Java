/**
* Klass som hanterar kategorier och dessas frågor till spelet Trivia
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

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
    
    //-------------------------------Get metoder-----------------------------------
    public int getKategoriListaStorlek()
    {
        return kategoriLista.size();
    }
    
    
    //-------------------------------Publika metoder----------------------------------- 
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
    public boolean skapaFraga(String text, String svar, String kategoriNamn)
    {
    	//variabler
    	int kategoriPos;
    	boolean fragaSkapas,
    	
    	//Hitta medicinen
    	kategoriPos = finnsKategori(kategoriNamn);
        
        //Om ej finns
        if (kategoriPos < 0)
        {
            return false; 
        }
    	
    	//Skapa frågan
    	
    	
    	return true;
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
