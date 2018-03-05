package proj.mainApp;

import java.io.IOException;
import java.util.Scanner;

import proj.main.admin.AdminController;
import proj.main.user.UserController;

public class MainApp {

	public static void main(String arr[]) throws IOException {

		boolean mainFlag = true;
		Scanner in = new Scanner(System.in);
		System.out.println("WELCOME TO TRIP MANAGEMNT");
		do {
			int choice = 0;

			System.out.println("CHOOSE \n1.User\n2.ADmin");
			try {

				choice = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(e);
			}
			switch (choice) {

			case 1:
				Login login1 = new Login();
				if (login1.userLogin()) {
					UserController user = new UserController(in, login1.getUserPOJO());
					user.startUserOperations();
					break;
				} else {
					System.out.println("LOGIN FAILED");
				}
				break;

			case 2:
				Login login2 = new Login();
				boolean loginFlag2 = login2.adminLogin();
				if (loginFlag2 == true) {
					AdminController admin = new AdminController(in);
					admin.startAdminOperations();
					break;
				} else {
					System.out.println("LOGIN FAILED");
				}
				break;

			case 3:
				mainFlag = false;
				break;

			default:
				System.out.println("WRONG KEY PRESSED");
				break;

			}

		} while (mainFlag);
		System.out.println("END");

		in.close();
	}
}