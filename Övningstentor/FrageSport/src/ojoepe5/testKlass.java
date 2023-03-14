/**
* Klass för att testa olika delar av programmet
* @author Johanna Petersson, ojoepe-5
*/

package ojoepe5;

import java.util.ArrayList;

public class testKlass 
{
	public static void main(String[]args)
    {
		//Variabler
		FrageBank frageBank = new FrageBank();
		SpelaTrivia spelaTrivia = new SpelaTrivia(frageBank);
		
		boolean spelareSkapad = false;
		boolean kategoriSkapad = false;
		boolean kategoriBorttagen = false;
		boolean fragaSkapad = false;
		boolean fragaBorttagen = false;
		boolean fragaAndrad = false;
		
		ArrayList<String> kategoriLista = new ArrayList<String>();
		ArrayList<String> fragorLista = new ArrayList<String>();
		
		//Prova att skapa en spelare
		spelareSkapad = spelaTrivia.skapaSpelare("Anna");
		System.out.println("Skapa spelare (true): " + spelareSkapad); 
		
		//Prova att skapa en spelare igen
		spelareSkapad = spelaTrivia.skapaSpelare("Anna");
		System.out.println("Skapa spelare Anna igen (false): " + spelareSkapad); 
		
		//Prova att en kategori
		kategoriSkapad = frageBank.skapaKategori("Länder");
		System.out.println("Skapa kategori Länder(true): " + kategoriSkapad); 
		kategoriSkapad = frageBank.skapaKategori("Länder");
		System.out.println("Skapa kategori Länder igen (false): " + kategoriSkapad); 
		kategoriSkapad = frageBank.skapaKategori("Städer");
		System.out.println("Skapa kategori Städer(true): " + kategoriSkapad); 
		kategoriSkapad = frageBank.skapaKategori("Djur");
		System.out.println("Skapa kategori Djur(true): " + kategoriSkapad); 
		
		//Skapa en fråga
		fragaSkapad = frageBank.skapaFraga("Vilket land kommer IKEA ifrån", "Sverige", "Länder");
		System.out.println("Skapa fråga (sant): " + fragaSkapad); 
		
		//Hämta lista med kategorier och printa
		kategoriLista = frageBank.getKategoriNamn();
		System.out.println("Lista med kategorier: "); 
		for (String string: kategoriLista)
		{
			System.out.println(string); 
		}
		
		//Plocka bort en kategori
		kategoriBorttagen = frageBank.taBortKategori("Städer");
		System.out.println("Kategori Städer borta(true): " + kategoriBorttagen);
		kategoriLista = frageBank.getKategoriNamn();
		System.out.println("Lista med kategorier: "); 
		for (String string: kategoriLista)
		{
			System.out.println(string); 
		}
		kategoriBorttagen = frageBank.taBortKategori("Städer");
		System.out.println("Kategori Städer borta igen(false): " + kategoriBorttagen);
		
		//Skapa en fråga
		fragaSkapad = frageBank.skapaFraga("Vilket land börjar på K och slutar på ina", "Kina", "Länder");
		System.out.println("Skapa fråga (sant): " + fragaSkapad);
		
		//Hämta lista med frågor för kategori länder
		fragorLista = frageBank.hamtaListaMedFragor("Länder");
		System.out.println("Lista med frågor från kategori Länder: "); 
		for (String string: fragorLista)
		{
			System.out.println(string); 
		}
		
		// Ta bort fråga
		fragaBorttagen = frageBank.taBortFraga(1002);
		System.out.println("Ta bort fråga med ID 1002: (true)" + fragaBorttagen); 
		fragaBorttagen = frageBank.taBortFraga(1002);
		System.out.println("Ta bort fråga med ID 1002 igen: (false)" + fragaBorttagen); 
		//Hämta lista med frågor för kategori länder
		fragorLista = frageBank.hamtaListaMedFragor("Länder");
		System.out.println("Lista med frågor från kategori Länder: "); 
		for (String string: fragorLista)
		{
			System.out.println(string); 
		}
		
		//Editera fråga
		fragaAndrad = frageBank.editeraFraga("Vilket land på F ligger granne med Sverige", "Finland", 1001);
		System.out.println("Editerat fråga 1001 (true)" + fragaAndrad); 
		
		//Skapa en fråga
		fragaSkapad = frageBank.skapaFraga("Vilket land börjar på K och slutar på ina", "Kina", "Länder");
		System.out.println("Skapa fråga (sant): " + fragaSkapad);
		
		//Hämta lista med frågor för kategori länder
		fragorLista = frageBank.hamtaListaMedFragor("Länder");
		System.out.println("Lista med frågor från kategori Länder: "); 
		for (String string: fragorLista)
		{
			System.out.println(string); 
		}
    }
	
}
