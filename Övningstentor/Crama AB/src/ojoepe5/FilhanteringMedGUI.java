/**
 * Klass för att skapa en filhanterare med eget GUI.
 * 
 * @author Johanna Petersson, ojoepe-5
 */

package ojoepe5;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FilhanteringMedGUI 
{
	//Komponenter för att spara/ladda fil Källa:https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
    private JFileChooser hanteraFil;
    private FileNameExtensionFilter filterText;
    private FileNameExtensionFilter filterBank;
	
	// Konstruktorer
    public FilhanteringMedGUI ()
    {
        //Skapa en bank
        bankLogic = bank;
        frame = gui;
        
        //Skapa filhanteraren 
        //Källor:
        //https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
        //https://stackoverflow.com/questions/13423950/setting-the-default-jfilechooser-directory-to-a-relative-path-from-jar-location
        //https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
        hanteraFil = new JFileChooser();
        hanteraFil.setCurrentDirectory(new File("ojoepe5_files" + File.separator  + ".")); //För att hamna i korrekt mapp
        filterText = new FileNameExtensionFilter(".txt filer", "txt"); //Används när användren vill ladda konton
        filterBank = new FileNameExtensionFilter(".dat, .ser, .tmp filer","dat", "ser", "tmp");
    }

}
