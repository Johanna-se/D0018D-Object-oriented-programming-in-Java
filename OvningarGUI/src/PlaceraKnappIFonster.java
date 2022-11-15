import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JButton;

public class PlaceraKnappIFonster 
{
	public static void main(String[] args) 
	{
		final int FRAME_WIDTH  = 400; 
	    final int FRAME_HEIGHT = 400; 
	    
	    JFrame frame = new JFrame(); 
	    //Skapa knappar
	    JButton buttonOne = new JButton("Röd");
	    JButton buttonTwo = new JButton("Blå");
	    JButton buttonThree = new JButton("Grön");
	    JLabel  label  = new JLabel("Placera knappar i ett fönster ");
	    
	    //Skapa JPanel
	    JPanel panel = new JPanel(); 
	    
	    //Lägg till komponenter till panelen 
	    panel.add(buttonOne);
	    panel.add(buttonTwo);
	    panel.add(buttonThree);
	    panel.add(label);
	    
	    //Lägg till panelen till fönstret 
	    frame.add(panel); 
	    
	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);             
	    frame.setTitle("Mitt andra GUI!");                 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    frame.setVisible(true);
	}

}
