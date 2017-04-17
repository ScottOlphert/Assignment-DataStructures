package priorityList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Display extends JFrame implements ActionListener {
	
	private Container cn;
	private JLabel title,buf,buf1,buf2,buf3;
	private JPanel north, south;
	private JScrollPane jsp;
	private JTextArea list;
	private JButton exit;
	
	public Display()
	{
		cn = getContentPane();
		cn.setLayout(new GridBagLayout());
		cn.setBackground(Color.decode("#4C9900"));
		
		north = new JPanel(new GridBagLayout());
		north.setBackground(Color.decode("#4C9900"));
		
		south = new JPanel(new GridBagLayout());
		south.setBackground(Color.decode("#4C9900"));
		
		title = new JLabel("<html><u>--Priority List--</u></html>",JLabel.CENTER);
		title.setFont(new Font("Arial",Font.BOLD,20));
		title.setForeground(Color.white);
		buf = new JLabel("");
		buf1 = new JLabel("");
		buf2 = new JLabel("");
		buf3 = new JLabel("");
		
		list = new JTextArea();
		list.setEditable(false);
		list.setBackground(Color.WHITE);
		list.setText("");
		
		jsp = new JScrollPane(list);
		jsp.setBackground(Color.WHITE);
		
		exit = new JButton("Close");
		exit.setBackground(Color.WHITE);
		exit.addActionListener(this);
		
		addComp(north,title,1,0,1,1,0,0);
		addComp(north,buf,0,0,1,1,1,0);
		addComp(north,buf1,2,0,1,1,1,0);
		addComp(cn,north,0,0,3,1,0,0);
		addComp(cn,list,0,1,3,1,1,1);
		addComp(cn,south,0,2,3,1,0,0);
		addComp(south,exit,2,0,1,1,0,0);
		addComp(south,buf2,0,0,1,1,1,0);
		addComp(south,buf3,1,0,1,1,1,0);
		
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== exit);
		{
			list.setText("");
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
