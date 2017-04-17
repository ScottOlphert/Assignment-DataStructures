package priorityList;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GB 
{

	public void add(Container Con, Component c, int x, int y, int width, int height, int Weightx, int weighty)
	{
		Font all = new Font("Calibri", Font.BOLD,18); // Create a font to use as default

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


