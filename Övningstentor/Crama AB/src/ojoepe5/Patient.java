/**
* Klass för att hantera en patient.
* Medicinen lagras i en array.
* 
* Psudokod:
* get metoder
* Metod för lägg till medicin
* Metod för att ta medicin
* 	logga intaget
* metod för påminnelse
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.time.LocalTime;
import java.util.ArrayList;

public class Patient 
{
    private String namn;
    private ArrayList<Medicin> medicinList; //Lista för att förvara patients olika mediciner
    private ArrayList<String> loggList; //Logg lista för patients intag
    
    // Konstruktor
    public Patient (String patientNamn)
    {
    	namn = patientNamn;
    	medicinList = new ArrayList<Medicin>();
    	loggList = new ArrayList<String>();
    }
    
    //-----------------------------------------------Get metoder--------------------------------------------------    
    
    public String getNamn()
    {
        return namn;
    }
    
    
    //-----------------------------------------------Metoder för medicin-------------------------------------------------
    
    /**
    * Metod för att lägga till en medicin till patienten. 
    * @param String medicinNamn - vilken medicin
    * @param int mangd - mängden av medicin som ska tas
    * @param long tid - vilken tid medicinen ska tas
    * @param int antal - hur många gånger medicinen ska tas
    * @param LocalTime tidNu - utgår från vad klockan inom programmet är nu för att skapa logg när medicin ska tas
    */
    public boolean skapaMedicin(String medicinNamn, int mangd, long tid, int antal, LocalTime tidNu)
    {
    	//variabler
    	String kontroll;
    	
    	//Kolla så att patienten inte redan har medicinen
    	for (Medicin medicin : medicinList)
    	{
    		kontroll = medicin.medicinNamn();
    		
    		if (kontroll.equals(medicinNamn))
    		{
    			return false; //Medicinen finns sedan tidigare
    		}
    	}
    	
    	//Skapa medicinen
    	Medicin medicin = new Medicin(medicinNamn, mangd, tid, antal, tidNu);
    	
    	//Lägg till i listan
    	medicinList.add(medicin);
    	
    	return true;
    }
    
    /**
     * Metod för att ta medicin 
     * @param String medicinNamn - vilken medicin
     * @param int mangd - mängden av medicin som ska tas
     * @param long tid - vilken tid medicinen ska tas
     * @param int antal - hur många gånger medicinen ska tas
     * @param LocalTime tidNu - utgår från vad klockan inom programmet är nu för att skapa logg när medicin ska tas
     */
     public boolean taMedicin(String medicinNamn, LocalTime tidNu)
     {
         //Variabler
         int medicinPos;
         
         //Hitta patienten
         medicinPos = finnsMedicin(medicinNamn);
         
         //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         System.out.println("medicins position i listan? : " + medicinPos ); 
         
         
         //Om det gör det, returnera false
         if (medicinPos < 0)
         {
             return false; //om kund ej finns returnera tom array
         }
         
         //medicinklassen kollar om det är tid att ta medicinen
         return medicinList.get(medicinPos).taMedicin(tidNu);
         
         //TODO
     }
    
     /**
      * Metod för att hämta patientens medicinlista
      * @return ArrayList<String> - Lista med patent namn + medicin
      */
      public ArrayList<String> hamtaMedicinLista()
      {
     	 ArrayList<String> arrayAttReturnera = new ArrayList<String>();
     	 
     	 for (Medicin medicin : medicinList)
     	 {
     		 arrayAttReturnera.add(namn + " " + medicin.toString());
     	 }
     	 
     	 return arrayAttReturnera;
      }
      
      //-----------------------------------------Privata Metoder -------------------------------------------------    
      
      /**
      * Privat metod för att kolla om patient har medicin
      * @param String namn, medicinens namn
      * @return int, om medicinen finns returnera position i lista, om ej returnera -1
      */
      private int finnsMedicin(String namn)
      {
          //Loopa igenom patientlista
          for (Medicin medicin : medicinList)
          {
              if (namn.equals(medicin.medicinNamn()))
              {
                  return medicinList.indexOf(medicin); 
              }
          }
          
          //Om loopen ej hittar 
          return -1;
      }
}
