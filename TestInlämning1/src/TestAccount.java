
public class TestAccount
{
    public static void main(String[] args)
       {
            //variables
            int kontonummer = 1111;
            double saldo = 100.2;
            double ranta = 0.05;
            String kontoTyp = "Sparkonto";
            
            //test att skapa ett konto
            Account testKonto = new Account(kontonummer, saldo, ranta, kontoTyp);
            
        }
}
