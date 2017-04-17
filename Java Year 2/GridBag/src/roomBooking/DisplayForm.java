package roomBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;



public class DisplayForm extends JFrame implements ActionListener
{
	private Container CN;
	private JLabel lblHeader;
	private JTextArea txtDisplay;
	private JScrollPane jsp;
	private JButton btnDisplay, btnExit;
	private RoomBooking [] bks = new RoomBooking [10];
	
	public DisplayForm (RoomBooking [] local)
	{
		
		bks = local;
		
		CN = getContentPane();
		CN.setLayout(null);
		
		lblHeader = new JLabel("Bookings");
		lblHeader.setBounds(20,20,200,50);
		
		txtDisplay = new JTextArea();
		//txtDisplay.setBounds(20,90,300,300);
		
		jsp = new JScrollPane(txtDisplay);
		jsp.setBounds(20,90,350,350);
		
		btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(this);
		btnDisplay.setBounds(20,460,100,50);
		btnExit = new JButton("Exit");
		btnExit.setBounds(140,460,100,50);
		
		CN.add(lblHeader);
		CN.add(jsp);
		CN.add(btnDisplay);
		CN.add(btnExit);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== btnDisplay)
		{
			try
			{
				for(int x = 0; x < bks.length; x++)
				{
					txtDisplay.append(bks[x].toString());
				}
			}
			catch(NullPointerException np)
			{
				JOptionPane.showMessageDialog(null, "All Items Printed");
			}
		}
		
	}
	
	/*public static void main(String[] args) 
	{    
       
		DisplayForm frm = new DisplayForm();     
		frm.setSize(390, 570);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }*/
	
	
}