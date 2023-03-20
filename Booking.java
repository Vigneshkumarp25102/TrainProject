import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trains.Train;
import trains.TrainDetails;

public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BookingDetails> BookingDetailsList = new ArrayList<>();
	public Train train;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		if(true) {
		String trainNo = request.getParameter("trainNo");
		int bookingId = Integer.valueOf(request.getParameter("bookingId"));
		String passengerName = request.getParameter("passengerName");
	    int passengerSeats = Integer.valueOf(request.getParameter("passengerSeats"));
	    BookingDetails bookingDetails = new BookingDetails(trainNo,bookingId,passengerName,passengerSeats);
	    BookingDetailsList.add(bookingDetails);
	    
//		for (TrainDetails trainsList : train.getList()) {
//			if (trainsList.getTrainNo() == trainNo) {
//				int a = trainsList.getTrainSeats();
//				trainsList.setTrainSeats(a-passengerSeats);
//			}
//		}
	    }
	}
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String path = request.getPathInfo();
		if (path == null) {
			response.setContentType("application/json");
			response.getWriter().println(BookingDetailsList.toString());
		}
		else {
		    int bookingId = Integer.valueOf(request.getParameter("bookingId"));
			String passengerName = request.getParameter("passengerName");
			for (BookingDetails booking : BookingDetailsList) {
				if (booking.getBookingId() == bookingId && booking.getPassengerName() == passengerName ) {
					response.setContentType("application/json");
					response.getWriter().println(booking.toString());
				}
			}
		}
	}
}
