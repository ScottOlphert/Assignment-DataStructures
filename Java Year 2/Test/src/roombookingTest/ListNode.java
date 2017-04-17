package roombookingTest;

public class ListNode {
	RoomBooking rBook;
	ListNode link;
	
	//constructors
	ListNode(RoomBooking rBook)
	{
		this.rBook=rBook;
		link=null;
	}

	public RoomBooking getRBook() {
		return rBook;
	}
	
	public void setRBook(RoomBooking book) {
		rBook = book;
	}

	public ListNode getLink() {
		return link;
	}

	public void setLink(ListNode link) {
		this.link = link;
	}
	
}

