package roomBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;



public class AddBooking extends JFrame implements ActionListener
{
	// Declare components
	private JComboBox cmbRoom;
	private JTextField txtDate, txtTime, txtContact ;
	private JLabel lblheading, lblRoom, lblDate, lblTime, lblContact, lblMaxParty, lblConfirmed, lblPartyNo;
	private JButton btnAdd, btnReset, btnExit ;
	private JRadioButton meeting, lecture, tutorial;
	private ButtonGroup Purpose;
	private RoomBooking [] bks = new RoomBooking [10];
	private int count = 0;
	private Container Main;

	Font all = new Font("Calibri", Font.BOLD,14); // Create a font to use as default

	// Method used to add component to the container and declare constraints
	private void addComp(Component c, int x, int y, int width, int height, int Weightx, int weighty)
	{
		// Create instance of constraints
		GridBagConstraints gc = new GridBagConstraints();
		//set constraints
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(5,5,5,5);// sets the space between components 
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.weightx = Weightx;
		gc.weighty = weighty;

		// set the font using the default created above
		c.setFont(all); 

		//add the component to the container
		getContentPane().add(c, gc);

	}


	// Constructor
	public AddBooking(RoomBooking [] local) 
	{

		bks=local;

		// Create the labels
		lblheading = new JLabel("Room Bookings",JLabel.CENTER);
		lblRoom = new JLabel("Room Desc ",JLabel.RIGHT); 
		lblDate = new JLabel("Date ",JLabel.RIGHT);
		lblTime = new JLabel("Time ",JLabel.RIGHT);
		lblContact = new JLabel("Contact ",JLabel.RIGHT);
		lblMaxParty = new JLabel("Max party: ",JLabel.RIGHT);
		lblPartyNo= new JLabel("Max Number",JLabel.LEFT);
		lblConfirmed = new JLabel("Please add booking details",JLabel.CENTER);
		lblConfirmed.setFont(new Font("Calibri", Font.ITALIC,12));

		// array to hold the combo box options
		String [] rooms = {"---Select---","Assembly Hall", "Boardroom", "Conference Room", "Lecture Theatre"};

		// create combo box
		cmbRoom = new JComboBox(rooms); 
		cmbRoom.addActionListener(this);

		// Create the text fields
		txtDate = new JTextField();  
		txtTime  = new JTextField();
		txtContact  = new JTextField();

		// Create the buttons

		btnAdd = new JButton ("Add Item");
		btnAdd.addActionListener(this);
		btnReset = new JButton ("Reset");
		btnReset.addActionListener(this);
		btnExit = new JButton ("Exit");
		btnExit.addActionListener(this);

		meeting = new JRadioButton("Meeting");
		meeting.setActionCommand( meeting.getText());
		lecture = new JRadioButton("Lecture");
		lecture.setActionCommand( lecture.getText());
		tutorial = new JRadioButton("Tutorial");
		tutorial.setActionCommand( tutorial.getText());

		Purpose = new ButtonGroup();
		Purpose.add(meeting);
		Purpose.add(lecture);
		Purpose.add(tutorial);

		Box bPurpose = Box.createVerticalBox();
		bPurpose.add(meeting);
		bPurpose.add(lecture);
		bPurpose.add(tutorial);
		bPurpose.setBorder(BorderFactory.createTitledBorder("Purpose"));

		// Create layout
		getContentPane().setLayout(new GridBagLayout());

		addComp(lblheading,0,0,4,1,1,3);
		addComp(lblRoom,0,1,1,1,0,0);
		addComp(lblDate,0,2,1,1,0,0);
		addComp(lblTime,0,3,1,1,0,0);
		addComp(lblContact,0,4,1,1,0,0);
		addComp(lblMaxParty,0,5,1,1,0,0);
		addComp(lblPartyNo,1,5,1,1,2,1);
		addComp(lblConfirmed,0,6,4,1,1,3);
		addComp(cmbRoom,1,1,2,1,2,1);
		addComp(txtDate,1,2,2,1,2,1);
		addComp(txtTime,1,3,1,1,2,1);
		addComp(txtContact,1,4,1,1,2,1);
		addComp(btnAdd,0,7,2,1,1,1);
		addComp(btnReset,2,7,1,1,1,1);
		addComp(btnExit,3,7,1,1,1,1);
		addComp(bPurpose,2,3,1,2,1,1);

		lblheading.setFont(new Font("Calibri", Font.BOLD,20));






	}

	/*public static void main(String[] args) 
	{    

		AddBooking frm = new AddBooking();     
		frm.setSize(500, 500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(); 
        //Frame.add(AddBooking);
        frm.setVisible(true);
    }*/


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== cmbRoom)
		{
			if(cmbRoom.getSelectedItem().toString()=="---Select---")
			{
				lblConfirmed.setText("Please add booking details");
			}
			else
				lblConfirmed.setText(cmbRoom.getSelectedItem().toString());
		}
		if(e.getSource()== btnAdd)
		{
			if(count <= 10)
			{
				try{
					bks[count] = new RoomBooking();
					bks[count].setRoomDesc(cmbRoom.getSelectedItem().toString());
					bks[count].setBookingDate(txtDate.getText());
					bks[count].setBookingTime(txtTime.getText());
					bks[count].setContact(txtContact.getText());
				}
				catch (BookingException BE)
				{
					JOptionPane.showMessageDialog (null, BE.toString());
				}
				count++;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Array is Full");
			}

			String room = cmbRoom.getSelectedItem().toString();
			String date = txtDate.getText();
			String time = txtTime.getText();
			String contact = txtContact.getText();
			String purpose = Purpose.getSelection().getActionCommand();

			if(meeting.isSelected())
			{
				String Purpose = meeting.getText().toString();
			}
			else if(lecture.isSelected())
			{
				String Purpose = lecture.getText().toString();
			}
			else if(tutorial.isSelected())
			{
				String Purpose = tutorial.getText().toString();
			}

			lblConfirmed.setText("The "+room+" has been booked for the "+date+" at "+time+" by "+contact+" for a "+purpose);

			//Reset();
		}

		if (e.getSource()== btnExit)
		{
			try
			{
				out = new file("Bookings.dat");
				rd = new RandomAccessFile (out, "rw");
				
				//if(out.exists())
				
				while (bookings.itemAtFront()!=null)
				{
					RoomBooking bk = new RoomBooking();
					bk = bookings.itemAtFront();
					rd.writeUTF(bk.getRoomDesc());
					rd.writeUTF(bk.getBookingDate());
					rd.writeUTF(bk.getBookingTime());
					rd.writeUTF(bk.getContact());
					
					bookings.leave();
				}
					rd.close();
			}
			catch (IOException ex)
			{
				JOptionPane.showMessageDialog(null, "Unable to Save");
			}
			
			System.exit(0);
		}

		if (e.getSource()== btnReset)
		{
			Reset();
			lblConfirmed.setText("Please add booking details");
		}


	}

	private void Reset()
	{
		cmbRoom.setSelectedIndex(0);
		txtDate.setText("");
		txtTime.setText("");
		txtContact.setText("");

		Enumeration<AbstractButton> e =Purpose.getElements(); 
		while(e.hasMoreElements()) 
		{
			AbstractButton b = e.nextElement();
			b.setSelected(false);

		}
	}





}
