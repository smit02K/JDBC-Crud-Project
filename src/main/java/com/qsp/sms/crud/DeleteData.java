package com.qsp.sms.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData {

	public static void main(String[] args) {
		DeleteData.delete();

	}

	public static void delete() {
		

			Scanner sc= new Scanner(System.in);
			

			String url="jdbc:postgresql://localhost:5432/my-first-jdbc-program-m1";
			String user="postgres";
			String password="root";
			
			
			try {
				//Step1 :Load or Register 
				Class.forName("org.postgresql.Driver");
				
				//Step2 : Establish connection
				Connection connection = DriverManager.getConnection(url,user,password);
				
				//Step3 : Creation of statement
				
				
				String sql_id="DELETE from student where id=?";
				PreparedStatement preparedStatement_idx = connection.prepareStatement(sql_id);
				
				String sql_name="DELETE from student where name=?";
				PreparedStatement preparedStatement_str = connection.prepareStatement(sql_name);
				
				String sql_id_name="DELETE from student where id=? AND name=?";
				PreparedStatement preparedStatement_idx_str = connection.prepareStatement(sql_id_name);
				
				
				boolean flag =false;
				while(!flag){
				
				
				System.out.println(" \nif you want to Delete record using:\n1.Index press 1 \n2.Name press 2 \n3.Index and Name both press 3");
				System.out.print("\nSelect Option: ");
				int n=sc.nextInt();
				
				if(n==1) {
					System.out.print("Enter index :");
					int idx=sc.nextInt();
			
					preparedStatement_idx.setInt(1,idx);
					preparedStatement_idx.execute();
				}
				else if(n==2) {
					System.out.print("enter name :");
					sc.nextLine();
					String str=sc.nextLine();
					
					preparedStatement_str.setString(1,str);
					preparedStatement_str.execute();

				}
				else if(n==3) {
					System.out.print("enter index :");
					int idx=sc.nextInt();
					sc.nextLine();
					System.out.print("enter name :");
					String str=sc.nextLine();
					
					preparedStatement_idx_str.setInt(1,idx);
					preparedStatement_idx_str.setString(2,str);
					preparedStatement_idx_str.execute();
				}
				else {
					System.out.println("sorry");
				}	
				
				System.out.print("If you want to Delete more data enter 1 else enter 0 : ");
				int x=sc.nextInt();
				
				if(x==0) {
					flag=true;
					break;
				}

			}		
				//Step5 : close connection 
				connection.close();
				
				System.out.println("-------------------- Data are Deleted--------------------");
				
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
