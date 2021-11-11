package com.dollarsbank.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Account.AccountType;
import com.dollarsbank.model.Customer;

public class FileStorageUtility {
	
	List<Customer> cList = new ArrayList<Customer>();
	List<Account> aList = new ArrayList<Account>();
	List<String> transactions;

	File file = null;
	FileReader fileReader = null; 
	BufferedReader reader = null;
	
	FileWriter fileWriter = null;
	BufferedWriter buffWriter = null;
	PrintWriter printWriter = null;
	
	// Read Customer File Method
	public List<Customer> readCustomerFile() {

		try {
			file = new File("resources/customer.txt");
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);

			String line; 

			while((line = reader.readLine()) != null) {
				String[] tokens = line.split("  "); //seperated by two spaces
				
				Customer cus = new Customer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);

				cList.add(cus);
			}

		} catch(FileNotFoundException e){
			System.out.println("This file does not exist!");
		} catch(IOException e) {
			System.out.println("Could not read character!");
		} finally {
			try {
				fileReader.close();
				reader.close();
			} catch(IOException e) {
				System.out.println("Could not close reader objects!");
			}
		}

		return cList;

	}
	
	// Read Account File Method
	public List<Account> readAccountFile(){

		try {

			file = new File("resources/account.txt");
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);

			String line;

			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split("  "); // seperated by two spaces

				Account acc = new Account(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]),
						AccountType.valueOf(tokens[2]), tokens[3]);

				aList.add(acc);
			}

		} catch (FileNotFoundException e) {
			System.out.println("This file does not exist!");
		} catch (IOException e) {
			System.out.println("Could not read character!");
		} finally {
			try {
				fileReader.close();
				reader.close();
			} catch (IOException e) {
				System.out.println("Could not close reader objects!");
			}
		}

		return aList;

	}
	
	// Read Transaction File for Specific customer 
	public List<String> readCustomerTransactions(String cusId){
		try {

			file = new File("resources/transactions.txt");
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);

			String line;

			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split("  "); // seperated by two spaces
				if(tokens[0].equals(cusId))
					transactions.add(tokens[2] + " in account [" + tokens[1] + "].\n" 
							+ "Balance - " + tokens[3] + " as on " + tokens[4] + "\n");
			}

		} catch (FileNotFoundException e) {
			System.out.println("This file does not exist!");
		} catch (IOException e) {
			System.out.println("Could not read character!");
		} finally {
			try {
				fileReader.close();
				reader.close();
			} catch (IOException e) {
				System.out.println("Could not close reader objects!");
			}
		}

		return transactions;
		
	}
	
	// Add to Customer File
	public void addCustomerToFile(Customer customer) throws IOException {

		file = new File("resources/customer.txt");
		fileWriter = new FileWriter(file, true);
		buffWriter = new BufferedWriter(fileWriter);
		printWriter = new PrintWriter(buffWriter, true);

		cList.add(customer);
		printWriter.println(customer.fileFormat());

		if (buffWriter != null) 
			buffWriter.close();


		if (fileWriter != null) 
			fileWriter.close();


		if (printWriter != null) 
			printWriter.close();

	}
	
	// Add to Account File
	public void addAccountToFile(Account account) throws IOException {

		file = new File("resources/account.txt");
		fileWriter = new FileWriter(file, true);
		buffWriter = new BufferedWriter(fileWriter);
		printWriter = new PrintWriter(buffWriter, true);

		aList.add(account);
		printWriter.println(account.fileFormat());

		if (buffWriter != null) 
			buffWriter.close();


		if (fileWriter != null) 
			fileWriter.close();
		

		if (printWriter != null) 
			printWriter.close();

	}
	
	// Add to Transactions File 
	public void addTransactionToFile(String cusId, int accId, String activity, double amount, Date date) throws IOException {
		file = new File("resources/account.txt");
		fileWriter = new FileWriter(file, true);
		buffWriter = new BufferedWriter(fileWriter);
		printWriter = new PrintWriter(buffWriter, true);

		String consoleFormat = activity + " in account [" + Integer.toString(accId) + "].\n" 
							+ "Balance - " + amount + " as on " + date.toString() + "\n";
		String fileFormat = cusId + "  " + Integer.toString(accId) + "  " + activity + "  " + amount + "  " + date.toString();
		transactions.add(consoleFormat);
		printWriter.println(fileFormat);

		if (buffWriter != null) 
			buffWriter.close();


		if (fileWriter != null) 
			fileWriter.close();
		

		if (printWriter != null) 
			printWriter.close();
		
	}
	
	// Update Balance to Account File
	public void updateBalanceToFile(int id, double newBalance) throws NumberFormatException, IOException {
		
		// deleting in file 
		file = new File("resources/employees.txt");
		File temp = File.createTempFile("tmp", "");

		fileReader = new FileReader(file);
		reader = new BufferedReader(fileReader);
		fileWriter = new FileWriter(temp, true);
		buffWriter = new BufferedWriter(fileWriter);
		printWriter = new PrintWriter(buffWriter, true);

		String line;
		
		Account account = null;

		while((line = reader.readLine()) != null) {

			String[] tokens = line.split("  ");

			if(Integer.parseInt(tokens[0]) == id) {

				for (Account acc : aList) {
					if(acc.getId() == id) {
						account = acc;
						aList.remove(aList.indexOf(acc));
						break;
					}
				}

			}
			else {
				printWriter.println(line);
			}

		}

		File oldFile = file;
		if (oldFile.delete())
			temp.renameTo(oldFile);
		
		// update account 
		Account updated = new Account(account.getId(), newBalance, account.getType(), account.getCustomerId());
		
		// re adding to file 
		addAccountToFile(updated);
		
		fileReader.close();
		reader.close();
		
		if (buffWriter != null) 
			buffWriter.close();


		if (fileWriter != null) 
			fileWriter.close();
		

		if (printWriter != null) 
			printWriter.close();
		
	}
	
	// returns console format of the transactions
	public List<String> transactionsConsoleFormat(){
		return transactions;
	}
	
	
}
