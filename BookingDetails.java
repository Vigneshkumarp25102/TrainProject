
public class BookingDetails {
	private String trainNo;
	private int bookingId;
	private String passengerName;
	private int passengerSeats;
	
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerSeats() {
		return passengerSeats;
	}
	public void setPassengerSeats(int passengerSeats) {
		this.passengerSeats = passengerSeats;
	}
	
	public BookingDetails(String trainNo,int bookingId, String passengerName, int passengerSeats) {
		super();
		this.trainNo = trainNo;
		this.bookingId = bookingId;
		this.passengerName = passengerName;
		this.passengerSeats = passengerSeats;
	}
	
	public String toString() {
		return String.format("BookingDetails{trainNo='%s',bookingId=%d,passengerName='%s',passengerSeats=%d}",
				trainNo,bookingId,passengerName,passengerSeats);
	}

}
