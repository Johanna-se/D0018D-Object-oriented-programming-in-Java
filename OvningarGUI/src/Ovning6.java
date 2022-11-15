import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;


public class Ovning6 extends JFrame implements ActionListener
{
	 private static final int FRAME_WIDTH  = 300; 
	 private static final int FRAME_HEIGHT = 300;
	 private static final int ROWS = 10; 
	 private static final int COLS = 20;
	 
	//Knappar
	 private JButton LaggTill = new JButton("Lägg till");
	 
	 //TextFält
	 private JLabel NamnLabel = new JLabel("Namn: "); 
	 private JLabel NrLabel = new JLabel("Telefonnummer: ");
	 private JTextArea textArea = new JTextArea(ROWS, COLS);
	 private JTextField NamnField = new JTextField(20);
	 private JTextField NrField = new JTextField(20);
	 
	 public Ovning6() 
	 { 
		 createComponents();
		 pack();

	 }
	 
	private void createComponents() 
	{ 
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setLocationRelativeTo(null);
		
		//Titled borders
		
		//TitledBorder title;
		//title = BorderFactory.createTitledBorder(NamnLabel);
		//jComp8.setBorder(title);
		

		//Lägg till textruta namn
		 panel.add(NamnLabel);
		 NamnField.addActionListener(this);
		 panel.add(NamnField);
		 
		//Lägg till textruta namn		 
		 panel.add(NrLabel);
		 NrField.addActionListener(this);
		 panel.add(NrField);
		 
		 //Lägg till knapp
		 LaggTill.addActionListener(this); 
		 panel.add(LaggTill);
		
		 //Lägg till inforuta
		 panel.add(textArea);
	    
	    //Lägg till panelen till fönstret 
		this.add(panel); 
	 }
	
	//Lyssnare
	public void actionPerformed(ActionEvent evt)
	{
		//SvarLabel.setText("Du skrev: " + SkrivField.getText()); 
	}
	
	public static void main(String[] args) 
	{
		JFrame frame = new Ovning6();  
        frame.setTitle("Adressbok");   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);     
    } 


}
