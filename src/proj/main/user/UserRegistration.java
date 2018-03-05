package proj.main.user;
import pojo.*;
import proj.dbconnctor.*;
import java.sql.*;

public class UserRegistration
{
	private ConnectionProvider dbConnector;
	public UserRegistration()
	{
		dbConnector=ConnectionProvider.getInstance();

	}
	public void insertUserDetails(UserPOJO userPojo) throws Exception
	{
		try{

			int resultCount = dbConnector.insert(" insert into tbl2 (user_fname, user_lname, user_gender, user_emailid, user_address,user_city, user_country, user_login_id,user_password, user_id,user_bdate, user_contact)"
					+ " values ('"+userPojo.getUser_fname()+"','"+userPojo.getUser_lname()+"','"+userPojo.getUser_gender()+"','"
					+"'"+userPojo.getUser_emailid()+"','"+userPojo.getUser_address()+"','"+userPojo.getUser_city()+"','"+userPojo.getUser_country()+"','"+userPojo.getUser_login_id()+"','"
					+"'"+userPojo.getUser_password()+"','"+userPojo.getUser_id()+"','"+userPojo.getUser_bdate()+"','"+userPojo.getUser_contact()+"')");


			if (resultCount > 0)
				System.out.println("Record Inserted Successfully");
			else
				System.out.println("Error Inserting Record Please Try Again");
		}

		catch(SQLException e){
			System.out.println(e);
		}}
}




