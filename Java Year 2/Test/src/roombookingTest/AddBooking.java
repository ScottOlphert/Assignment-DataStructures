package roombookingTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AddBooking  extends JFrame implements ActionListener {
	private JLabel heading, lblRoomDesc, lblDate, lblTime, lblContact, lblMaxParty, lblPartyNo, 
				padder1,confirmed, padder2;
	private JComboBox cmbRoomDesc;
	private JTextField txtDate, txtTime, txtContact;
	private JButton btnAdd, btnReset, btnExit;
	
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	
	private Queue currBookings = new Queue();
	private int queueCount=1;
	
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
	
	// Constructor
	public AddBooking(Queue bookings) {
		currBookings = bookings;
		
		heading = new JLabel("Room Bookings", JLabel.CENTER);
		heading.setFont(new Font("Serif", Font.BOLD,20));
		
		lblRoomDesc = new JLabel("Room Desc:", JLabel.RIGHT);
		lblRoomDesc.setFont(new Font("Serif", Font.BOLD,14));
		
		lblDate = new JLabel("Date:", JLabel.RIGHT);
		lblDate.setFont(new Font("Serif", Font.BOLD,14));
		
		lblTime = new JLabel("Time:", JLabel.RIGHT);
		lblTime.setFont(new Font("Serif", Font.BOLD,14));
		
		lblContact = new JLabel("Contact:", JLabel.RIGHT);
		lblContact.setFont(new Font("Serif", Font.BOLD,14));
		
		lblMaxParty = new JLabel("Max Party:", JLabel.RIGHT);
		lblMaxParty.setFont(new Font("Serif", Font.BOLD,14));
		
		// String array to store items for the combo box
		String [] rooms = {"---Select---","Assembly Hall", "Boardroom", 
"Conference Room", "Lecture Theatre"};
		cmbRoomDesc = new JComboBox(rooms);
		cmbRoomDesc.setFont(new Font("Serif", Font.BOLD,14));
		cmbRoomDesc.addActionListener(this);
		
		txtDate= new JTextField(10);
		txtDate.setFont(new Font("Serif", Font.BOLD,14));
		
		txtTime= new JTextField(10);
		txtTime.setFont(new Font("Serif", Font.BOLD,14));
		
		txtContact= new JTextField(20);
		txtContact.setFont(new Font("Serif", Font.BOLD,14));
		
		lblPartyNo = new JLabel("Max Number", JLabel.LEFT);
		lblPartyNo.setFont(new Font("Serif", Font.BOLD,14));
		
		// just gives a line of space
		padder1 = new JLabel("You don't see me...right?", JLabel.CENTER);
		padder1.setFont(new Font("Serif", Font.BOLD,8));
		padder1.setForeground(Color.decode("#ffffff"));
		
		confirmed = new JLabel("Please add booking details", JLabel.CENTER);
		confirmed.setFont(new Font("Serif", Font.ITALIC,12));
		
		// just gives a line of space
		padder2 = new JLabel("You don't see me...right?", JLabel.CENTER);
		padder2.setFont(new Font("Serif", Font.BOLD,8));
		padder2.setForeground(Color.decode("#ffffff"));
		
		//add buttons
		btnAdd = new JButton ("Add Item");
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
		
		// Use the code below if you wish to change the background colour
		getContentPane().setBackground(Color.decode("#ffffff"));
		
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.CENTER;
		
		addComp(heading, gbLayout, gbConstraints, 2, 1, 2, 8, 70, 20);
		
		addComp(lblRoomDesc, gbLayout, gbConstraints, 5, 2, 1, 2, 35, 15);
		
		addComp(lblDate, gbLayout, gbConstraints, 7, 2, 1, 2, 35, 15);
		
		addComp(lblTime, gbLayout, gbConstraints, 9, 2, 1, 2, 35, 15);

		addComp(lblContact, gbLayout, gbConstraints, 11, 2, 1, 2, 35, 15);

		addComp(lblMaxParty, gbLayout, gbConstraints, 13, 2, 1, 2, 35, 15);

		addComp(cmbRoomDesc, gbLayout, gbConstraints, 5, 4, 1, 2, 35, 15);

		addComp(txtDate, gbLayout, gbConstraints, 7, 4, 1, 1, 0, 15);

		addComp(txtTime, gbLayout, gbConstraints, 9, 4, 1, 1, 0, 15);

		addComp(txtContact, gbLayout, gbConstraints, 11, 4, 1, 2, 35, 15);

		addComp(lblPartyNo, gbLayout, gbConstraints, 13, 4, 1, 2, 35, 15);
		
		addComp(padder1, gbLayout, gbConstraints, 15, 1, 2, 8, 70, 20);
		
		addComp(confirmed, gbLayout, gbConstraints, 17, 1, 2, 8, 70, 20);
		
		addComp(padder2, gbLayout, gbConstraints, 19, 1, 2, 8, 70, 20);

		addComp(btnAdd, gbLayout, gbConstraints, 21, 3, 2, 2, 30, 15);

		addComp(btnReset, gbLayout, gbConstraints, 21, 5, 2, 2, 30, 15);

		addComp(btnExit, gbLayout, gbConstraints, 21, 7, 2, 2, 30, 15);

	}
	// ActionListener's method to respond to component actions
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnAdd)
		{
			String retMsg = addToQueue();
			// Confirm booking and reset
			confirmed.setText(retMsg);
			resetFields();
		}
		if(e.getSource() == btnReset)
		{
			// reset fields
			resetFields();
		}
		if(e.getSource() == btnExit)
		{
			// close application
			this.setVisible(false);
		}
		if(e.getSource() == cmbRoomDesc)
		{
			// display a message based on the selected item
			if(cmbRoomDesc.getSelectedItem()=="Assembly Hall")
				lblPartyNo.setText("250 people");
			else if(cmbRoomDesc.getSelectedItem()=="Boardroom")
				lblPartyNo.setText("20 people");
			else if(cmbRoomDesc.getSelectedItem()=="Conference Room")
				lblPartyNo.setText("40 people");
			else if(cmbRoomDesc.getSelectedItem()=="Lecture Theatre")
				lblPartyNo.setText("125 people");
		}
	}
	private void resetFields()
	{
		cmbRoomDesc.setSelectedItem("---Select---");
		txtDate.setText("");
		txtTime.setText("");
		txtContact.setText("");
		lblPartyNo.setText("");
	}
	private String addToQueue()
	{
		String msg = "Booking Number: " + queueCount + " has been made for " 
+ txtContact.getText() + " on " + txtDate.getText() + ".";
		
		
		// add new item and join the queue
		RoomBooking newBk = new RoomBooking();
		
		newBk.setRoomDesc(cmbRoomDesc.getSelectedItem().toString());
		newBk.setContact(txtContact.getText().toString());
		newBk.setBookingDate(txtDate.getText().toString());
		newBk.setBookingTime(txtTime.getText().toString());
		queueCount++;
		currBookings.join(newBk);
		
		return msg;
	}

}

