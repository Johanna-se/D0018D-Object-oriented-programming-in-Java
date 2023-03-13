package ojoepe5;

import java.util.ArrayList;

public class FrageBank 
{
	//Variabler
    private ArrayList<Kategori> kategoriLista;
    
  //konstruktor
    public FrageBank ()
    {
    	kategoriLista = new ArrayList<Kategori>();
    }
    
    //--------------------------------Metoder för IO--------------------------------------------
    
    //-------------------------------Get metoder-----------------------------------
    public int getKategoriListaStorlek()
    {
        return kategoriLista.size();
    }
    
    //-------------------------------Publika metoder----------------------------------- 
    
}
