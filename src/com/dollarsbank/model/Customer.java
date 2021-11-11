package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String name, address, userId, password, contactNum; 
	private Account firstAcc;
	
	private List<Account> accounts = new ArrayList<Account>();
	private List<String> transactions = new ArrayList<String>();
	
	public Customer() {
		this("N/A", "N/A", "U000000", "password", "123456789", new Account());
	}
	
	//For retrieval in file
	public Customer(String name, String address, String userId, String password, String contactNum) {
		super();
		this.name = name;
		this.address = address;
		this.userId = userId;
		this.password = password;
		this.contactNum = contactNum;
	}
	
	//For creating customer
	public Customer(String name, String address, String userId, String password, String contactNum,
			Account firstAcc) {
		super();
		this.name = name;
		this.address = address;
		this.userId = userId;
		this.password = password;
		this.contactNum = contactNum;
		this.firstAcc = firstAcc;
		accounts.add(firstAcc);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public Account getFirstAcc() {
		return firstAcc;
	}

	public void setFirstAcc(Account firstAcc) {
		this.firstAcc = firstAcc;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<String> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Name:" + name + "\n" 
			+  "Address:" + address + "\n" 
			+  "User ID:" + userId + "\n" 
			+  "Password:" + password + "\n"
			+  "Contact Number:" + contactNum + "\n"
			+  "Accounts:" + accounts ;
	}
	
	public String fileFormat() {
		return name + "  " + address + "  " + userId + "  " + password + "  " + contactNum;
	}

}
