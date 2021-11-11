package com.dollarsbank.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.FileStorageUtility;

public class DollarsBankApplication {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner scan = new Scanner(System.in);
		
		ConsolePrinterUtility printer = new ConsolePrinterUtility();
		FileStorageUtility file = new FileStorageUtility();
		
		List<Customer> customers = file.readCustomerFile();
		List<Account> accounts = file.readAccountFile();
		List<String> transactions = null; 

		Customer currCustomer;
		
		printer.printStartChoice(1);
		
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
		
		
		printer.printCustomerMenu();
		
		//where the loops go --flow of program
		
		//when log-in gather transactions
		
		//add to local list data 
		
		//Double check 5 transactions method 
		
	}

}
