package personRegisterMedBil;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame
{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 300;
	
	private Logic logic;
	
	// Komponenterna till första panelen (person)
	private JPanel personPanel;
	private JList personList;
	private JTextField nameField;
	private JTextField phoneNrField;
	private JLabel personTextLabel = new JLabel();
	
	// Komponenterna till andra panelen (bil)
	private JPanel carPanel;
	private JList carList;
	private JTextField brandField;
	private JTextField colorField;
	private JTextField idField;
	private JLabel carTextLabel = new JLabel();
	private JTextField personField = new JTextField(); // Info om vald kund
	
	public static void main(String[] args)
	{
		GUI frame = new GUI();
		frame.setVisible(true);
	}
	
	public GUI()
	{
		createComponents();
		setTitle("Bilregister");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createComponents()
	{
		logic = new Logic();
		// Lägger till testpersoner och bilar för att föränkla testning����
		logic.addPerson("Stina", "070-999 88 77");
		logic.addPerson("Pelle", "070-123 45 67");
		logic.addCar(0, "Volvo", "Gr n", "AAA111");
		logic.addCar(0, "Golf", "R d", "BBB222");
		logic.addCar(1, "Ferarri", "R d", "CCC333");
		
		// Skapar personPanel med layoutmanager BorderLayout
		personPanel = new JPanel(new BorderLayout());
		
		// När vi använder layoutmanagers så använder vi setPreferredSize istället för setSize��
		personPanel.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		carPanel = new JPanel(new BorderLayout());
		carPanel.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		
		// Jag skapar en panel så att switchandet mellan paneler ska fungera
		// Detta beroende på att frame har layoutmanager BorderLayput som default
		JPanel framePanel = new JPanel();
		
		// Skapa upp personPanel och lägg till den
		createPersonPanel();
		framePanel.add(personPanel);
		
		// Skapa upp carPanel och lägg till den
		createCarPanel();
		framePanel.add(carPanel);
		
		// Lägg till framePanel till fönstret
		add(framePanel);
		
		// Anropas för att fönstret ska få rätt storlek uifrån de önskade storlekar och layouts
		pack();
		
		// Ser till så att testpersonerna syns i vår JList
		personList.setListData(logic.getAllPersons().toArray());
	}
	
	/**
	 * Skapar upp den andra panelen (person)
	 */
	private void createPersonPanel()
	{
		ActionListener listener = new ClickPersonListener();
		
		// Skapar upp topPanel med 1 rad och två kolumner
		JPanel topPanel = new JPanel(new GridLayout(1,2));
		
		// Skapar upp leftPanel med 5 rader och 1 kolumn
		JPanel leftPanel = new JPanel(new GridLayout(5,1));
		
		// Skapar och lägger till textfälten
		nameField = new JTextField(10);
		nameField.setBorder(BorderFactory.createTitledBorder("Namn"));
		leftPanel.add(nameField);
		phoneNrField = new JTextField(10);
		phoneNrField.setBorder(BorderFactory.createTitledBorder("Telefonnummer"));
		leftPanel.add(phoneNrField);
		
		// Skapar och lägger till knappar
		JButton addButton = new JButton("Lägg till");
		addButton.addActionListener(listener);
		leftPanel.add(addButton);
		JButton showButton = new JButton("Visa");
		showButton.addActionListener(listener);
		leftPanel.add(showButton);
		JButton clearButton = new JButton("Rensa");
		clearButton.addActionListener(listener);
		leftPanel.add(clearButton);
		
		// Lägger till leftPanel till topPanel
		topPanel.add(leftPanel);
		
		// Skapar och lägger till JList personList
		personList = new JList();
		personList.setBorder(BorderFactory.createTitledBorder("Personer"));
		
		// Anonym lyssnare som hanterar vad som händer när vi klickar på en person i listan
		personList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent evt) 
			{
				getPersonInfo();
			}
		});
		
		// Lägger till JList personList till topPanel
		topPanel.add(personList);
		
		// Lägger till topPanel till personPanel
		personPanel.add(topPanel);
		
		// Lägger till personTextLabel längst ner i personPanel
		personPanel.add(personTextLabel, BorderLayout.SOUTH);
		
		// Denna panel ska visas när programmet startar
		personPanel.setVisible(true);
	}
	
	/**
	 * Skapar upp den andra panelen (bil)
	 */
	private void createCarPanel()
	{
		ActionListener listener = new ClickCarListener();
		personField.setEditable(false);  // Användaren får inte ändra i detta fält
		personField.setHorizontalAlignment(JTextField.CENTER);  // Centrerar texten i fältet
	
		// Skapar upp topPanel med 1 rad och två kolumner
		JPanel topPanel = new JPanel(new GridLayout(1,2));
	
		// Skapar upp leftPanel med 6 rader och 1 kolumn
		JPanel leftPanel = new JPanel(new GridLayout(6,1));
		
		// Skapar och lägger till textfälten
		brandField = new JTextField(10);
		brandField.setBorder(BorderFactory.createTitledBorder("Bilmärke"));
		leftPanel.add(brandField);
		colorField = new JTextField(10);
		colorField.setBorder(BorderFactory.createTitledBorder("Färg"));
		leftPanel.add(colorField);
		idField = new JTextField(10);
		idField.setBorder(BorderFactory.createTitledBorder("Regnummer"));
		leftPanel.add(idField);
		
		// Skapar och lägger till knappar
		JButton addButton = new JButton("Lägg till");
		addButton.addActionListener(listener);
		leftPanel.add(addButton);
		JButton clearButton = new JButton("Rensa");
		clearButton.addActionListener(listener);
		leftPanel.add(clearButton);
		JButton backButton = new JButton("Tillbaka");
		backButton.addActionListener(listener);
		leftPanel.add(backButton);
		
		// Lägger till leftPanel till topPanel
		topPanel.add(leftPanel);
	
		// Skapar och lägger till JList carList
		carList = new JList();
		carList.setBorder(BorderFactory.createTitledBorder("Bilar"));
	
		// Anonym lyssnare som hanterar vad som händer när vi klickar på en bil i listan
		carList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent evt) 
			{
				getCarInfo();
			}
		});
		
		// Lägger till listan till topPanel
		topPanel.add(carList);
		
		// Lägger listan med två kolumner till carPanel
		carPanel.add(topPanel);
		
		// Lägger carTextLabel längst ner i carPanel
		carPanel.add(carTextLabel, BorderLayout.SOUTH);
		
		// Lägger personField högst upp i carPanel
		carPanel.add(personField, BorderLayout.NORTH);
		
		// Denna panel ska inte visas när programmet startar
		carPanel.setVisible(false);
	}
	
	/**
	 * Hanterar klick som görs i den första panelen (person)
	 */
	public class ClickPersonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			
			if(buttonText.equals("Lägg till"))
			{
				add();
			}
			
			if(buttonText.equals("Visa"))
			{
				if(showSelected() >= 0)
				{
					// Byter ut så att personPanel blir osynlig och carPanel synlig
					personPanel.setVisible(false);
					carPanel.setVisible(true);
				}
			}
			
			if(buttonText.equals("Rensa"))
			{
				clear();
			}
		}
	}
	
	/**
	 * Hanterar klick som görs i den andra panelen (bil)
	 */
	public class ClickCarListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if(buttonText.equals("Lägg till"))
			{
				addCar();
			}
			if(buttonText.equals("Tillbaka"))
			{
				carTextLabel.setText("");
				// Byter ut så att personPanel blir synlig och carPanel osynlig
				personPanel.setVisible(true);
				carPanel.setVisible(false);
			}
			if(buttonText.equals("Rensa"))
			{
				clear();
			}
		}
	}
	
	/**
	 * Lägger till en person�
	 */
	private void add()
	{
		// Går via logic för att skapa upp en person
		logic.addPerson(nameField.getText(), phoneNrField.getText());
		// Ser till så att vår JList personList blir uppdaterad med den nya personen
		personList.setListData(logic.getAllPersons().toArray());
		// Tömmer textfölten
		clear();
	}
	
	/**
	 * Lägger till en bil
	 */
	private void addCar()
	{
		// Index till person som markerats i personList
		int position = personList.getSelectedIndex();
		
		// Går via logic för att skapa upp en bil
		logic.addCar(position, brandField.getText(), colorField.getText(), idField.getText());
		
		// Ser till så att vår JList carList blir uppdaterad med den nya bilen
		carList.setListData(logic.getAllCars(position).toArray());
	
		// Tömmer textfälten
		clear();
	}
	
	/**
	 * Den person som valts i listan personList ska visas
	 * @return position i listan för vald person
	 */
	private int showSelected()
	{
		// Index till person som markerats i personList
		int position = personList.getSelectedIndex();
	
		// Endast om man valt en person
		if(position > -1)
		{
			// Lägger personens registrerade bilar i carList
			carList.setListData(logic.getAllCars(position).toArray());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Du måste markera en person i listan!");
		}
		
		return position;
	}
	
	/**
	 * Tömmer alla textälten
	 */
	private void clear()
	{
		nameField.setText("");
		phoneNrField.setText("");
		brandField.setText("");
		colorField.setText("");
		idField.setText("");
		personTextLabel.setText("");
		carTextLabel.setText("");
	}
	
	/**
	 * Hämtar info om en person och skriv in det i carTextLabel
	 */
	private void getPersonInfo()
	{
		// Index till person som markerats i personList
		int position = personList.getSelectedIndex();
	
		// Endast om man valt en person
		if(position > -1)
		{
			// Gå via logic för att hämta ut info om personen
			String info = logic.getPersonInfo(position);
			
			// Sätter info till personTextLabel
			personTextLabel.setText(info);
			
			// Sätter info även till personField��
			personField.setText(info);
		}
	}
	
	/**
	 * Hämtar info om en bil och skriv in det i carTextLabel
	 */
	private void getCarInfo()
	{
		// Index till person som markerats i personList
		int position = personList.getSelectedIndex();
	
		// Index till bil som markerats i carList
		int carPosition = carList.getSelectedIndex();
	
		// Endast om man markerat person och bil
		if(position > -1 && carPosition != -1)
		{
			// Gå via logic för att hämta ut info om bilen
			String info = logic.getCarInfo(position, carPosition);
			
			// Sätter info till carTextLabel
			carTextLabel.setText(info);
		}
	}
}
