package ovningsUppgifter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame 
{
	private JTextField display;
	
	//Klass som definerar knapplyssnare
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// hämta texten på den knapp som genererade händelsen
			String buttonText = e.getActionCommand();
			if (buttonText.equals("C"))
			{
				// rensa displayen
				display.setText("");
			}
			else if (buttonText.equals("="))
			{
				// göra beräkning
				calculateAndShow();
			}
			else
			{
				// fylla på displayen med knapptexten
				addToDisplay(buttonText);
			}
		}
	}
	
	// konstruktor
	public Calculator()
	{
		//A border layout lays out a container, arranging and resizing its components to fit in five regions: north, south, east, west, and center.
		setLayout(new BorderLayout());
		setSize(400, 400);
		setTitle("Calculator");
		setLocation(200,200); // placerar fönstret 100 pixlar sidled resp höjdled från övre högra hörnet
		buildNrButtonPanel();
		buildOpButtonPanel();
		buildDisplayPanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Bygg knapparna för siffror
	private void buildNrButtonPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,3,5,5)); // 4 rader, 3 kolumner, 5 pixlar mellanrum sedled, 5 pixlar mellanrum i höjdled
		
		JButton button = null;
		ButtonListener buttonlist = new ButtonListener(); // skapar ett lyssnarobjekt
		
		//Loopar igenom och ger nummerknapparna namn 1-9
		for (int i = 1; i <= 9; i++)
		{
			button = new JButton("" + i);
			button.addActionListener(buttonlist);
			panel.add(button);
		}
		
		//En tom yta brevid 0an
		JLabel empty = new JLabel();
		panel.add(empty);
		
		//Lägg till 0an
		button = new JButton("0");
		button.addActionListener(buttonlist);
		panel.add(button);
		
		//Lägger knapparna i mitten av ruttan
		add(panel, BorderLayout.CENTER);
	}
	
	//Bygg knapparna för beräkning
	private void buildOpButtonPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,1,5,5)); //4 rader och 1 kolumn
		
		ButtonListener buttonlist = new ButtonListener(); // skapar ett lyssnarobjekt
		
		//Knappar 
		JButton button = new JButton("C");
		button.addActionListener(buttonlist);
		panel.add(button);
		
		button = new JButton("+");
		button.addActionListener(buttonlist);
		panel.add(button);
		
		button = new JButton("-");
		button.addActionListener(buttonlist);
		panel.add(button);
		
		button = new JButton("=");
		button.addActionListener(buttonlist);
		panel.add(button);
		
		//Lägg knapparna till höger om sifferknapparna
		add(panel, BorderLayout.EAST);
	}
	
	//Klass för att bygga displayen
	private void buildDisplayPanel()
	{
		JLabel label = new JLabel("Calculator ver 9.4", JLabel.CENTER); // centrerar texten på etiketten
		display = new JTextField(20);
		display.setHorizontalAlignment(JTextField.RIGHT);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1,5,5));
		panel.add(label);
		panel.add(display);
		
		//Placerar den på övgre delen av rutan
		add(panel, BorderLayout.NORTH);
	}
	
	//Visa beräkning
	private void calculateAndShow()
	{
		String displayText = display.getText(); // tex "23+9" eller "34-7"
		int pos = displayText.indexOf("+"); // ger positionen för +-tecknet
		
		if (pos > -1) // det fanns ett + - tecken
		{
			String firstStr = displayText.substring(0,pos); // tex "23" 
			String secStr = displayText.substring(pos+1); // tex "9"
			
			int result = Integer.parseInt(firstStr) + Integer.parseInt(secStr);
			display.setText("" + result);
		}
		else // subtraktion
		{
			pos = displayText.indexOf("-");
			
			String firstStr = displayText.substring(0,pos); // tex "23"
			String secStr = displayText.substring(pos+1);  // tex "9"
			
			int result = Integer.parseInt(firstStr) - Integer.parseInt(secStr);
			
			display.setText("" + result);
		}
	}
	
	private void addToDisplay(String buttonText)
	{
		display.setText(display.getText() + buttonText);
	}
	
	public static void main(String[] args)
	{
		Calculator calc = new Calculator();
		calc.setVisible(true);
	}
}
