import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

public class TextrelateradeGUIKomp extends JFrame implements ActionListener
{
	 private static final int FRAME_WIDTH  = 300; 
	 private static final int FRAME_HEIGHT = 200; 
	 
	 private JLabel SkrivLabel = new JLabel("Skriv något tänkvärt: "); 
	 private JLabel SvarLabel = new JLabel(""); //Denna är osynlig tills den används av lyssnaren
	 private JTextField SkrivField = new JTextField(20);
	 
	 public TextrelateradeGUIKomp() 
	 { 
		 createComponents(); 
		 setSize(FRAME_WIDTH, FRAME_HEIGHT);  
	 }
	 
	private void createComponents() 
	{ 
		JPanel panel = new JPanel();
		
		//Lägg Skapa textruta
		 panel.add(SkrivLabel);
		 SkrivField.addActionListener(this);
		 panel.add(SkrivField);
		 panel.add(SvarLabel);
	    
	    //Lägg till panelen till fönstret 
		this.add(panel); 
	 }
	
	//Lyssnare
	public void actionPerformed(ActionEvent evt)
	{
		SvarLabel.setText("Du skrev: " + SkrivField.getText()); 
	}
	 

	public static void main(String[] args) 
	{
		JFrame frame = new TextrelateradeGUIKomp();  
        frame.setTitle("Mitt tredje GUI!");   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);   
	} 
}
