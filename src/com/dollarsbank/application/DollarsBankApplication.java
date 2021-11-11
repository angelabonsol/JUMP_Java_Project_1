package com.dollarsbank.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.exceptions.AccountDoesNotExistException;
import com.dollarsbank.exceptions.InvalidChoiceException;
import com.dollarsbank.exceptions.InvalidCredentialsException;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Account.AccountType;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;
import com.dollarsbank.utility.FileStorageUtility;

public class DollarsBankApplication {

	static Scanner scan = new Scanner(System.in);
	
	static ConsolePrinterUtility printer = new ConsolePrinterUtility();
	static FileStorageUtility file = new FileStorageUtility();
	static DataGeneratorStubUtil dataGen = new DataGeneratorStubUtil();
	static DollarsBankController controller = new DollarsBankController();
	
	static boolean logged;

	public static void main(String[] args) throws Exception {

		List<Customer> customers = file.readCustomerFile();
		List<Account> accounts = file.readAccountFile();
		List<String> transactions = null; 

		Customer currCustomer;
		boolean continuous = true;
		
		while(continuous == true) {
			printer.printStarter();
			int choice = scan.nextInt();
			scan.nextLine();
			currCustomer = starterMenu(choice);
			
			//No currCustomer -- user entered exit 
//			if(currCustomer == null)
//				continuous = false;
			
			while(logged == true) {
				currCustomer.setAccounts(dataGen.findAccountsOfCustomer(currCustomer.getUserId()));
				//set transactions here 

				printer.printCustomerMenu();
				choice = scan.nextInt();
				scan.nextLine();
				customerMenu(currCustomer, choice);
				
			}
			
			continuous = false;
		}
		
		
//		printer.printCustomerMenu();
						
		//add to local list data 
		
		//Double check 5 transactions method -
		
	}
	
	private static Customer starterMenu(int choice) throws InvalidChoiceException, IOException, InvalidCredentialsException {
		
		printer.printStartChoice(choice);
		
		switch(choice) {
			case 1:
				System.out.println("Customer Name:");
				String name = scan.nextLine();
				
				System.out.println("Customer Address:");
				String address = scan.nextLine();

				System.out.println("Customer Contact Number:");
				String contact = scan.nextLine();
				
				System.out.println("User Id:");
				String userId = scan.nextLine();

				System.out.println("Password: 8 characters with Lower, Upper & Special");
				String password = scan.nextLine();
				
				System.out.println("Initial Deposit Amount:");
				double deposit = scan.nextDouble();
				
				logged = true;
				
				return controller.newCustomer(name, address, contact, userId, password, deposit);
				
			case 2: 				
				System.out.println("User Id:");
				String user = scan.nextLine();
				
				System.out.println("Password:");
				String pass = scan.nextLine();
				
				logged = true;
				return controller.Login(user, pass);

			case 3: 
				logged = false;
				return null;
			
			default:
				throw new InvalidChoiceException(1,3);
		}		
	}
	
	private static void customerMenu(Customer customer, int choice) throws Exception {
		int acc; 
		double amount;
		
		printer.printCustomerChoice(choice);
		
		switch(choice) {
			case 1:
				System.out.println("Type of Account(SAVINGS, CHECKING, CREDIT):");
				String type = scan.nextLine();
				System.out.println("Desposit Amount:");
				double deposit = scan.nextDouble();
				
				customer.getAccounts().add(controller.openNewAccount(deposit, AccountType.valueOf(type), customer.getUserId()));
				break; 
				
			case 2:
				System.out.println("Account Id:");
				acc = scan.nextInt();
				System.out.println("Deposit Amount:");
				amount = scan.nextDouble();
				
				controller.deposit(customer.getUserId(), acc, amount);
				break; 
				
			case 3:
				System.out.println("Account Id:");
				acc = scan.nextInt();
				System.out.println("Withdraw Amount:");
				amount = scan.nextDouble();
				
				controller.withdraw(customer.getUserId(), acc, amount);
				break;
				
			case 4:
				System.out.println("FROM -- Account Id:");
				acc = scan.nextInt();
				System.out.println("TO -- Account Id:");
				int acc2 = scan.nextInt();
				System.out.println("Transfer Amount:");
				amount = scan.nextDouble();
				
				controller.transfer(customer.getUserId(), acc, acc2, amount);
				break; 
				
			case 5:
				//View 5 Recent transactions 
				break;
				
			case 6:
				System.out.println(controller.displayCustomerInfo(customer));
				break;
				
			case 7: 
				//sign out 
				logged = false;
				break;
			
			default: 
				throw new InvalidChoiceException(1,7);
		
		
		}
		
		
	}

}
