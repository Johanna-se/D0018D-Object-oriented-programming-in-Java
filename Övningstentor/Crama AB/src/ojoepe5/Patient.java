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
    public void skapaMedicin(String medicinNamn, int mangd, long tid, int antal, LocalTime tidNu)
    {
    	
    	//Skapa medicinen
    	Medicin medicin = new Medicin(medicinNamn, mangd, tid, antal, tidNu);
    	
    	//Lägg till i listan
    	medicinList.add(medicin);
    }
    
    /**
     * Metod för att ta medicin 
     * @param String medicinNamn - vilken medicin
     * @param int mangd - mängden av medicin som ska tas
     * @param long tid - vilken tid medicinen ska tas
     * @param int antal - hur många gånger medicinen ska tas
     * @param LocalTime tidNu - utgår från vad klockan inom programmet är nu för att skapa logg när medicin ska tas
     */
     //public boolean taMedicin(String medicinNamn, int mangd, long tid, int antal, LocalTime tidNu)
     {
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
}
