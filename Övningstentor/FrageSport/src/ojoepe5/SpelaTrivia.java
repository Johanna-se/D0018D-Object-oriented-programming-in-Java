package ojoepe5;

import java.util.ArrayList;

public class SpelaTrivia 
{
	//Variabler
    private ArrayList<Spelare> spelarLista;
    private Spelare dennaSpelare;
    private Kategori dennaKategori;
    private Fraga dennaFraga;
    private int spelaresPoang;
    
    
  //konstruktor
    public SpelaTrivia()
    {
    	spelarLista = new ArrayList<Spelare>();
    	dennaSpelare = null;
    	dennaKategori = null;
    	dennaFraga = null;
    	spelaresPoang = 0;
    }
    
    //--------------------------------Metoder för IO--------------------------------------------
    
    //-------------------------------Publika metoder-----------------------------------
    /**
    * Metod för att skapa en spelare. 
    * NOTE: Jag har antagit att två spelare ej kan heta samma sak
    * @param String namn - spelarens namn
    * @return boolean skapad Ja/Nej.
    */
    public boolean skapaSpelare(String namn)
    {
    	//Kontrollera om finns sedan tidigare (om den gör det returneras position i kundlista, om ej -1)
        int finnsSpelaren;
        finnsSpelaren = finnsNamn(namn);
        
        //Om det gör det, returnera false
        if (finnsSpelaren >= 0)
        {
            return false;
        }
        
        //Om patienten ej existerar sedan tidigare, skapa och lägg till i listan. 
        Spelare  spelare  = new Spelare (namn);
        spelarLista.add(spelare);

        return true;
    	
    }
    
	//-----------------------------------------Privata Metoder -------------------------------------------------    
	
	/**
	* Privat metod för att kolla om namnet finns sedan tidigare.
	* @param String namn, spelarens namn
	* @return int, om spelaren finns returnera position i lista, om ej returnera -1
	*/
	private int finnsNamn(String namn)
	{
	    //Loopa igenom patientlista
	    for (Spelare spelare : spelarLista)
	    {
	        if (namn.equals(spelare.getNamn()))
	        {
	            return spelarLista.indexOf(spelare); //Källa: https://www.tutorialspoint.com/get-the-location-of-an-element-in-java-arraylist
	        }
	    }
	    
	    //Om loopen ej hittar 
	    return -1;
	}
}
