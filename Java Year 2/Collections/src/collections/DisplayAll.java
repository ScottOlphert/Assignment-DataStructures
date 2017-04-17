package collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DisplayAll extends JFrame implements ActionListener
{
	private JLabel lblTitle;
	private JTextArea txtArea;
	private JButton btnExit,btnDisplay;
	private JScrollPane jsp;
	private Container cn;
	
	// Declare a hashmap called students
	private static HashMap<String, Student> students;
	File Report = new File("Resource/Report.txt");
	
	public DisplayAll(HashMap<String, Student> Local) // declare a hashmap in the brackets called sItems
	{
		// students = sItems; // remove the comment markers
		students = Local;
		
		cn = getContentPane();
		cn.setBackground(Color.decode("#333333"));
		
		cn.setLayout(null); 		//Absolute Layout Manager
		
		lblTitle = new JLabel("Display Students");
		lblTitle.setFont(new Font("Serif",Font.BOLD,20));
		lblTitle.setBounds(10, 20, 300, 50);
		lblTitle.setForeground(Color.white);
		cn.add(lblTitle);
		
		txtArea = new JTextArea(20,60);
		txtArea.setFont(new Font("Lucida Console",Font.PLAIN,12));
	
		jsp = new JScrollPane(txtArea);
		jsp.setBounds(10, 100, 720, 300);
		
		cn.add(jsp);
		
		btnDisplay = new JButton ("Display");
		btnDisplay.setFont(new Font("Serif", Font.BOLD,18));
		btnDisplay.setBounds(420,30,150,50);
		btnDisplay.addActionListener(this);
		cn.add(btnDisplay);
		
		btnExit = new JButton ("Exit");
		btnExit.setFont(new Font("Serif", Font.BOLD,18));
		btnExit.setBounds(580,30,150,50);
		btnExit.addActionListener(this);
		cn.add(btnExit);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if ( e.getSource()==btnExit)
			this.setVisible(false);
		if ( e.getSource()==btnDisplay)
		{
			try
			{
			txtArea.setText("");
			
			String s;
			// Add a header
			s="Student ID.   Forename             Surname             Subject        Result\n";
			txtArea.append(s);
			s="-----------------------------------------------------------------------------\n";
			txtArea.append(s);
			
			// Create an instance of Iterator
			
			PrintWriter create = new PrintWriter(Report);
			
			create.println("Student List");
			create.println("------------");
			create.println("");
			create.println("Student ID.   Forename             Surname             Subject        Result");
			create.println("-----------------------------------------------------------------------------");
		
		
			Iterator i = students.entrySet().iterator();
			// Loop through the items (see notes)
			
			while (i.hasNext())
			{
				Map.Entry me = (Map.Entry)i.next();
				
				txtArea.append(me.getValue().toString());
				create.println(me.getValue().toString());
			}
			create.close();
			}
			catch(FileNotFoundException fEx)
			{
				JOptionPane.showMessageDialog(null, "File not found");
			}

			// retrieve each value to a string and 
			
			// append the string to the text area

			// Close the loop

		}
			
	}

}
