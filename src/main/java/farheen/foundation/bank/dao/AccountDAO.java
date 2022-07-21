package farheen.foundation.bank.dao;

import java.util.List;

import farheen.foundation.bank.entities.Account;

public interface AccountDAO {

	public Account getAccount(int accountId);
	public List<Account> getAccounts();
	public Account createAccount(Account account);
	public Account updateAccount(int accountId, Account account);
	public Account deleteAccount(int accountId);
}
