package proj.main.admin;

import proj.main.report.Report;
import proj.main.user.*;


import java.util.Scanner;

import pojo.TripPOJO;



public class AdminController{
	
	private Scanner in;
	boolean mainFlag=true;
	
	AdminServices adminService=new AdminServices();
	
	public AdminController(Scanner in){
		
		this.in=in;
	}
	
	public void startAdminOperations(){
		
		do{
			int pressed=0;
			
			System.out.println("CHOOSE\n1.VIEW TRIPS\n2.ADD\n3.Edit \n4.ViewBooked Trips\n5.REPORT\n6.GO back");
			try{
				pressed=Integer.parseInt(in.nextLine());
				
			}catch(Exception e){
				System.out.println("ERROR"+e.getMessage());
				}
			switch(pressed)
			{
			
			case 1: String sql="SELECT * FROM trips WHERE destination IS NOT NULL";
			
					try{
							UserServices userService1= new UserServices();
							userService1.viewTrips(sql);
						}catch(Exception e)
						{
							System.out.println("ERROR"+e.getMessage());
						}
						break;
					
			
			case 2:
					TripPOJO tripPojo = new TripPOJO();
					System.out.println("Enter Package name :");
					tripPojo.setPackage_name(in.nextLine());
					System.out.println("Enter Package id :");
					tripPojo.setPackage_id(Integer.parseInt(in.nextLine()));
					System.out.println("Enter source :");
					tripPojo.setSource(in.nextLine());
					System.out.println("Enter destination :");
					tripPojo.setDestination(in.nextLine());
					System.out.println("Enter departure date  :");
					tripPojo.setDeparture_date(in.nextLine());
					System.out.println("Enter hotel name :");
					tripPojo.setHotel_name(in.nextLine());
					System.out.println("Enter no. of nights :");
					tripPojo.setNo_of_nights(Integer.parseInt(in.nextLine()));
					System.out.println("Enter mode of transport :");
					tripPojo.setMode_of_transport(in.nextLine());
					System.out.println("Enter Trip Description :");
					tripPojo.setPackage_name(in.nextLine());
					System.out.println("Enter Price of Package :");
					tripPojo.setPackage_id(Integer.parseInt(in.nextLine()));
					System.out.println("Enter Discount :");
					tripPojo.setDiscount(Integer.parseInt(in.nextLine()));
					try {
						AdminServices adminServices =new AdminServices();
						adminServices.insertTrips(tripPojo);
					} catch (Exception e) {
						System.out.println(e);
					}
					break;	
	/*		case 3:
				try{
					TripPOJO tripPojo = new TripPOJO();
					System.out.println("Enter Package id :");
					tripPojo.setPackage_name(in.next());
					adminService.deleteTrips(tripPojo);
					} catch (Exception e) {
						System.out.println(e);
					}break;		
		*/			 
			case 4:		try{
							AdminServices adminServices1 =new AdminServices();
					
							adminServices1.viewBooking();
						} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}break;
					
			case 5:Report rep=new Report();
					rep.reportGen();
					System.out.println("REPORT CREATED");
				
			case 6:
					mainFlag=false;
					break;

			default:
				System.out.println("WRONG KEY PRESSED");
				break;		
			}
			
			
		}while(mainFlag);
	}
	
	
}
