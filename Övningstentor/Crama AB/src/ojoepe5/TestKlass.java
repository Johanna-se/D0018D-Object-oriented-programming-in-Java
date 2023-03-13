/**
* Klass för att testa olika delar av programmet
* @author Johanna Petersson, ojoepe-5
*/
package ojoepe5;

import java.util.ArrayList;

public class TestKlass 
{
	public static void main(String[]args)
    {
		//Skapa patientregister
		PatientRegister patientRegister  = new PatientRegister();
		Tid klockan = new Tid();
		
		//Skapa variabler
		ArrayList<String> patientLista = new ArrayList<String>();
		ArrayList<String> patientOMedicinLista = new ArrayList<String>();
		boolean patientSkapad = false;
		boolean medicinSkapad = false;
		ArrayList<String> medicinLista = new ArrayList<String>();
		FilhanteringMedGUI filHantering = new FilhanteringMedGUI(patientRegister);
		
		//Prova att skapa patient, printa svar
		patientSkapad = patientRegister.skapaPatienter("Anna Andersson");
		System.out.println("Skapa Anna Andersson (true): " + patientSkapad); 
		
		//Prova att skapa samma
		patientSkapad = patientRegister.skapaPatienter("Anna Andersson");
		System.out.println("Skapa Anna Andersson igen (false): " + patientSkapad); 
		
		
		
		
		//Nytt TEST
		System.out.println("");
	
		//Lägg till fler patienter
		patientSkapad = patientRegister.skapaPatienter("Bettan Bertilsson");
		System.out.println("Skapa Bettan Bertilsson (true): " + patientSkapad);
		patientSkapad = patientRegister.skapaPatienter("Cecilia Cerdersson");
		System.out.println("Skapa Cecilia Cerdersson (true): " + patientSkapad); 
		
		//Hämta alla patienter och printa
		patientLista = patientRegister.hamtaAllaPatienter();
		
		for (String patient: patientLista)
		{
			System.out.println("Printa från lista: " + patient); 
		}
		
		
		
		
		//Nytt TEST
		System.out.println("");
		
		//Testa tidsklassen
		System.out.println("Klockan är (12.00): " + klockan.getTid());
		
		//Lägg till 5 min
		klockan.laggTillFemMin();
		System.out.println("Klockan är (12.05): " + klockan.getTid());
		
		
		
		
		//Nytt TEST
		System.out.println("");
		
		//Skapa en medicin för patient Anna Andersson
		medicinSkapad = patientRegister.skapaMedicin("Anna Andersson", "Alvedon", 200, 10L, 3, klockan.getTid());
		System.out.println("Skapa medicin åt  Anna Andersson (true): " + medicinSkapad); 
		
		//Hämta medicinlista och printa
		medicinLista = patientRegister.hamtaMedicinLista("Anna Andersson");
		System.out.println("Printa medicinlista för Anna Andersson, bör vara Alvedon 200 ml:");
		for (String string : medicinLista)
		{
			System.out.print(string + " ");
		}
		
		//Nytt TEST
		System.out.println("");
		//Skapa en medicin för patient Anna Andersson
		medicinSkapad = patientRegister.skapaMedicin("Anna Andersson", "Alvedon", 500, 10L, 3, klockan.getTid());
		System.out.println("Skapa medicin åt  Anna Andersson igen (false): " + medicinSkapad); 
		
		//Nytt TEST
		System.out.println("");
		
		//Testa tidsklassen
		System.out.println("Klockan är (12.05): " + klockan.getTid());
		
		//Skapa en till  medicin för patient Anna Andersson, printa listan igen
		klockan.laggTillFemMin();
		medicinSkapad = patientRegister.skapaMedicin("Anna Andersson", "Bamyl", 500, 20L, 1, klockan.getTid());
		//Hämta medicinlista och printa
		medicinLista = patientRegister.hamtaMedicinLista("Anna Andersson");
		System.out.println("Printa medicinlista för Anna Andersson, bör ha två rader:");
		for (String string : medicinLista)
		{
			System.out.println(string);
		}
		
		//Testa tidsklassen
		System.out.println("Klockan är (12.10): " + klockan.getTid());
		
		
		
		//Nytt TEST
		System.out.println("");
		
		//Hämta lista över alla patienter samt deras mediciner
		patientOMedicinLista = patientRegister.hamtaAllaPatienterOchMedicin();
		
		//Printa listan
		System.out.println("Printa patientOMedicinlista :");
		for (String string : patientOMedicinLista)
		{
			System.out.println(string);
		}
		
		
		
		//Nytt TEST
		System.out.println("");
		
		//Lägg till medicin för övriga två patienter och printa listan igen
		patientRegister.skapaMedicin("Bettan Bertilsson", "Hallom", 500, 60L, 4, klockan.getTid());
		patientRegister.skapaMedicin("Cecilia Cerdersson", "Alvedon", 500, 80L, 2, klockan.getTid());
		patientOMedicinLista = patientRegister.hamtaAllaPatienterOchMedicin();
		System.out.println("Printa patientOMedicinlista :");
		for (String string : patientOMedicinLista)
		{
			System.out.println(string);
		}
		
		//Testa filhantering
		filHantering.sparaRegister();

		
		

    }
}
