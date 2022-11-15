import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

public class Ovning5 extends JFrame implements ActionListener
{
	 private static final int FRAME_WIDTH  = 300; 
	 private static final int FRAME_HEIGHT = 200; 
	 
	 //Knappar
	 private JButton buttonOne = new JButton("Surfa"); 
	 private JButton buttonTwo = new JButton("Måla"); 
	 private JButton buttonThree = new JButton("Låda");
	 
	 //Bilder
	 private ImageIcon surfImage = new ImageIcon("image/surfing.gif");
	 private JLabel surfLabel  = new JLabel(""); 
	 private ImageIcon paintImage = new ImageIcon("image/painting.gif");
	 private JLabel paintLabel  = new JLabel(""); 
	 private ImageIcon boxImage = new ImageIcon("image/box.gif");
	 private JLabel boxLabel  = new JLabel(""); 
	 
	 public Ovning5() 
	 { 
		 createComponents(); 
		 pack();
	 }
	 
	private void createComponents() 
	{ 
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setLocationRelativeTo(null);
		
	    //Lägg till knappar
		buttonOne.addActionListener(this); 
	    panel.add(buttonOne);
	    buttonTwo.addActionListener(this);
	    panel.add(buttonTwo);
	    buttonThree.addActionListener(this);
	    panel.add(buttonThree);
	    
	    //Lägg till Surfbilden
	    surfLabel.setIcon(surfImage); 
	    surfLabel.setVisible(false); //Gör den osynlig
	    panel.add(surfLabel);
	    
	    //Lägg till Paintbilden
	    paintLabel.setIcon(paintImage); 
	    paintLabel.setVisible(false); //Gör den osynlig
	    panel.add(paintLabel);
	    
	    //Lägg till boxbilden
	    boxLabel.setIcon(boxImage); 
	    boxLabel.setVisible(false); //Gör den osynlig
	    panel.add(boxLabel);
	    
	    //Lägg till panelen till fönstret 
		this.add(panel); 
	 }
	
	//Vad ska hända när programmet upptäcker lyssnaren
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == buttonOne)
		{
			surfLabel.setVisible(true); //Gör bild synlig
		}
		
		if(e.getSource() == buttonTwo)
		{
			paintLabel.setVisible(true); 
		}
		
		if(e.getSource() == buttonThree)
		{
			boxLabel.setVisible(true); 
		}
	}
	
	public static void main(String[] args) 
	{
		JFrame frame = new Ovning5();  
        frame.setTitle("Mitt fjärde GUI!");   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);     
    } 

}
