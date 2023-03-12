/**
* Klass för att hantera företagets patienter. Använder sig av klassen Patient för detta
* Patient lagras i en array.
* 
* Psudokod:
* Konstruktor
* Metod för att hämta alla patienter
* Metod för att hämta en patient
* Metod för att ta medicin
* Metod ta bort färdig medicin
* 
* 
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PatientRegister 
{
	//Variabler
    private ArrayList<Patient> patientLista;
    
    //konstruktor
    public PatientRegister ()
    {
    	patientLista = new ArrayList<Patient>();
    }
    
    
    //-------------------------------Metoder för patienter ----------------------------------- 
    
    /**
    * Metod för att returnera information om alla bolagets patienter
    * @return ArrayList<String> - array med alla bankens kunder ("7505121231 Lotta Larsson") //KOLLA!!!!!
    */
    public ArrayList<String> hamtaAllaPatienter()
    {
        //variabler
        ArrayList<String> arrayAttReturnera = new ArrayList<String>();
        String patientInfo;
        
        //Loop-igenom array med kunder och lagra info i retur arrayen OBS Uppdaterad efter feedback från uppgift 1 källa:https://www.geeksforgeeks.org/for-each-loop-in-java/
        for (Patient patient : patientLista)
        {
        	patientInfo = patient.getNamn();
            arrayAttReturnera.add(patientInfo);
        }
        
        return arrayAttReturnera;
    }
    
    /**
    * Metod för att returnera information om alla bolagets patienter som har en medicin inlaggd. Saknas det medicin så 
    * @return ArrayList<String> - array med alla patienter och deras mediciner "Anna Andersson Alvedon 200ml 12:15"
    */
    public ArrayList<String> hamtaAllaPatienterOchMedicin()
    {
    	//variabler
        ArrayList<String> arrayAttReturnera = new ArrayList<String>();
        ArrayList<String> tempArray = new ArrayList<String>();
        
        //Loop-igenom array med patienter, hämta dessas medicinlista 
        for (Patient patient : patientLista)
        {
        	//Hämta medicinlista för patient
        	tempArray = hamtaMedicinLista(patient.getNamn());
        	
        	//Kolla om patienten saknar medicin (arrayen är då tom). Om så, lägg till patientens namn endast
        	if (tempArray.isEmpty())
        	{
        		arrayAttReturnera.add(patient.getNamn() + " *" + " *" + " *");
        	}
        	
        	//Lägg till arrayen
        	arrayAttReturnera.addAll(tempArray); //Källa: https://www.geeksforgeeks.org/join-two-arraylists-in-java/
        }
        
        return arrayAttReturnera;
    }
    
    /**
    * Metod för att skapa en patient. Jag har här antagit att alla patienter har olika namn och kollar innan om patienten (namnet) finns sedan tidigare, om ja returnera falskt. 
    * @param String namn - patientens namn
    * @return boolean skapad Ja/Nej. Om ja - patienten skapades. Om Nej - patienten med det namnet finns sedan tidigare
    */
    public boolean skapaPatienter(String namn)
    {
    	//Kontrollera om finns sedan tidigare (om den gör det returneras position i kundlista, om ej -1)
        int finnsPatient;
        finnsPatient = finnsNamn(namn);
        
        //Om det gör det, returnera false
        if (finnsPatient >= 0)
        {
            return false;
        }
        
        //Om patienten ej existerar sedan tidigare, skapa och lägg till i listan. 
        Patient patient = new Patient(namn);
        patientLista.add(patient);

        return true;
    	
    }
    
    //---------------------------------------Metoder för medicin -----------------------------------------------
    /**
    * Metod för att lägga till en medicin till en patient. 
    * @param String namn - patientens namn
    * @param String medicinNamn - vilken medicin
    * @param int mangd - mängden av medicin som ska tas
    * @param long tid - vilken tid medicinen ska tas
    * @param int antal - hur många gånger medicinen ska tas
    * @param LocalTime tidNu - utgår från vad klockan inom programmet är nu
    * @return boolean skapad Ja/Nej. Om ja - patienten skapades. Om Nej - patienten med det namnet finns sedan tidigare
    */
    public boolean skapaMedicin(String namn, String medicinNamn, int mangd, long tid, int antal, LocalTime tidNu)
    {
    	//Kontrollera om finns sedan tidigare (om den gör det returneras position i kundlista, om ej -1)
        int patientPos;
        patientPos = finnsNamn(namn);
        boolean kontroll;
        
        //Om det gör det, returnera false
        if (patientPos < 0)
        {
            return false;
        }
        
        //Om patienten ej existerar sedan tidigare, skapa och lägg till i medicinen. 
        kontroll = patientLista.get(patientPos).skapaMedicin(medicinNamn, mangd, tid, antal, tidNu);

        return kontroll; //Är false om patienten har medicinen sedan tidigare och true om den skapades
    	
    }
    
    /**
    * Metod för att lägga hämta en patients mediciner 
    * @param String namn - patientens namn
    * @return ArrayList<String> - Lista med patient namn + medicin
    */
    public ArrayList<String> hamtaMedicinLista(String namn)
    {
    	//Variabler
    	int patientPos;
    	ArrayList<String> arrayAttReturnera = new ArrayList<String>();
    	
    	//Hitta patienten
        patientPos = finnsNamn(namn);
        
        
        //Om det gör det, returnera false
        if (patientPos < 0)
        {
        	return arrayAttReturnera; //om kund ej finns returnera tom array
        }
        
        //Om patienten finns hämta listan
        arrayAttReturnera = patientLista.get(patientPos).hamtaMedicinLista();

        return arrayAttReturnera;
    }
    
    /**
    * Metod för att ta medicin
    * @param String namn - patientens namn
    * @param String medicinNamn - medicinen som ska tas namn
    * @param LocalTime tidNu - vad är klockan
    * @return boolean - medicin tagen ja/nej
    */
    public boolean taMedicin(String namn, String medicinNamn, LocalTime tidNu)
    {
    	//Variabler
    	int patientPos;
    	
    	//Hitta patienten
        patientPos = finnsNamn(namn);
        
        //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println("patients position i listan? : " + patientPos); 
        
        
        //Om det gör det, returnera false
        if (patientPos < 0)
        {
        	return false; //om kund ej finns returnera tom array
        }
        
        //Om patienten finns försök ta medicinen
        return patientLista.get(patientPos).taMedicin(medicinNamn, tidNu);

        //return arrayAttReturnera;
    }
    
    /**
    * Metod för att hämta en patients loggLista över tagna mediciner
    * @param String namn - patientens namn
    * @return ArrayList<String> - Lista med patients logg
    */
    public ArrayList<String> hamtaLogg(String namn)
    {
        //Variabler
        int patientPos;
        ArrayList<String> arrayAttReturnera = new ArrayList<String>();
        
        //Hitta patienten
        patientPos = finnsNamn(namn);
         
        //Om det gör det, returnera false
        if (patientPos < 0)
        {
            return arrayAttReturnera; //om kund ej finns returnera tom array
        }
        
        //Om patienten finns hämta dennes loggLista
        arrayAttReturnera = patientLista.get(patientPos).getLoggList();
        
        return arrayAttReturnera;
    }


	//-----------------------------------------Privata Metoder -------------------------------------------------    
	
	/**
	* Privat metod för att kolla om patienten med samma namn finns sedan tidigare 
	* @param String namn, patientens namn
	* @return int, om patienten finns returnera position i lista, om ej returnera -1
	*/
	private int finnsNamn(String namn)
	{
	    //Loopa igenom patientlista
	    for (Patient patient : patientLista)
	    {
	        if (namn.equals(patient.getNamn()))
	        {
	            return patientLista.indexOf(patient); //Källa: https://www.tutorialspoint.com/get-the-location-of-an-element-in-java-arraylist
	        }
	    }
	    
	    //Om loopen ej hittar 
	    return -1;
	}
	
	/**
	* Privat metod för att sortera kundlista utifrån vilken tid medicinen ska tas
	* @param ArrayList<String> kundLista - osorterad lista
	* @return ArrayList<String> - sorterad lista
	*/
	//private ArrayList<String> orteraListaPaTid(ArrayList<String> kundLista)
	{
	    //Loopa igenom patientlista
	    //for (Patient patient : patientLista)
	    {
	        //if (namn.equals(patient.getNamn()))
	        {
	            //return patientLista.indexOf(patient); //Källa: https://www.tutorialspoint.com/get-the-location-of-an-element-in-java-arraylist
	        }
	    }
	    
	    //Om loopen ej hittar 
	    //return -1;
	}
}
