package proj.main.user;

import java.util.Scanner;

import pojo.UserPOJO;

public class UserController {

	private Scanner in;
	boolean mainFlag = true;
	private UserPOJO userPOJO;
	UserServices userService = new UserServices();

	public UserController(Scanner in, UserPOJO userPOJO) {
		this.userPOJO = userPOJO;
		this.in = in;
	}

	public void startUserOperations() {

		do {
			int choice = 0;

			System.out.println(
					"CHOOSE\n1.VIEW TRIPS\n2.SEARCH\n3.Edit Details\n4.Book TICKET\n5.VIEW BOOKED TRIPS\n6.GO back");
			try {
				choice = Integer.parseInt(in.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("ERROR" + e.getMessage());
			}
			switch (choice) {

			case 1:
				System.out.println("VIEW TRIPS\nSORT BY\n1.Price\n2.Discount\n3.BEST DEALS\n6.GO back");
				int press = Integer.parseInt(in.nextLine());
				switch (press) {
				case 1:
					String sql1 = "SELECT * FROM trips ORDER BY package_cost";
					try {
						UserServices userService1 = new UserServices();
						userService1.viewTrips(sql1);
					} catch (Exception e) {
						System.out.println("ERROR" + e.getMessage());
					}
					break;
				case 2:
					String sql2 = "SELECT * FROM trips ORDER BY discount DESC";
					try {
						UserServices userService1 = new UserServices();
						userService1.viewTrips(sql2);
					} catch (Exception e) {
						System.out.println("ERROR" + e.getMessage());
					}
					break;
				case 3:
					String sql3 = "SELECT * FROM trips WHERE destination IS NOT NULL";
					try {
						UserServices userService1 = new UserServices();
						userService1.viewTrips(sql3);
					} catch (Exception e) {
						System.out.println("ERROR" + e.getMessage());
					}
					break;

				default:
					System.out.println("WRONG KEY PRESSED");
					break;
				}

				/*
				 * try{ UserServices userService1= new UserServices();
				 * userService1.viewTrips(); }catch(Exception e) {
				 * System.out.println("ERROR"+e.getMessage()); }
				 */
				break;

			case 2:
				System.out.println("VIEW TRIPS\nSORT BY\n1.des\n2.keyword");
				int press2 = Integer.parseInt(in.nextLine());
				switch (press2) {

				case 1:
					System.out.println("Enter Destination no to be searched:");
					String inDestination = in.nextLine();
					System.out.println("Enter Date to be searched:");
					String inDate = in.nextLine();
					System.out.println("Enter budget to be searched:");
					String inPrice = in.nextLine();
					UserServices userService2 = new UserServices();
					userService2.searchTrips(inDestination, inDate, inPrice);
					break;

				case 2:
					System.out.println("Enter Searching Keyword no to be searched:");
					String keyword1 = in.nextLine();

					UserServices userService3 = new UserServices();
					userService3.searchKeyword(keyword1);
					break;
				default:
					System.out.println("WRONG KEY PRESSED");
					break;
				}
				break;

			case 4:
				System.out.println("WHICH TRIP YOU WANT TO BOOK????\nEnter package ID");
				int inPackageID = Integer.parseInt(in.nextLine());
				UserServices userServices3 = new UserServices();
				userServices3.bookTicket(inPackageID, userPOJO.getUser_id());
				//Email email=new Email();
				//email.emailSend();
				break;
			case 5:
				UserServices userServices4 = new UserServices();
				userServices4.viewUserTicket(userPOJO.getUser_id());
				break;

			case 6:
				mainFlag = false;
				break;
			default:
				System.out.println("WRONG KEY PRESSED");
				break;
			}

		} while (mainFlag);
	}

}
