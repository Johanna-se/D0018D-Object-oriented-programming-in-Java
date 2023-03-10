package ojoepe5;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * ExempelGUI för vårdföretagsprogrammet
 * 
 * @author Susanne Fahlman, susanne.fahlman@ltu.se
 *
 */

public class MainGUI extends JFrame implements ActionListener, ListSelectionListener
{
	private static final long serialVersionUID = 5765267086570271159L;

	// Tabellens storlek
	private final int WIDTH = 500;
	private final int HEIGHT = 300;

	
    // Innehåller raderna som ska synas i tabellen	
	Vector<String[]> data = new Vector<String[]>();
	
	// Inre klass för att hantera kolumnerna i tabellen
	TableModel dataModel = new AbstractTableModel() 
	{
		private static final long serialVersionUID = 4399034668796428416L;
		
		// Kolumnernas antal och namn får gärna ändras
		private String[] columns = {"Namn", "Medicin", "Mängd", "Tidpunkt" };

		// Returnerar antalet kolumner i tabellen
        public int getColumnCount() 
        {
            return columns.length;
        }

        // Returnerar antalet rader i tabellen
        public int getRowCount() 
        {
            return data.size();
        }

        // Returnerar kolumnnamn för angiven kolumn
        public String getColumnName(int col) 
        {
            return columns[col];
        }

        public String getValueAt(int row, int col) 
        {
        	String[] temp = data.get(row);
          	return temp[col];
        }
    };

    JMenuItem addAction = new JMenuItem("Lägg till Patient");
    JTable m_clTable = new JTable(dataModel);
    JButton m_clAddMin = new JButton("+5min");
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == m_clAddMin)
  		{
			// TODO Räkna upp tiden med 15 minuter
			
			
			System.err.println("Should add 5 minutes ");			
			// Visar kod för att ta bort en rad från tabellen
	    	data.remove(0);
	    	m_clTable.revalidate(); 
	    	m_clTable.repaint();
  		}
		else if(event.getSource() == addAction)
  		{
			// TODO Lägg till en ny patient
			
			
			System.err.println("Should add a new patient");
			
			// Visar kod för att lägga till en rad till tabellen
	    	String[] s = {"Olga", "Alvedon", "20 ml", "11.00"};
	    	data.add(s);
	    	m_clTable.revalidate(); 
	    	m_clTable.repaint();
  		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		// Varje klick triggar lyssnaren två gånger och vi är bara intresserade av första klicket
		if(!e.getValueIsAdjusting())	
		{
			// Hämtar markerad rad och kolumn
			int col = m_clTable.getSelectedColumn();
			int row = m_clTable.getSelectedRow();
			
			// Kollar så att rad och kolum ligger inom rätt intervall (behövs pga. clearSelection)
			if(col > -1 && col < data.get(0).length && row > -1 && row < data.size())
			{
				// Hämta värdet i cellen
				String value = (String) dataModel.getValueAt(row, col);
				System.err.println("Du klickade på " + row + " " + col + " " + value);
				
				// Avmarkerar raden så man kan klicka på samma rad två gånger efter varandra
				// m_clTable.getSelectionModel().clearSelection();
			
				// TODO Ja, vad ska göras när man klickat på en cell?
			}
			
		}
	}
	
	// Defaultkonstruktor
    public MainGUI()
    {
    	// Testar tabellen
    	String[] s = {"Olga", "Alvedon", "20 ml", "11.00"};
    	String[] s1 = {"Gustav", "MedX", "50 ml", "11.40"};
    	data.add(s);
    	data.add(s1);
        
        m_clTable.getSelectionModel().addListSelectionListener(this);
        JScrollPane m_clScrollpane = new JScrollPane(m_clTable);
        m_clScrollpane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        // Lägger till komponenterna till fönstret
        JPanel headPanel = new JPanel();
        headPanel.add(m_clScrollpane);
        add(m_clAddMin, BorderLayout.SOUTH);
        m_clAddMin.addActionListener(this);
        add(headPanel);
       
        // Menyn
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("Arkiv");
        menuBar.add(fileMenu);

        fileMenu.add(addAction);
        addAction.addActionListener(this);
        
        //Vid avslut på X-et
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
                System.exit(0);
            }
        });

    }
    
    public static void main(String[] args)
    {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainGUI frame = new MainGUI();
            	frame.setLocation(200, 200);
            	frame.setResizable(false);
            	frame.setTitle("CramaAB");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

