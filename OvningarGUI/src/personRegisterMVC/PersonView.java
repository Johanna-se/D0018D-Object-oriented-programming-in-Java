package personRegisterMVC;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This is the View, the View is responsible to present the data to the user
 * 
 * @author Susanne Fahlman
 *
 */

public class PersonView extends JFrame
{
    private static final long serialVersionUID = 7207001945354636294L;
    private JList<Object> personList;
    private JTextField nameField;
    private JTextField phoneNrField;
    private JButton newButton = new JButton("Lägg till");
    private JButton showButton = new JButton("Visa");
    private JButton clearButton = new JButton("Rensa");

    public PersonView()
    {
        initiateInstanceVariables();
        buildFrame();
        setVisible(true);
    }

    /**
     * Initiate the instance variables
     */
    private void initiateInstanceVariables()
    {
        nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("Namn"));
        phoneNrField = new JTextField();
        phoneNrField.setBorder(BorderFactory.createTitledBorder("Telefonnummer"));
        personList = new JList<Object>();
        personList.setBorder(BorderFactory.createTitledBorder("Registrerade personer"));
    }

    /**
     * Set up the frame
     */
    private void buildFrame()
    {
        setTitle("Person register");
        setSize(300, 250);
        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel(new GridLayout(5, 1));
        leftPanel.add(nameField);
        leftPanel.add(phoneNrField);
        leftPanel.add(newButton);
        leftPanel.add(showButton);
        leftPanel.add(clearButton);

        add(leftPanel);
        add(personList);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Returns the text in the name text field
     * 
     * @return the name
     */
    public String getName()
    {
        return nameField.getText();
    }

    /**
     * Returns the text in the phone text field
     * 
     * @return the phone nr
     */
    public String getPhone()
    {
        return phoneNrField.getText();
    }

    /**
     * Returns the index that is selected in the JList
     * 
     * @return index
     */
    public int getIndex()
    {
        return personList.getSelectedIndex();
    }

    /**
     * Shows info of the person that is selected in the JList
     */
    public void showPerson(Logic theModel)
    {
        // Get the index that is selected
        int position = getIndex();

        // Someone is selected
        if(position > -1)
        {
            // Retrieve the name and tells the view to show the name
            String text = theModel.getNameForPersonAt(position);
            nameField.setText(text);
            // Retrieve the phone number and tells the view to show the phone
            // number
            text = theModel.getPhoneNrForPersonAt(position);
            phoneNrField.setText(text);
        }
        else
        {
            // Notify the view that no selection was made
            JOptionPane.showMessageDialog(null, "Du måste markera en person i listan!");
        }
    }

    /**
     * Clears the text fields
     */
    public void clearTextFields()
    {
        nameField.setText("");
        phoneNrField.setText("");
    }

    /**
     * Adds a listener for the newButton
     * 
     * @param listenForButton
     */
    public void addNewListeners(ActionListener listenForButton)
    {
        newButton.addActionListener(listenForButton);
    }

    /**
     * Adds a listener for the showButton
     * 
     * @param listenForButton
     */
    public void addShowListeners(ActionListener listenForButton)
    {
        showButton.addActionListener(listenForButton);
    }

    /**
     * Adds a listener for the clearButton
     * 
     * @param listenForButton
     */
    public void addClearListeners(ActionListener listenForButton)
    {
        clearButton.addActionListener(listenForButton);
    }

    public void updateView(Logic theModel)
    {
        Object[] newData = theModel.getAllPersons().toArray();
        personList.setListData(newData);
        clearTextFields();
    }
}
