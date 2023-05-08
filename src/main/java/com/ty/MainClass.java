package com.ty;

import java.util.Scanner;

import customException.InvalidChoiceException;

public class MainClass {

	public static void main(String[] args) {
			System.out.println("Welcome to Student DB Project");
			System.out.println("-----------------------------");
			Scanner sc = new Scanner(System.in);
			Functionalities fn = new FunctionalitiesImp();
			while (true) {
				System.out.println(
						"1:ADD STUDENT\n2:DISPLAY ALL STUDENTS\n3:DISPLAY STUDENT BY REGNO\n4:DISPLAY STUDENT BY NAME\n5:DISPLAY STUDENT BY EMAIL\n6:SORT STUDENTS\n7:EXIT");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					fn.addStudent();
					break;
				case 2:
					fn.displayStudents();
					break;
				case 3:
					fn.getByRegNo();
					break;
				case 4:
					fn.getByName();
					break;
				case 5:
					fn.getByEmail();
					break;
				case 6:
					fn.sortStudents();
					break;
				case 7:
					System.out.println("Thank you");
					System.exit(0);
				default:
					try {
						String mssg = "Invalid Choice ,Enter Valid Choice!";
						throw new InvalidChoiceException(mssg);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				System.out.println("----------------------------");
			}
		}
	

}
