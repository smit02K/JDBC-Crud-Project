package com.qsp.sms.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadData {

	public static void main(String[] args) {
		ReadData.read();

	}
	
	public static void read() {
		
		
			
			String url="jdbc:postgresql://localhost:5432/my-first-jdbc-program-m1";
			String user="postgres";
			String password="root";

			try {
				//Step1 :Load or Register 
				Class.forName("org.postgresql.Driver");

				//Step2 : Establish connection
				Connection connection = DriverManager.getConnection(url,user,password);

				//Step3 : Creation of statement
				String sql_all = "select * from student";
				PreparedStatement pstn_all = connection.prepareStatement(sql_all);
				
				String sql_using_id="select * from student where id=?";
				PreparedStatement pstn_using_id = connection.prepareStatement(sql_using_id);
				
				String sql_using_name="select * from student where name=?";
				PreparedStatement pstn_using_name = connection.prepareStatement(sql_using_name);
				
				//Step4 : Execution of statement 
			
				
				
				boolean flag =false;
				while(!flag){

				Scanner sc= new Scanner(System.in);
				System.out.println(" \n1. If you want to Read All data press 1\n2. Read data Using index press 2\n3. Read data Using name press 3");
				System.out.print("\nSelect Option: ");
				int n=sc.nextInt();
				
				if(n==1) {
					
					ResultSet resultSet =  pstn_all.executeQuery();
					System.out.println();
					while(resultSet.next()) {
		
						System.out.println("id: "+resultSet.getInt(1)+ " name: " +resultSet.getString(2));
						System.out.println("--------------------------------");
				
					}
					
				}
				else if(n==2) {
					
					System.out.print("enter index :");
					int idx=sc.nextInt();
					pstn_using_id.setInt(1,idx);
					ResultSet resultSet =  pstn_using_id.executeQuery();
					
					System.out.println();
					while(resultSet.next()) {
		
						System.out.println("id: "+resultSet.getInt(1)+ " name: " +resultSet.getString(2));
						System.out.println("--------------------------------");
				
					}
						
				}
				else if(n==3) {

					sc.nextLine();
					System.out.print("enter name :");
					String str=sc.nextLine();

					
					pstn_using_name.setString(1,str);
					ResultSet resultSet =  pstn_using_name.executeQuery();
					System.out.println();
					while(resultSet.next()) {
		
						System.out.println("id: "+resultSet.getInt(1)+ " name: " +resultSet.getString(2));
						System.out.println("--------------------------------");
				
					}
						
				}
				else {
					System.out.println("sorry");
				}	
				
				
				System.out.print("\nIf you want to continue Rading data enter 1 else enter 0 : ");
				int x=sc.nextInt();

				if(x==0) {
					flag=true;
					break;
				}

			}

				//Step5 : close connection 
				connection.close();

				System.out.println("------------------Reading opration completed---------------");


			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
