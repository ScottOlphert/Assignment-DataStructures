package roombookingTest;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DisplayAll extends JFrame implements ActionListener
{
	private JLabel lblTitle;
	private JTextArea txtArea;
	private JButton btnDisplay,btnExit;
	private JScrollPane jsp;
	private Container cn;
	private Queue currBookings = new Queue();
	
	public DisplayAll(Queue bookings)
	{
		currBookings = bookings;
		
		cn = getContentPane();
		cn.setBackground(Color.decode("#333333"));
		
		cn.setLayout(null); 		//Absolute Layout Manager
		
		lblTitle = new JLabel("Display Bookings");
		lblTitle.setFont(new Font("Serif",Font.BOLD,20));
		lblTitle.setBounds(10, 20, 300, 50);
		lblTitle.setForeground(Color.white);
		cn.add(lblTitle);

		txtArea = new JTextArea(20,60);
		txtArea.setFont(new Font("Lucida Console",Font.PLAIN,12));
	
		jsp = new JScrollPane(txtArea);
		jsp.setBounds(10, 120, 785,270);
		
		cn.add(jsp);

		btnDisplay = new JButton ("Display");
		btnDisplay.setFont(new Font("Serif", Font.BOLD,18));
		btnDisplay.setBounds(475,50,150,50);
		btnDisplay.addActionListener(this);
		cn.add(btnDisplay);
		
		btnExit = new JButton ("Exit");
		btnExit.setFont(new Font("Serif", Font.BOLD,18));
		btnExit.setBounds(645,50,150,50);
		btnExit.addActionListener(this);
		cn.add(btnExit);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if ( e.getSource()==btnExit)
		{
			txtArea.setText("");
			this.setVisible(false);
		}
		if ( e.getSource()==btnDisplay)
		{	
			String s;
						
			txtArea.setText("");
			s="Room Description           Booking Date  Booking Time   Contact \n";
			txtArea.append(s);
			s="---------------------------------------------------------------\n";
			txtArea.append(s);
			
			txtArea.append(currBookings.display());
			
			
		}
			
	}

}

