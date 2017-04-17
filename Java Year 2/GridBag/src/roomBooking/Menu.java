package roomBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Enumeration;



public class Menu extends JFrame implements ActionListener
{
	private JMenuBar bookingMenu;
	private JMenu Rooms, System, mDisplay;
	private JMenuItem mAdd, mDelete, mAll, mByRoom, mExit;
	private AddBooking add;
	private DisplayForm display;
	private RoomBooking [] bks = new RoomBooking [10];
	
	private File out;
	private RandomAccessFile rd;
	
	public Menu()
	{
		try
		{
			out = new File ("Bookings.dat");
			rd = new RandomAccessFile(out,"rx");
			
			if(rd.length()>0)
			{
				boolean eof = false;
				do
				{
					try
					{
						RoomBooking storedBK = new RoomBooking();
						storedBK.setRoomDesc(rd.readUTF());
						storedBK.setBookingDate(rd.readUTF());
						storedBK.setBookingTime(rd.readUTF());
						storedBK.setContact(rd.readUTF());
						
						bookings.join(storedBK);
					}
					catch(EOFException e1)
					{
						eof = true;
					}
				}while (!eof);
				rd.close();
			}
			
			else
				JOptionPane.showMessageDialog(null, "No Records Loaded");
		}
		catch(IOException e2)
		{
			JOptionPane.showMessageDialog(null, "cannot open file");
		}
	
	// Create Menu bar
	bookingMenu = new JMenuBar(); 
	
	Rooms = new JMenu("Rooms"); // create menu options
	System = new JMenu("System");
	
	mAdd = new JMenuItem ("Add"); // create menu items
	mAdd.addActionListener(this);
	mDisplay = new JMenu ("Display");
	mDelete = new JMenuItem ("Delete");
	mExit = new JMenuItem ("Exit");
	
		mByRoom = new JMenuItem ("By Room");
		mAll = new JMenuItem ("All");
		mAll.addActionListener(this);
	
		mDisplay.add(mAll); // Add items to display creating sub menu;
		mDisplay.add(mByRoom);
	
	Rooms.add(mAdd); // Add items to Rooms menu
	Rooms.add(mDisplay);
	Rooms.add(mDelete);
	
	System.add(mExit);  // Add exit to system Menu
	
	bookingMenu.add(Rooms);
	bookingMenu.add(System);
	
	setJMenuBar(bookingMenu); // Set Menu bar
	
	
	add = new AddBooking(bks);     
	add.setSize(500, 500);
	//add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	display = new DisplayForm(bks);     
	display.setSize(390, 570);
	//display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
 
	
	}
	
	public static void main(String[] args) 
	{    
       
		Menu frm = new Menu();     
		frm.setSize(500, 500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== mAdd)
		{
			add.setVisible(true);
		}
		
		if(e.getSource()== mAll)
		{
			display.setVisible(true);
		}
				
		
	}
	
	
	

}
