package Ovning1Modul1;
import java.util.Scanner;
import java.util.ArrayList;

public class TestMovie
{
    public static void main(String[] args)
    {
    Scanner keyboard = new Scanner(System.in);
    int choice = 0;
    //Movie[] movies = new Movie[20];
    //int nrOfMovies = 0;
    
    ArrayList<Movie> movies = new ArrayList<Movie>();
    
    do
    {
        menu();
        choice = keyboard.nextInt();
        keyboard.nextLine();
        
        switch(choice)
        {
         // Skapar ett nytt filmobjekt
            case 1:
                System.out.print("Titel: ");
                String aTitle = keyboard.nextLine();
        
                System.out.print("Speltid: ");
                int aLength = keyboard.nextInt();
                keyboard.nextLine(); //Rensar bort returtecken ut inmatningsbufferten
             
                System.out.print("Kategori: ");
                String aCategory = keyboard.nextLine();
        
                System.out.print("Recension: ");
                String aReview = keyboard.nextLine();
                      
                Movie aMovie = new Movie(aTitle, aLength, aCategory, aReview);
                       
                //movies[nrOfMovies] = aMovie;
                //nrOfMovies++;
                      
                movies.add(aMovie);
                        
                break;
        
            // Skriv ut alla filmobjekt
            case 2:
                /*for(int i = 0; i < nrOfMovies; i++)
                {
                     System.out.println("Film nr " + i + ":\n" + movies[i]+ "\n");
                }*/
                for(int i = 0; i < movies.size(); i++)
                {
                    System.out.println("Film nr " + i + ":\n" + movies.get(i) + "\n");
                }
                
                break;
                      
            // Ta bort ett filmobjekt
            case 3:
                System.out.print("Vilken film vill Du ta bort? ");
                int movieNr = keyboard.nextInt();
                keyboard.nextLine();
        
      
                /*for(int i = movieNr; i < nrOfMovies-1; i++)
                {
                     movies[i] = movies[i+1];
                }
                nrOfMovies--;*/
                if(movies.size() > movieNr)
                {
                    movies.remove(movieNr);
                }
                break;
            }
        }while(choice!=4);
    }
    public static void menu()
    {
        System.out.println("\n## MENU ##\n");
        System.out.println("1. Lägg till film");
        System.out.println("2. Skriv ut alla filmer");
        System.out.println("3. Ta bort film");
        System.out.println("4. Avsluta");
        System.out.print("Ditt val: ");
    }
}
