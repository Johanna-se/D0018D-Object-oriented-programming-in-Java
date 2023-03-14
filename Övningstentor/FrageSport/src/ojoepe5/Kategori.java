/**
* Klass för kategorier
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    /**
    * Metod för att kunna läsa objected från en stream. behövs för att implementera Serializable 
    * @param ObjectOutputStream streamUt
    * @return void
    */
    private void readObject(ObjectInputStream streamIn) throws ClassNotFoundException, IOException
    {
        try
        {
        	frageLista = (ArrayList <Fraga>) streamIn.readObject();
        	kategori = streamIn.readUTF();
        	nastaFraga = 0;
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
        	 streamUt.writeObject(frageLista);
             streamUt.writeUTF(kategori);
         }
         catch (IOException e)
         {
             throw new IOException();
         }
     }
    
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
