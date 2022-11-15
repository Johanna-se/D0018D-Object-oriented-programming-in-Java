import javax.swing.JFrame; 
public class EttForstaFonster 
{
	public static void main(String[] args) 
	{ 
		final int FRAME_WIDTH  = 400; 
	    final int FRAME_HEIGHT = 500; 
	     
	    JFrame frame = new JFrame();                          
	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);             
	    frame.setTitle("Mitt första GUI!");                 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    frame.setVisible(true);                               
	  }

}
