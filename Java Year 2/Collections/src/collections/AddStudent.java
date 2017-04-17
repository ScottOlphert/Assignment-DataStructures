package collections;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

public class AddStudent extends JFrame implements ActionListener
{
	private JLabel heading, confirmed, padder1, padder2;
	private JLabel lblStudentID, lblForeName, lblSurname, lblSubject, lblResult;
	private JTextField txtStudentID, txtForeName, txtSurname, txtResult;
	private JComboBox cmbSubject;
	private JButton btnAdd,btnReset,btnExit;

	private String stockNo, description, category;	
	private int noSold, noInStock;  
	private double cost, sellingPrice;
	
	// Declare a HashMap called students
	public static HashMap<String,Student> students;
	
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	
	//Add component to the container
	private void addComp(Component c, GridBagLayout gbLayout, 
			GridBagConstraints gbConstraints,
			int row, int column, int numRows,
			int numColumns, int weightx, int weighty)
	{
		//set parameters
		gbConstraints.gridx = column;
		gbConstraints.gridy = row;
		gbConstraints.gridwidth = numColumns;
		gbConstraints.gridheight = numRows;
		gbConstraints.weightx = weightx;
		gbConstraints.weighty = weighty;
		gbConstraints.insets = new Insets(5,5,5,5);
		
		//set constraints in the GridBag Layout
		gbLayout.setConstraints(c, gbConstraints);
		
		//add component to the container
		getContentPane().add(c);
	}

	public AddStudent(HashMap<String, Student> Local) // declare a hashmap in the brackets called sItems
	
	{
		// students = sItems; // remove comment markers
		students = Local;
		//Grid Bag Layout
		heading = new JLabel("Student Results", JLabel.CENTER);
		heading.setFont(new Font("Serif", Font.BOLD,16));
		heading.setForeground(Color.white);
		
		lblStudentID = new JLabel("StudentID:", JLabel.RIGHT);
		lblStudentID.setFont(new Font("Serif", Font.BOLD,16));
		lblStudentID.setForeground(Color.white);
		
		lblForeName= new JLabel("ForeName:",JLabel.RIGHT);
		lblForeName.setFont(new Font("Serif", Font.BOLD,14));
		lblForeName.setForeground(Color.white);
		
		lblSurname= new JLabel("Surname:",JLabel.RIGHT);
		lblSurname.setFont(new Font("Serif", Font.BOLD,14));
		lblSurname.setForeground(Color.white);
		
		lblSubject= new JLabel("Subject:",JLabel.RIGHT);
		lblSubject.setFont(new Font("Serif", Font.BOLD,14));
		lblSubject.setForeground(Color.white);
		
		lblResult= new JLabel("Result:",JLabel.RIGHT);
		lblResult.setFont(new Font("Serif", Font.BOLD,14));
		lblResult.setForeground(Color.white);
		
		// just gives a line of space
		padder1 = new JLabel("You don't see me...right?", JLabel.CENTER);
		padder1.setFont(new Font("Serif", Font.BOLD,8));
		padder1.setForeground(Color.decode("#333333"));
		
		confirmed = new JLabel("Message will appear...", JLabel.LEFT);
		confirmed.setFont(new Font("Serif", Font.BOLD,14));
		confirmed.setForeground(Color.white);
		
		// just gives a line of space
		padder2 = new JLabel("You don't see me...right?", JLabel.CENTER);
		padder2.setFont(new Font("Serif", Font.BOLD,8));
		padder2.setForeground(Color.decode("#333333"));
		
		txtStudentID= new JTextField(15);
		txtStudentID.setFont(new Font("Serif", Font.BOLD,14));
		txtStudentID.setOpaque(true);
		
		txtForeName= new JTextField(30);
		txtForeName.setFont(new Font("Serif", Font.BOLD,14));
		
		txtSurname= new JTextField(30);
		txtSurname.setFont(new Font("Serif", Font.BOLD,14));
		
		//String [] subjects = {"Computing", "Drama", "Engineering", "Health Care", "Music", "Tourism"};
		cmbSubject = new JComboBox();
		cmbSubject.setFont(new Font("Serif", Font.BOLD,14));
		Readcmb();
		
		txtResult= new JTextField(15);
		txtResult.setFont(new Font("Serif", Font.BOLD,14));
		
		btnAdd = new JButton ("Add Student");
		btnAdd.setFont(new Font("Serif", Font.BOLD,20));
		btnAdd.addActionListener(this);
		
		btnReset = new JButton ("Reset");
		btnReset.setFont(new Font("Serif", Font.BOLD,20));
		btnReset.addActionListener(this);
		
		btnExit = new JButton ("Exit");
		btnExit.setFont(new Font("Serif", Font.BOLD,20));
		btnExit.addActionListener(this);
		
		//Create GridBagLayout and GridBag Constraints object
		gbLayout = new GridBagLayout();
		gbConstraints = new GridBagConstraints();
		getContentPane().setLayout(gbLayout);
		getContentPane().setBackground(Color.decode("#333333"));
		
		//Place JLabel to occupy row 0 (1st row)
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.CENTER;
		
		addComp(heading, gbLayout, gbConstraints, 2, 1, 2, 8, 70, 20);
		
		addComp(lblStudentID, gbLayout, gbConstraints, 5, 2, 1, 2, 35, 15);
		
		addComp(lblForeName, gbLayout, gbConstraints, 7, 2, 1, 2, 35, 15);
		
		addComp(lblSurname, gbLayout, gbConstraints, 9, 2, 1, 2, 35, 15);

		addComp(lblSubject, gbLayout, gbConstraints, 11, 2, 1, 2, 35, 15);

		addComp(lblResult, gbLayout, gbConstraints, 13, 2, 1, 2, 35, 15);

		addComp(txtStudentID, gbLayout, gbConstraints, 5, 4, 1, 2, 35, 15);

		addComp(txtForeName, gbLayout, gbConstraints, 7, 4, 1, 2, 35, 15);

		addComp(txtSurname, gbLayout, gbConstraints, 9, 4, 1, 2, 0, 15);

		addComp(cmbSubject, gbLayout, gbConstraints, 11, 4, 1, 1, 0, 15);

		addComp(txtResult, gbLayout, gbConstraints, 13, 4, 1, 2, 35, 15);
		
		addComp(padder1, gbLayout, gbConstraints, 19, 1, 2, 8, 70, 20);
		
		addComp(confirmed, gbLayout, gbConstraints, 21, 1, 2, 8, 70, 20);
		
		addComp(padder2, gbLayout, gbConstraints, 23, 1, 2, 8, 70, 20);

		addComp(btnAdd, gbLayout, gbConstraints, 25, 3, 2, 2, 30, 15);

		addComp(btnReset, gbLayout, gbConstraints, 25, 5, 2, 2, 30, 15);

		addComp(btnExit, gbLayout, gbConstraints, 25, 7, 2, 2, 30, 15);
				
		txtStudentID.requestFocus();
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		boolean add=true;
		
		if( e.getSource()== btnExit) // Exit - add requests from Queue to file using Queue.display()
		{		
			this.setVisible(false); // need to close form cos rd is closed	
		}
		else if( e.getSource()== btnReset) // Reset - clears all data without storing
		{		
			txtStudentID.setText("");
			txtForeName.setText("");
			txtSurname.setText("");
			cmbSubject.setSelectedItem("Computing");
			txtResult.setText("");
			txtStudentID.requestFocus();	
		}
		else if( e.getSource()== btnAdd)
		{
			if(students.containsKey(txtStudentID.getText()))
			{
				JOptionPane.showMessageDialog(null, "Student already exists, Please select a new Student ID");
				txtStudentID.setText("");
				txtStudentID.requestFocus();
			}
			// Use the containsKey method of Map to check if value entered exists
			// Show message if it does and request the focus for the StudentID text box
			else
			{
				Student newItem = new Student();
				
				newItem.setId(txtStudentID.getText());
				newItem.setForename(txtForeName.getText());
				newItem.setSurname(txtSurname.getText());
				newItem.setSubject(cmbSubject.getSelectedItem().toString());
				newItem.setResult(Integer.parseInt(txtResult.getText()));
				
				students.put(txtStudentID.getText(),newItem);
				
				// create a new instance of student
				
				// retrieve the values from the components and set them for the new student
				// remember to parseInt or cast as a String where appropriate

				
				// use the Map's put method to add the data remembering there are two objects needed

				confirmed.setText(newItem.getForename() + " has been processed.");
				txtStudentID.setText("");
				txtForeName.setText("");
				txtSurname.setText("");
				cmbSubject.setSelectedItem("Computing");
				txtResult.setText("");
				txtStudentID.requestFocus();
				
			}
		}
	}
	
	public void Readcmb()
	{
		String sClass = "";
		try
		{
			BufferedReader classList = new BufferedReader(new FileReader("Resource/classList.txt"));
			boolean eof = false;
			
			while(eof!=true)
			{
				sClass=classList.readLine();
				if(sClass!=null)
					cmbSubject.addItem(sClass);
				else
					eof=true;
			}
		}
		catch(FileNotFoundException fEx)
		{
			JOptionPane.showMessageDialog(null, "File not found");
		}
		catch(IOException ioEx)
		{
			JOptionPane.showMessageDialog(null, "Problem with the file");
		}
	}
	

}
