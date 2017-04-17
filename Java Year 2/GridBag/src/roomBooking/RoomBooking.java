package roomBooking;

public class RoomBooking {
	private String roomDesc, contact, bookingDate, bookingTime;

	public RoomBooking()
	{
		this.roomDesc="";this.contact="";this.bookingDate= "";this.bookingTime= "";
	}

	public RoomBooking(String roomDesc, String contact, String bookingDate, String bookingTime)
	{
		this.roomDesc=roomDesc;
		
		this.contact=contact;
		
		this.bookingDate=bookingDate;
		
		this.bookingTime=bookingTime;
	}

	public String getRoomDesc() 
	{
		return roomDesc;
	}
	
	public void setRoomDesc(String roomDesc) 
	{
		this.roomDesc = roomDesc;
	}
	
	public String getContact() 
	{
		return contact;
	}
	
	public void setContact(String contact) throws BookingException
	{
		if(contact.length()<= 3)
			throw new BookingException("Contact name must be creater than 3 characters");
		else
			this.contact = contact;
	}
	
	public String getBookingDate() 
	{
		return bookingDate;
	}
	
	public void setBookingDate(String bookingDate) 
	{
		this.bookingDate = bookingDate;
	}
	
	public String getBookingTime() 
	{
		return bookingTime;
	}
	
	public void setBookingTime(String bookingTime) 
	{
		this.bookingTime = bookingTime;
	}

	public String toString()
	{
		String str="";
		str = String.format(" %-15s           %-10s   %-10s   %-20s\n", 
				this.roomDesc, this.bookingDate, this.bookingTime, this.contact);

		return str;
	}


}


