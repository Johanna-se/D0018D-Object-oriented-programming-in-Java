package Ovning6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintLight2 extends JFrame
{
	private Color theColor;
	private JComboBox comboBox;
	private int x;
	private int y;
	
	private class MListener implements MouseListener, MouseMotionListener
	{
		//Om mustangenten trycks ner, så fånga var det sker någonstans
		public void mousePressed(MouseEvent event)
		{
			x = event.getX();
			y = event.getY();
		}
		
		//Hantera musklick
		//Om högerklick så töm ritytan annars sätt rätt färg
		public void mouseClicked(MouseEvent event)
		{
			x = event.getX();
			y = event.getY();
			//if(event.isMetaDown()) //Höger musknapp? alternativt 
			if (event.getButton() == MouseEvent.BUTTON3)
			{
				clear();
			}
			else //V nster musknapp? motsv. event.BUTTON1�
			{
				setChoosenColor();
			}
		}
		
		//Rita en rektangel med vald färg när musknappen släpps
		public void mouseReleased(MouseEvent event)
		{
			int endX = event.getX();
			int endY = event.getY();
			//Om det ej är höger musknapp (dvs om det är vänster musknapp
			if(!event.isMetaDown())
			{
				if(y>=60)
				{
					drawRectangle(endX, endY);
				}
			}
		}
		
		//Om "frihand" är vald så rita linje
		public void mouseDragged(MouseEvent event)
		{
			int index = comboBox.getSelectedIndex();
			//Vänster musknapp OCH "frihand" valt
			if(!event.isMetaDown() && index == 1)
			{
				int endX = event.getX();
				int endY = event.getY();
				draw(endX, endY);
			}
		}
		
		public void mouseEntered(MouseEvent event)
		{
		}
		
		public void mouseExited(MouseEvent event)
		{
		}
		
		public void mouseMoved(MouseEvent event)
		{
		}
	}
	
	public PaintLight2()
	{
		String[] items = {"Rektangel", "Frihand"};
		comboBox = new JComboBox(items);
		x=0;
		y=0;
		setTitle("PaintLight");
		setSize(550, 300);
		setLocation(50, 150);
		//Ingen layoutmanager
		setLayout(null);
		setResizable(false);
		Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA};
		
		for (int i=0; i<6; i++) // makeColorArea(0,0,75,30, Color.RED); makeColorArea(75,0,75,30, Color.GREEN);...makeColorArea(300,0,75,30, Color.MAGENTA);
		{
			makeColorArea(75*i,0,75,30, colors[i]);
		}
		comboBox.setBounds(450, 0, 100, 30);
		add(comboBox);
		MListener ml = new MListener();
		addMouseListener(ml);
		addMouseMotionListener(ml);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void makeColorArea(int x1, int y1, int x2, int y2, Color theColor)
	{
		JPanel p1 = new JPanel();
		p1.setBounds(x1, y1, x2, y2); //övre v hörnets koord x samt y, bredd, höjd
		p1.setBackground(theColor);
		add(p1);
	}
	
	private void clear()
	{
		Graphics g = getGraphics();
		Rectangle r = getBounds();
		g.clearRect(0, 60, r.width, r.height-60);
		g.dispose();
	}
	
	private void setChoosenColor()
	{
		if(x>=0 && x<75 && y>=30 && y<60)
		{
			theColor = Color.RED;
		}
		
		if(x>=75 && x<150 && y>=30 && y<60)
		{
			theColor = Color.GREEN;
		}
		
		if(x>=150 && x<225 && y>=30 && y<60)
		{
			theColor = Color.BLUE;
		}
		
		if(x>=225 && x<300 && y>=30 && y<60)
		{
			theColor = Color.CYAN;
		}
		
		if(x>=300 && x<375 && y>=30 && y<60)
		{
			theColor = Color.YELLOW;
		}
		
		if(x>=375 && x<450 && y>=30 && y<60)
		{
			theColor = Color.MAGENTA;
		}
	}
	
	private void drawRectangle(int endX, int endY)
	{
		Graphics g = getGraphics();
		g.setColor(theColor);
		g.fillRect(x, y, endX - x, endY - y);
		g.dispose();
	}
	
	private void draw(int endX, int endY)
	{
		Graphics g = getGraphics();
		g.setColor(theColor);
		g.drawLine(x, y, endX, endY);
		g.dispose();
		x = endX;
		y = endY;
	}
	
	public static void main(String[] args)
	{
		PaintLight2 pl = new PaintLight2();
		pl.setVisible(true);
	}
}
