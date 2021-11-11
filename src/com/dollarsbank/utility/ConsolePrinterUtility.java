package com.dollarsbank.utility;

public class ConsolePrinterUtility {
	
	//Box Wrapper 
	public void wrapper(String text) {
		
		String border ="+";
		
		for(int i=0; i < text.length()+2; i++) 
			border+="-";
		
		border += "+";
		
		System.out.println(border + "\n| " + text+ " |\n" + border);
		
		//TODO: Make Blue!!! 
		
	}
	
	//Starter Menu 
	public void printStarter() {
		wrapper("DOLLARSBANK Welcomes You!");
		System.out.println("1. Create New Account\n" + "2. Login\n" + "3. Exit.");
		
		//TODO: Make Green!!! 
		System.out.println("\nEnter Choice (1,2 or 3) :");
		
	}
	
	//Starter Choice
	public void printStartChoice(int choice) {
		switch(choice) {
			case 1: 
				//Enter Details for New Account
				wrapper("Enter Details For New Account");
			case 2:
				//Enter Login Details 
				wrapper("Enter Login Details"); 
			case 3: 
				//Exit
				wrapper("Exiting the Program. Thank you for using DOLLARSBANK!");
			default: 
				//insert error
		}
	}
	
	//Customer Menu
	public void printCustomerMenu() {
		wrapper("WELCOME Customer!!!");
		System.out.println("1. Open a New Account\n" + "2. Deposit Amount\n" 
						+ "3. Withdraw Amount\n" + "4. Funds Transfer\n" 
						+ "5. View 5 Recent Transactions\n" + "6. Display Customer Information\n" 
						+ "7. Sign Out");

		//TODO: Make Green!!! 
		System.out.println("\nEnter Choice (1,2,3,4,5,6 or 7) :");

	}
	
	//Customer Choice
	public void printCustomerChoice(int choice) {
		switch(choice) {
			case 1: 
				//Opening a new account
				wrapper("Enter Details for New Account");
				
			case 2: 
				//Deposit Amount
				printWhichAccount();

			case 3: 
				//Withdraw Amount 
				printWhichAccount();

			case 4: 
				//Funds Transfer
				printWhichAccount();

			case 5:
				//View 5 Recent Transactions
				wrapper("5 Recent Transactions:"); 

			case 6:
				//Display Customer Information 
				wrapper("Customer Information");
				
			case 7:
				//Sign out
				wrapper("Signing Out!");
				
			default: 
				//insert error
		}
		
	}

	
	//Which Account? 
	public void printWhichAccount() {
		wrapper("Which Account?"); 
		System.out.println("1. Savings\n" + "2. Checking\n" + "3. Credit\n");
		
		//TODO: Make Green!!! 
		System.out.println("\nEnter Choice (1,2 or 3) :");
	}
	
	//accountChoice
	public void printAccount(int choice) {
		switch(choice) {
		case 1: 
			//Savings Account
			wrapper("Savings Account");
			
		case 2: 
			//Checking Account
			wrapper("Checking Account");
			
		case 3: 
			//Credit Account
			wrapper("Credit Account");
			
		default: 
			//insert error
		}

	}
	

}

