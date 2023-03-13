/**
* Klass för frågor som tillhör en kategori
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Fraga implements Serializable
{
	//Variabler
    private String fraga;
    private String svar;
    
    //konstruktor
    public Fraga (String fraga, String svar)
    {
    	this.fraga = fraga;
    	this.svar = svar;
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
        	fraga = streamIn.readUTF();
        	svar = streamIn.readUTF();
        }
        catch (EOFException exc)
        {
            //Slut på inläsningen, 
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
             streamUt.writeUTF(fraga);
             streamUt.writeUTF(svar);
         }
         catch (IOException e)
         {
             throw new IOException();
         }
     }
    
     //-------------------------------Get metoder-----------------------------------
     public String getFraga()
     {
    	 return fraga;
     }
    
     public String getSvar()
     {
    	 return svar;
     }
}
