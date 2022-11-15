package personRegister;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class GUI extends JFrame implements ActionListener
{
	private Logic logic;
	private JList personList;
	private JTextField nameField;
	private JTextField phoneNrField;
	
	public static void main(String[] args)
	{
		GUI frame = new GUI();
		frame.setVisible(true);
	}
	
	public GUI()
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
		personList = new JList();
		personList.setBorder(BorderFactory.createTitledBorder("Registrerade personer"));
	}
	
	private void buildFrame()
	{
		setTitle("Person register");
		setSize(300, 250);
		setLayout(new GridLayout(1, 2));
		
		JPanel leftPanel = new JPanel(new GridLayout(5, 1));
		leftPanel.add(nameField);
		leftPanel.add(phoneNrField);
		JButton addButton = new JButton("Lägg till");
		addButton.addActionListener(this);
		leftPanel.add(addButton);
		JButton showButton = new JButton("Visa");
		showButton.addActionListener(this);
		leftPanel.add(showButton);
		JButton clearButton = new JButton("Rensa");
		clearButton.addActionListener(this);
		leftPanel.add(clearButton);
		add(leftPanel);
		add(personList);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
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
			JOptionPane.showMessageDialog(null, "Du måste markera en person i listan!");
		}
	}
	
	private void clear()
	{
		nameField.setText("");
		phoneNrField.setText("");
	}
}
