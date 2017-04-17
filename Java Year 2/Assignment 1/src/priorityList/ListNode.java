package priorityList;

public class ListNode {
	private TicketReq reqDetails;
	private ListNode link;

	public ListNode(TicketReq reqDetails) {

		this.reqDetails = reqDetails;
		this.link = null;
	}

	public TicketReq getReqDetails() {
		return reqDetails;
	}

	public void setReqDetails(TicketReq reqDetails) {
		this.reqDetails = reqDetails;
	}

	public ListNode getLink() {
		return link;
	}

	public void setLink(ListNode link) {
		this.link = link;
	}
	
}
