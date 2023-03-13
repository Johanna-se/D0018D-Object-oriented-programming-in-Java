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
    * Metod för att skapa en fråga
    * NOTE: Jag kollar inte om frågan finns sedan tidigare
    * @param String text - frågan
    * @param String svar - svaret på frågan
    * @return boolean skapad Ja/Nej.
    */
    public boolean skapaKategori(String text, String svar)
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
    
}
