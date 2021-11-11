package com.dollarsbank.model;

public class SavingsAccount extends Account{
	
	private double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(int id, double interestRate, double balance, String customerId) {
		super(id, balance, customerId);
		this.interestRate = interestRate;
	}
	
	public SavingsAccount(int id,  double balance, AccountType type, String customerId) {
		super(id, balance, type, customerId);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", getId()=" + getId() + ", getBalance()="
				+ getBalance() + ", getType()=" + getType() + ", getCustomerId()=" + getCustomerId() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	public String fileFormat() {
		return getId() + "  " + getBalance() + "  " + getType() + "  " + getCustomerId();
	}

	
}
