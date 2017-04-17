package orderList;

public class OrderList {
	
	ListNode start = null;
	ListNode end = null;
	
	OrderList()
	{
		start = null;
		end = null;
	}
	
	public boolean empty()
	{
		if(start==null)
			return true;
		else
			return false;
	}
	
	
	public void add (int num)
	{
		
	ListNode next = new ListNode(num);
	if(empty()==true)
	{
		start=next;
		end=next;
	}
	else
	{
		if(num < start.getNo())
		{
			next.setLink(start);
			start=next;
		}
		else
		{
			if(num>=end.getNo())
			{
				end.setLink(next);
				end=next;
			}
			else
			{
				ListNode prev;
				ListNode curr;
				prev=start;
				curr=start.getLink();
				while(curr.getNo()< next.getNo())
				{
					prev=curr;
					curr=curr.getLink();
				}
				prev.setLink(next);
				next.setLink(curr);
						
			}
		}
	}

	}
	
	public int remove (int num)
	{
		int returnNo = 0;
		ListNode prev, curr;
		
		if(empty()==true)
		{
			returnNo = -1;
		}
		else
		{
			if(num == start.getNo())
			{
				returnNo=num;
				start=start.getLink();
			}
			else
			{
				prev = start;
				curr = start.getLink();
				while(num!=curr.getNo() && curr!=null)
				{
					prev = curr;
					curr = curr.getLink();
				}
				if(curr != null)
				{
					prev.setLink(curr.getLink());
					return num;
				}
				else
				{
					return -2;
				}
			}
			
		}
		return returnNo;
		
	}
	
	public String display()
	{
		String disp="";
		
		ListNode curr = start;
		while(curr!=null)
		{
			disp+=curr.getNo()+"\n";
			curr=curr.getLink();
		}
		return disp;
	}
}
