package com.dollarsbank.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dollarsbank.exceptions.AccountDoesNotExist;
import com.dollarsbank.exceptions.InvalidCredentialsException;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Account.AccountType;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;
import com.dollarsbank.utility.FileStorageUtility;

public class DollarsBankController {
	
	ConsolePrinterUtility printer = new ConsolePrinterUtility();
	
	FileStorageUtility file = new FileStorageUtility();
	
	DataGeneratorStubUtil dataGen = new DataGeneratorStubUtil();
	
//	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	Date date = new Date();
	
//	Customer currCustomer; 
	
//	List<Customer> cList = file.readCustomerFile();
//	List<Account> aList = file.readAccountFile();

	// Create a New Customer
	public Customer newCustomer(String name, String address, String contact, String userId, String password, double deposit) throws IOException {
		
		Customer customer = new Customer(name, address, userId, password, contact, new Account(accountIdGenerator(), deposit, userId));
		
		file.addCustomerToFile(customer);
		
		return customer;
		
	}
	
	// Login
	public Customer Login(String cusId, String password) throws InvalidCredentialsException {
		
		if(dataGen.findCustomer(cusId) != null) 
			return dataGen.findCustomer(cusId);
		
		else 
			throw new InvalidCredentialsException();
			
	}
	
	// Open New Account
	public Account openNewAccount(double balance, AccountType type, String customerId) throws IOException {
		
		Account account = new Account (accountIdGenerator(), balance, type, customerId);
		
		file.addAccountToFile(account);
		file.addTransactionToFile(customerId, account.getId(), "Initial Deposit Amount", balance, date);
		
		return account;
		
	}
	
	// Deposit Amount
	public void deposit(String cusId, int id, double deposit) throws AccountDoesNotExist, NumberFormatException, IOException {
		if(dataGen.findAccount(id) != null) {
			file.updateBalanceToFile(id, deposit + dataGen.findAccount(id).getBalance());
			file.addTransactionToFile(cusId, id, "Deposit", deposit, date);
		}
		else 
			throw new AccountDoesNotExist();
	}
	
	// Withdraw Amount 
	public void withdraw(String cusId, int id, double withdraw) throws Exception {
		if(dataGen.findAccount(id) != null) {
			if(dataGen.findAccount(id).getBalance() - withdraw > 0) {
				file.updateBalanceToFile(id, dataGen.findAccount(id).getBalance() - withdraw);
				file.addTransactionToFile(cusId, id, "Withdraw", withdraw, date);
			}
			else 
				throw new Exception("Cannot withdraw more than balance!");
		}
		else 
			throw new AccountDoesNotExist();
	}
	
	// Fund Transfer
	public void transfer(String cusId, int fromAccount, int toAccount, double amount) throws AccountDoesNotExist, NumberFormatException, IOException {
		if((dataGen.findAccount(fromAccount) != null) && (dataGen.findAccount(toAccount) != null)) {
			file.updateBalanceToFile(fromAccount, dataGen.findAccount(fromAccount).getBalance() - amount);
			file.updateBalanceToFile(toAccount, amount + dataGen.findAccount(toAccount).getBalance());
			
			file.addTransactionToFile(cusId, fromAccount, "Transfer", dataGen.findAccount(fromAccount).getBalance() - amount, date);
			file.addTransactionToFile(cusId, toAccount, "Transfer", dataGen.findAccount(toAccount).getBalance(), date);
		}
		else 
			throw new AccountDoesNotExist();
	}

	// 5 Recent Transactions
	public void recentTransactions() {
		List<String> transactions = file.transactionsConsoleFormat();
		//only nit pick 5
		for (String t : transactions) {
			
		}
		
	}
	
	// Display Customer Information
	public String displayCustomerInfo(Customer customer) {
		return customer.toString();
	}
	
	public int accountIdGenerator() {
		
		int id = random.nextInt(1000);
			
		while(dataGen.findAccount(id) != null)
			id = random.nextInt(1000);
			
		return id;
	}
	
}
