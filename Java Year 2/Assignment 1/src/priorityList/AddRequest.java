package priorityList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddRequest extends JFrame implements ActionListener {

	private Container cn; 
	private JLabel lblTitle,lblName,lblEmail,lblDate,lblTelNo,lblReq,
	buf,buf1,buf2,buf3,buf4,buf5;
	private JPanel p1, p2, p3, p4, p5;
	private JTextField name, email, telNo, day, year;
	private JComboBox<?> month, ticketNo; 
	private JButton reset, add, exit;


	public AddRequest()
	{
		cn = getContentPane();
		cn.setLayout(new GridBagLayout());
		cn.setBackground(Color.decode("#4C9900"));
		cn.setForeground(Color.WHITE);

		p1 = new JPanel(new GridBagLayout());
		p1.setBackground(Color.decode("#4C9900"));
		p2 = new JPanel(new GridBagLayout());
		p2.setBackground(Color.decode("#4C9900"));
		p3 = new JPanel(new GridBagLayout());
		p3.setBackground(Color.decode("#4C9900"));
		p4 = new JPanel(new GridBagLayout());
		p4.setBackground(Color.decode("#4C9900"));
		p5 = new JPanel(new GridBagLayout());
		p5.setBackground(Color.decode("#4C9900"));

		lblTitle = new JLabel("<html><u>--Submit Request--</u></html>",JLabel.CENTER);
		lblTitle.setFont(new Font("Arial",Font.BOLD,20));
		lblTitle.setForeground(Color.white);
		lblName = new JLabel("Name:",JLabel.LEFT);
		lblName.setForeground(Color.WHITE);
		lblEmail = new JLabel("Email:", JLabel.LEFT);
		lblEmail.setForeground(Color.WHITE);
		lblTelNo = new JLabel("Phone:", JLabel.LEFT);
		lblTelNo.setForeground(Color.WHITE);
		lblDate = new JLabel("Member Start Date:", JLabel.LEFT);
		lblDate.setForeground(Color.WHITE);
		lblReq = new JLabel("Tickets Wanted:", JLabel.LEFT);
		lblReq.setForeground(Color.WHITE);

		buf = new JLabel("    ");		
		buf1 = new JLabel("    ");
		buf2 = new JLabel("    ");
		buf3 = new JLabel("    ");
		buf4 = new JLabel("    ");
		

		

		name = new JTextField();
		email = new JTextField();
		telNo = new JTextField();

		day = new JTextField();
		day.setText("--Day--");
		day.setFont(new Font("Arial", Font.PLAIN,14));
		String [] months = {"--Month--","January", "February", "March", "April", "May", "June","July","August","Septemner","October","November","December"};
		month = new JComboBox(months);
		month.setFont(new Font("Arial", Font.PLAIN,14));
		month.setBackground(Color.WHITE);
		year = new JTextField();
		year.setFont(new Font("Arial", Font.PLAIN,14));
		year.setText("--Year--");

		String [] tickets = {"--Select--","1","2","3","4"};
		ticketNo = new JComboBox(tickets);
		ticketNo.setBackground(Color.WHITE);

		reset = new JButton("Clear");
		reset.setBackground(Color.white);
		reset.addActionListener(this);
		add = new JButton("Submit");
		add.setBackground(Color.white);
		add.addActionListener(this);
		exit = new JButton("Close");
		exit.setBackground(Color.white);
		exit.addActionListener(this);



		addComp(p1,lblTitle,1,0,1,1,1,0);
		//addComp(p1,buf,0,0,1,1,0,0);
		//addComp(p1,buf1,2,0,1,1,0,0);

		addComp(p2,buf,0,0,1,1,0,0);
		addComp(p2,lblName,1,0,1,1,0,0);
		addComp(p2,buf1,5,0,1,1,0,0);
		addComp(p2,name,1,1,4,1,3,0);
		addComp(p2,lblEmail,1,2,1,1,0,0);
		addComp(p2,email,1,3,4,1,3,0);
		addComp(p2,lblTelNo,1,4,1,1,0,0);
		addComp(p2,telNo,1,5,4,1,3,0);
		addComp(p2,lblDate,1,6,1,1,0,0);
		addComp(p2,month,1,7,2,1,1,0);
		addComp(p2,day,3,7,1,1,1,0);
		addComp(p2,year,4,7,1,1,1,0);
		addComp(p2,lblReq,1,8,1,1,0,0);
		addComp(p2,ticketNo,1,9,2,1,1,0);
		addComp(p2,reset,1,10,1,1,1,0);
		addComp(p2,add,4,10,1,1,1,0);
		
		addComp(p3,buf2,0,0,1,1,0,1);
		addComp(p3,buf3,0,1,1,1,0,0);
		addComp(p3,exit,1,1,4,1,1,0);
		addComp(p3,buf4,5,1,1,1,0,0);
		addComp(p3,buf3,0,2,1,1,0,1);
		
		addComp(cn,p1,0,0,1,1,1,0);
		addComp(cn,p2,0,1,1,1,1,0);
		addComp(cn,p3,0,2,1,1,1,1);
	}


	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== exit);
		{
			
			this.setVisible(false);
		}

	}

	// Method used to add component to the container and declare constraints
	private void addComp(Container Con, Component c, int x, int y, int width, int height, int Weightx, int weighty)
	{
		Font all = new Font("Arial", Font.BOLD,16); // Create a font to use as default

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
		Con.add(c, gc);

	} 

}
