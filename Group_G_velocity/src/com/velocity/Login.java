package com.velocity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
		
	private static boolean loggedIn = false;
	
	public static void validateLogin(String Entered_username, String Entered_password) throws SQLException {
		
	con=cc.getconnecion();
	
	//step 3-prepare statement
	 try 
	 {
		ps=con.prepareStatement("Select * from registrationdata where BINARY username=? AND BINARY password=?");
		
		//set the values
		ps.setString(1, Entered_username);
		ps.setString(2, Entered_password);
		
		//step 4-submit query
		 rs=ps.executeQuery();
		 
		 if(rs.next())
		 {
			 loggedIn = true;
			 System.out.println("Logged in...");
			 operations.toContinue();
			
		 }
		 else 
		 {
			System.out.println("Oops...Invalid username and password");
			operations.toContinue();
		 }
		
		
		 //step 5- process the result it will happened internally
		
	 } 
	 catch (SQLException e)
	 {
		
		e.printStackTrace();
	 }
	 finally 
	 {
		 // Close resources in the finally block
         if (con != null) {
             con.close();
         }
         if (ps != null) {
             ps.close();
         }
         if (rs != null) {
             rs.close();
         }
		
	 }
			
	}
	
	
	public static boolean isLoggedIn()
	{
		return loggedIn;
		
		
	}

	

}
