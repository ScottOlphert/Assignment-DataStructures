package orderList;

public class ListNode {
	int no; // could be any variable type or object
	ListNode link;
	
	//constructors
	ListNode(int no)
	{
		this.no=no;
		link=null;
	}
	//used to return the no. stored in the node
	public int getNo() {
		return no;
	}
	//used to set the no. stored in the node
	public void setNo(int no) {
		this.no = no;
	}
	//used to return the reference to the next node
	public ListNode getLink() {
		return link;
	}
	//used to set the reference to the next node
	public void setLink(ListNode link) {
		this.link = link;
	}
	
	
}

