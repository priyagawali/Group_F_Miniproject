package com.velocity;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StartQuiz {
	static Scanner scanner=new Scanner(System.in);
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rSet=null;
	
	public static void startQuiz() throws SQLException
	{
		
		try {
			con=cc.getconnecion();
			
			//step 3-prepare statement
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM quizdata");
			
			//step 4- submit query
			
			 rSet=ps.executeQuery();
			 
			 while(rSet.next())
			 {
				 int Q_no=rSet.getInt(1);
				 System.out.print(Q_no+". " );
				 
				 
				 String Question_1=rSet.getString(2);
				 System.out.println("Question: "+Question_1);
				 
				 String Option_1=rSet.getString(3);
				 System.out.println(Option_1);
				 
				 String Option_2=rSet.getString(4);
				 System.out.println(Option_2);
				 
				 String Option_3=rSet.getString(5);
				 System.out.println(Option_3);
				 
				 String Option_4=rSet.getString(6);
				 System.out.println(Option_4);
				 
				 System.out.println("Enter Answer: ");
				 String answer=scanner.next();
				 
				

				 
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 finally {
	            // Close resources in the finally block
	            if (con != null) {
	                con.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (rSet != null) {
	                rSet.close();
	            }
		}
		
	}
	
	

}
