package collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.*;


public class StudentMenu extends JFrame implements ActionListener
{
	private JMenuBar jmb;
	private JMenu mainMenu,dispMenu,systemMenu;
	private JMenuItem addItem,dAll,updateItem,deleteItem, eSystem;
	private Container cn;
	private AddStudent add;
	private DisplayAll displayAll;
	//private UpdateItem update;
	private Delete delete;

	private static HashMap<String, Student> students = new HashMap<String, Student> (50);
	
	File Result = new File("Result");
	
	
	
	public StudentMenu()
	{
		cn= getContentPane();
		cn.setBackground(Color.LIGHT_GRAY);
		
		jmb = new JMenuBar();
		jmb.setBackground(Color.decode("#333333"));
		
		mainMenu = new JMenu("Students");
		mainMenu.setFont(new Font("Serif",Font.BOLD,20));
		mainMenu.setBackground(Color.decode("#333333"));
		mainMenu.setForeground(Color.white);
		
		addItem = new JMenuItem("Add Student");
		addItem.setFont(new Font("Serif",Font.BOLD,20));
		addItem.setForeground(Color.decode("#333333"));
		addItem.setBackground(Color.white);
		addItem.addActionListener(this);
		mainMenu.add(addItem);
		
		updateItem = new JMenuItem("Update Student");
		updateItem.setFont(new Font("Serif",Font.BOLD,20));
		updateItem.setForeground(Color.decode("#333333"));
		updateItem.setBackground(Color.white);
		updateItem.addActionListener(this);
		mainMenu.add(updateItem);
		
		//delete
		deleteItem = new JMenuItem("Delete Student");
		deleteItem.setFont(new Font("Serif",Font.BOLD,20));
		deleteItem.setForeground(Color.decode("#333333"));
		deleteItem.setBackground(Color.white);
		deleteItem.addActionListener(this);
		mainMenu.add(deleteItem);
		
		dispMenu = new JMenu("Display");
		dispMenu.setFont(new Font("Serif",Font.BOLD,20));
		dispMenu.setForeground(Color.white);
		dispMenu.setBackground(Color.decode("#333333"));
		
		dAll = new JMenuItem("Display Students");
		dAll.setFont(new Font("Serif",Font.BOLD,20));
		dAll.setForeground(Color.decode("#333333"));
		dAll.setBackground(Color.white);
		dAll.addActionListener(this);
		dispMenu.add(dAll);
		
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
		
		jmb.add(mainMenu);
		jmb.add(dispMenu);
		jmb.add(systemMenu);
		
		setJMenuBar(jmb);
		
		
		 Read();
		 
		//Menu Options
		add = new AddStudent(students); // pass students
		add.setTitle("Add Student");
		add.setSize(500,450);
		add.setLocation(100,100);
		
		displayAll = new DisplayAll(students);
		displayAll.setTitle("Display Students");
		displayAll.setSize(760,450);
		displayAll.setLocation(100,100);

		/*update = new UpdateItem(students); 
		update.setTitle("Update Student");
		update.setSize(500,450);
		update.setLocation(100,100);*/
		
		delete = new Delete(students);
		delete.setTitle("Delete Student");
		delete.setSize(750,450);
		delete.setLocation(100,100);
		
	}
		
	public void actionPerformed(ActionEvent e) 
	{
		String s = e.getActionCommand();
		if ( s.equalsIgnoreCase("Exit"))
		{
			Write();
			
			System.exit(0);
		}
		
		if ( s.equalsIgnoreCase("Add Student"))
		{
			add.setVisible(true);
		}

		if ( s.equalsIgnoreCase("Display Students"))
		{
			displayAll.setVisible(true);
		}
		/*if ( s.equalsIgnoreCase("Update Student"))
		{
			update.setVisible(true);
		}*/
		if ( s.equalsIgnoreCase("Delete Student"))
		{
			delete.setVisible(true);
		}
	}
	
	public void Read()
	{
		try{
			FileInputStream fis = new FileInputStream("Result");
			ObjectInputStream ois = new ObjectInputStream(fis);
			students = (HashMap<String, Student>) ois.readObject();
			ois.close();
			fis.close();
		}
		catch(ClassNotFoundException cEx)
		{
			JOptionPane.showMessageDialog(null, "The contents could not be read");
		}
		catch(FileNotFoundException fEx)
		{
			JOptionPane.showMessageDialog(null, "File not found");
		}
		catch(IOException ioEx)
		{
			JOptionPane.showMessageDialog(null, "Could not read from file");
		}
	}
	
	public void Write()
	{
		try{
			FileOutputStream fos = new FileOutputStream(Result);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(students);
			oos.close();
			fos.close();
		}
		
		catch(FileNotFoundException fEx)
		{
			JOptionPane.showMessageDialog(null, "File not found");
		}
		catch(IOException ioEx)
		{
			JOptionPane.showMessageDialog(null, "Could not write file");
		}
	}
	
	/*public void Report()
	{
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
			
			create.println(me.getValue().toString());
		}
		
		
		create.close();
		
	}*/
}
