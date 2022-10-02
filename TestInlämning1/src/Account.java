
public class Account
{
  //variables
    private int kontonummer;
    private double saldo;
    private double ranta;
    private String kontoTyp;
    
    // Konstruktorer
    public Account(int nyKontoNr, double nySaldo, double nyRanta, String nyKontoTyp)
    {
        kontonummer = nyKontoNr;
        saldo = nySaldo;
        ranta = nyRanta;
        kontoTyp = nyKontoTyp;
    }
    public Account()
    {
        kontonummer = 0000;
        saldo = 0;
        ranta = 0;
        kontoTyp = "Ej angiven";
    }
    // ------- Set-metoder ----------
    
    // ------- Get-metoder ----------
    
    public int getKontoNummer()
    {
        return kontonummer;
    }
    
    public double getSaldo()
    {
        return saldo;
    }
    
    public double getRanta()
    {
        return ranta;
    }
    
    public String getKontoTyp()
    {
        return kontoTyp;
    }

    
    ////Göra transaktioner
    


}
