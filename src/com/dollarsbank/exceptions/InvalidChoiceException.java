package com.dollarsbank.exceptions;

public class InvalidChoiceException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidChoiceException() {
		System.out.println("Invalid choice from the menu!");
	}
	
	public InvalidChoiceException(int startChoice, int endChoice) {
		System.out.println("Please choose from " + startChoice +  " to " + endChoice + " only.");
	}
}
