import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

public class KopplaLyssnareTillKnapp extends JFrame implements ActionListener
{
	 private static final int FRAME_WIDTH  = 400; 
	 private static final int FRAME_HEIGHT = 400; 
	 
	 private JButton buttonOne = new JButton("Röd!"); 
	 private JButton buttonTwo = new JButton("Blå!"); 
	 private JButton buttonThree = new JButton("Grön!"); 
	 private JLabel  label  = new JLabel("Placera knappar i ett fönster"); 
	 
	 public KopplaLyssnareTillKnapp() 
	 { 
		 createComponents(); 
		 setSize(FRAME_WIDTH, FRAME_HEIGHT);  
	 }
	 
	private void createComponents() 
	{ 
		JPanel panel = new JPanel();  
	    //Lägg till komponenter till panelen
		buttonOne.addActionListener(this); 
	    panel.add(buttonOne);
	    buttonTwo.addActionListener(this);
	    panel.add(buttonTwo);
	    buttonThree.addActionListener(this);
	    panel.add(buttonThree);
	    panel.add(label); 
	    
	    //Lägg till panelen till fönstret 
		this.add(panel); 
	 }
	
	//Vad ska hända när programmet upptäcker lyssnaren
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == buttonOne) 
	        System.out.println("Röd");
		
		if(e.getSource() == buttonTwo) 
	        System.out.println("Blå");
		
		if(e.getSource() == buttonThree) 
	        System.out.println("Grön");
	}
	 
	public static void main(String[] args) 
	{
		JFrame frame = new KopplaLyssnareTillKnapp();  
        frame.setTitle("Mitt andra GUI!");   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);     
    } 
}
