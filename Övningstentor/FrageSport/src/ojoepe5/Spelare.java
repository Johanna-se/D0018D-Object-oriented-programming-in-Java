/**
* Klass för spelare 
* @author Johanna Petersson, ojoepe-5
*/


package ojoepe5;

public class Spelare 
{
	//Variabler
    private String namn;
    private int poang;
    
    //konstruktor
    public Spelare (String namn)
    {
    	this.namn = namn;
    	poang = 0;

    }
    
    //--------------------------------Metoder för IO--------------------------------------------
    
    //-----------------------------------------------Get metoder--------------------------------------------------    
    
    public String getNamn()
    {
        return namn;
    }
    
    //-------------------------------Publika metoder----------------------------------- 
}
