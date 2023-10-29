package com.qsp.sms.crud;

import java.util.Scanner;

public class MainCrud {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte x=1;
		while (x==1) {
			
		
			System.out.println("\nWhich of the following operations do you want to perform on the Student database: ");
			System.out.print("1. Add Student details\n2. Delete particular Student records\n3. Update record \n4. Read record \n5. Delete all records\n6. Exit System\n");
			System.out.print("\nSelect Option: ");
			
			int Option=sc.nextInt();
			
			switch (Option) {
			case 1:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println("|          Add Student details         |");
				System.out.println("----------------------------------------");
				System.out.println();
				InsertData.insert();
				break;
			case 2:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println("|    Delete particular Student records  |");
				System.out.println("----------------------------------------");
				System.out.println();
				DeleteData.delete();
				break;

			case 3:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println("|              Update record           |");
				System.out.println("----------------------------------------");
				System.out.println();
				UpdateData.update();
				break;
				
			case 4:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println("|             Read record              |");
				System.out.println("----------------------------------------");
				System.out.println();
				ReadData.read();
				break;
					
			case 5:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println("|         Delete all records            |");
				System.out.println("----------------------------------------");
				System.out.println();
				
//				DeleteAllData.deleteall();
				break;
				
			case 6:
				System.out.println("exit");
				System.out.println("+++++++++Tank you+++++++++");
				System.exit(0);

			default:
				System.out.println("Select another option");
				break;
			}
			
			System.out.print("\nDo you want to continue crud if yes press 1 else press 0: ");
			x=sc.nextByte();
			
			
		}
		sc.close();
		System.out.println("Tank you");
		
	
		

	}

}
