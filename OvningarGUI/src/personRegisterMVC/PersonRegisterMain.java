package personRegisterMVC;
import javax.swing.SwingUtilities;

public class PersonRegisterMain 
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new PersonController();
            }
        });
    }
}
