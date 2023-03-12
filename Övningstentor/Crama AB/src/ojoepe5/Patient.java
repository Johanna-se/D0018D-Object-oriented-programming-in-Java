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
    
    //OBS kopia av logglistan
    public ArrayList<String> getLoggList()
    {
        //Variabel
        ArrayList<String> arrayAttReturnera = new ArrayList<String>();
        
        for (String string : loggList)
        {
            arrayAttReturnera.add(string);
        }
        
        return arrayAttReturnera;
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
    		kontroll = medicin.getMedicinNamn();
    		
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
     * @param LocalTime tidNu - utgår från vad klockan inom programmet är nu för att skapa logg när medicin ska tas
     * @return boolean - medicin tagen ja/nej
     */
     public boolean taMedicin(String medicinNamn, LocalTime tidNu)
     {
         //Variabler
         int medicinPos;
         boolean medicinTagen;
         String logg;
         
         //Hitta medicinen
         medicinPos = finnsMedicin(medicinNamn);
         
         //Om ej finns
         if (medicinPos < 0)
         {
             return false; //om kund ej finns returnera tom array
         }
         
         //medicinklassen kollar om det är tid att ta medicinen
         medicinTagen = medicinList.get(medicinPos).taMedicin(tidNu);
         
         //Om meddicinen togs, uppdatera loggen
         if (medicinTagen == true)
         {
             //Uppdatera logglista
             logg = medicinList.get(medicinPos).toString();
             loggList.add(logg);
         }
         
         return medicinTagen;
     }
     
     /**
      * Metod för att ta bort medicin
      * @param String medicinNamn - vilken medicin
      * @return boolean - medicin borttagen ja/nej
      */
      public boolean taBortMedicin(String medicinNamn)
      {
          //Variabler
          int medicinPos;
          boolean medicinKlar;
          
          //Hitta medicinen
          medicinPos = finnsMedicin(medicinNamn);


          //Om ej finns
          if (medicinPos < 0)
          {
              return false; //om kund ej finns returnera tom array
          }
          
          //Kolla om medicin är klar
          medicinKlar = medicinList.get(medicinPos).getMedicinKlar();
          
          //Om medicin ej klar
          if (medicinKlar == false)
          {
              System.out.println("medicinKlar är: " + medicinKlar);
              return false;
          }
          
          //Ta bort medicin
          medicinList.remove(medicinPos);
          
          return true;
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
              if (namn.equals(medicin.getMedicinNamn()))
              {
                  return medicinList.indexOf(medicin); 
              }
          }
          
          //Om loopen ej hittar 
          return -1;
      }
}
