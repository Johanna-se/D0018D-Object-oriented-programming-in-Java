package Ovning6;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI2 extends JFrame //implements ActionListener
{
	private Logic logic;
	private JList personList;
	private JTextField nameField;
	private JTextField phoneNrField;
	
	/* Inre klass som sköter det som ska hända om man väljer alternativet "Lägg till" */
	private class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			add();
		}
	}
	
	/* Inre klass som sköter det som ska hända om man väljer alternativet "Visa"*/
	private class ShowListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			showSelected();
		}
	}
	
	/* Inre klass som sköter det som ska hända om man väljer alternativet "Rensa"*/
	private class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			clear();
		}
	}
	
	/* Inre klass som sköter menyval "Exit" */
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		GUI2 frame = new GUI2();
		frame.setVisible(true);
	}
	
	public GUI2()
	{
		initiateInstanceVariables();
		buildFrame();
	}
	
	private void initiateInstanceVariables()
	{
		logic = new Logic();
		nameField = new JTextField();
		nameField.setBorder(BorderFactory.createTitledBorder("Namn"));
		phoneNrField = new JTextField();
		phoneNrField.setBorder(BorderFactory.createTitledBorder("Telefonnummer"));
		personList = new JList<Person>();
		personList.setBorder(BorderFactory.createTitledBorder("Registrerade personer"));
	}
	
	private void buildFrame()
	{
		setTitle("Person register");
		setSize(300,250);
		setLocation(100,100);
		setLayout(new GridLayout(1,2));
		buildMenu(); // Skapa upp menyn
		JPanel leftPanel = new JPanel(new GridLayout(5,1));
		leftPanel.add(nameField);
		leftPanel.add(phoneNrField);
		JButton addButton = new JButton("Lägg till");
		addButton.addActionListener(new AddListener());
		leftPanel.add(addButton);
		JButton showButton = new JButton("Visa");
		showButton.addActionListener(new ShowListener());
		leftPanel.add(showButton);
		JButton clearButton = new JButton("Rensa");
		clearButton.addActionListener(new ClearListener());
		leftPanel.add(clearButton);
		add(leftPanel);
		add(personList);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/*public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Lägg till"))
		{
			add();
		}
		if(buttonText.equals("Visa"))
		{
			showSelected();
		}
		if(buttonText.equals("Rensa"))
		{
			clear();
		}
	}*/
	
	private void buildMenu()
	{
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Arkiv");
		menubar.add(menu);
		JMenuItem item = new JMenuItem("Lägg till person");
		item.addActionListener(new AddListener());
		menu.add(item);
		item = new JMenuItem("Avsluta");
		item.addActionListener(new ExitListener());
		menu.add(item);
		setJMenuBar(menubar);
	}
	
	private void add()
	{
		logic.addPerson(nameField.getText(), phoneNrField.getText());
		personList.setListData(logic.getAllPersons().toArray());
		clear();
	}
	
	private void showSelected()
	{
		int position = personList.getSelectedIndex();
		
		if(position > -1)
		{
			nameField.setText(logic.getNameForPersonAt(position));
			phoneNrField.setText(logic.getPhoneNrForPersonAt(position));
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Du måste markera en person ilistan!");
		}
	}
	
	private void clear()
	{
		nameField.setText("");
		phoneNrField.setText("");
	}
}
