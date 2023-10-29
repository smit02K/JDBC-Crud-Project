package com.qsp.sms.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAllData {

	public static void main(String[] args) {
	

		DeleteAllData.deleteall();
		
	}
	
	public static void deleteall(){
		
		String url="jdbc:postgresql://localhost:5432/my-first-jdbc-program-m1";
		String user="postgres";
		String password="root";
		
		try {
			//Step1 :Load or Register 
			Class.forName("org.postgresql.Driver");
			
			//Step2 : Establish connection
			Connection connection = DriverManager.getConnection(url,user,password);
			
			//Step3 : Creation of statement
			Statement statement = connection.createStatement();
			
			//Step4 : Execution of statement 
			statement.execute("TRUNCATE TABLE student");
			
			//Step5 : close connection 
			connection.close();
			
			System.out.println("completed");
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
