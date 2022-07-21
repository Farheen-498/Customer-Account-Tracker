package farheen.foundation.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import farheen.foundation.bank.entities.Account;

@Component
public class AccountDAOImpl implements AccountDAO{
	private static List<Account> accounts = new ArrayList<Account>();
	private static int counter=1000;
	static {
		accounts.add(new Account(++counter, "savings", 1000));
		accounts.add(new Account(++counter, "current", 2000));
		accounts.add(new Account(++counter, "current", 3000));
		
	}

	@Override
	public Account getAccount(int accountNumber) {
		Account searchAccount = null;
		for(Account account: accounts) {
			if(account.getAccountNumber()==accountNumber) {
				searchAccount = account;
				break;
			}
		}
		return searchAccount;
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;
	}

	@Override
	public Account createAccount(Account account) {
		Account saveAccount = account;
		saveAccount.setAccountNumber(++counter);
		accounts.add(saveAccount);
		
		return saveAccount;
	}

	@Override
	public Account updateAccount(int accountNumber, Account account) {
		Account accountUpdate = null;
		
		for(Account acc: accounts) {
			if(acc.getAccountNumber()==accountNumber) {
				acc.setAccountType(account.getAccountType());
				acc.setBalance(account.getBalance());
				accountUpdate = acc;
				break;
			}
		}
		return accountUpdate;
	}

	@Override
	public Account deleteAccount(int accountNumber) {
    Account accountDelete = null;
		
		for(Account account: accounts) {
			if(account.getAccountNumber()==accountNumber) {
				accountDelete = account;
				accounts.remove(accountDelete);
				break;
			}
		}
		return accountDelete;

   }
}
