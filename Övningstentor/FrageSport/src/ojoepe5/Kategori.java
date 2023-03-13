/**
* Klass för kategorier
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

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
}
