package com.qsp.sms.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) {
		InsertData.insert();
	}
	public static void insert() {


		String url="jdbc:postgresql://localhost:5432/my-first-jdbc-program-m1";
		String user="postgres";
		String password="root";


		Scanner sc= new Scanner(System.in);

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url,user,password);




			String sql = "INSERT INTO student VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			boolean flag =false;
			while(!flag){


				System.out.print("enter index :");
				int idx=sc.nextInt();
				sc.nextLine();
				System.out.print("enter name :");
				String str=sc.nextLine();


				preparedStatement.setInt(1, idx);
				preparedStatement.setString(2, str);
				preparedStatement.execute();

				System.out.print("\nIf you want to insert more data enter 1 else enter 0 : ");
				int x=sc.nextInt();

				if(x==0) {
					flag=true;
					break;
				}
			}




			connection.close();
			System.out.println();
			System.out.println("--------values are entered in database-----");


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
