package priorityList;

public class TicketReq {
	
	private String name, email, telNo,dateOfRequest;
	private int loyaltyPoints, noTicketsRequested, noAllocated;
	
	public TicketReq(String name, String email, String telNo,
			String dateOfRequest, int loyaltyPoints, int noTicketsRequested,
			int noAllocated) 
	{
		this.name = name;
		this.email = email;
		this.telNo = telNo;
		this.dateOfRequest = dateOfRequest;
		this.loyaltyPoints = loyaltyPoints;
		this.noTicketsRequested = noTicketsRequested;
		this.noAllocated = noAllocated;
	}
	
	public TicketReq() 
	{
		this.name = "";
		this.email = "";
		this.telNo = "";
		this.dateOfRequest = "";
		this.loyaltyPoints = 0;
		this.noTicketsRequested = 0;
		this.noAllocated = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public int getNoTicketsRequested() {
		return noTicketsRequested;
	}

	public void setNoTicketsRequested(int noTicketsRequested) {
		this.noTicketsRequested = noTicketsRequested;
	}

	public int getNoAllocated() {
		return noAllocated;
	}

	public void setNoAllocated(int noAllocated) {
		this.noAllocated = noAllocated;
	}

	
	public String toString() {
		return "TicketReq [name=" + name + ", email=" + email + ", telNo="
				+ telNo + ", dateOfRequest=" + dateOfRequest
				+ ", loyaltyPoints=" + loyaltyPoints + ", noTicketsRequested="
				+ noTicketsRequested + ", noAllocated=" + noAllocated + "]";
	}
	

}
