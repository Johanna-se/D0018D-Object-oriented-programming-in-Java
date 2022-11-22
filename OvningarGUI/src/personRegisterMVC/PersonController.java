package personRegisterMVC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the Controller, the Controller is listening after interactions from
 * the user. The Controller updates the data in the model and updates the view
 * with the new data.
 */

public class PersonController 
{
    private PersonView theView;
    private Logic theModel;

    public PersonController()
    {
        theView = new PersonView();
        theModel = new Logic();

        // The View has the components, but the controller needs to listen if
        // the user clicks a button
        theView.addNewListeners(new AddNewPersonListener());
        theView.addShowListeners(new ShowPersonListener());
        theView.addClearListeners(new ClearFieldsListener());
    }

    /**
     * Update the model with a new person
     */
    private void addPerson()
    {
        // Update the model
        theModel.addPerson(theView.getName(), theView.getPhone());

        // Update the view
        theView.updateView(theModel);
    }

    private class AddNewPersonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            addPerson();
        }
    }

    private class ShowPersonListener implements ActionListener
    {

        public void actionPerformed(ActionEvent event)
        {
            theView.showPerson(theModel);
        }
    }

    private class ClearFieldsListener implements ActionListener
    {

        public void actionPerformed(ActionEvent event)
        {
            theView.clearTextFields();
        }
    }

}
