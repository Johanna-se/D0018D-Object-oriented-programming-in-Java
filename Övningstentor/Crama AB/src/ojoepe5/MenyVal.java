/**
* Klass för att testa olika delar av programmet genom ett menyval
* @author Johanna Petersson, ojoepe-5
*/
package ojoepe5;

import java.util.ArrayList;
import java.util.Scanner; 

public class MenyVal
{
    private static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[]args)
    {
        //Variabler
        int val;
        ArrayList<String> patientLista = new ArrayList<String>();
        ArrayList<String> patientOMedicinLista = new ArrayList<String>();
        boolean patientSkapad = false;
        boolean medicinSkapad = false;
        ArrayList<String> medicinLista = new ArrayList<String>();
        String namnPatient;
        String medicinNamn;
        int mangdMedicin;
        long tidsIntervall;
        int antalGanger;
        
        //Skapa patientregister
        PatientRegister patientRegister  = new PatientRegister();
        Tid klockan = new Tid();
        
      //Welcome user 
        System.out.printf("_________________________________________%n"); 
        System.out.printf("%nDemonstration av tenta%n");
        System.out.printf("_________________________________________%n");

        do
        {
            val = meny ();
            switch (val)
            {
                case -1:
                    System.out.printf("%nDemonstrationen avslutas");
                    break;
                case 1:
                    System.out.println("%n1. Skapa patient.");
                    
                    //Prova att skapa patient, printa svar
                    System.out.println("Namn på Patient: ");
                    namnPatient = userInput.nextLine(); 
                    patientSkapad = patientRegister.skapaPatienter(namnPatient);
                    System.out.println("Patient skapad?: " + patientSkapad); 
                    break;
                case 2:
                    System.out.println("2. Printa patient och medicinlista: ");
                    break;
                case 3:
                    System.out.println("3. Printa vad klockan är: ");
                    System.out.println("Klockan är : " + klockan.getTid());
                    break;
                case 4:
                    System.out.println("4. Lägg till 5 min: ");
                    klockan.laggTillFemMin();
                    System.out.println("Klockan är : " + klockan.getTid());
                    break;
                case 5:
                    System.out.printf("5. Lägg till medicin: ");
                    
                    //Patients namn: 
                    System.out.println("Namn på Patient: ");
                    namnPatient = userInput.nextLine(); 
                    
                    //Vilken medicin?
                    System.out.println("Vilken medicin? ");
                    medicinNamn = userInput.nextLine(); 
                    
                    //Mängd?
                    mangdMedicin = inputIntMinMax("Vilken mängd? ", "Mängden måste vara minst 0.", 0, 10000000); 
                    
                    //Vilken tidsintervall (anges i minuter)
                    System.out.println("Med vilken tidsintervall ska medicinen tas? anges i minuter ");
                    tidsIntervall = inputLongMinMax("Med vilken tidsintervall ska medicinen tas? anges i minuter " , "För enkel testning har jag valt min 0 min upp till 200 min. ", 0L, 200L);
                    
                    //Hur många gånger?
                    antalGanger = inputIntMinMax("Hur många gånger ska medicinen tas? ", "Kan inte vara negativ eller mer än 100", 0, 100); ; 
                    
                    medicinSkapad = patientRegister.skapaMedicin(namnPatient, medicinNamn, mangdMedicin, tidsIntervall, antalGanger, klockan.getTid());
                    System.out.println("Skapades medicinen?: " + medicinSkapad); 
                    break;
                case 6:
                    System.out.println("6. ...");
                    break;
                default:
                    System.out.println("Ej giltigt val, välj en annan siffra ");
                    
            }
        }while(val != -1);
    }
    
    /**
    * Metod för att printa en meny
    * @return val - int
    */ 
    public static int meny ()
    {
        //create variables
        int val = 0;

        //Print menu
        System.out.printf("%n1. Skapa patient.");
        System.out.printf("%n2. Printa patient och medicinlista.");
        System.out.printf("%n3. Printa vad klockan är. ");
        System.out.printf("%n4. Lägg till 5 min. ");
        System.out.printf("%n5. Lägg till medicin: ");
        System.out.printf("%n6. ...");
        System.out.printf("%nq. ...");
            
        //user input
        System.out.printf("%nDitt val: ");
        val  = inputInt();
        userInput.nextLine();

        return val ;
    }
    
    /**
    * Metod för att få en int från användaren
    * @return svar - int
    */  
    public static int inputInt()
    {
        //skapa variabler
        int svar = -2;
        
        //loop genom data
        while (svar == -2)
        {    
            //Om användaren anger en int
            if (userInput.hasNextInt())
            {
                svar = userInput.nextInt(); 
                svar = Math.abs(svar);
            }
            
            //Om användaren skriver in q (för att avsluta)
            else if (userInput.next().equalsIgnoreCase("q"))
            {
                svar = -1;
            }
            
            // Ej giltigt värde
            else
            {
                System.out.printf("Ej giltigt svar.%n");
                svar = -2;
            }
        }
        return svar;   
    }
    
    /**
    * Metod för att få en int från användaren med ett min eller maxvärde
    * @return svar - int
    */  
    public static int inputIntMinMax(String text, String error, int min, int max)
    {
        //create variables
        int svar = min-1;

        System.out.printf(text);
        do
        {
            svar = inputInt();
            userInput.nextLine();

            if (svar < min | svar > max)
            {
                System.out.printf(error);
                svar = min-1;
            }
        } while (svar == min-1);
        
        return svar;
    }
    
    /**
    * Metod för att få en long från användaren med ett min eller maxvärde
    * @return svar - long
    */  
    public static long inputLongMinMax(String text, String error, long min, long max)
    {
        //create variables
        long svar = min-1;

        System.out.printf(text);
        do
        {
            svar = inputLong();
            userInput.nextLine();

            if (svar < min | svar > max)
            {
                System.out.printf(error);
                svar = min-1;
            }
        } while (svar == min-1);
        
        return svar;
    }
    
    /**
    * Metod för att få en long från användaren
    * @return svar - long
    */  
    public static long inputLong()
    {
        //skapa variabler
        long svar = -2L;
        
        //loop genom data
        while (svar == -2L)
        {    
            //Om användaren anger en int
            if (userInput.hasNextLong())
            {
                svar = userInput.nextLong(); 
                svar = Math.abs(svar);
            }
            
            //Om användaren skriver in q (för att avsluta)
            else if (userInput.next().equalsIgnoreCase("q"))
            {
                svar = -1;
            }
            
            // Ej giltigt värde
            else
            {
                System.out.printf("Ej giltigt svar.%n");
                svar = -2;
            }
        }
        return svar;   
    }
}
