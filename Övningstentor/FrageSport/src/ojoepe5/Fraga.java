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

public class Fraga implements Serializable
{
	//Klass-variabel
    protected static int senastAnvandaFrageID = 1000; //gemensam för alla fråge object 
    //NOTE: Jag har valt att ange frågornas ID som en klass-variabel så varje fråga får ett unikt nummer på detta sätt
	
	//Variabler
    private String fraga;
    private String svar;
    private int frageID;
    
    //konstruktor
    public Fraga (String fraga, String svar)
    {
    	senastAnvandaFrageID++;
    	
    	this.fraga = fraga;
    	this.svar = svar;
    	this.frageID = senastAnvandaFrageID;
    }
    
    //--------------------------------Metoder för IO--------------------------------------------
    /**
    * Metod för att kunna läsa objected från en stream. behövs för att implementera Serializable 
    * @param ObjectOutputStream streamUt
    * @return void
    */
    private void readObject(ObjectInputStream streamIn) throws IOException
    {
        try
        {
        	fraga = streamIn.readUTF();
        	svar = streamIn.readUTF();
        	frageID = streamIn.readInt();
        	
        	//senastAnvandaKontoNr höjs
            if (senastAnvandaFrageID < frageID )
            {
            	senastAnvandaFrageID = frageID++;
            }
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
             streamUt.writeInt(frageID);
             
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
     
     public int getfrageID()
     {
    	 return frageID;
     }
     
     //-------------------------------Set metoder-----------------------------------
     public String setFraga(String text)
     {
    	 return fraga;
     }
    
     public String setSvar(String text)
     {
    	 return svar;
     }

}
