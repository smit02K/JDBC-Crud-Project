package com.qsp.sms.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {

	public static void main(String[] args) {
		UpdateData.update();

	}

	
	public static void update(){
		
	
			String url="jdbc:postgresql://localhost:5432/my-first-jdbc-program-m1";
			String user="postgres";
			String password="root";
			Scanner sc= new Scanner(System.in);

			try {
				//Step1 :Load or Register 
				Class.forName("org.postgresql.Driver");

				//Step2 : Establish connection
				Connection connection = DriverManager.getConnection(url,user,password);

				//Step3 : Creation of statement

				//Step4 : Execution of statement 
				String sql_uptd_id_using_id ="UPDATE student SET id=? where id=?";
				PreparedStatement pstn_uptd_id_using_id = connection.prepareStatement(sql_uptd_id_using_id);
				
				String sql_uptd_id_using_name ="UPDATE student SET id=? where name=?";
				PreparedStatement pstn_uptd_id_using_name = connection.prepareStatement(sql_uptd_id_using_name);
				
				String sql_uptd_name_using_id ="UPDATE student SET name=? where id=?";
				PreparedStatement pstn_uptd_name_using_id = connection.prepareStatement(sql_uptd_name_using_id);
				
				String sql_uptd_name_using_name ="UPDATE student SET name=? where name=?";
				PreparedStatement pstn_uptd_name_using_name = connection.prepareStatement(sql_uptd_name_using_name);

				
				
				
				boolean flag =false;
				while(!flag){
					
				
				
				System.out.println(" \nif you want to Update:\n1.Index press 1 \n2.Name press 2 ");
				System.out.print("\nSelect Option: ");
				int n=sc.nextInt();

				if(n==1){
					System.out.println(" \nif you want to Update Index using :\n1.Index press 1 \n2.Name press 2 ");
					System.out.print("\nSelect Option: ");
					int m=sc.nextInt();
					if(m==1) {
						System.out.print("\nEnter index :");
						int idx=sc.nextInt();

						System.out.print("Enter Updated index :");
						int idx_new=sc.nextInt();

						pstn_uptd_id_using_id.setInt(1,idx_new);
						pstn_uptd_id_using_id.setInt(2,idx);
						pstn_uptd_id_using_id.execute();

					}else {
						System.out.print("\nEnter name :");
						sc.nextLine();
						String str=sc.nextLine();

						System.out.print("Enter Updated index :");
						int idx_new=sc.nextInt();

						pstn_uptd_id_using_name.setInt(1,idx_new);
						pstn_uptd_id_using_name.setString(2,str);
						pstn_uptd_id_using_name.execute();
					}
				}
				else {
					System.out.println(" \nif you want to Update Name using :\n1.Index press 1 \n2.Name press 2 ");
					System.out.print("\nSelect Option: ");
					int m=sc.nextInt();
					if(m==1) {
						System.out.print("\nEnter index :");
						int idx=sc.nextInt();

						System.out.print("Enter Updated name:");
						sc.nextLine();
						String str_new=sc.nextLine();
						
						pstn_uptd_name_using_id.setString(1,str_new);
						pstn_uptd_name_using_id.setInt(2, idx);
						pstn_uptd_name_using_id.execute();
					}else {
						System.out.print("\nEnter name :");
						sc.nextLine();
						String str=sc.nextLine();

						System.out.print("Enter Updated name:");
						String str_new=sc.nextLine();

						pstn_uptd_name_using_name.setString(1,str_new);
						pstn_uptd_name_using_name.setString(2,str);
						pstn_uptd_name_using_name.execute();

					}
				}
				
				
				
				System.out.print("\nIf you want to Update More data enter 1 else enter 0 : ");
				int x=sc.nextInt();

				if(x==0) {
					flag=true;
					break;
				}

			}


				//Step5 : close connection
				connection.close();

				System.out.println("\n--------------All Records Are Updated-------------");


			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
	}
}
