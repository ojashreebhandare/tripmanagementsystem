package proj.main.admin;
import pojo.*;
import proj.dbconnctor.*;
import java.sql.*;

public class AdminServices
{
	
	private ConnectionProvider dbConnector;
	public AdminServices()
	{
		dbConnector=ConnectionProvider.getInstance();
	
	}
	
	
	public void viewBooking() throws Exception
	{
		try
		{	
			ResultSet allBookingResultSet = dbConnector.selectQuery("SELECT * FROM ticket");
			if(allBookingResultSet==null)
				System.out.println("NULLLLLLLLLLLLLLLLLLLL");
			
			while(allBookingResultSet.next())
			{	
				System.out.println("\nPackageID.: " + allBookingResultSet.getInt("package_id"));
				System.out.println("UserID: " + allBookingResultSet.getInt("user_id"));
				System.out.println("TICKET date: " + allBookingResultSet.getInt("ticket_date"));
				System.out.println("Ticket no.: " + allBookingResultSet.getInt("ticket_no"));
			}
			/*	
			while (allBookingResultSet.next()) 
			{
			
				System.out.println("\nPackageNo.: " + allTripsResultSet.getInt("package_id"));
				System.out.println("Package Name: " + allTripsResultSet.getString("package_name"));
				System.out.println("Source: " + allTripsResultSet.getString("source"));
				System.out.println("Destination: " + allTripsResultSet.getString("destination"));
				System.out.println("Departure Date:" + allTripsResultSet.getString("departure_date"));
				System.out.println("HOTEL: " + allTripsResultSet.getString("hotel_name"));
				System.out.println("NO.OF Nights: " + allTripsResultSet.getInt("no_of_nights"));
				System.out.println("Mode of Transportation: " + allTripsResultSet.getString("mode_of_transport"));
				System.out.println("Description: " + allTripsResultSet.getString("trip_desc"));
				System.out.println("Cost: " + allTripsResultSet.getInt("package_cost"));
				System.out.println("Discount: " + allTripsResultSet.getInt("discount"));
				
			
			}*/
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void insertTrips(TripPOJO tripPOJO)throws Exception
	{
		try{
			int resultCount=dbConnector.insert("INSERT INTO trips(package_id,package_name,source,destination,departure_date,hotel_name,no_of_nights,mode_of_transport,trip_desc,package_cost,discount)"
					+ " VALUES('"+tripPOJO.getPackage_id()+"','"+tripPOJO.getPackage_name()+"',"
							+ "'"+tripPOJO.getSource()+"','"+tripPOJO.getDestination()+"','"+tripPOJO.getDeparture_date()+"',"
									+ "'"+tripPOJO.getHotel_name()+"','"+tripPOJO.getNo_of_nights()+"','"+tripPOJO.getMode_of_transport()+"'"
											+ ",'"+tripPOJO.getTrip_desc()+"','"+tripPOJO.getPackage_cost()+"'"
													+ ",'"+tripPOJO.getDiscount()+ "')");
			if (resultCount > 0)
				System.out.println("Record Inserted Successfully");
			else
				System.out.println("Error Inserting Record Please Try Again");
		
		}catch(SQLException e){
			System.out.println(e);
		}
		
	}/*
	public void updateTrips(TripPOJO tripPOJO) throws SQLException {
		try{


			int resultCount= dbConnector.update("UPDATE trips set package_name = '"+tripPOJO.getPackage_name()+"', "
					+ "source = '"+tripPOJO.getSource()+"', destination = '"+tripPOJO.getDestination()+"',departure_date = '"+tripPOJO.getDeparture_date()+"', "
					+ "hotel_name='"+tripPOJO.getHotel_name()+"', no_of_nights='"+tripPOJO.getNo_of_nights()+"', mode_of_transport='"+tripPOJO.getMode_of_transport()+"', "
					+ "trip_desc='"+tripPOJO.getTrip_desc()+"', package_cost='"+tripPOJO.getPackage_cost()+"', discount='"+tripPOJO.getDiscount()+"' "
					+ "where package_id = '"+tripPOJO.getPackage_id()+"' ");


			if (resultCount > 0)
				System.out.println("Record Updated Successfully");
			else
				System.out.println("Error Upting Record Please Try Again");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}



	public void deleteTrips(TripPOJO tripPOJO) {
		{
			try{
				int resultCount=dbConnector.delete("DELETE FROM trips " + "WHERE package_id = '"+tripPOJO.getPackage_id()+"'");
				if(resultCount > 0){
					System.out.println("Record Deleted Successfully");
				}	else{
					System.out.println("Error Deleting Record Please Try Again");
				}}
			catch(SQLException e){
				System.out.println(e);
			}

		}

	}
*/
}
