package farheen.foundation.bank.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNumber;
	private String accountType;
	private double balance;
	
	
	public Account() {
		
	}
	
	public Account(String accountType, double balance) {
		this.accountType = accountType;
		this.balance = balance;
		
	}
	
	public Account(int accountNumber, String accountType, double balance) {
		this.accountNumber = accountNumber;
		this.accountType= accountType;
		this.balance= balance;
		
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
				+ "]";
	}
	
}
