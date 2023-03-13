/**
 * Klass för att skapa en filhanterare med eget GUI.
 * 
 * @author Johanna Petersson, ojoepe-5
 */

package ojoepe5;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FilhanteringMedGUI extends JFrame 
{
	//Komponenter för att spara/ladda fil Källa:https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
    private JFileChooser hanteraFil;
    private FileNameExtensionFilter filter;
    
    //Skapa patientregister
    private PatientRegister patientRegister;
	
	// Konstruktorer
    public FilhanteringMedGUI (PatientRegister register)
    {
        //Skapa en bank
    	patientRegister = register;
        
        //Skapa filhanteraren 
        //Källor:
        //https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
        //https://stackoverflow.com/questions/13423950/setting-the-default-jfilechooser-directory-to-a-relative-path-from-jar-location
        //https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
        hanteraFil = new JFileChooser();
        hanteraFil.setCurrentDirectory(new File("ojoepe5_files" + File.separator  + ".")); //För att hamna i korrekt mapp
        filter = new FileNameExtensionFilter(".dat, .ser, .tmp filer","dat", "ser", "tmp");
    }
    
    /**
    * Metod för att spara data i ett register till en fil samt hanterar användarens val.
    * @return void
    */
    public void sparaRegister()
    {
        //Sätt filter
        hanteraFil.setFileFilter(filter);
        
        //Variabler 
        int anvandarVal;
        int returVarde = hanteraFil.showSaveDialog(frame);  
        File fil;

        if (returVarde == JFileChooser.APPROVE_OPTION)
        {
            fil = hanteraFil.getSelectedFile();
            
            //Källa: https://stackoverflow.com/questions/13738625/jfilechooser-custom-file-name-create-new-file
            if (hanteraFil.getDialogType() == 1) //hanteraFil.getDialogType() == 1 == SAVE_DIALOG
            {
                if(fil.exists()) //Om filen finns sedan tidigare OBS: hanteraFil.getDialogType() == 1 == SAVE_DIALOG
                {
                    //Varna användaren att filen finns sedan tidigare och kommer skrivas över, ge val och handla efter detta
                    anvandarVal = JOptionPane.showConfirmDialog(frame, "Filen du valt finns redan, vill du skriva över den?", "Befintlig fil", JOptionPane.YES_NO_OPTION);
                    
                    switch(anvandarVal)
                    {
                        case JOptionPane.YES_OPTION:
                            sparaData(fil);
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                        case JOptionPane.CLOSED_OPTION:
                            break;
                    }
                }
                else
                {
                    hanteraFil.approveSelection(); //Skapar filen
                    sparaData(fil);
                }
            } 
        }
    }
    
    /**
    * Metod för att ladda data för ett register in i programmet från en fil samt hanterar användarens val.
    * @return void
    */
    public BankLogic laddaRegister()
    {
        //Sätt filter
        hanteraFil.setFileFilter(filter);
        
        //Variabler 
        int anvandarVal;
        int returVarde = hanteraFil.showOpenDialog(frame);
        File fil;
        
        if (returVarde == JFileChooser.APPROVE_OPTION)
        {
            fil = hanteraFil.getSelectedFile();
            
            //Varana användaren att befintliga kunder kommer att skrivas över
            anvandarVal = JOptionPane.showConfirmDialog(frame, "Du kommer ladda in nya kunder till banken från fil, eventuella icke-sparade kunder kommer att försvinna, vill du fortsätta?", "Ladda kunder från fil", JOptionPane.YES_NO_OPTION);
                    
            switch(anvandarVal)
            {
                case JOptionPane.YES_OPTION:
                    try
                    {
                        ObjectInputStream infil = new ObjectInputStream(new FileInputStream(fil));
                        bankLogic = (BankLogic) infil.readObject(); //Läs in banken från fil
                        infil.close();
                        JOptionPane.showMessageDialog(null, "Bankdata laddades"); //Meddela användaren att banken laddades
                    }
                     catch (EOFException exc)
                     {
                        //Slut på inläsningen, 
                     }
                     catch(ClassNotFoundException ce)
                     {
                         ce.printStackTrace(System.out);
                         JOptionPane.showMessageDialog(null, "Kunde inte hitta klassen");    
                     }
                     catch(IOException e)
                     {
                         e.printStackTrace(System.out);
                         JOptionPane.showMessageDialog(null, "Det gick inte att läsa från filen");
                      }
                      break;
                case JOptionPane.NO_OPTION:
                     break;
                case JOptionPane.CLOSED_OPTION:
                     break;
            }
        }
        return bankLogic;
    }

}
