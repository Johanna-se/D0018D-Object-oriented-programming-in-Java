/**
* Klass för att testa olika delar av programmet
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

public class testKlass 
{
	public static void main(String[]args)
    {
		//Variabler
		FrageBank frageBank = new FrageBank();
		SpelaTrivia spelaTrivia = new SpelaTrivia(frageBank);
		
		boolean spelareSkapad = false;
		
		//Prova att skapa en spelare
		spelareSkapad = spelaTrivia.skapaSpelare("Anna");
		System.out.println("Skapa Anna  (true): " + spelareSkapad); 
		
		//Prova att skapa en spelare igen
		spelareSkapad = spelaTrivia.skapaSpelare("Anna");
		System.out.println("Skapa Anna  (false): " + spelareSkapad); 
    }
	
}
