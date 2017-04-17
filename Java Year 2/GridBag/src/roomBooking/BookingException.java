package roomBooking;

public class BookingException extends Exception 
{
	private String message;
	
	BookingException(String msg)
	{
		message = msg;
	}
	
	public String toString()
	{
		return "Booking exception: " + message;
	}

}
