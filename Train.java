package trains;
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


public class Train extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<TrainDetails> trainDetailsList;
	
	public Train() {
	trainDetailsList = new ArrayList<>();
	}
	public List<TrainDetails> getList(){
		return trainDetailsList;
	}
//	private List<BookingDetails> BookingDetailsList = new ArrayList<>();


	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String trainNo = request.getParameter("trainNo");
		String trainName = request.getParameter("trainName");
	    int trainSeats = Integer.valueOf(request.getParameter("trainSeats"));
	    TrainDetails trainDetails = new TrainDetails(trainNo,trainName,trainSeats);
	    trainDetailsList.add(trainDetails);
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    BufferedReader reader = request.getReader();
//	    StringBuilder sb = new StringBuilder();
//	    String line;
//	    while ((line = reader.readLine()) != null) {
//	        sb.append(line);
//	    }
//	    String json = sb.toString();
//	    try {
//		JSONObject jsonObject = new JSONObject(json);
//	    String trainNo = jsonObject.getString("trainNo");
//	    String trainName = jsonObject.getString("trainName");
//	    int trainSeats = jsonObject.getInt("trainSeats");
//	    TrainDetails trainDetails = new TrainDetails(trainNo, trainName, trainSeats);
//	    trainDetailsList.add(trainDetails);
//}		catch(Exception e) {
//		System.out.print(e);
//	    }
//	    response.setStatus(HttpServletResponse.SC_CREATED);
//	    response.getWriter().println("Train details added successfully.");
//	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//
//        JSONObject jsonObject;
//        String trainNo;
//        String trainName;
//        int trainSeats;
//		try {
//			jsonObject = new JSONObject(sb.toString());
//			trainNo = jsonObject.getString("trainNo");
//			trainName = jsonObject.getString("trainName");
//			trainSeats = jsonObject.getInt("trainSeats");
//			TrainDetails trainDetails = new TrainDetails(trainNo, trainName, trainSeats);
//	        trainDetailsList.add(trainDetails);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}    
//    }
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String path = request.getPathInfo();

		if (path == null) {
			response.setContentType("application/json");
			response.getWriter().println(trainDetailsList.toString());
		}
		else {
			String trainNo = request.getParameter("trainNo");
			String trainName = request.getParameter("trainName");
			for (TrainDetails trains : trainDetailsList) {
				if (trains.getTrainNo() == trainNo || trains.getTrainName() == trainName ) {
					response.setContentType("application/json");
					response.getWriter().println(trains.toString());
				}
			}
		}
	}
}
