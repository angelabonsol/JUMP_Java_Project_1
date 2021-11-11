package com.dollarsbank.utility;

import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class DataGeneratorStubUtil {
	
	FileStorageUtility file = new FileStorageUtility();
	
	List<Customer> cList = file.readCustomerFile();
	List<Account> aList = file.readAccountFile();
	
	//TODO: Find Customer by User Id
	public Customer findCustomer(String userId){
		for (Customer cus : cList) {
			if(cus.getUserId().equals(userId)) {
				return cus;
			}
		}
		return null;
	}
	
	//TODO: Find Account by id
	public Account findAccount(int id){
		for (Account acc : aList) {
			if(acc.getId() == id) {
				return acc;
			}
		}
		return null;
	}
	
	//TODO: Find Accounts of Customer by userId
	public List<Account> findAccountsOfCustomer(String userId){
		
		List<Account> cusAcc = new ArrayList<Account>();
		
		for (Account acc : aList) {
			if(acc.getCustomerId().equals(userId)) {
				cusAcc.add(acc);
			}
		}
		
		return cusAcc;
		
	}
	
	

}
