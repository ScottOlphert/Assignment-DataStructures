package roombookingTest;

public class Queue {
	ListNode front=null;
	ListNode rear=null;
	
	Queue()
	{
		front=null;
		rear=null;
	}
	
	public void join (RoomBooking newBooking)
	{
		ListNode current = new ListNode(newBooking);
		if(front==null)
		{
			rear=current;
			front=current;
		}
		else
		{
			rear.setLink(current);
			rear = current;
		}
	}
	
	public void leave ()
	{
		ListNode current;
		current = front;
		front = front.getLink();
		current=null;
	}
	
	public RoomBooking itemAtFront()
	{
		return front.getRBook();
	}
	
	public String display()
	{
		ListNode current = front;
		String s="";
		while(current != null)
		{
			s += current.getRBook().toString();
			current=current.getLink();
		}
		return s;
	}
	
	public boolean empty()
	{
		if(front==null)
			return true;
		else
			return false;
	}
	
}


