/**
* Klass för att testa olika delar av programmet genom ett menyval
* @author Johanna Petersson, ojoepe-5
*/
package ojoepe5;

import java.util.Scanner; 

public class MenyVal
{
    private static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[]args)
    {
        //Variabler
        int val;
        
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
                    System.out.printf("%n1. ...");
                    break;
                case 2:
                    System.out.printf("%n2. ...");
                    break;
                case 3:
                    System.out.printf("%n3. ...");
                    break;
                case 4:
                    System.out.printf("%n4. ...");
                    break;
                case 5:
                    System.out.printf("%n5. ...");
                    break;
                case 6:
                    System.out.printf("%n6. ...");
                    break;
                default:
                    System.out.printf("%nEj giltigt val, välj en annan siffra ");
                    
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
        System.out.printf("%n1. ...");
        System.out.printf("%n2. ...");
        System.out.printf("%n3. ...");
        System.out.printf("%n4. ...");
        System.out.printf("%n5....");
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
    * @return svar - int
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
