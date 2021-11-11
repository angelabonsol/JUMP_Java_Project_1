package com.dollarsbank.utility;

import com.dollarsbank.exceptions.InvalidChoiceException;

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
	public void printStartChoice(int choice) throws InvalidChoiceException {
		switch(choice) {
			case 1: 
				//Enter Details for New Customer
				wrapper("Enter Details For New Customer");
				break;
			case 2:
				//Enter Login Details 
				wrapper("Enter Login Details"); 
				break;
			case 3: 
				//Exit
				wrapper("Exiting the Program. Thank you for using DOLLARSBANK!");
				break;
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
	public void printCustomerChoice(int choice) throws InvalidChoiceException {
		switch(choice) {
			case 1: 
				//Opening a new account
				wrapper("Enter Details for New Account");
				break;
				
			case 2: 
				//Deposit Amount
				printWhichAccount(1);
				break;

			case 3: 
				//Withdraw Amount 
				printWhichAccount(2);
				break;

			case 4: 
				//Funds Transfer
				printWhichAccount(3);
				break;

			case 5:
				//View 5 Recent Transactions
				wrapper("5 Recent Transactions:"); 
				break;

			case 6:
				//Display Customer Information 
				wrapper("Customer Information");
				break;
				
			case 7:
				//Sign out
				wrapper("Signing Out!");
				break;
				
			default: 
				throw new InvalidChoiceException();
		}
		
	}

	
	//Which Account? 
	public void printWhichAccount(int choice) {
		switch(choice) {
			case 1:
				wrapper("Despositing"); 
				break;
			case 2: 
				wrapper("Withdrawing"); 
				break;
			case 3: 
				wrapper("Transfering"); 
				break;
			default: 
				break;
				
		}
		
	}
	
	//accountChoice
	public void printAccount(int choice) throws InvalidChoiceException {
		switch(choice) {
		case 1: 
			//Savings Account
			wrapper("Savings Account");
			break;
			
		case 2: 
			//Checking Account
			wrapper("Checking Account");
			break;
			
		case 3: 
			//Credit Account
			wrapper("Credit Account");
			break;
			
		default: 
			throw new InvalidChoiceException();
		}

	}
	

}

