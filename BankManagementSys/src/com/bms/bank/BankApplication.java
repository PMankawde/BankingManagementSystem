package com.bms.bank;

import java.util.Scanner;

public class BankApplication {
	public static void main(String arg[]) {
		System.out.println("Enter your name and Id: \n");
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		String Name = sc.nextLine();
		String Id= sc.nextLine();
		Home hm= new Home();
		hm.menu(Name, Id);
		
	}

}
