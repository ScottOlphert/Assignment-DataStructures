package collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Delete extends JFrame implements ActionListener
{
	private JLabel lblTitle, lblStudentID;
	private JTextArea txtArea;
	private JButton btnExit,btnFind,btnDelete;
	private JScrollPane jsp;
	private Container cn;
	private JTextField txtStudentID;
	private String found;

	// Declare a hashmap called students
	private static HashMap<String, Student> students;

	public Delete(HashMap<String, Student> Local) // declare a hashmap in the brackets called sItems
	{
		// students = sItems; // remove the comment markers
		students = Local;

		cn = getContentPane();
		cn.setBackground(Color.decode("#333333"));

		cn.setLayout(null); 		//Absolute Layout Manager

		lblTitle = new JLabel("Delete Students");
		lblTitle.setFont(new Font("Serif",Font.BOLD,16));
		lblTitle.setBounds(10, 20, 150, 50);
		lblTitle.setForeground(Color.white);
		cn.add(lblTitle);

		lblStudentID = new JLabel("StudentID:");
		lblStudentID.setFont(new Font("Serif", Font.BOLD,16));
		lblStudentID.setBounds(10, 65, 75, 20);
		lblStudentID.setForeground(Color.white);
		cn.add(lblStudentID);


		txtStudentID= new JTextField(15);
		txtStudentID.setFont(new Font("Serif", Font.BOLD,14));
		txtStudentID.setBounds(85, 65, 150, 20);
		txtStudentID.setOpaque(true);
		cn.add(txtStudentID);

		txtArea = new JTextArea(20,60);
		txtArea.setFont(new Font("Lucida Console",Font.PLAIN,12));

		jsp = new JScrollPane(txtArea);
		jsp.setBounds(10, 100, 720, 300);

		cn.add(jsp);

		btnFind = new JButton ("Find");
		btnFind.setFont(new Font("Serif", Font.BOLD,18));
		btnFind.setBounds(260,30,150,50);
		btnFind.addActionListener(this);
		cn.add(btnFind);

		btnDelete = new JButton ("Delete");
		btnDelete.setFont(new Font("Serif", Font.BOLD,18));
		btnDelete.setBounds(420,30,150,50);
		btnDelete.addActionListener(this);
		cn.add(btnDelete);

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
		if ( e.getSource()==btnFind)
		{
			if(!students.containsKey(txtStudentID.getText()))
			{
				JOptionPane.showMessageDialog(null, "Student does not exist");
				txtStudentID.setText("");
				txtStudentID.requestFocus();
			}
			// Use the containsKey method of Map to check if value entered exists
			// Show message if it does and request the focus for the StudentID text box
			else
			{
				found = txtStudentID.getText();
				txtArea.setText("");

				String s;
				// Add a header
				s="Student ID.   Forename             Surname             Subject        Result\n";
				txtArea.append(s);
				s="-----------------------------------------------------------------------------\n";
				txtArea.append(s);

				// Create an instance of Iterator

				Student newitem = students.get(txtStudentID.getText());
				

				txtArea.append(newitem.toString());	
			}


			// retrieve each value to a string and 

			// append the string to the text area

			// Close the loop
		}

		if ( e.getSource()==btnDelete)
		{
			students.remove(found);
			txtArea.setText("");
			String s;
			// Add a header
			s="Student ID.   Forename             Surname             Subject        Result\n";
			txtArea.append(s);
			s="-----------------------------------------------------------------------------\n";
			txtArea.append(s);
			
			JOptionPane.showMessageDialog(null, "Student " + found +" has been deleted");
			
		}
	}

}


