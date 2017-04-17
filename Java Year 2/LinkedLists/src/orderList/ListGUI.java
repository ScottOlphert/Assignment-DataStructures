package orderList;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class ListGUI extends JFrame implements ActionListener {
	private JButton btnAdd, btnRemove, btnSearch, btnExit;
	private JLabel lblHeading, lblStack, lblPosition, lblRemoved, lblPosLabel;
	private JTextField txtAdd, txtRemove, txtSearch;
	private JTextArea taStack;
	private OrderList myNos = new OrderList();
	// object to represent the path of the file
	//private File out;
	// object to allow moving through the file + read/write
	//private RandomAccessFile rd;

	public static void main(String[] args) throws IOException{
		ListGUI fStack = new ListGUI();
		fStack.setTitle("Show List");
		fStack.setSize(350, 350);
		fStack.setLocation(400, 200);
		fStack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fStack.setVisible(true);

	}

	// Constructor
	public ListGUI()throws IOException
	{
		// fetch the form's container & use Absolute Manager
		Container cn;
		cn = getContentPane();
		cn.setLayout(null);

		// add components to the container
		lblHeading = new JLabel("Using the Ordered List");
		lblHeading.setBounds(10, 20, 200, 30);
		cn.add(lblHeading);

		lblStack = new JLabel("List");
		lblStack.setBounds(230, 50, 60, 30);
		cn.add(lblStack);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 80, 80, 30);
		btnAdd.addActionListener(this);
		cn.add(btnAdd);

		txtAdd = new JTextField();
		txtAdd.setBounds(120, 80, 60, 30);
		cn.add(txtAdd);

		taStack = new JTextArea();
		taStack.setBounds(230, 80, 60, 120);
		cn.add(taStack);

		btnRemove = new JButton("Remove");
		btnRemove.setBounds(10, 120, 80, 30);
		btnRemove.addActionListener(this);
		cn.add(btnRemove);

		txtRemove = new JTextField();
		txtRemove.setBounds(120, 120, 60, 30);
		cn.add(txtRemove);

		lblRemoved = new JLabel(" ");
		lblRemoved.setBounds(120, 120, 60, 30);
		cn.add(lblRemoved);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(10, 160, 80, 30);
		btnSearch.addActionListener(this);
		cn.add(btnSearch);

		txtSearch = new JTextField();
		txtSearch.setBounds(120, 160, 60, 30);
		cn.add(txtSearch);

		lblPosLabel = new JLabel("Position",  JLabel.RIGHT);
		lblPosLabel.setBounds(10, 200, 60, 30);
		cn.add(lblPosLabel);

		lblPosition = new JLabel(" ",  JLabel.CENTER);
		lblPosition.setBounds(100, 200, 60, 30);
		cn.add(lblPosition);

		btnExit = new JButton("Exit");
		btnExit.setBounds(100, 250, 100, 30);
		btnExit.addActionListener(this);
		cn.add(btnExit);

		/*try
		{
			// path of the output file
			out = new File ("Requests.dat");
			// file to use + type r - read only. rw - read/write
			rd = new RandomAccessFile(out,"rw");

			if ( rd.length()>0)
			{  
				boolean eof = false;
				do
				{
					try
					{
						// read next int and add it to list
						myNos.add(rd.readInt());
					}
					// EOF exception thrown when end of file
					catch( EOFException e1)
					{
						eof =true;
					}

				}while ( !eof);

				rd.close();
			}
			else
				JOptionPane.showMessageDialog(null, "No Records Loaded");
		}
		// general exception when trying to access the file
		catch(IOException ex2)
		{
			JOptionPane.showMessageDialog(null, "Cannot Open File");
		}
		refreshList();*/
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd)
		{


			// exception handler to trap number exceptions
			try
			{
				int no = Integer.parseInt(txtAdd.getText());
				myNos.add(no);
				refreshList();
			}
			catch (NumberFormatException numEx)
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
			}

			txtAdd.setText("");
			txtAdd.requestFocus();
		}
		if(e.getSource() == btnRemove)
		{
			if(myNos.empty()==false)
			{
				// trap number exceptions and if item doesn't exist
				try
				{
					int no = Integer.parseInt(txtRemove.getText());
					lblRemoved.setText("" + no);
					myNos.remove(no);
					refreshList();
				}
				catch (NumberFormatException numEx)
				{
					JOptionPane.showMessageDialog(null, "Invalid number");
				}
				catch (NullPointerException npEx)
				{
					JOptionPane.showMessageDialog(null, "Not in the list");
				}
				// clear text field and put cursor back in it
				txtRemove.setText("");
				txtRemove.requestFocus();
			}

		}
		/*if(e.getSource() == btnSearch)
		{
			int no=0, position=0;
			// trap number format exceptions
			try
			{
				no = Integer.parseInt(txtSearch.getText());
				String suffix;
				position = myNos.search(no);
				// if the item has been found
				if(position != -1) 
				{
					// add suffix such as st, nd, rd
					switch(position)
					{
					case 1 : case 21 : case 31 : case 41 : suffix="st"; break;
					case 2 : case 22 : case 32 : case 42 :	suffix="nd"; break;
					case 3 : case 23 : case 33 : case 43 : suffix="rd"; break;
					default :
						suffix="th";

					}
					lblPosition.setText("" + position + suffix);
				}


else
					lblPosition.setText("Not Listed");
			}
			catch (NumberFormatException numEx)
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid number");
			}

		}*/
		if(e.getSource() == btnExit)
		{
			// send list to dat file
			/*try
			{
				out=new File ("Requests.dat"); 
				rd= new RandomAccessFile(out,"rw");

				while(myNos.empty()==false)
				{
					int curNo = myNos.peek();
					// write the current number to the file
					rd.writeInt(curNo);
					myNos.remove(curNo);
				}
				rd.close();
			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null, "Need numeric data");
			}
			catch ( IOException ex2)
			{
				JOptionPane.showMessageDialog(null, "Cannot Write to File");
			}
			// close application*/
			System.exit(0);
		}

	}
	// procedure to clear text area and reprint list
	private void refreshList()
	{
		String pList="";
		taStack.setText("");
		pList = myNos.display();
		taStack.append(pList);
	}



}


