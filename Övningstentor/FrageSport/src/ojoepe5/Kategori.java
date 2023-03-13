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
    * NOTE: Jag kollar inte om frågan finns sedan tidigare
    * @param String text - frågan
    * @param String svar - svaret på frågan
    * @return boolean skapad Ja/Nej.
    */
    public boolean skapaFraga(String text, String svar)
    {
        //Skapa frågan
        //TODO
         
         return true;
     }
}
