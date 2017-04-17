package roombookingTest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import test.Test;


public class BookingMenu extends JFrame implements ActionListener{
	private JMenuBar jmb;
	private JMenu bookingMenu, display,systemMenu;
	private JMenuItem addItem, dAll, dByName, dByClass,updateItem,deleteItem, 
byCategory, eSystem;
	private Container cn;
	private JPanel imagePanel;
	private AddBooking add;
	private DisplayAll displayAll;
	private Queue bookings = new Queue(); // queue created
	                    
	public BookingMenu()
	{
		cn= getContentPane();
		cn.setBackground(Color.LIGHT_GRAY);
		
		jmb = new JMenuBar();
		jmb.setBackground(Color.decode("#333333"));
		
		bookingMenu = new JMenu("Rooms");
		bookingMenu.setFont(new Font("Serif",Font.BOLD,20));
		bookingMenu.setBackground(Color.decode("#333333"));
		bookingMenu.setForeground(Color.white);
		
		addItem = new JMenuItem("Add Booking");
		addItem.setFont(new Font("Serif",Font.BOLD,20));
		addItem.setForeground(Color.decode("#333333"));
		addItem.setBackground(Color.white);
		addItem.addActionListener(this);
		bookingMenu.add(addItem);
		
		display = new JMenu("Display");
		display.setFont(new Font("Serif",Font.BOLD,20));
		
		dAll = new JMenuItem("All");
		dAll.setFont(new Font("Serif",Font.BOLD,20));
		dAll.addActionListener(this);
		display.add(dAll);
		
		dByName = new JMenuItem("By Name");
		dByName.setFont(new Font("Serif",Font.BOLD,20));
		dByName.addActionListener(this);
		display.add(dByName);
		
		dByClass = new JMenuItem("By Class");
		dByClass.setFont(new Font("Serif",Font.BOLD,20));
		dByClass.addActionListener(this);
		display.add(dByClass);
		
		bookingMenu.add(display);
		
		updateItem = new JMenuItem("Update Booking");
		updateItem.setFont(new Font("Serif",Font.BOLD,20));
		updateItem.setForeground(Color.decode("#333333"));
		updateItem.setBackground(Color.white);
		updateItem.addActionListener(this);
		bookingMenu.add(updateItem);
		
		//delete
		deleteItem = new JMenuItem("Delete Booking");
		deleteItem.setFont(new Font("Serif",Font.BOLD,20));
		deleteItem.setForeground(Color.decode("#333333"));
		deleteItem.setBackground(Color.white);
		deleteItem.addActionListener(this);
		bookingMenu.add(deleteItem);
		
		systemMenu = new JMenu("System");
		systemMenu.setFont(new Font("Serif",Font.BOLD,20));
		systemMenu.setBackground(Color.decode("#333333"));
		systemMenu.setForeground(Color.white);
		
		eSystem = new JMenuItem("Exit");
		eSystem.setFont(new Font("Serif",Font.BOLD,20));
		eSystem.setBackground(Color.white);
		eSystem.setForeground(Color.decode("#333333"));
		eSystem.addActionListener(this);
		systemMenu.add(eSystem);
		
		jmb.add(bookingMenu);
		jmb.add(systemMenu);
		
		setJMenuBar(jmb);
		
		// need to pass the queue to the new form
		add = new AddBooking(bookings); 	
		add.setTitle("Add Booking");
		add.setSize(500,450);
		add.setLocation(100,100);
		
		displayAll = new DisplayAll(bookings); // queue
		displayAll.setTitle("Display All Bookings");
		displayAll.setSize(820,450);
		displayAll.setLocation(100,100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == addItem)
		{
			add.setVisible(true);
		}
		if ( e.getSource() == dAll)
		{
			displayAll.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) 
	{    

		BookingMenu frm = new BookingMenu();     
		frm.setSize(500, 500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JPanel panel = new JPanel(); 
		//Frame.add(AddBooking);
		frm.setVisible(true);
	}
}

