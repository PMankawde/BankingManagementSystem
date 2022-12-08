package com.bms.bank;

import java.util.Scanner;

public class Home {

	int option;
	String customerName;
	String customerId;
	double amm;
	double prev;
	int x;
	Scanner sc = new Scanner(System.in);

	public void menu(String customerName, String customerId) {
		Account acc = new Account(customerName, customerId);
		System.out.println("Welcome " + acc.getCustomerName());
		System.out.println("Your ID:" + acc.getCustomerId());
		System.out.println("\n Select from the following options: \n");
		System.out.println("1) Check Balance");
		System.out.println("2) Deposit Amount");
		System.out.println("3) Withdraw Amount");
		System.out.println("4) Previous Transaction");
		System.out.println("5) Exit");
		
		while (option != 5) {
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("......................");
				System.out.println(" Your Balance is: " + acc.getBal());
				System.out.println("......................");
				System.out.println("\n");
				break;
			case 2:
				System.out.println("......................");
				System.out.println("Enter ammount to be deposit :");
				System.out.println("\n");
				double db = sc.nextDouble();
				amm = acc.getBal() + db;
				prev = db;
				x = 1;
				acc.setTrans(db);
				acc.setBal(amm);
				System.out.println("Your new balance is: " + amm);
				break;
			case 3:
				System.out.println("......................");
				System.out.println("Enter ammount to be withdraw :");
				System.out.println("\n");
				double wt = sc.nextDouble();
				if (wt <= acc.getBal()) {
					amm = acc.getBal() - wt;
					prev = wt;
					x = 0;
					acc.setTrans(wt);
					acc.setBal(amm);
					System.out.println("Your new balance is: " + amm);
				} else {
					System.out.println("Your balance is insufficient");
				}
				break;
			case 4:
				System.out.println("......................");
				System.out.println("Your Previous Transaction was :");
				System.out.println("\n");
				if (x == 0) {
					System.out.println(" Withdrawal of Rs: " + acc.getTrans());
				} else if (x == 1) {
					System.out.println(" Deposit of Rs: " + acc.getTrans());
				} else {
					System.out.println(" No Previous Transactions");
				}
			case 5:
				System.out.println("......................");
				break;
			default:
				System.out.println("Choose a correct option to proceed");
				break;

			}
		}

	}

}
