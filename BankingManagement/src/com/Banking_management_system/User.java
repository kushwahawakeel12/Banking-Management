package com.Banking_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {

	private Connection connection;
	private Scanner scanner;

	public User(Connection connection, Scanner scanner) {

		this.connection = connection;
		this.scanner = scanner;
	}

	//register
	void register() {

		System.out.print("Enter full name: ");
		String full_name = scanner.nextLine();

		System.out.print("Enter email: ");
		String email = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		if (user_exist(email)) {
			System.out.println("User Already Exists for this Email Address!!");
			return;

		}

		String register_query = "INSERT INTO user(full_name,email,password) VALUES (?,?,?)";
		
		
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(register_query);

			prepareStatement.setString(1, full_name);
			prepareStatement.setString(2, email);
			prepareStatement.setString(3, password);

			int i = prepareStatement.executeUpdate();
			if (i > 0) 
			{
				System.out.println("Registration successfull!!");
			} 
			else
			{
				System.out.println("Registration failed!");
			}

		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	//login
	public String login()
	{
		
	System.out.print("Enter you email: ");
	String email = scanner.nextLine();
	
	System.out.print("Enter password");
	String password = scanner.nextLine();
	
	String login_query = "SELECT * FROM user WHERE email=? AND password =?";
	
	try {
			PreparedStatement prepareStatement = connection.prepareStatement(login_query);
		    prepareStatement.setString(1, email);
		    prepareStatement.setString(2, password);
		    
		   ResultSet resultSet  = prepareStatement.executeQuery();
		  if(resultSet.next())
		  	{
			  return email;
		  	}
		  else 
		  	{
			  return null;
		  	}
	  } 
	catch (SQLException e) 
	   {
			e.printStackTrace();
	   }
			return null;
	}
	
	
	
	
	private boolean user_exist(String email)
	{
		String user_exist = "SELELCT *FROM user WHERE email=?";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(user_exist);
			prepareStatement.setString(1, email);
			
			ResultSet resultset = prepareStatement.executeQuery();
			if(resultset.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
}
