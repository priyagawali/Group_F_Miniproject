package com.velocity;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	public static void choices() {
		System.out.println("Welcome to Console based java Quiz application");
		System.out.println("We have some choices for you like...");
		System.out.println("1 For Student Registration");
		System.out.println("2 For Student Login");
		System.out.println("3 For Start Quiz");
		System.out.println("4 For to store quix result into database");
		System.out.println("5 For Display result");
		System.out.println("6 For diaplay result in ascending order");
		System.out.println("7 For display result by id");
		System.out.println("8 For Add your question");
		
		
	}
	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
	
		
//		System.out.println("Welcome to Console based java Quiz application");
//		System.out.println("We have some choices for you like...");
//		System.out.println("1 For Student Registration");
//		System.out.println("2 For Student Login");
//		System.out.println("3 For Start Quiz");
//		System.out.println("4 For to store quix result into database");
//		System.out.println("5 For Display result");
//		System.out.println("6 For diaplay result in ascending order");
//		System.out.println("7 For display result by id");
//		System.out.println("8 For Add your question");
//		
		Test.choices();
		
		System.out.println("Enter your choice");
		int choice =scanner.nextInt();
		
		operations.PerformOperation(choice);
		
	
		
	}

}
