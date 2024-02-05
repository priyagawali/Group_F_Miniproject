package com.velocity;
import com.velocity.Login;
import com.velocity.ScoreCalculation;
import com.velocity.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Result implements Result_Interface {
	static CreateConection cc=new CreateConection();
	static Connection con=null;
	static PreparedStatement ps=null;
	static char grade;
	
	
	public static void storeResult() throws SQLException {
		
		
		try {
			con=cc.getconnecion();
			
			if(Login.isLoggedIn())
			{
				String LoggedinUsername=Login.LoggediUserName();
				//System.out.println("username: "+LoggedinUsername);
				int marks=ScoreCalculation.calculatedscore();
			//	System.out.println("score:"+marks);
				
				if(marks<2)
				{
					grade='D';
				}
				else if(marks>2 && marks<5){
					grade='C';
				}
				else if (marks>5 && marks<8) {
					grade='B';

				} 
				else if(marks>8 && marks<=10) {
					grade='A';
				}
			//System.out.println("grade:"+grade);
				//step 3-prepare statement
				
				ps=con.prepareStatement("INSERT INTO result ( USERNAME, SCORE, GRADE) VALUES (?, ?,?)");
				
				ps.setString(1, LoggedinUsername);
				ps.setInt(2, marks);
				ps.setString(3,String.valueOf(grade));
				
				//step 4- excute quesry
				
				ps.executeUpdate();
				
			
			
		
			
		
			}
			else
			{
				
				operations.PerformOperation(2);
			}
		
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally {
			
			if(con!=null)
			{
				con.close();
			}
			if(ps!=null)
			{
				ps.close();
			}
			
		}
		
		
		
		
	}

}
